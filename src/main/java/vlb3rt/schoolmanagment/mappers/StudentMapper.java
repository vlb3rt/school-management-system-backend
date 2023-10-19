package vlb3rt.schoolmanagment.mappers;

import org.springframework.stereotype.Component;
import vlb3rt.schoolmanagment.models.CDMStudent;
import vlb3rt.schoolmanagment.entities.Student;

import java.util.ArrayList;
import java.util.List;

@Component
public final class StudentMapper {

    public Student toEntityMapper(CDMStudent cdmStudent) {
        Student student = new Student();

        student.setName(cdmStudent.getName());
        student.setLastName(cdmStudent.getLastName());
        student.setSchoolClassId(student.getSchoolClassId());

        return student;
    }

    public CDMStudent toCDMMapper(Student student) {
        CDMStudent cdmStudent = new CDMStudent();

        cdmStudent.setStudentID(cdmStudent.getStudentID());
        cdmStudent.setName(student.getName());
        cdmStudent.setLastName(student.getLastName());
        cdmStudent.setSchoolClassId(student.getSchoolClassId());

        return cdmStudent;
    }

    public List<Student> toEntityListMapper(List<CDMStudent> cdmStudents) {
        List<Student> students = new ArrayList<>();

        for (CDMStudent cdmStudent : cdmStudents) {
            Student student = new Student();

            student.setName(cdmStudent.getName());
            student.setLastName(cdmStudent.getLastName());
            student.setSchoolClassId(student.getSchoolClassId());

            students.add(student);
        }

        return students;
    }

    public List<CDMStudent> toCDMListMapper(List<Student> students) {
        List<CDMStudent> cdmStudents = new ArrayList<>();

        for (Student student : students) {
            CDMStudent cdmStudent = new CDMStudent();

            cdmStudent.setStudentID(cdmStudent.getStudentID());
            cdmStudent.setName(student.getName());
            cdmStudent.setLastName(student.getLastName());
            cdmStudent.setSchoolClassId(student.getSchoolClassId());

            cdmStudents.add(cdmStudent);
        }

        return cdmStudents;
    }

}
