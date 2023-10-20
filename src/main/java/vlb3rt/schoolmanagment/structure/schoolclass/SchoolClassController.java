package vlb3rt.schoolmanagment.structure.schoolclass;

import org.springframework.web.bind.annotation.*;
import vlb3rt.schoolmanagment.models.CDMSchoolClass;
import vlb3rt.schoolmanagment.models.CDMStudent;

@RestController
@RequestMapping("/structure/schoolclass")
public class SchoolClassController {

    private final SchoolClassService schoolClassService;

    public SchoolClassController(SchoolClassService schoolClassService) {
        this.schoolClassService = schoolClassService;
    }

    @PostMapping(value = "/create")
    public void createSchoolClass(
            @RequestBody CDMSchoolClass cdmSchoolClass
    ) {
        schoolClassService.createSchoolClass(cdmSchoolClass);
    }

    @GetMapping(value = "/read")
    public CDMSchoolClass readStudent(
            @RequestParam Long schoolClassId
    ) {
        return schoolClassService.readSchoolClassById(schoolClassId);
    }

    @PutMapping(value = "/update")
    public void updateSchoolClass(
            @RequestParam("schoolClassId") Long schoolClassId,
            @RequestBody CDMSchoolClass cdmSchoolClass
    ) {
        schoolClassService.updateSchoolClass(schoolClassId, cdmSchoolClass);
    }

    @DeleteMapping(value = "/delete")
    public void deleteSchoolClass(
            @RequestParam("schoolClassId") Long schoolClassId
    ) {
        schoolClassService.deleteSchoolClass(schoolClassId);
    }

    @DeleteMapping(value = "/deleteAll")
    public void deleteAllSchoolClasses(

    ) {
        schoolClassService.deleteAllSchoolClasses();
    }

}
