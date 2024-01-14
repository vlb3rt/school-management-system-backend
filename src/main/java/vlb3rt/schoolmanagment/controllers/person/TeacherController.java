package vlb3rt.schoolmanagment.controllers.person;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vlb3rt.schoolmanagment.models.dto.person.teacher.TeacherResponse;
import vlb3rt.schoolmanagment.models.dto.person.teacher.TeacherResponses;
import vlb3rt.schoolmanagment.responses.exceptions.EntityException;
import vlb3rt.schoolmanagment.services.person.TeacherService;

@RestController
@RequestMapping("/person/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping(value = "/getTeacher")
    public ResponseEntity<?> getTeacher(@RequestParam(name = "teacherId") long teacherId) {
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

}
