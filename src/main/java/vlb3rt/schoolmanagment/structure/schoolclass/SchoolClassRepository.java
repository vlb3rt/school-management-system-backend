package vlb3rt.schoolmanagment.structure.schoolclass;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vlb3rt.schoolmanagment.entities.SchoolClass;

@Repository
public interface SchoolClassRepository extends CrudRepository<SchoolClass, Long> {

}
