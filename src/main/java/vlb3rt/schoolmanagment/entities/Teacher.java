package vlb3rt.schoolmanagment.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import vlb3rt.schoolmanagment.interfaces.EntityInterface;

@Entity
@Table(name = "teacher")
public class Teacher implements EntityInterface {

    @Id
    @GeneratedValue
    private Long teacherId;

    private String name;

    private String lastName;

    private Long schoolClassId;

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

    public Long getSchoolClassId() {
        return schoolClassId;
    }

    public void setSchoolClassId(Long schoolClassId) {
        this.schoolClassId = schoolClassId;
    }
}
