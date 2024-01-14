package vlb3rt.schoolmanagment.models.dto.person.teacher;

import vlb3rt.schoolmanagment.interfaces.ResponseInterface;
import vlb3rt.schoolmanagment.models.dto.value.subject.SubjectResponse;

public class TeacherResponse implements ResponseInterface {

    private long teacherId;

    private String name;

    private String lastName;

    private SubjectResponse mainSubject;

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public SubjectResponse getMainSubject() {
        return mainSubject;
    }

    public void setMainSubject(SubjectResponse mainSubject) {
        this.mainSubject = mainSubject;
    }
}
