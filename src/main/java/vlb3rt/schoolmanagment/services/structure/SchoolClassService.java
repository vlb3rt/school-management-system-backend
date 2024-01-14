package vlb3rt.schoolmanagment.services.structure;

import org.springframework.stereotype.Service;
import vlb3rt.schoolmanagment.mappers.structure.SchoolClassMapper;
import vlb3rt.schoolmanagment.models.dto.structure.schoolClass.SchoolClassResponse;
import vlb3rt.schoolmanagment.models.dto.structure.schoolClass.SchoolClassResponses;
import vlb3rt.schoolmanagment.models.entities.structure.SchoolClass;
import vlb3rt.schoolmanagment.repositories.structure.SchoolClassRepository;
import vlb3rt.schoolmanagment.responses.exceptions.EntityException;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolClassService {

    private SchoolClassRepository schoolClassRepository;

    private SchoolClassMapper schoolClassMapper;

    public SchoolClassService(SchoolClassRepository schoolClassRepository, SchoolClassMapper schoolClassMapper) {
        this.schoolClassRepository = schoolClassRepository;
        this.schoolClassMapper = schoolClassMapper;
    }

    public SchoolClassResponse getSchoolClass(long schoolClassId) throws EntityException {
        return schoolClassRepository
                .findById(schoolClassId)
                .map(schoolClassMapper::toResponseMapper)
                .orElseThrow(() -> new EntityException("not found"));
    }

    public SchoolClassResponses getAllSchoolClasses() {
        List<SchoolClass> schoolClasses = new ArrayList<>();
        schoolClassRepository.findAll().forEach(schoolClasses::add);
        return schoolClassMapper.toResponseListMapper(schoolClasses);
    }
}
