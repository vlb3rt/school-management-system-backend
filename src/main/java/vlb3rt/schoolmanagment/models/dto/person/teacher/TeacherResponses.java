package vlb3rt.schoolmanagment.models.dto.person.teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherResponses {

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
