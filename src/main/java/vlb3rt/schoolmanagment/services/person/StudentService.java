package vlb3rt.schoolmanagment.services.person;

import org.springframework.stereotype.Service;
import vlb3rt.schoolmanagment.mappers.person.StudentMapper;
import vlb3rt.schoolmanagment.models.dto.person.student.StudentResponse;
import vlb3rt.schoolmanagment.models.dto.person.student.StudentResponses;
import vlb3rt.schoolmanagment.models.entities.person.Student;
import vlb3rt.schoolmanagment.repositories.person.StudentRepository;
import vlb3rt.schoolmanagment.responses.exceptions.EntityException;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    private StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentResponse getStudent(long studentId) throws EntityException {
        return null;
    }

    public StudentResponses getAllStudents() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return studentMapper.toResponseListMapper(students);
    }
}
