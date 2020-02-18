import org.junit.Rule;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

public class EndangeredAnimalTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();


    @Test
    public void getName() {
        Date testDate = new Date();
        EndangeredAnimal newEndangeredAnimal = new EndangeredAnimal("lion", new Timestamp(12-12-2009),"sick");
        assertEquals("lion" ,newEndangeredAnimal.getName());
    }

    @Test
    public void getTimestamp() {
        Date testDate = new Date();
        EndangeredAnimal newEndangeredAnimal = new EndangeredAnimal("lion",new Timestamp(12-12-2009),"sick");
        assertEquals(2001 ,newEndangeredAnimal.getTimestamp());
    }

    @Test
    public void getHealth() {
        Date testDate = new Date();
        EndangeredAnimal newEndangeredAnimal = new EndangeredAnimal("lion",new Timestamp(12-12-2009),"sick");
        assertEquals("sick",newEndangeredAnimal.getHealth());
    }
    @Test
    public void save_insertObjectIntoDatabase_Animal(){
        Date testDate = new Date();
        EndangeredAnimal newEndangeredAnimal = new EndangeredAnimal("lion",new Timestamp(12-12-2009),"sick");
        newEndangeredAnimal.saveEndangered();
        assertTrue(EndangeredAnimal.getAllAnimals().get(0).equals(newEndangeredAnimal));
    }
    @Test
    public void delete_deleteAnimalFromDatabase_0(){
        Date testDate = new Date();
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("lion",new Timestamp(12-12-2009),"sick");
        endangeredAnimal.saveEndangered();
        endangeredAnimal.delete();
        assertEquals(0,EndangeredAnimal.getAllAnimals() .size());
    }

}