package vlb3rt.schoolmanagment.models.entities.structure;

import jakarta.persistence.*;
import vlb3rt.schoolmanagment.interfaces.EntityInterface;
import vlb3rt.schoolmanagment.models.entities.person.Student;
import vlb3rt.schoolmanagment.models.entities.person.Teacher;

import java.util.List;

@Entity
@Table(name = "class")
public class SchoolClass implements EntityInterface {

    @Id
    @GeneratedValue
    private Long schoolClassId;

    private String schoolClassName;

    @OneToOne
    @JoinColumn(name = "teacherId")
    private Teacher teacher;

    @OneToMany(mappedBy = "schoolClass", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students;

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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
