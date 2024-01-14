package vlb3rt.schoolmanagment.models.dto.person.teacher;

import vlb3rt.schoolmanagment.interfaces.ResponsesInterface;

import java.util.ArrayList;
import java.util.List;

public class TeacherResponses implements ResponsesInterface {

    private List<TeacherResponse> teachers = new ArrayList<>();

    public TeacherResponses(List<TeacherResponse> teachers) {
        this.teachers = teachers;
    }

    public List<TeacherResponse> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TeacherResponse> teachers) {
        this.teachers = teachers;
    }
}
