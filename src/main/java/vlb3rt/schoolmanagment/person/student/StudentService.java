package vlb3rt.schoolmanagment.person.student;

import org.springframework.stereotype.Service;

import vlb3rt.schoolmanagment.mappers.StudentMapper;
import vlb3rt.schoolmanagment.models.CDMStudent;


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
        return studentRepository.findById(studentId)
                .map(studentMapper::toCDMMapper)
                .orElse(null);
    }
}
