package vlb3rt.schoolmanagment.controllers.person;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import vlb3rt.schoolmanagment.models.dto.person.teacher.TeacherResponse;
import vlb3rt.schoolmanagment.models.dto.person.teacher.TeacherResponses;
import vlb3rt.schoolmanagment.responses.exceptions.EntityException;
import vlb3rt.schoolmanagment.services.person.TeacherService;

@CrossOrigin(originPatterns = "*", allowCredentials = "true", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RestController
@RequestMapping("/person/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    /** GET methods*/
    @GetMapping(value = "/getTeacher")
    public ResponseEntity<?> getTeacher(@RequestParam(name = "teacherId") Long teacherId) {
        try {
            return new ResponseEntity<TeacherResponse>(teacherService.getTeacher(teacherId), HttpStatusCode.valueOf(200));
        } catch (EntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(422));
        }
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<TeacherResponses> getAllTeachers() {
        return new ResponseEntity<TeacherResponses>(teacherService.getAllTeachers(), HttpStatusCode.valueOf(200));
    }

    /** POST methods */
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody TeacherResponse teacherResponse) {
        try {
            teacherService.createTeacher(teacherResponse);
            return new ResponseEntity<>(HttpStatusCode.valueOf(200));
        } catch (EntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(422));
        }
    }

    /** PUT methods */
    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody TeacherResponse teacherResponse) {
        try {
            teacherService.updateTeacher(teacherResponse);
            return new ResponseEntity<>(HttpStatusCode.valueOf(200));
        } catch (EntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(422));
        }
    }

    /** DELETE methods */
    @GetMapping("/delete/{teacherId}")
    public ResponseEntity<String> update(@PathVariable("teacherId") Long teacherId) {
        try {
            teacherService.deleteTeacher(teacherId);
            return new ResponseEntity<>(HttpStatusCode.valueOf(200));
        } catch (EntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(422));
        }
    }
}
