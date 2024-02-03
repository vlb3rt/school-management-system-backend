package vlb3rt.schoolmanagment.mappers.value;

import org.springframework.stereotype.Component;
import vlb3rt.schoolmanagment.models.dto.value.subject.SubjectResponse;
import vlb3rt.schoolmanagment.models.dto.value.subject.SubjectResponses;
import vlb3rt.schoolmanagment.models.entities.value.Subject;

import java.util.ArrayList;
import java.util.List;

@Component
public class SubjectMapper {

    public Subject toEntityMapper(SubjectResponse subjectResponse) {
        Subject subject = new Subject();

        subject.setSubjectId(subjectResponse.getSubjectId());
        subject.setName(subjectResponse.getSubjectName());
        subject.setShortName(subjectResponse.getSubjectShortName());

        return subject;
    }

    public SubjectResponse toResponseMapper(Subject subject) {
        SubjectResponse response = new SubjectResponse();

        response.setSubjectId(subject.getSubjectId());
        response.setSubjectName(subject.getName());
        response.setSubjectShortName(subject.getShortName());

        return response;
    }

    public SubjectResponses toResponseListMapper(List<Subject> subjects) {
        List<SubjectResponse> responses = new ArrayList<>();

        for (Subject subject : subjects) {
            responses.add(toResponseMapper(subject));
        }
        return new SubjectResponses(responses);
    }
}
