package vlb3rt.schoolmanagment.structure.scienceclub;

import org.springframework.web.bind.annotation.*;
import vlb3rt.schoolmanagment.models.CDMScienceClub;

@RestController
@RequestMapping("/structure/scienceclub")
public class ScienceClubController {

    private final ScienceClubService scienceClubService;

    public ScienceClubController(ScienceClubService scienceClubService) {
        this.scienceClubService = scienceClubService;
    }

    @PostMapping(value = "/create")
    public void createScienceClub(
            @RequestBody CDMScienceClub cdmScienceClub
    ) {
        scienceClubService.createScienceClub(cdmScienceClub);
    }

    @GetMapping(value = "/read")
    public CDMScienceClub readScienceClub(
        @RequestParam("scienceClubId") Long scienceClubId
    ) {
        return scienceClubService.readScienceClubById(scienceClubId);
    }

    @PutMapping(value = "/update")
    public void updateScienceClub(
            @RequestParam("scienceClubId") Long scienceClubId,
            @RequestBody CDMScienceClub cdmScienceClub
    ) {
        scienceClubService.updateScienceClub(scienceClubId, cdmScienceClub);
    }

    @DeleteMapping(value = "/delete")
    public void deleteScienceClub(
            @RequestParam("scienceClubId") Long scienceClubId
    ) {
        scienceClubService.deleteScienceClub(scienceClubId);
    }

    @DeleteMapping(value = "/deleteAll")
    public void deleteScienceClub(

    ) {
        scienceClubService.deleteAllScienceClubs();
    }
}
