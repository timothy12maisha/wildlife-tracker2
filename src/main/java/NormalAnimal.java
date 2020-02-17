// import org.sql2o.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NormalAnimal {
    private int id;
    private String name;
    private int newdate;
    private static ArrayList<NormalAnimal> instances = new ArrayList<>();

    public NormalAnimal(int id, String name, int newdate) {
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

    public int getTimestamp() {
        return newdate;
    }

    public void setTimestamp(int timestamp) {
        this.newdate = timestamp;
    }

    public void saveNormal() {
    }

}
