package vlb3rt.schoolmanagment.structure.schoolclass;

import org.springframework.stereotype.Service;

import vlb3rt.schoolmanagment.entities.SchoolClass;
import vlb3rt.schoolmanagment.mappers.SchoolClassMapper;
import vlb3rt.schoolmanagment.models.CDMSchoolClass;
import vlb3rt.schoolmanagment.models.CDMSchoolClasses;

import java.util.ArrayList;
import java.util.List;
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

    public CDMSchoolClasses findAll() {
        List<SchoolClass> schoolClasses = new ArrayList<>();
        schoolClassRepository.findAll().forEach(schoolClasses::add);
        CDMSchoolClasses cdmSchoolClasses = new CDMSchoolClasses();
        cdmSchoolClasses.setClasses(schoolClassMapper.toCDMListMapper(schoolClasses));
        return cdmSchoolClasses;
    }

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
    public void deleteSchoolClassById(Long schoolClassId) {
        schoolClassRepository.deleteById(schoolClassId);
    }


    public void deleteAllSchoolClasses() {
        schoolClassRepository.deleteAll();
    }
}
