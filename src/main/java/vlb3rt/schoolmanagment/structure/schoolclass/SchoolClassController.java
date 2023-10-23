package vlb3rt.schoolmanagment.structure.schoolclass;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vlb3rt.schoolmanagment.models.CDMSchoolClass;

import java.util.Optional;

@RestController
@RequestMapping("/structure/schoolclass")
public class SchoolClassController {

    private final SchoolClassService schoolClassService;

    public SchoolClassController(SchoolClassService schoolClassService) {
        this.schoolClassService = schoolClassService;
    }

    /** DONE */
    @PostMapping(value = "/create")
    public ResponseEntity<CDMSchoolClass> createSchoolClass(
            @RequestBody CDMSchoolClass cdmSchoolClass
    ) {
        return schoolClassService.createSchoolClass(cdmSchoolClass)
                .map(model -> {
                    return new ResponseEntity<CDMSchoolClass>(model, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    /** DONE */
    @GetMapping(value = "/read")
    public ResponseEntity<CDMSchoolClass> readStudent(
            @RequestParam Long schoolClassId
    ) {
        return schoolClassService.findSchoolClassById(schoolClassId)
                .map(model -> {
                    return new ResponseEntity<CDMSchoolClass>(model, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    /** DONE */
    @PutMapping(value = "/update")
    public ResponseEntity<CDMSchoolClass> updateSchoolClass(
            @RequestParam("schoolClassId") Long schoolClassId,
            @RequestBody CDMSchoolClass cdmSchoolClass
    ) {
        return schoolClassService.updateSchoolClass(schoolClassId, cdmSchoolClass)
                .map(model -> {
                    return new ResponseEntity<CDMSchoolClass>(model, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    /** DONE */
    @DeleteMapping(value = "/delete")
    public ResponseEntity<CDMSchoolClass> deleteSchoolClass(
            @RequestParam("schoolClassId") Long schoolClassId
    ) {
        return schoolClassService.deleteSchoolClassById(schoolClassId)
                .map(model -> {
                    return new ResponseEntity<CDMSchoolClass>(model, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(new CDMSchoolClass(), HttpStatus.BAD_REQUEST));

    }

    /** DONE */
    @DeleteMapping(value = "/deleteAll")
    public void deleteAllSchoolClasses(

    ) {
        schoolClassService.deleteAllSchoolClasses();
    }

}
