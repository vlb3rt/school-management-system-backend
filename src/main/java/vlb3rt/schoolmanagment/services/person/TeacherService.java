package vlb3rt.schoolmanagment.services.person;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import vlb3rt.schoolmanagment.mappers.person.TeacherMapper;
import vlb3rt.schoolmanagment.models.dto.person.teacher.TeacherResponse;
import vlb3rt.schoolmanagment.models.dto.person.teacher.TeacherResponses;
import vlb3rt.schoolmanagment.models.entities.person.Teacher;
import vlb3rt.schoolmanagment.repositories.person.TeacherRepository;
import vlb3rt.schoolmanagment.responses.exceptions.EntityException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public Teacher getTeacherEntity(Long teacherId) throws EntityException {
        return teacherRepository
                .findById(teacherId)
                .orElseThrow(() -> new EntityException("not found"));
    }

    public TeacherResponses getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        teacherRepository.findAll().forEach(teachers::add);
        return teacherMapper.toResponseListMapper(teachers);
    }

    public void createTeacher(TeacherResponse teacherResponse) throws EntityException {
        teacherResponse.setTeacherId(null);
        if(createValidation(teacherResponse)) {
            teacherRepository.save(teacherMapper.toEntityMapper(teacherResponse));
        }
    }

    public void updateTeacher(TeacherResponse teacherResponse) throws EntityException {
        if(updateValidation(teacherResponse)) {
            teacherRepository.save(teacherMapper.toEntityMapper(teacherResponse));
        }
    }

    public void deleteTeacher(Long teacherId) throws EntityException {
        try {
            teacherRepository.deleteById(teacherId);
        } catch (DataIntegrityViolationException e) {
            throw new EntityException(e.getMessage());
        }
    }

    private boolean createValidation(TeacherResponse teacher) throws EntityException {
        TeacherResponses teachers = getAllTeachers();

        Optional<TeacherResponse> indexInUse = isTeacherIndexUsed(teachers, teacher.getTeacherIndex());

        if(indexInUse.isPresent()) {
            throw new EntityException("teacher with name: " + teacher.getTeacherIndex() + " already exists");
        }
        return true;
    }

    private boolean updateValidation(TeacherResponse teacher) throws EntityException {
        TeacherResponses teachers = getAllTeachers();

        if(isTeacherIdUsed(teachers, teacher.getTeacherId()).isEmpty()) {
            throw new EntityException("teacher with id: " + teacher.getTeacherId() + " does not exist");
        }

        Optional<TeacherResponse> indexInUse = isTeacherIndexUsed(teachers, teacher.getTeacherIndex());

        if(indexInUse.isPresent()) {
            if(!Objects.equals(indexInUse.get().getTeacherIndex(), teacher.getTeacherIndex())) {
                throw new EntityException("teacher with index: " + teacher.getTeacherIndex() + " already exists");
            }
        }
        return true;
    }

    private Optional<TeacherResponse> isTeacherIdUsed(TeacherResponses teacherResponses, Long teacherId) {
        return teacherResponses.getTeachers()
                .stream()
                .filter(teacherResponse -> teacherResponse.getTeacherId().longValue() ==  teacherId)
                .findFirst();
    }

    private Optional<TeacherResponse> isTeacherIndexUsed(TeacherResponses teacherResponses, Long teacherIndex) throws EntityException {
        if(teacherIndex == null) {
            throw new EntityException("teacherIndex can not be null");
        }

        return teacherResponses.getTeachers()
                .stream()
                .filter(teacherResponse -> teacherResponse.getTeacherIndex().longValue() == teacherIndex)
                .findFirst();
    }
}