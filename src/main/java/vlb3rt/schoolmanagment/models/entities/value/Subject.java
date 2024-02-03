package vlb3rt.schoolmanagment.models.entities.value;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue
    private Long subjectId;

    private String name;

    private String shortName;

    public Subject() {

    }

    public Subject(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    public Subject(Long subjectId, String name, String shortName) {
        this.subjectId = subjectId;
        this.name = name;
        this.shortName = shortName;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
