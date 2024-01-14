package vlb3rt.schoolmanagment.services.value;

import org.springframework.stereotype.Service;
import vlb3rt.schoolmanagment.models.dto.value.subject.SubjectResponse;
import vlb3rt.schoolmanagment.models.dto.value.subject.SubjectResponses;
import vlb3rt.schoolmanagment.mappers.value.SubjectMapper;
import vlb3rt.schoolmanagment.models.entities.value.Subject;
import vlb3rt.schoolmanagment.repositories.value.SubjectRepository;
import vlb3rt.schoolmanagment.responses.exceptions.EntityException;
import vlb3rt.schoolmanagment.services.person.TeacherService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    private final SubjectMapper subjectMapper;

    private final TeacherService teacherService;

    public SubjectService(SubjectRepository subjectRepository, SubjectMapper subjectMapper, TeacherService teacherService) {
        this.subjectRepository = subjectRepository;
        this.subjectMapper = subjectMapper;
        this.teacherService = teacherService;
    }

    public SubjectResponse getSubject(long subjectId) throws EntityException {
        return subjectRepository
                .findById(subjectId)
                .map(subjectMapper::toResponseMapper)
                .orElseThrow(() -> new EntityException("not found"));
    }

    public SubjectResponses getAllSubjects() {
        List<Subject> subjects = new ArrayList<>();
        subjectRepository.findAll().forEach(subjects::add);
        return subjectMapper.toResponseListMapper(subjects);
    }

    public void createSubject(SubjectResponse subjectResponse) throws EntityException {
        if(validateSubject(subjectResponse)) {
            subjectRepository.save(subjectMapper.toEntityMapper(subjectResponse));
        }
    }

    public void updateSubject(SubjectResponse subjectResponse) throws EntityException {
        if(validateSubject(subjectResponse)) {
            subjectRepository.save(subjectMapper.toEntityMapper(subjectResponse));
        }
    }

    public void deleteSubject(long subjectId) throws EntityException {
        if(isSubjectUsed(subjectId)) {
            subjectRepository.deleteById(subjectId);
        }
    }

    private boolean validateSubject(SubjectResponse subject) throws EntityException {
        SubjectResponses subjects = getAllSubjects();

        boolean nameExists = subjects.getSubjects()
                .stream()
                .anyMatch(subjectResponse -> subjectResponse.getSubjectName().equalsIgnoreCase(subject.getSubjectName()));

        if(nameExists) {
            throw new EntityException("subject named: " + subject.getSubjectName() + " already exists");
        }

        if(subject.getSubjectId() != 0) {
            boolean idExists = subjects.getSubjects()
                    .stream()
                    .anyMatch(subjectResponse -> subjectResponse.getSubjectId() == subject.getSubjectId());

            if(!idExists) {
                throw new EntityException("subject with id: " + subject.getSubjectId() + " does not exist");
            }

            return true;
        } else {
            return true;
        }
    }

    private boolean isSubjectUsed(long subjectId) throws EntityException {
        boolean subjectInUse =  teacherService.getAllTeachers()
                .getTeachers()
                .stream()
                .anyMatch(teacherResponse -> teacherResponse.getMainSubject().getSubjectId() == subjectId);

        if (subjectInUse) {
            throw new EntityException("subject with id: " + subjectId + " references other tables");
        }
        return true;
    }
}
