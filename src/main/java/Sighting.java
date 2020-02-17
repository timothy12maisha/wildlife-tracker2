import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Sighting {
    private int id;
    private String location;
    private String rangerName;
    private static ArrayList<Sighting> instances = new ArrayList<>();

    public Sighting(int id, String location, String rangerName) {
        this.id = id;
        this.location = location;
        this.rangerName = rangerName;

        instances.add(this);
        this.id = instances.size();
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

    public static ArrayList<Sighting> getInstances() {
        return instances;
    }

    public static void setInstances(ArrayList<Sighting> instances) {
        Sighting.instances = instances;
    }
    public static ArrayList<Sighting> getAll(){
        return instances;
    }
}
