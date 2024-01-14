package vlb3rt.schoolmanagment.models.dto.person.student;

import vlb3rt.schoolmanagment.interfaces.ResponsesInterface;

import java.util.ArrayList;
import java.util.List;

public class StudentResponses implements ResponsesInterface {

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
