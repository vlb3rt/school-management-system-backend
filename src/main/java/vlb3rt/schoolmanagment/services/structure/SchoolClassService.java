package vlb3rt.schoolmanagment.services.structure;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import vlb3rt.schoolmanagment.mappers.structure.SchoolClassMapper;
import vlb3rt.schoolmanagment.models.dto.structure.schoolClass.SchoolClassResponse;
import vlb3rt.schoolmanagment.models.dto.structure.schoolClass.SchoolClassResponses;
import vlb3rt.schoolmanagment.models.entities.structure.SchoolClass;
import vlb3rt.schoolmanagment.repositories.structure.SchoolClassRepository;
import vlb3rt.schoolmanagment.responses.exceptions.EntityException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SchoolClassService {

    private final SchoolClassRepository schoolClassRepository;

    private final SchoolClassMapper schoolClassMapper;

    public SchoolClassService(SchoolClassRepository schoolClassRepository, SchoolClassMapper schoolClassMapper) {
        this.schoolClassRepository = schoolClassRepository;
        this.schoolClassMapper = schoolClassMapper;
    }

    public SchoolClassResponse getSchoolClass(Long schoolClassId) throws EntityException {
        return schoolClassRepository
                .findById(schoolClassId)
                .map(schoolClassMapper::toResponseMapper)
                .orElseThrow(() -> new EntityException("not found"));
    }

    public SchoolClass getSchoolClassEntity(Long schoolClassId) throws EntityException {
        return schoolClassRepository
                .findById(schoolClassId)
                .orElseThrow(() -> new EntityException("not found"));
    }

    public SchoolClassResponses getAllSchoolClasses() {
        List<SchoolClass> schoolClasses = new ArrayList<>();
        schoolClassRepository.findAll().forEach(schoolClasses::add);
        return schoolClassMapper.toResponseListMapper(schoolClasses);
    }

    public void createSchoolClass(SchoolClassResponse schoolClassResponse) throws EntityException {
        if(createValidation(schoolClassResponse)) {
            schoolClassRepository.save(schoolClassMapper.toEntityMapper(schoolClassResponse, new SchoolClass()));
        }
    }

    public void updateSchoolClass(SchoolClassResponse schoolClassResponse) throws EntityException {
        if(updateValidation(schoolClassResponse)) {
            schoolClassRepository.save(schoolClassMapper.toEntityMapper(schoolClassResponse, getSchoolClassEntity(schoolClassResponse.getSchoolClassId())));
        }
    }

    public void deleteSchoolClass(Long schoolClassId) throws EntityException {
        try {
            schoolClassRepository.deleteById(schoolClassId);
        } catch (DataIntegrityViolationException e) {
            throw new EntityException(e.getMessage());
        }
    }

    private boolean createValidation(SchoolClassResponse schoolClass) throws EntityException {
        SchoolClassResponses schoolClasses = getAllSchoolClasses();

        Optional<SchoolClassResponse> nameInUse = isSchoolClassNameUsed(schoolClasses, schoolClass.getSchoolClassName());
        if(nameInUse.isPresent()) {
            throw new EntityException("schoolClass with name: " + schoolClass.getSchoolClassName() + " already exists");
        }

        Optional<SchoolClassResponse> teacherResponse = isTeacherAssigned(schoolClasses, schoolClass.getTeacher().getTeacherId());
        if(teacherResponse.isPresent()) {
            throw new EntityException("teacher with index: " + teacherResponse.get().getTeacher().getTeacherIndex()+ " is already assigned");
        }
        return true;
    }

    private boolean updateValidation(SchoolClassResponse schoolClass) throws EntityException {
        SchoolClassResponses schoolClasses = getAllSchoolClasses();

        if(isSchoolClassIdUsed(schoolClasses, schoolClass.getSchoolClassId()).isEmpty()) {
            throw new EntityException("schoolClass with id: " + schoolClass.getSchoolClassId() + " does not exist");
        }

        Optional<SchoolClassResponse> nameInUse = isSchoolClassNameUsed(schoolClasses, schoolClass.getSchoolClassName());
        if(nameInUse.isPresent()) {
            if(nameInUse.get().getSchoolClassId().longValue() != schoolClass.getSchoolClassId()) {
                throw new EntityException("schoolClass with name: " + schoolClass.getSchoolClassName() + " already exists");
            }
        }

        Optional<SchoolClassResponse> teacherResponse = isTeacherAssigned(schoolClasses, schoolClass.getTeacher().getTeacherId());
        if(teacherResponse.isPresent()) {
            if(teacherResponse.get().getTeacher().getTeacherId().longValue() != schoolClass.getTeacher().getTeacherId()) {
                throw new EntityException("teacher with index: " + teacherResponse.get().getTeacher().getTeacherIndex()+ " is already assigned");
            }
        }
        return true;
    }

    private Optional<SchoolClassResponse> isSchoolClassNameUsed(SchoolClassResponses schoolClassesResponses, String schoolClassName) throws EntityException {
        if(schoolClassName == null || schoolClassName.isEmpty() || schoolClassName.isBlank()) {
            throw new EntityException("subjectName can not be null, empty nor blank");
        }
        return schoolClassesResponses.getSchoolClasses()
                .stream()
                .filter(schoolClassResponse -> schoolClassResponse.getSchoolClassName().equalsIgnoreCase(schoolClassName))
                .findFirst();
    }

    private Optional<SchoolClassResponse> isSchoolClassIdUsed(SchoolClassResponses schoolClasses, Long schoolClassId) {
        return schoolClasses.getSchoolClasses()
                .stream()
                .filter(schoolClassResponse -> schoolClassResponse.getSchoolClassId().longValue() ==  schoolClassId)
                .findFirst();
    }

    private Optional<SchoolClassResponse> isTeacherAssigned(SchoolClassResponses schoolClasses, Long teacherId) throws EntityException {
        if(teacherId == null) {
            throw new EntityException("teacherId can not be null");
        }

        return schoolClasses.getSchoolClasses()
                .stream()
                .filter(schoolClassResponse -> schoolClassResponse.getTeacher().getTeacherId().longValue() == teacherId)
                .findFirst();
    }
}