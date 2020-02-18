import org.junit.Test;

import java.sql.Date;
import java.sql.Timestamp;

import static org.junit.Assert.*;
public class NormalAnimalTest {

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
}