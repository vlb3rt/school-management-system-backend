package vlb3rt.schoolmanagment.person.student;

import org.springframework.stereotype.Service;

import vlb3rt.schoolmanagment.entities.Student;
import vlb3rt.schoolmanagment.exceptions.singleexceptions.EntityNotFoundException;
import vlb3rt.schoolmanagment.mappers.StudentMapper;
import vlb3rt.schoolmanagment.models.CDMStudent;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentMapper studentMapper;

    private final StudentRepository studentRepository;

    public StudentService(StudentMapper studentMapper, StudentRepository studentRepository) {
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
    }

    public void createStudent(CDMStudent cdmStudent) {
        studentRepository.save(studentMapper.toEntityMapper(cdmStudent));
    }

    public CDMStudent readStudentById(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);

        if(student.isEmpty()) {
            throw new EntityNotFoundException("Student o podanym Id nie istnieje.");
        } else {
            return studentMapper.toCDMMapper(student.get());
        }
    }

    public void updateStudent(Long studentId, CDMStudent cdmStudent) {
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.isPresent()) {
            student = Optional.of(studentMapper.toEntityMapper(cdmStudent));
            student.get().setStudentId(studentId);
            studentRepository.save(student.get());
        } else {
            throw new EntityNotFoundException("Student o podanym Id nie istnieje.");
        }
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }
}
