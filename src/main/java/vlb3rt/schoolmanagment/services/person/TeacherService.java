package vlb3rt.schoolmanagment.services.person;

import org.springframework.stereotype.Service;
import vlb3rt.schoolmanagment.mappers.person.TeacherMapper;
import vlb3rt.schoolmanagment.models.dto.person.teacher.TeacherResponse;
import vlb3rt.schoolmanagment.models.dto.person.teacher.TeacherResponses;
import vlb3rt.schoolmanagment.models.entities.person.Teacher;
import vlb3rt.schoolmanagment.repositories.person.TeacherRepository;
import vlb3rt.schoolmanagment.responses.exceptions.EntityException;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    private final TeacherMapper teacherMapper;

    public TeacherService(TeacherRepository teacherRepository, TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }

    public TeacherResponse getTeacher(long teacherId) throws EntityException {
        return teacherRepository
                .findById(teacherId)
                .map(teacherMapper::toResponseMapper)
                .orElseThrow(() -> new EntityException("not found"));
    }

    public TeacherResponses getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        teacherRepository.findAll().forEach(teachers::add);
        return teacherMapper.toResponseListMapper(teachers);
    }
}
