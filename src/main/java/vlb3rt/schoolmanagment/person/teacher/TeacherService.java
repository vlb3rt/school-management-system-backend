package vlb3rt.schoolmanagment.person.teacher;

import org.springframework.stereotype.Service;

import vlb3rt.schoolmanagment.entities.Teacher;
import vlb3rt.schoolmanagment.mappers.TeacherMapper;
import vlb3rt.schoolmanagment.models.CDMTeacher;

import java.util.Optional;

@Service
public class TeacherService {

    private final TeacherMapper teacherMapper;

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherMapper teacherMapper, TeacherRepository teacherRepository) {
        this.teacherMapper = teacherMapper;
        this.teacherRepository = teacherRepository;
    }

    public Optional<CDMTeacher> createTeacher(CDMTeacher cdmTeacher) {
        if(findSchoolClassByName(cdmTeacher.getPersonId()).isEmpty()) {
            return Optional.of(
                    teacherMapper.toCDMMapper(
                            teacherRepository.save(
                                    teacherMapper.toEntityMapper(cdmTeacher))));
        }
        return Optional.empty();
    }

    public Optional<CDMTeacher> findSchoolClassByName(int personId) {
        return teacherRepository.findTeacherByPersonId(personId)
                .map(teacherMapper::toCDMMapper);
    }

    public CDMTeacher readTeacherById(Long teacherId) {
        return teacherRepository.findById(teacherId)
                .map(teacherMapper::toCDMMapper)
                .orElse(null);
    }

    public void updateTeacher(Long teacherId, CDMTeacher cdmTeacher) {
        Optional<Teacher> teacher = teacherRepository.findById(teacherId);
        if(teacher.isPresent()) {
            teacher = Optional.of(teacherMapper.toEntityMapper(cdmTeacher));
            teacher.get().setTeacherId(cdmTeacher.getTeacherId());
            teacherRepository.save(teacher.get());
        }
    }

    public void deleteTeacher(Long teacherId) {
        teacherRepository.deleteById(teacherId);
    }

    public void deleteAllTeachers() {
        teacherRepository.deleteAll();
    }
}
