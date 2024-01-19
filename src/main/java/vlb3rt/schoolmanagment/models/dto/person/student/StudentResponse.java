package vlb3rt.schoolmanagment.models.dto.person.student;

import vlb3rt.schoolmanagment.interfaces.ResponseInterface;
import vlb3rt.schoolmanagment.models.entities.structure.SchoolClass;

public class StudentResponse implements ResponseInterface {

    private Long studentId;

    private String name;

    private String lastName;

    private Long studentIndex;

    private Long schoolClassId;

    private String schoolClassName;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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

    public Long getStudentIndex() {
        return studentIndex;
    }

    public void setStudentIndex(Long studentIndex) {
        this.studentIndex = studentIndex;
    }

    public Long getSchoolClassId() {
        return schoolClassId;
    }

    public void setSchoolClassId(Long schoolClassId) {
        this.schoolClassId = schoolClassId;
    }

    public String getSchoolClassName() {
        return schoolClassName;
    }

    public void setSchoolClassName(String schoolClassName) {
        this.schoolClassName = schoolClassName;
    }
}
