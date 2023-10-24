package vlb3rt.schoolmanagment.structure.schoolclass;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vlb3rt.schoolmanagment.models.CDMSchoolClass;
import vlb3rt.schoolmanagment.models.CDMSchoolClasses;

@RestController
@RequestMapping("/structure/schoolclass")
public class SchoolClassController {

    private final SchoolClassService schoolClassService;

    public SchoolClassController(SchoolClassService schoolClassService) {
        this.schoolClassService = schoolClassService;
    }

    /**
     * POST
     * */
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

    /**
     * GET
     * */
    @GetMapping(value = "/read")
    public ResponseEntity<CDMSchoolClass> readSchoolClass(
            @RequestParam Long schoolClassId
    ) {
        return schoolClassService.findSchoolClassById(schoolClassId)
                .map(model -> {
                    return new ResponseEntity<CDMSchoolClass>(model, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(value = "/readAll")
    public ResponseEntity<CDMSchoolClasses> readSchoolClass(

    ) {
        return new ResponseEntity<>(schoolClassService.findAll(), HttpStatus.OK);
    }

    /**
     *  PUT
     *  */
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

    /**
     * DELETE
     * */
    @DeleteMapping(value = "/delete")
    public ResponseEntity<CDMSchoolClass> deleteSchoolClass(
            @RequestParam("schoolClassId") Long schoolClassId
    ) {
        schoolClassService.deleteSchoolClassById(schoolClassId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping(value = "/deleteAll")
    public ResponseEntity<CDMSchoolClass> deleteAllSchoolClasses(

    ) {
        schoolClassService.deleteAllSchoolClasses();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
