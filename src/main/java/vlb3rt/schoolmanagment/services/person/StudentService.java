package vlb3rt.schoolmanagment.services.person;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import vlb3rt.schoolmanagment.mappers.person.StudentMapper;
import vlb3rt.schoolmanagment.models.dto.person.student.StudentResponse;
import vlb3rt.schoolmanagment.models.dto.person.student.StudentResponses;
import vlb3rt.schoolmanagment.models.entities.person.Student;
import vlb3rt.schoolmanagment.repositories.person.StudentRepository;
import vlb3rt.schoolmanagment.responses.exceptions.EntityException;
import vlb3rt.schoolmanagment.services.structure.SchoolClassService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;

    private final SchoolClassService schoolClassService;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper, SchoolClassService schoolClassService) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.schoolClassService = schoolClassService;
    }

    public StudentResponse getStudent(long studentId) throws EntityException {
        return studentRepository
                .findById(studentId)
                .map(studentMapper::toResponseMapper)
                .orElseThrow(() -> new EntityException("not found"));
    }

    public Student getStudentEntity(Long studentId) throws EntityException {
        return studentRepository
                .findById(studentId)
                .orElseThrow(() -> new EntityException("not found"));
    }

    public StudentResponses getAllStudents() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return studentMapper.toResponseListMapper(students);
    }

    public void createStudent(StudentResponse studentResponse) throws EntityException {
        System.out.println(studentResponse);
        studentResponse.setStudentId(null);
        if(createValidation(studentResponse)) {
            studentRepository.save(studentMapper.toEntityMapper(studentResponse, schoolClassService.getSchoolClassEntity(studentResponse.getSchoolClassId())));
        }
    }

    public void updateStudent(StudentResponse studentResponse) throws EntityException {
        if(updateValidation(studentResponse)) {
            studentRepository.save(studentMapper.toEntityMapper(studentResponse, schoolClassService.getSchoolClassEntity(studentResponse.getSchoolClassId())));
        }
    }

    public void deleteStudent(Long studentId) throws EntityException {
        try {
            studentRepository.deleteById(studentId);
        } catch (DataIntegrityViolationException e) {
            throw new EntityException(e.getMessage());
        }
    }

    private boolean createValidation(StudentResponse student) throws EntityException {
        StudentResponses students = getAllStudents();

        Optional<StudentResponse> indexInUse = isStudentIndexInUse(students, student.getStudentIndex());
        if(indexInUse.isPresent()) {
            throw new EntityException("teacher with index: " + student.getStudentIndex() + " already exists");
        }
        return true;
    }

    private boolean updateValidation(StudentResponse student) throws EntityException {
        StudentResponses students = getAllStudents();

        if(isStudentIdInUse(students, student.getStudentId()).isEmpty()) {
            throw new EntityException("student with id: " + student.getStudentId() + " does not exist");
        }

        Optional<StudentResponse> indexInUse = isStudentIndexInUse(students, student.getStudentIndex());

        if(indexInUse.isPresent()) {
            if(indexInUse.get().getStudentIndex().longValue() != student.getStudentIndex()) {
                throw new EntityException("student with index: " + student.getStudentIndex() + " already exists");
            }
        }
        return true;
    }

    private Optional<StudentResponse> isStudentIdInUse(StudentResponses studentResponses, Long studentId) {
        return studentResponses.getStudents()
                .stream()
                .filter(studentResponse -> studentResponse.getStudentId().longValue() ==  studentId)
                .findFirst();
    }

    private Optional<StudentResponse> isStudentIndexInUse(StudentResponses studentResponses, Long studentIndex) throws EntityException {
        if(studentIndex == null) {
            throw new EntityException("teacherIndex can not be null");
        }

        return studentResponses.getStudents()
                .stream()
                .filter(studentResponse -> studentResponse.getStudentIndex().longValue() == studentIndex)
                .findFirst();
    }

}
