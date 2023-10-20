package vlb3rt.schoolmanagment.mappers;

import org.springframework.stereotype.Component;

import vlb3rt.schoolmanagment.interfaces.MapperInterface;
import vlb3rt.schoolmanagment.models.CDMSchoolClass;
import vlb3rt.schoolmanagment.entities.SchoolClass;

import java.util.ArrayList;
import java.util.List;

@Component
public final class SchoolClassMapper implements MapperInterface<SchoolClass, CDMSchoolClass> {

    @Override
    public SchoolClass toEntityMapper(CDMSchoolClass cdmSchoolClass) {
        SchoolClass schoolClass = new SchoolClass();

        schoolClass.setSchoolClassId(cdmSchoolClass.getSchoolClassId());
        schoolClass.setName(cdmSchoolClass.getName());
        schoolClass.setMaxSize(cdmSchoolClass.getMaxSize());
        schoolClass.setCurrentSize(cdmSchoolClass.getCurrentSize());

        return schoolClass;
    }

    @Override
    public CDMSchoolClass toCDMMapper(SchoolClass schoolClass) {
        CDMSchoolClass cdmSchoolClass = new CDMSchoolClass();

        cdmSchoolClass.setSchoolClassId(schoolClass.getSchoolClassId());
        cdmSchoolClass.setName(schoolClass.getName());
        cdmSchoolClass.setMaxSize(schoolClass.getMaxSize());
        cdmSchoolClass.setCurrentSize(schoolClass.getCurrentSize());

        return cdmSchoolClass;
    }

    @Override
    public List<SchoolClass> toEntityListMapper(List<CDMSchoolClass> cdmSchoolClasses) {
        List<SchoolClass> schoolClasses = new ArrayList<>();

        for (CDMSchoolClass cdmSchoolClass : cdmSchoolClasses) {
            SchoolClass schoolClass = new SchoolClass();

            schoolClass.setSchoolClassId(cdmSchoolClass.getSchoolClassId());
            schoolClass.setName(cdmSchoolClass.getName());
            schoolClass.setMaxSize(cdmSchoolClass.getMaxSize());
            schoolClass.setCurrentSize(cdmSchoolClass.getCurrentSize());

            schoolClasses.add(schoolClass);
        }

        return schoolClasses;
    }

    @Override
    public List<CDMSchoolClass> toCDMListMapper(List<SchoolClass> schoolClasses) {
        List<CDMSchoolClass> cdmSchoolClasses = new ArrayList<>();

        for (SchoolClass schoolClass : schoolClasses) {
            CDMSchoolClass cdmSchoolClass = new CDMSchoolClass();

            cdmSchoolClass.setSchoolClassId(schoolClass.getSchoolClassId());
            cdmSchoolClass.setName(schoolClass.getName());
            cdmSchoolClass.setMaxSize(schoolClass.getMaxSize());
            cdmSchoolClass.setCurrentSize(schoolClass.getCurrentSize());

            cdmSchoolClasses.add(cdmSchoolClass);
        }

        return cdmSchoolClasses;
    }
}
