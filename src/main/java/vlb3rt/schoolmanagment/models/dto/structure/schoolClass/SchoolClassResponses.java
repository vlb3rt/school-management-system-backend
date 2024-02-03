package vlb3rt.schoolmanagment.models.dto.structure.schoolClass;

import java.util.ArrayList;
import java.util.List;

public class SchoolClassResponses {

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
