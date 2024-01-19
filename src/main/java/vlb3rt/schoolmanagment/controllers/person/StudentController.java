package vlb3rt.schoolmanagment.controllers.person;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import vlb3rt.schoolmanagment.models.dto.person.student.StudentResponse;
import vlb3rt.schoolmanagment.models.dto.person.student.StudentResponses;
import vlb3rt.schoolmanagment.models.dto.person.teacher.TeacherResponse;
import vlb3rt.schoolmanagment.models.entities.person.Student;
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
            return new ResponseEntity<StudentResponse>(studentService.getStudent(studentId), getHeaders(), HttpStatusCode.valueOf(200));
        }catch (EntityException e) {
            return new ResponseEntity<String>(e.getMessage(), getHeaders(), HttpStatusCode.valueOf(422));
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<StudentResponses> getALl() {
        return new ResponseEntity<StudentResponses>(studentService.getAllStudents(), getHeaders(), HttpStatusCode.valueOf(200));
    }

    /** POST methods */
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody StudentResponse studentResponse) {
        try {
            studentService.createStudent(studentResponse);
            return new ResponseEntity<>(getHeaders(), HttpStatusCode.valueOf(200));
        } catch (EntityException e) {
            return new ResponseEntity<>(e.getMessage(), getHeaders(), HttpStatusCode.valueOf(422));
        }
    }

    /** PUT methods */
    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody StudentResponse studentResponse) {
        try {
            studentService.updateStudent(studentResponse);
            return new ResponseEntity<>(getHeaders(), HttpStatusCode.valueOf(200));
        } catch (EntityException e) {
            return new ResponseEntity<>(e.getMessage(), getHeaders(), HttpStatusCode.valueOf(422));
        }
    }

    /** DELETE methods */
    @DeleteMapping("/delete")
    public ResponseEntity<String> update(@RequestParam("studentId") Long studentId) {
        try {
            studentService.deleteStudent(studentId);
            return new ResponseEntity<>(getHeaders(), HttpStatusCode.valueOf(200));
        } catch (EntityException e) {
            return new ResponseEntity<>(e.getMessage(), getHeaders(), HttpStatusCode.valueOf(422));
        }
    }

    private MultiValueMap<String, String> getHeaders() {
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Credentials", "true");
        headers.add("Access-Control-Allow-Headers", "Content-Type, Content-Length, Accept-Encoding, X-CSRF-Token, Authorization, accept, origin, Cache-Control, X-Requested-With");
        headers.add("Access-Control-Allow-Methods", "POST, OPTIONS, GET, PUT, PATCH");
        return headers;
    }
}
