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
import java.util.Optional;

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

    public Optional<SubjectResponse> getSubject(long subjectId) throws EntityException {
        return subjectRepository
                .findById(subjectId)
                .map(subjectMapper::toResponseMapper);
    }

    public SubjectResponses getAllSubjects() {
        List<Subject> subjects = new ArrayList<>();
        subjectRepository.findAll().forEach(subjects::add);
        return subjectMapper.toResponseListMapper(subjects);
    }

    public void createSubject(SubjectResponse subjectResponse) throws EntityException {
        subjectResponse.setSubjectId(0);
        if(createValidation(subjectResponse)) {
            subjectRepository.save(subjectMapper.toEntityMapper(subjectResponse));
        }
    }

    public void updateSubject(SubjectResponse subjectResponse) throws EntityException {
        if(updateValidation(subjectResponse)) {
            subjectRepository.save(subjectMapper.toEntityMapper(subjectResponse));
        }
    }

    public void deleteSubject(long subjectId) throws EntityException {
        if(isSubjectUsed(subjectId)) {
            subjectRepository.deleteById(subjectId);
        }
    }

    private boolean createValidation(SubjectResponse subject) throws EntityException {
        SubjectResponses subjects = getAllSubjects();

        Optional<SubjectResponse> nameInUse = isSubjectNameUsed(subjects, subject.getSubjectName());

        if(nameInUse.isPresent()) {
            throw new EntityException("subject with name: " + subject.getSubjectName() + " already exists");
        }
        return true;
    }

    private boolean updateValidation(SubjectResponse subject) throws EntityException {
        SubjectResponses subjects = getAllSubjects();

        if(isSubjectIdUsed(subjects, subject.getSubjectId()).isEmpty()) {
            throw new EntityException("subject with id: " + subject.getSubjectId() + " does not exist");
        }

        Optional<SubjectResponse> nameInUse = isSubjectNameUsed(subjects, subject.getSubjectName());

        if(nameInUse.isPresent()) {
            if(nameInUse.get().getSubjectId() != subject.getSubjectId()) {
                throw new EntityException("subject with name: " + subject.getSubjectName() + " already exists");
            }
        }
        return true;
    }

    private Optional<SubjectResponse> isSubjectIdUsed(SubjectResponses subjectResponses, long subjectId) {
        return subjectResponses.getSubjects()
                .stream()
                .filter(subjectResponse -> subjectResponse.getSubjectId() == subjectId)
                .findFirst();
    }

    private Optional<SubjectResponse> isSubjectNameUsed(SubjectResponses subjectResponses, String subjectName) throws EntityException {
        if(subjectName == null || subjectName.isEmpty() || subjectName.isBlank()) {
            throw new EntityException("subjectName can not be null, empty nor blank");
        }
        return subjectResponses.getSubjects()
                .stream()
                .filter(subjectResponse -> subjectResponse.getSubjectName().equalsIgnoreCase(subjectName))
                .findFirst();
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
