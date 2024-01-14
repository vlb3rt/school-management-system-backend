package vlb3rt.schoolmanagment.models.dto.structure.schoolClass;

import vlb3rt.schoolmanagment.interfaces.ResponseInterface;
import vlb3rt.schoolmanagment.models.dto.person.student.StudentResponse;
import vlb3rt.schoolmanagment.models.dto.person.teacher.TeacherResponse;

import java.util.List;

public class SchoolClassResponse implements ResponseInterface {

    private long schoolClassId;

    private String schoolClassName;

    private TeacherResponse teacher;

    private List<StudentResponse> students;

    public long getSchoolClassId() {
        return schoolClassId;
    }

    public void setSchoolClassId(long schoolClassId) {
        this.schoolClassId = schoolClassId;
    }

    public String getSchoolClassName() {
        return schoolClassName;
    }

    public void setSchoolClassName(String schoolClassName) {
        this.schoolClassName = schoolClassName;
    }

    public TeacherResponse getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherResponse teacher) {
        this.teacher = teacher;
    }

    public List<StudentResponse> getStudents() {
        return students;
    }

    public void setStudents(List<StudentResponse> students) {
        this.students = students;
    }
}
