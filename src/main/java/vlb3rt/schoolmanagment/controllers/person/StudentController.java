package vlb3rt.schoolmanagment.controllers.person;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vlb3rt.schoolmanagment.models.dto.person.student.StudentResponses;
import vlb3rt.schoolmanagment.services.person.StudentService;

@RequestMapping("/person/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<StudentResponses> getALl() {
        return new ResponseEntity<StudentResponses>(studentService.getAllStudents(), HttpStatusCode.valueOf(200));
    }

}
