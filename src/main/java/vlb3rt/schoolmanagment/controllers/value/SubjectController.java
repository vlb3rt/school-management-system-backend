package vlb3rt.schoolmanagment.controllers.value;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import vlb3rt.schoolmanagment.models.dto.value.subject.SubjectResponse;
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

    /** GET methods*/
    @GetMapping("/getSubject")
    public ResponseEntity<?> getSubject(@RequestParam(name = "subjectId") Long subjectId) {
        try {
            return new ResponseEntity<>(subjectService.getSubject(subjectId), getHeaders(), HttpStatusCode.valueOf(200));
        } catch (EntityException e) {
            return new ResponseEntity<>(e.getMessage(), getHeaders(), HttpStatusCode.valueOf(422));
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<SubjectResponses> getAllSubjects() {
        return new ResponseEntity<>(subjectService.getAllSubjects(), getHeaders(), HttpStatusCode.valueOf(200));
    }

    /** POST methods */
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody SubjectResponse subjectResponse) {
        try {
            subjectService.createSubject(subjectResponse);
            return new ResponseEntity<>(getHeaders(), HttpStatusCode.valueOf(200));
        } catch (EntityException e) {
            return new ResponseEntity<>(e.getMessage(), getHeaders(), HttpStatusCode.valueOf(422));
        }
    }

    /** PUT methods */
    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody SubjectResponse subjectResponse) {
        try {
            subjectService.updateSubject(subjectResponse);
            return new ResponseEntity<>(getHeaders(), HttpStatusCode.valueOf(200));
        } catch (EntityException e) {
            return new ResponseEntity<>(e.getMessage(), getHeaders(), HttpStatusCode.valueOf(422));
        }
    }

    /** DELETE methods */
    @DeleteMapping("/delete")
    public ResponseEntity<String> update(@RequestParam("subjectId") Long subjectId) {
        try {
            subjectService.deleteSubject(subjectId);
            return new ResponseEntity<>(getHeaders(), HttpStatusCode.valueOf(200));
        } catch (EntityException e) {
            return new ResponseEntity<>(e.getMessage(), getHeaders(), HttpStatusCode.valueOf(422));
        }
    }

    private MultiValueMap<String, String>  getHeaders() {
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Credentials", "true");
        headers.add("Access-Control-Allow-Headers", "Content-Type, Content-Length, Accept-Encoding, X-CSRF-Token, Authorization, accept, origin, Cache-Control, X-Requested-With");
        headers.add("Access-Control-Allow-Methods", "POST, OPTIONS, GET, PUT, PATCH");
        return headers;
    }
}
