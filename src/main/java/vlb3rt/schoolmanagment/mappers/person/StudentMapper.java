package vlb3rt.schoolmanagment.mappers.person;

import org.springframework.stereotype.Component;
import vlb3rt.schoolmanagment.mappers.structure.SchoolClassMapper;
import vlb3rt.schoolmanagment.models.dto.person.student.StudentResponse;
import vlb3rt.schoolmanagment.models.dto.person.student.StudentResponses;
import vlb3rt.schoolmanagment.models.entities.person.Student;
import vlb3rt.schoolmanagment.models.entities.structure.SchoolClass;
import vlb3rt.schoolmanagment.responses.exceptions.EntityException;
import vlb3rt.schoolmanagment.services.structure.SchoolClassService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentMapper {

    public Student toEntityMapper(StudentResponse studentResponse, SchoolClass schoolClass) throws EntityException {
        Student student = new Student();

        student.setStudentId(studentResponse.getStudentId());
        student.setName(studentResponse.getName());
        student.setLastName(studentResponse.getLastName());
        student.setStudentIndex(studentResponse.getStudentIndex());
        student.setSchoolClass(schoolClass);

        return student;
    }

    public StudentResponse toResponseMapper(Student student) {
        StudentResponse response = new StudentResponse();

        response.setStudentIndex(student.getStudentIndex());
        response.setStudentId(student.getStudentId());
        response.setName(student.getName());
        response.setLastName(student.getLastName());
        response.setSchoolClassId(student.getSchoolClass().getSchoolClassId());
        response.setSchoolClassName(student.getSchoolClass().getSchoolClassName());

        return response;
    }

    public StudentResponses toResponseListMapper(List<Student> students) {
        return new StudentResponses(
                students
                        .stream()
                        .map(this::toResponseMapper)
                        .collect(Collectors.toList()));
    }
}
