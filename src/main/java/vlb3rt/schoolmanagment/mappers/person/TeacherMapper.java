package vlb3rt.schoolmanagment.mappers.person;

import org.springframework.stereotype.Component;
import vlb3rt.schoolmanagment.mappers.value.SubjectMapper;
import vlb3rt.schoolmanagment.models.dto.person.teacher.TeacherResponse;
import vlb3rt.schoolmanagment.models.dto.person.teacher.TeacherResponses;
import vlb3rt.schoolmanagment.models.entities.person.Teacher;
import vlb3rt.schoolmanagment.responses.exceptions.EntityException;
import vlb3rt.schoolmanagment.services.value.SubjectService;

import java.util.ArrayList;
import java.util.List;


@Component
public class TeacherMapper {

    private final SubjectMapper subjectMapper;

    private final SubjectService subjectService;

    public TeacherMapper(SubjectMapper subjectMapper, SubjectService subjectService, SubjectService subjectService1) {
        this.subjectMapper = subjectMapper;
        this.subjectService = subjectService1;
    }

    public Teacher toEntityMapper(TeacherResponse teacherResponse) throws EntityException {
        Teacher teacher = new Teacher();

        teacher.setTeacherId(teacherResponse.getTeacherId());
        teacher.setName(teacherResponse.getName());
        teacher.setLastName(teacherResponse.getLastName());
        teacher.setTeacherIndex(teacherResponse.getTeacherIndex());
        teacher.setMainSubject(subjectService.getSubjectEntity(teacherResponse.getMainSubject().getSubjectId()));
        return teacher;
    }

    public TeacherResponse toResponseMapper(Teacher teacher) {
        TeacherResponse teacherResponse = new TeacherResponse();

        teacherResponse.setTeacherId(teacher.getTeacherId());
        teacherResponse.setName(teacher.getName());
        teacherResponse.setLastName(teacher.getLastName());
        teacherResponse.setTeacherIndex(teacher.getTeacherIndex());
        teacherResponse.setMainSubject(subjectMapper.toResponseMapper(teacher.getMainSubject()));

        return teacherResponse;
    }

    public TeacherResponses toResponseListMapper(List<Teacher> teachers) {
        List<TeacherResponse> responses = new ArrayList<>();

        for (Teacher teacher : teachers) {
            responses.add(toResponseMapper(teacher));
        }
        return new TeacherResponses(responses);
    }
}
