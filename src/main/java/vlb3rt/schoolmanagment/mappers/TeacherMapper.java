package vlb3rt.schoolmanagment.mappers;

import org.springframework.stereotype.Component;
import vlb3rt.schoolmanagment.models.CDMTeacher;
import vlb3rt.schoolmanagment.entities.Teacher;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherMapper {

    public Teacher toEntityMapper(CDMTeacher cdmTeacher) {
        Teacher teacher = new Teacher();

        teacher.setTeacherId(cdmTeacher.getTeacherId());
        teacher.setName(cdmTeacher.getName());
        teacher.setLastName(cdmTeacher.getLastName());
        teacher.setSchoolClassId(cdmTeacher.getSchoolClassId());

        return teacher;
    }

    public CDMTeacher toCDMMapper(Teacher teacher) {
        CDMTeacher cdmTeacher = new CDMTeacher();

        cdmTeacher.setTeacherId(teacher.getTeacherId());
        cdmTeacher.setName(teacher.getName());
        cdmTeacher.setLastName(teacher.getLastName());
        cdmTeacher.setSchoolClassId(teacher.getSchoolClassId());

        return cdmTeacher;
    }

    public List<Teacher> toEntityListMapper(List<CDMTeacher> cdmTeachers) {
        List<Teacher> teachers = new ArrayList<>();

        for (CDMTeacher cdmTeacher : cdmTeachers) {
            Teacher teacher = new Teacher();

            teacher.setTeacherId(cdmTeacher.getTeacherId());
            teacher.setName(cdmTeacher.getName());
            teacher.setLastName(cdmTeacher.getLastName());
            teacher.setSchoolClassId(cdmTeacher.getSchoolClassId());

            teachers.add(teacher);
        }

        return teachers;
    }

    public List<CDMTeacher> toCDMListMapper(List<Teacher> teachers) {
        List<CDMTeacher> cdmTeachers = new ArrayList<>();

        for (Teacher teacher : teachers) {
            CDMTeacher cdmTeacher = new CDMTeacher();

            cdmTeacher.setTeacherId(teacher.getTeacherId());
            cdmTeacher.setName(teacher.getName());
            cdmTeacher.setLastName(teacher.getLastName());
            cdmTeacher.setSchoolClassId(teacher.getSchoolClassId());

            cdmTeachers.add(cdmTeacher);
        }

        return cdmTeachers;
    }

}
