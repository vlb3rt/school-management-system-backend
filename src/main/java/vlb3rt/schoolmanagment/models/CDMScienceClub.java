package vlb3rt.schoolmanagment.models;

public class CDMScienceClub {

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
