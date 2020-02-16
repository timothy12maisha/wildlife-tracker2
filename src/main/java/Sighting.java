import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Sighting {
    private int id;
    private String location;
    private String rangerName;

    public Sighting(int id, String location, String rangerName) {
        this.id = id;
        this.location = location;
        this.rangerName = rangerName;
    }

    public static Object getAllSightings() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRangerName() {
        return rangerName;
    }

    public void setRangerName(String rangerName) {
        this.rangerName = rangerName;
    }
}
