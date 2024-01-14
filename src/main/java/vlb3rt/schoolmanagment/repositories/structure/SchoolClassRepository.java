package vlb3rt.schoolmanagment.repositories.structure;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vlb3rt.schoolmanagment.models.entities.structure.SchoolClass;

@Repository
public interface SchoolClassRepository extends CrudRepository<SchoolClass, Long> {
}
