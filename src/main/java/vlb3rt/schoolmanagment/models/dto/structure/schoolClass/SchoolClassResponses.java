package vlb3rt.schoolmanagment.models.dto.structure.schoolClass;

import vlb3rt.schoolmanagment.interfaces.ResponsesInterface;

import java.util.ArrayList;
import java.util.List;

public class SchoolClassResponses implements ResponsesInterface {

    private List<SchoolClassResponse> schoolClasses = new ArrayList<>();

    public List<SchoolClassResponse> getSchoolClasses() {
        return schoolClasses;
    }

    public void setSchoolClasses(List<SchoolClassResponse> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }

    public SchoolClassResponses(List<SchoolClassResponse> schoolClasses) {
        this.schoolClasses = schoolClasses;


    }
}
