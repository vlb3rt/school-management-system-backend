package vlb3rt.schoolmanagment.models.entities.person;

import jakarta.persistence.*;
import vlb3rt.schoolmanagment.models.entities.structure.SchoolClass;

import java.io.Serializable;

@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @GeneratedValue
    private Long studentId;

    private String name;

    private String lastName;

    private Long studentIndex;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_class_id")
    private SchoolClass schoolClass;

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

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }
}
