// import org.sql2o.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NormalAnimal {
    private int id;
    private String name;
    private int newdate;

    public NormalAnimal(int id, String name, int newdate) {
        this.id = id;
        this.name = name;
        this.newdate = newdate;
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
