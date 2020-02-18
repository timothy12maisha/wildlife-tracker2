import org.junit.Rule;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;
public class NormalAnimalTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();


    @Test
    public void getId() {
        NormalAnimal newNormalAnimal = new NormalAnimal (1, "rhino", new Timestamp(12-12-2009));
        assertEquals( 1, newNormalAnimal.getId());

    }

    @Test
    public void getName() {
        NormalAnimal newNormalAnimal = new NormalAnimal(1, "rhino",new Timestamp(12-12-2009));
        assertEquals("rhino",newNormalAnimal.getName());
    }

    @Test
    public void getTimestamp() {
        NormalAnimal newNormalAnimal = new NormalAnimal(1, "rhino",new Timestamp(12-12-2009));
        assertEquals(2001, newNormalAnimal.getTimestamp());
    }
    @Test
    public void saves_NormalAnimals_to_database(){
        java.util.Date testDate = new Date();
        NormalAnimal newNormalAnimal = new NormalAnimal(1,"rhino",new Timestamp(12-12-2009));
        newNormalAnimal.saveNormal();
        assertTrue(EndangeredAnimal.getAllAnimals().get(0).equals(newNormalAnimal));
    }


}