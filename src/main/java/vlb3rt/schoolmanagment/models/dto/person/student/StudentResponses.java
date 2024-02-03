package vlb3rt.schoolmanagment.models.dto.person.student;

import java.util.ArrayList;
import java.util.List;

public class StudentResponses {

    private List<StudentResponse> students = new ArrayList<>();

    public StudentResponses(List<StudentResponse> students) {
        this.students = students;
    }

    public List<StudentResponse> getStudents() {
        return students;
    }

    public void setStudents(List<StudentResponse> students) {
        this.students = students;
    }
}
