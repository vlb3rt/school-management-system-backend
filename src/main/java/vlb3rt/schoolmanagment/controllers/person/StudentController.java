package vlb3rt.schoolmanagment.controllers.person;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vlb3rt.schoolmanagment.models.dto.person.student.StudentResponse;
import vlb3rt.schoolmanagment.models.dto.person.student.StudentResponses;
import vlb3rt.schoolmanagment.responses.exceptions.EntityException;
import vlb3rt.schoolmanagment.services.person.StudentService;

@RestController
@RequestMapping("/person/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getStudent")
    public ResponseEntity<?> getStudent(@RequestParam("studentId") long studentId) throws EntityException {
        try {
            return new ResponseEntity<StudentResponse>(studentService.getStudent(studentId), HttpStatusCode.valueOf(200));
        }catch (EntityException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatusCode.valueOf(422));
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<StudentResponses> getALl() {
        return new ResponseEntity<StudentResponses>(studentService.getAllStudents(), HttpStatusCode.valueOf(200));
    }

}
