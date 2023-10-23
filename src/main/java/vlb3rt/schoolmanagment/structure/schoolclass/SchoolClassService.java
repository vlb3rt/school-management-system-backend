package vlb3rt.schoolmanagment.structure.schoolclass;

import org.springframework.stereotype.Service;

import vlb3rt.schoolmanagment.mappers.SchoolClassMapper;
import vlb3rt.schoolmanagment.models.CDMSchoolClass;

import java.util.Optional;

@Service
public class SchoolClassService {

    private final SchoolClassMapper schoolClassMapper;

    private final SchoolClassRepository schoolClassRepository;

    public SchoolClassService(SchoolClassMapper schoolClassMapper, SchoolClassRepository schoolClassRepository) {
        this.schoolClassMapper = schoolClassMapper;
        this.schoolClassRepository = schoolClassRepository;
    }

    /** DONE */
    public Optional<CDMSchoolClass> createSchoolClass(CDMSchoolClass cdmSchoolClass) {
        if (findSchoolClassByName(cdmSchoolClass.getName()).isEmpty()) {
            return Optional.of(
                    schoolClassMapper.toCDMMapper(
                            schoolClassRepository.save(
                                    schoolClassMapper.toEntityMapper(cdmSchoolClass))));
        }
       return Optional.empty();
    }

    /** DONE */
    public Optional<CDMSchoolClass> findSchoolClassByName(String name) {
        return schoolClassRepository.findSchoolClassByName(name)
                .map(schoolClassMapper::toCDMMapper);
    }

    /** DONE */
    public Optional<CDMSchoolClass> findSchoolClassById(Long schoolClassId) {
        return schoolClassRepository.findById(schoolClassId)
                .map(schoolClassMapper::toCDMMapper);
    }

    /** DONE */
    public Optional<CDMSchoolClass> updateSchoolClass(Long schoolClassId, CDMSchoolClass cdmSchoolClass) {
        return findSchoolClassById(schoolClassId)
                .map(schoolClass -> {
                    cdmSchoolClass.setSchoolClassId(schoolClass.getSchoolClassId());
                    schoolClassRepository.save(schoolClassMapper.toEntityMapper(cdmSchoolClass));
                    return cdmSchoolClass;
                });
    }

    /** DONE */
    public Optional<CDMSchoolClass> deleteSchoolClassById(Long schoolClassId) {
        return schoolClassRepository.deleteSchoolClassBySchoolClassId(schoolClassId)
                .map(schoolClassMapper::toCDMMapper);
    }

    public void deleteAllSchoolClasses() {
        schoolClassRepository.deleteAll();
    }
}
