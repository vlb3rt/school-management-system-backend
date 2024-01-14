package vlb3rt.schoolmanagment.repositories.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vlb3rt.schoolmanagment.models.entities.person.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {



}
