package vlb3rt.schoolmanagment.mappers.person;

import org.springframework.stereotype.Component;
import vlb3rt.schoolmanagment.interfaces.MapperInterface;
import vlb3rt.schoolmanagment.models.dto.person.student.StudentResponse;
import vlb3rt.schoolmanagment.models.dto.person.student.StudentResponses;
import vlb3rt.schoolmanagment.models.entities.person.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentMapper {

    public Student toEntityMapper(StudentResponse studentResponse)  {
        return null;
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

    public List<Student> toEntityListMapper(List<StudentResponse> studetsList) {
        List<Student> students = new ArrayList<>();
        for (StudentResponse student : studetsList) {
            students.add(toEntityMapper(student));
        }
        return  students;
    }
}
