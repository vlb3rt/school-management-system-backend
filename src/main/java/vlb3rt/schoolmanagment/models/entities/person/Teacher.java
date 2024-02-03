package vlb3rt.schoolmanagment.models.entities.person;

import jakarta.persistence.*;
import vlb3rt.schoolmanagment.models.entities.value.Subject;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue
    private Long teacherId;

    private String name;

    private String lastName;

    private Long teacherIndex;

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

    public Long getTeacherIndex() {
        return teacherIndex;
    }

    public void setTeacherIndex(Long teacherIndex) {
        this.teacherIndex = teacherIndex;
    }

    public Subject getMainSubject() {
        return mainSubject;
    }

    public void setMainSubject(Subject mainSubject) {
        this.mainSubject = mainSubject;
    }
}