package vlb3rt.schoolmanagment.person.student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vlb3rt.schoolmanagment.entities.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {


}
