package vlb3rt.schoolmanagment.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "science_club")
public class ScienceClub {

    @Id
    @GeneratedValue
    private Long scienceClubId;

    private String name;

    private int maxSize;

    private int currentSize;

    public Long getScienceClubId() {
        return scienceClubId;
    }

    public void setScienceClubId(Long scienceClubId) {
        this.scienceClubId = scienceClubId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }
}
