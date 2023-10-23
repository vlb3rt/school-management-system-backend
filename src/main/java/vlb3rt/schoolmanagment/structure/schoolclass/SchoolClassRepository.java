package vlb3rt.schoolmanagment.structure.schoolclass;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vlb3rt.schoolmanagment.entities.SchoolClass;

import java.util.Optional;

@Repository
public interface SchoolClassRepository extends CrudRepository<SchoolClass, Long> {

    Optional<SchoolClass> findSchoolClassByName(String name);

    Optional<SchoolClass> deleteSchoolClassBySchoolClassId(Long schoolClassId);


}
