// import org.sql2o.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NormalAnimal {
    private int id;
    private String name;
    private Timestamp newdate;
    private static ArrayList<NormalAnimal> instances = new ArrayList<>();

    public NormalAnimal(int id, String name, Timestamp newdate) {
        this.id = id;
        this.name = name;
        this.newdate = newdate;

        instances.add(this);
        this.id = instances.size();
    }
    public static ArrayList<NormalAnimal> getAll(){
        return instances;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getTimestamp() {
        return newdate;
    }

    public void setTimestamp(int timestamp) {
        this.newdate = newdate;
    }

    public void saveNormal() {
    }

}
