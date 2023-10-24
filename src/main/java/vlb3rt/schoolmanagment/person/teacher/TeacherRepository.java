package vlb3rt.schoolmanagment.person.teacher;

import org.springframework.data.repository.CrudRepository;
import vlb3rt.schoolmanagment.entities.Teacher;

import java.util.Optional;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {

    Optional<Teacher> findTeacherByPersonId(int personId);

}
