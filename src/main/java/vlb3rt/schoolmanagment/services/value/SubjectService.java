package vlb3rt.schoolmanagment.services.value;

import org.springframework.stereotype.Service;
import vlb3rt.schoolmanagment.models.dto.value.subject.SubjectResponse;
import vlb3rt.schoolmanagment.models.dto.value.subject.SubjectResponses;
import vlb3rt.schoolmanagment.mappers.value.SubjectMapper;
import vlb3rt.schoolmanagment.models.entities.value.Subject;
import vlb3rt.schoolmanagment.repositories.value.SubjectRepository;
import vlb3rt.schoolmanagment.responses.exceptions.EntityException;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    private final SubjectMapper subjectMapper;

    public SubjectService(SubjectRepository subjectRepository, SubjectMapper subjectMapper) {
        this.subjectRepository = subjectRepository;
        this.subjectMapper = subjectMapper;
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
}
