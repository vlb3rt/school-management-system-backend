package vlb3rt.schoolmanagment.models.entities.person;

import jakarta.persistence.*;
import vlb3rt.schoolmanagment.interfaces.EntityInterface;
import vlb3rt.schoolmanagment.models.entities.structure.SchoolClass;

@Entity
@Table(name = "student")
public class Student implements EntityInterface {

    @Id
    @GeneratedValue
    private Long studentId;

    private String name;

    private String lastName;

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

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }
}
