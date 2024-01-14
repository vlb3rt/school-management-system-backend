package vlb3rt.schoolmanagment.controllers.value;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vlb3rt.schoolmanagment.models.dto.value.subject.SubjectResponses;
import vlb3rt.schoolmanagment.responses.exceptions.EntityException;
import vlb3rt.schoolmanagment.services.value.SubjectService;

@RestController
@RequestMapping("/value/subject")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/getSubject")
    public ResponseEntity<?> getSubject(@RequestParam(name = "subjectId") long subjectId) {
        try {
            return new ResponseEntity<>(subjectService.getSubject(subjectId), HttpStatusCode.valueOf(200));
        } catch (EntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(422));
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<SubjectResponses> getAllSubjects() {
        return new ResponseEntity<>(subjectService.getAllSubjects(), HttpStatusCode.valueOf(200));
    }
}
