package vlb3rt.schoolmanagment.mappers.structure;

import org.springframework.stereotype.Component;
import vlb3rt.schoolmanagment.interfaces.MapperInterface;
import vlb3rt.schoolmanagment.mappers.person.TeacherMapper;
import vlb3rt.schoolmanagment.models.dto.structure.schoolClass.SchoolClassResponse;
import vlb3rt.schoolmanagment.models.dto.structure.schoolClass.SchoolClassResponses;
import vlb3rt.schoolmanagment.models.entities.structure.SchoolClass;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SchoolClassMapper implements MapperInterface<SchoolClass, SchoolClassResponse, SchoolClassResponses> {

    private TeacherMapper teacherMapper;

    public SchoolClassMapper(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    @Override
    public SchoolClass toEntityMapper(SchoolClassResponse schoolClassResponse) {
        return null;
    }

    @Override
    public SchoolClassResponse toResponseMapper(SchoolClass schoolClass) {
        SchoolClassResponse schoolClassResponse = new SchoolClassResponse();

        schoolClassResponse.setSchoolClassId(schoolClass.getSchoolClassId());
        schoolClassResponse.setSchoolClassName(schoolClass.getSchoolClassName());
        schoolClassResponse.setTeacher(teacherMapper.toResponseMapper(schoolClass.getTeacher()));

        return schoolClassResponse;
    }

    @Override
    public SchoolClassResponses toResponseListMapper(List<SchoolClass> schoolClasses) {
        return new SchoolClassResponses(
                schoolClasses
                        .stream()
                        .map(this::toResponseMapper)
                        .collect(Collectors.toList()));
    }
}
