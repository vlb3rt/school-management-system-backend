package vlb3rt.schoolmanagment.controllers.person;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vlb3rt.schoolmanagment.models.dto.person.student.StudentResponse;
import vlb3rt.schoolmanagment.models.dto.person.student.StudentResponses;
import vlb3rt.schoolmanagment.responses.exceptions.EntityException;
import vlb3rt.schoolmanagment.services.person.StudentService;

@CrossOrigin(originPatterns = "*", allowCredentials = "true", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
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
        } catch (EntityException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatusCode.valueOf(422));
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<StudentResponses> getALl() {
        return new ResponseEntity<StudentResponses>(studentService.getAllStudents(), HttpStatusCode.valueOf(200));
    }

    /**
     * POST methods
     */
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody StudentResponse studentResponse) {
        try {
            studentService.createStudent(studentResponse);
            return new ResponseEntity<>(HttpStatusCode.valueOf(200));
        } catch (EntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(422));
        }
    }

    /**
     * PUT methods
     */
    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody StudentResponse studentResponse) {
        try {
            studentService.updateStudent(studentResponse);
            return new ResponseEntity<>(HttpStatusCode.valueOf(200));
        } catch (EntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(422));
        }
    }

    /**
     * DELETE methods
     */
    @GetMapping("/delete/{studentId}")
    public ResponseEntity<String> delete(@PathVariable("studentId") Long studentId) {
        try {
            studentService.deleteStudent(studentId);
            return new ResponseEntity<>(HttpStatusCode.valueOf(200));
        } catch (EntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(422));
        }
    }
}
