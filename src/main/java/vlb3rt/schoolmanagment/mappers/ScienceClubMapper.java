package vlb3rt.schoolmanagment.mappers;

import org.springframework.stereotype.Component;

import vlb3rt.schoolmanagment.entities.ScienceClub;
import vlb3rt.schoolmanagment.interfaces.MapperInterface;
import vlb3rt.schoolmanagment.models.CDMScienceClub;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScienceClubMapper implements MapperInterface<ScienceClub, CDMScienceClub> {

    @Override
    public ScienceClub toEntityMapper(CDMScienceClub cdmScienceClub) {
        ScienceClub scienceClub = new ScienceClub();

        scienceClub.setScienceClubId(cdmScienceClub.getScienceClubId());
        scienceClub.setName(cdmScienceClub.getName());
        scienceClub.setMaxSize(cdmScienceClub.getMaxSize());
        scienceClub.setCurrentSize(cdmScienceClub.getCurrentSize());

        return scienceClub;
    }

    @Override
    public CDMScienceClub toCDMMapper(ScienceClub scienceClub) {
        CDMScienceClub cdmScienceClub = new CDMScienceClub();

        cdmScienceClub.setScienceClubId(cdmScienceClub.getScienceClubId());
        cdmScienceClub.setName(cdmScienceClub.getName());
        cdmScienceClub.setMaxSize(cdmScienceClub.getMaxSize());
        cdmScienceClub.setCurrentSize(cdmScienceClub.getCurrentSize());

        return cdmScienceClub;
    }

    @Override
    public List<ScienceClub> toEntityListMapper(List<CDMScienceClub> cdmScienceClubs) {
        List<ScienceClub> scienceClubs = new ArrayList<>();

        for (CDMScienceClub cdmScienceClub : cdmScienceClubs) {
            ScienceClub scienceClub = new ScienceClub();

            scienceClub.setScienceClubId(cdmScienceClub.getScienceClubId());
            scienceClub.setName(cdmScienceClub.getName());
            scienceClub.setMaxSize(cdmScienceClub.getMaxSize());
            scienceClub.setCurrentSize(cdmScienceClub.getCurrentSize());

            scienceClubs.add(scienceClub);
        }

        return scienceClubs;
    }

    @Override
    public List<CDMScienceClub> toCDMListMapper(List<ScienceClub> scienceClubs) {
        List<CDMScienceClub> cdmScienceClubs = new ArrayList<>();

        for (ScienceClub scienceClub : scienceClubs) {
            CDMScienceClub cdmScienceClub = new CDMScienceClub();

            cdmScienceClub.setScienceClubId(cdmScienceClub.getScienceClubId());
            cdmScienceClub.setName(cdmScienceClub.getName());
            cdmScienceClub.setMaxSize(cdmScienceClub.getMaxSize());
            cdmScienceClub.setCurrentSize(cdmScienceClub.getCurrentSize());

            cdmScienceClubs.add(cdmScienceClub);
        }

        return cdmScienceClubs;
    }
}