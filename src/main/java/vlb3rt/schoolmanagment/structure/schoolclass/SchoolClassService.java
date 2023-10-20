package vlb3rt.schoolmanagment.structure.schoolclass;

import org.springframework.stereotype.Service;

import vlb3rt.schoolmanagment.entities.SchoolClass;
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

    public void createSchoolClass(CDMSchoolClass cdmSchoolClass) {
        schoolClassRepository.save(schoolClassMapper.toEntityMapper(cdmSchoolClass));
    }

    public CDMSchoolClass readSchoolClassById(Long schoolClassId) {
        return schoolClassRepository.findById(schoolClassId)
                .map(schoolClassMapper::toCDMMapper)
                .orElse(null);
    }

    public void updateSchoolClass(Long schoolClassId, CDMSchoolClass cdmSchoolClass) {
        Optional<SchoolClass> schoolClass = schoolClassRepository.findById(schoolClassId);
        if(schoolClass.isPresent()) {
            schoolClass = Optional.of(schoolClassMapper.toEntityMapper(cdmSchoolClass));
            schoolClass.get().setSchoolClassId(schoolClassId);
            schoolClassRepository.save(schoolClass.get());
        }
    }

    public void deleteSchoolClass(Long schoolClassId) {
        schoolClassRepository.deleteById(schoolClassId);
    }

    public void deleteAllSchoolClasses() {
        schoolClassRepository.deleteAll();
    }
}
