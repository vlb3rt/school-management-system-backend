package vlb3rt.schoolmanagment.controllers.structure;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
            return new ResponseEntity<>(schoolClassService.getSchoolClass(schoolClassId), HttpStatusCode.valueOf(200));
        } catch (EntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(200));
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<SchoolClassResponses> getAll() {
        return new ResponseEntity<>(schoolClassService.getAllSchoolClasses(), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/create")
    public ResponseEntity<String> createSchoolClass(@RequestBody SchoolClassResponse schoolClassResponse) {
        try {
            schoolClassService.createSchoolClass(schoolClassResponse);
            return new ResponseEntity<>(HttpStatusCode.valueOf(200));
        } catch (EntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(422));
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateSchoolClass(@RequestBody SchoolClassResponse schoolClassResponse) {
        try {
            schoolClassService.updateSchoolClass(schoolClassResponse);
            return new ResponseEntity<>(HttpStatusCode.valueOf(200));
        } catch (EntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(422));
        }
    }

    /** DELETE methods */
    @DeleteMapping("/delete")
    public ResponseEntity<String> update(@RequestParam("schoolClassId") Long schoolClassId) {
        try {
            schoolClassService.deleteSchoolClass(schoolClassId);
            return new ResponseEntity<>(HttpStatusCode.valueOf(200));
        } catch (EntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(422));
        }
    }
}
