package vlb3rt.schoolmanagment.mappers.structure;

import org.springframework.stereotype.Component;
import vlb3rt.schoolmanagment.mappers.person.StudentMapper;
import vlb3rt.schoolmanagment.mappers.person.TeacherMapper;
import vlb3rt.schoolmanagment.models.dto.structure.schoolClass.SchoolClassResponse;
import vlb3rt.schoolmanagment.models.dto.structure.schoolClass.SchoolClassResponses;
import vlb3rt.schoolmanagment.models.entities.structure.SchoolClass;
import vlb3rt.schoolmanagment.responses.exceptions.EntityException;
import vlb3rt.schoolmanagment.services.person.TeacherService;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SchoolClassMapper {

    private final TeacherMapper teacherMapper;

    private final TeacherService teacherService;

    private final StudentMapper studentMapper;

    public SchoolClassMapper(TeacherMapper teacherMapper, TeacherService teacherService, StudentMapper studentMapper) {
        this.teacherMapper = teacherMapper;
        this.teacherService = teacherService;
        this.studentMapper = studentMapper;
    }

    public SchoolClass toEntityMapper(SchoolClassResponse schoolClassResponse, SchoolClass schoolClass) throws EntityException {
        schoolClass.setSchoolClassId(schoolClassResponse.getSchoolClassId());
        schoolClass.setSchoolClassName(schoolClassResponse.getSchoolClassName());
        schoolClass.setTeacher(teacherService.getTeacherEntity(schoolClassResponse.getTeacher().getTeacherId()));

        return schoolClass;
    }

    public SchoolClassResponse toResponseMapper(SchoolClass schoolClass) {
        SchoolClassResponse schoolClassResponse = new SchoolClassResponse();

        schoolClassResponse.setSchoolClassId(schoolClass.getSchoolClassId());
        schoolClassResponse.setSchoolClassName(schoolClass.getSchoolClassName());
        schoolClassResponse.setTeacher(teacherMapper.toResponseMapper(schoolClass.getTeacher()));
        schoolClassResponse.setStudents(
                schoolClass.getStudents()
                        .stream()
                        .map(studentMapper::toResponseMapper)
                        .collect(Collectors.toList()));
        return schoolClassResponse;
    }

    public SchoolClassResponses toResponseListMapper(List<SchoolClass> schoolClasses) {
        return new SchoolClassResponses(
                schoolClasses
                        .stream()
                        .map(this::toResponseMapper)
                        .collect(Collectors.toList()));
    }
}
