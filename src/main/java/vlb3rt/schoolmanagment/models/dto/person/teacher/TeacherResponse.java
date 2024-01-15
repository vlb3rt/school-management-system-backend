package vlb3rt.schoolmanagment.models.dto.person.teacher;

import vlb3rt.schoolmanagment.interfaces.ResponseInterface;
import vlb3rt.schoolmanagment.models.dto.value.subject.SubjectResponse;

public class TeacherResponse implements ResponseInterface {

    private Long teacherId;

    private String name;

    private String lastName;

    private Long teacherIndex;

    private SubjectResponse mainSubject;

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
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

    public Long getTeacherIndex() {
        return teacherIndex;
    }

    public void setTeacherIndex(Long teacherIndex) {
        this.teacherIndex = teacherIndex;
    }

    public SubjectResponse getMainSubject() {
        return mainSubject;
    }

    public void setMainSubject(SubjectResponse mainSubject) {
        this.mainSubject = mainSubject;
    }
}
