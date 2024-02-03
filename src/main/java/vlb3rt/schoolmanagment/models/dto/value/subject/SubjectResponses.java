package vlb3rt.schoolmanagment.models.dto.value.subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectResponses {

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
