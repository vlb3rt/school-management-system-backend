package vlb3rt.schoolmanagment.mappers.person;

import org.springframework.stereotype.Component;
import vlb3rt.schoolmanagment.interfaces.MapperInterface;
import vlb3rt.schoolmanagment.mappers.value.SubjectMapper;
import vlb3rt.schoolmanagment.models.dto.person.teacher.TeacherResponse;
import vlb3rt.schoolmanagment.models.dto.person.teacher.TeacherResponses;
import vlb3rt.schoolmanagment.models.dto.value.subject.SubjectResponse;
import vlb3rt.schoolmanagment.models.entities.person.Teacher;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherMapper implements MapperInterface<Teacher, TeacherResponse, TeacherResponses> {

    private SubjectMapper subjectMapper;

    public TeacherMapper(SubjectMapper subjectMapper) {
        this.subjectMapper = subjectMapper;
    }

    @Override
    public Teacher toEntityMapper(TeacherResponse teacherResponse) {
        return null;
    }

    @Override
    public TeacherResponse toResponseMapper(Teacher teacher) {
        TeacherResponse teacherResponse = new TeacherResponse();

        teacherResponse.setTeacherId(teacher.getTeacherId());
        teacherResponse.setName(teacher.getName());
        teacherResponse.setLastName(teacher.getLastName());
        teacherResponse.setMainSubject(subjectMapper.toResponseMapper(teacher.getMainSubject()));

        return teacherResponse;
    }

    @Override
    public TeacherResponses toResponseListMapper(List<Teacher> teachers) {
        List<TeacherResponse> responses = new ArrayList<>();

        for (Teacher teacher : teachers) {
            responses.add(toResponseMapper(teacher));
        }
        return new TeacherResponses(responses);
    }
}
