package vlb3rt.schoolmanagment.models.dto.person.student;

import vlb3rt.schoolmanagment.interfaces.ResponseInterface;
import vlb3rt.schoolmanagment.models.entities.structure.SchoolClass;

public class StudentResponse implements ResponseInterface {

    private long studentId;

    private String name;

    private String lastName;

    private long schoolClassId;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
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

    public long getSchoolClassId() {
        return schoolClassId;
    }

    public void setSchoolClassId(long schoolClassId) {
        this.schoolClassId = schoolClassId;
    }
}
