package vlb3rt.schoolmanagment.models.entities.person;

import jakarta.persistence.*;
import vlb3rt.schoolmanagment.interfaces.EntityInterface;
import vlb3rt.schoolmanagment.models.entities.value.Subject;

@Entity
@Table(name = "teacher")
public class Teacher implements EntityInterface {

    @Id
    @GeneratedValue
    private Long teacherId;

    private String name;

    private String lastName;

    @ManyToOne
    @JoinColumn(name = "mainSubject")
    private Subject mainSubject;

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

    public Subject getMainSubject() {
        return mainSubject;
    }

    public void setMainSubject(Subject mainSubject) {
        this.mainSubject = mainSubject;
    }
}