package vlb3rt.schoolmanagment.models.dto.person.student;

import vlb3rt.schoolmanagment.interfaces.ResponseInterface;
import vlb3rt.schoolmanagment.models.entities.structure.SchoolClass;

public class StudentResponse implements ResponseInterface {

    private long studentId;

    private String name;

    private String lastName;

    private boolean isClassLeader;


}
