import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredAnimalTest {

   // @Rule
//    public DatabaseRule database = new DatabaseRule();


    @Test
    public void getName() {
        EndangeredAnimal newEndangeredAnimal = new EndangeredAnimal("lion",2001,"sick");
        assertEquals("lion" ,newEndangeredAnimal.getName());
    }

    @Test
    public void getTimestamp() {
        EndangeredAnimal newEndangeredAnimal = new EndangeredAnimal("lion",2001,"sick");
        assertEquals(2001 ,newEndangeredAnimal.getTimestamp());
    }

    @Test
    public void getHealth() {
        EndangeredAnimal newEndangeredAnimal = new EndangeredAnimal("lion",2001,"sick");
        assertEquals("sick",newEndangeredAnimal.getHealth());
    }
    @Test
    public void save_insertObjectIntoDatabase_Animal(){
        EndangeredAnimal newEndangeredAnimal = new EndangeredAnimal("lion",2001,"sick");
        newEndangeredAnimal.saveEndangered();
        assertTrue(EndangeredAnimal.getAllAnimals().get(0).equals(newEndangeredAnimal));
    }
    @Test
    public void delete_deleteAnimalFromDatabase_0(){
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("lion",2001,"sick");
        endangeredAnimal.saveEndangered();
        endangeredAnimal.delete();
        assertEquals(0,EndangeredAnimal.getAllAnimals() .size());
    }

}