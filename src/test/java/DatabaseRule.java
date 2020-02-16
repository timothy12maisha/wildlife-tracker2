import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
public class DatabaseRule extends ExternalResource {
    @Override
    protected void before() {
        Database.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "timothymaina", "password");
    }
    @Override
    protected void after() {
        try (Connection con = Database.sql2o.open()) {
            String deleteAnimalsQuery = "DELETE FROM animal *;";
            String deleteEndangeredAnimalsQuery = "DELETE FROM endangeredanimal *;";
            con.createQuery(deleteAnimalsQuery).executeUpdate();
            con.createQuery(deleteEndangeredAnimalsQuery).executeUpdate();

        }
    }
}