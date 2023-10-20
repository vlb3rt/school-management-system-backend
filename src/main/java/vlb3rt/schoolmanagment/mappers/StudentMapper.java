package vlb3rt.schoolmanagment.mappers;

import org.springframework.stereotype.Component;

import vlb3rt.schoolmanagment.interfaces.MapperInterface;
import vlb3rt.schoolmanagment.models.CDMStudent;
import vlb3rt.schoolmanagment.entities.Student;

import java.util.ArrayList;
import java.util.List;

@Component
public final class StudentMapper implements MapperInterface<Student, CDMStudent> {

    @Override
    public Student toEntityMapper(CDMStudent cdmStudent) {
        Student student = new Student();

        student.setStudentId(cdmStudent.getStudentId());
        student.setName(cdmStudent.getName());
        student.setLastName(cdmStudent.getLastName());
        student.setSchoolClassId(student.getSchoolClassId());

        return student;
    }

    @Override
    public CDMStudent toCDMMapper(Student student) {
        CDMStudent cdmStudent = new CDMStudent();

        cdmStudent.setStudentId(cdmStudent.getStudentId());
        cdmStudent.setName(student.getName());
        cdmStudent.setLastName(student.getLastName());
        cdmStudent.setSchoolClassId(student.getSchoolClassId());

        return cdmStudent;
    }

    @Override
    public List<Student> toEntityListMapper(List<CDMStudent> cdmStudents) {
        List<Student> students = new ArrayList<>();

        for (CDMStudent cdmStudent : cdmStudents) {
            Student student = new Student();

            student.setStudentId(cdmStudent.getStudentId());
            student.setName(cdmStudent.getName());
            student.setLastName(cdmStudent.getLastName());
            student.setSchoolClassId(student.getSchoolClassId());

            students.add(student);
        }

        return students;
    }

    @Override
    public List<CDMStudent> toCDMListMapper(List<Student> students) {
        List<CDMStudent> cdmStudents = new ArrayList<>();

        for (Student student : students) {
            CDMStudent cdmStudent = new CDMStudent();

            cdmStudent.setStudentId(cdmStudent.getStudentId());
            cdmStudent.setName(student.getName());
            cdmStudent.setLastName(student.getLastName());
            cdmStudent.setSchoolClassId(student.getSchoolClassId());

            cdmStudents.add(cdmStudent);
        }

        return cdmStudents;
    }
}