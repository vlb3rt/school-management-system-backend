package vlb3rt.schoolmanagment.person.student;

import org.springframework.web.bind.annotation.*;
import vlb3rt.schoolmanagment.models.CDMStudent;

@RestController
@RequestMapping("person/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "/create")
    public void createStudent(
            @RequestBody CDMStudent cdmStudent
    ) {
        studentService.createStudent(cdmStudent);
    }

    @GetMapping(value = "/read")
    public CDMStudent readStudent(
            @RequestParam Long studentId
    ) {
        return studentService.readStudentById(studentId);
    }

    @PutMapping(value = "/update")
    public void updateStudent(
            @RequestParam("studentId") Long studentId,
            @RequestBody CDMStudent cdmStudent
    ) {
        studentService.updateStudent(studentId, cdmStudent);
    }

    @DeleteMapping(value = "/delete")
    public void deleteStudent(
            @RequestParam("studentId") Long studentId
    ) {
        studentService.deleteStudent(studentId);
    }

    @DeleteMapping(value = "/deleteAll")
    public void deleteAllStudents() {
        studentService.deleteAllStudents();
    }

}
