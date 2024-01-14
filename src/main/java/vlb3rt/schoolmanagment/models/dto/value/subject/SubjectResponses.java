package vlb3rt.schoolmanagment.models.dto.value.subject;

import vlb3rt.schoolmanagment.interfaces.ResponsesInterface;

import java.util.ArrayList;
import java.util.List;

public class SubjectResponses implements ResponsesInterface {

    private List<SubjectResponse> subjects = new ArrayList<>();

    public SubjectResponses(List<SubjectResponse> subjects) {
        this.subjects = subjects;
    }

    public List<SubjectResponse> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectResponse> subjects) {
        this.subjects = subjects;
    }
}