package vlb3rt.schoolmanagment.models.dto.value.subject;

import vlb3rt.schoolmanagment.interfaces.ResponseInterface;

public class SubjectResponse implements ResponseInterface {

    private long subjectId;

    private String subjectName;

    private String subjectShortName;

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectShortName() {
        return subjectShortName;
    }

    public void setSubjectShortName(String subjectShortName) {
        this.subjectShortName = subjectShortName;
    }
}
