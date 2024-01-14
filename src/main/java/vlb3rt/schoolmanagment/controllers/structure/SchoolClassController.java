package vlb3rt.schoolmanagment.controllers.structure;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vlb3rt.schoolmanagment.models.dto.structure.schoolClass.SchoolClassResponse;
import vlb3rt.schoolmanagment.models.dto.structure.schoolClass.SchoolClassResponses;
import vlb3rt.schoolmanagment.responses.exceptions.EntityException;
import vlb3rt.schoolmanagment.services.structure.SchoolClassService;

@RestController
@RequestMapping("/structure/schoolClass")
public class SchoolClassController {

    private SchoolClassService schoolClassService;

    public SchoolClassController(SchoolClassService schoolClassService) {
        this.schoolClassService = schoolClassService;
    }

    @GetMapping("/getSchoolClass")
    public ResponseEntity<?> getSchoolClass(@RequestParam("schoolClassId") long schoolClassId) {
        try {
            return new ResponseEntity<SchoolClassResponse>(schoolClassService.getSchoolClass(schoolClassId), HttpStatusCode.valueOf(200));
        } catch (EntityException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatusCode.valueOf(200));
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<SchoolClassResponses> getAll() {
        return new ResponseEntity<SchoolClassResponses>(schoolClassService.getAllSchoolClasses(), HttpStatusCode.valueOf(200));
    }
}
