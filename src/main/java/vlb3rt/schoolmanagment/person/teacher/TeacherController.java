package vlb3rt.schoolmanagment.person.teacher;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vlb3rt.schoolmanagment.models.CDMTeacher;

@RestController
@RequestMapping("/person/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    /**
     * POST
     * */
    @PostMapping(value = "/create")
    public ResponseEntity<CDMTeacher> createTeacher(
            @RequestBody CDMTeacher cdmTeacher
    ) {
        return teacherService.createTeacher(cdmTeacher)
                .map(model -> {
                    return new ResponseEntity<CDMTeacher>(model, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(value = "/read")
    public CDMTeacher readTeacher(
            @RequestParam Long teacherId
    ) {
        return teacherService.readTeacherById(teacherId);
    }

    @PutMapping(value = "/update")
    public void updateTeacher(
            @RequestParam("teacherId") Long teacherId,
            @RequestBody CDMTeacher cdmTeacher
    ) {
        teacherService.updateTeacher(teacherId, cdmTeacher);
    }

    @DeleteMapping(value = "/delete")
    public void deleteTeacher(
            @RequestParam("teacherId") Long teacherId
    ) {
        teacherService.deleteTeacher(teacherId);
    }

    @DeleteMapping(value = "/deleteAll")
    public void deleteAllTeachers() {
        teacherService.deleteAllTeachers();
    }
}
