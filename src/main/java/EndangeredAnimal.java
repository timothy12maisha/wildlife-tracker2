import org.sql2o.*;
import org.sql2o.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class EndangeredAnimal {
    private int id;
    private String name;
    private int newdate;
    private String health;
    private static ArrayList<EndangeredAnimal> instances = new ArrayList<>();

    public EndangeredAnimal( String name, int newdate, String health) {
        this.name = name;
        this.newdate = newdate;
        this.health = health;

        instances.add(this);
        this.id = instances.size();
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
        this.newdate = newdate;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public static ArrayList<EndangeredAnimal> getInstances() {
        return instances;
    }

    public static void setInstances(ArrayList<EndangeredAnimal> instances) {
        EndangeredAnimal.instances = instances;
    }
    public static ArrayList<EndangeredAnimal> getAll(){
        return instances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EndangeredAnimal that = (EndangeredAnimal) o;
        return id == that.id &&
                newdate == that.newdate &&
                name.equals(that.name) &&
                health.equals(that.health);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, newdate, health);
    }
    public void saveEndangered(){
        try(Connection conn = Database.sql2o.open()){
            String sql = "INSERT INTO endangeredanimal( name, newdate, health) VALUES ( :name, :newdate, :health);";
            this.id = (int) conn.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("newdate", this.newdate)
                    .addParameter("health", this.health)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<EndangeredAnimal> getAllAnimals() {
        try (Connection conn = Database.sql2o.open()) {
            String sql = "SELECT * FROM endangeredanimal ORDER BY id DESC;";
            return conn.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(EndangeredAnimal.class);
        }
    }
    public EndangeredAnimal findById(int id) {
        String sql = "SELECT * FROM endangeredanimal WHERE id=:id";
        try (Connection conn = Database.sql2o.open()){
            EndangeredAnimal animal = conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(EndangeredAnimal.class);
            return animal;
        }catch (IndexOutOfBoundsException ex){
            System.out.println(ex);
            return null;
        }
    }
    public void delete() {
        try(Connection con = Database.sql2o.open()) {
            String sql = "DELETE FROM endangeredanimal; WHERE id=:id;";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
}
