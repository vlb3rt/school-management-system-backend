package vlb3rt.schoolmanagment.repositories.person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vlb3rt.schoolmanagment.models.entities.person.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
