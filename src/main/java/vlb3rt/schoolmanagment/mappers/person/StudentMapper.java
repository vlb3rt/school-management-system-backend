package vlb3rt.schoolmanagment.mappers.person;

import vlb3rt.schoolmanagment.interfaces.MapperInterface;
import vlb3rt.schoolmanagment.models.dto.person.student.StudentResponse;
import vlb3rt.schoolmanagment.models.dto.person.student.StudentResponses;
import vlb3rt.schoolmanagment.models.entities.person.Student;

import java.util.List;
import java.util.stream.Collectors;

public class StudentMapper implements MapperInterface<Student, StudentResponse, StudentResponses> {

    @Override
    public Student toEntityMapper(StudentResponse studentResponse) {
        return null;
    }

    @Override
    public StudentResponse toResponseMapper(Student student) {
        return null;
    }

    @Override
    public StudentResponses toResponseListMapper(List<Student> students) {
        return new StudentResponses(
                students
                        .stream()
                        .map(this::toResponseMapper)
                        .collect(Collectors.toList()));
    }
}
