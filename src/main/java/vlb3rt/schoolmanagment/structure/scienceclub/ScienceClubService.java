package vlb3rt.schoolmanagment.structure.scienceclub;

import org.springframework.stereotype.Service;

import vlb3rt.schoolmanagment.entities.ScienceClub;
import vlb3rt.schoolmanagment.mappers.ScienceClubMapper;
import vlb3rt.schoolmanagment.models.CDMScienceClub;

import java.util.Optional;

@Service
public class ScienceClubService {

    private final ScienceClubMapper scienceClubMapper;

    private final ScienceClubRepository scienceClubRepository;

    public ScienceClubService(ScienceClubMapper scienceClubMapper, ScienceClubRepository scienceClubRepository) {
        this.scienceClubMapper = scienceClubMapper;
        this.scienceClubRepository = scienceClubRepository;
    }

    public void createScienceClub(CDMScienceClub cdmScienceClub) {
        scienceClubRepository.save(scienceClubMapper.toEntityMapper(cdmScienceClub));
    }

    public CDMScienceClub readScienceClubById(Long scienceClubId) {
        return scienceClubRepository.findById(scienceClubId)
                .map(scienceClubMapper::toCDMMapper)
                .orElse(null);
    }

    public void updateScienceClub(Long scienceClubId, CDMScienceClub cdmScienceClub) {
        Optional<ScienceClub> scienceClub = scienceClubRepository.findById(scienceClubId);
        if(scienceClub.isPresent()) {
            scienceClub = Optional.of(scienceClubMapper.toEntityMapper(cdmScienceClub));
            scienceClub.get().setScienceClubId(scienceClubId);
            scienceClubRepository.save(scienceClub.get());
        }
    }

    public void deleteScienceClub(Long scienceClubId) {
        scienceClubRepository.deleteById(scienceClubId);
    }

    public void deleteAllScienceClubs() {
        scienceClubRepository.deleteAll();
    }
}
