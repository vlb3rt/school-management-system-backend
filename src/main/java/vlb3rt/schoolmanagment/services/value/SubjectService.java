package vlb3rt.schoolmanagment.services.value;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import vlb3rt.schoolmanagment.models.dto.value.subject.SubjectResponse;
import vlb3rt.schoolmanagment.models.dto.value.subject.SubjectResponses;
import vlb3rt.schoolmanagment.mappers.value.SubjectMapper;
import vlb3rt.schoolmanagment.models.entities.value.Subject;
import vlb3rt.schoolmanagment.repositories.value.SubjectRepository;
import vlb3rt.schoolmanagment.responses.exceptions.EntityException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    private final SubjectMapper subjectMapper;

    public SubjectService(SubjectRepository subjectRepository, SubjectMapper subjectMapper) {
        this.subjectRepository = subjectRepository;
        this.subjectMapper = subjectMapper;
    }

    public SubjectResponse getSubject(Long subjectId) throws EntityException {
        return subjectRepository
                .findById(subjectId)
                .map(subjectMapper::toResponseMapper)
                .orElseThrow(() -> new EntityException(""));
    }

    public Subject getSubjectEntity(Long subjectId) throws EntityException {
        return subjectRepository
                .findById(subjectId)
                .orElseThrow(() -> new EntityException("not found"));
    }

    public SubjectResponses getAllSubjects() {
        List<Subject> subjects = new ArrayList<>();
        subjectRepository.findAll().forEach(subjects::add);
        return subjectMapper.toResponseListMapper(subjects);
    }

    public void createSubject(SubjectResponse subjectResponse) throws EntityException {
        subjectResponse.setSubjectId(0L);
        if(createValidation(subjectResponse)) {
            subjectRepository.save(subjectMapper.toEntityMapper(subjectResponse));
        }
    }

    public void updateSubject(SubjectResponse subjectResponse) throws EntityException {
        if(updateValidation(subjectResponse)) {
            subjectRepository.save(subjectMapper.toEntityMapper(subjectResponse));
        }
    }

    public void deleteSubject(Long subjectId) throws EntityException {
        try {
            subjectRepository.deleteById(subjectId);
        } catch (DataIntegrityViolationException e) {
            throw new EntityException(e.getMessage());
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
            if(nameInUse.get().getSubjectId().longValue() != subject.getSubjectId()) {
                throw new EntityException("subject with name: " + subject.getSubjectName() + " already exists");
            }
        }
        return true;
    }

    private Optional<SubjectResponse> isSubjectIdUsed(SubjectResponses subjectResponses, Long subjectId) {
        return subjectResponses.getSubjects()
                .stream()
                .filter(subjectResponse -> subjectResponse.getSubjectId().longValue() == subjectId)
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
}
