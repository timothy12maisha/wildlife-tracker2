import org.junit.Test;
import static org.junit.Assert.*;
public class NormalAnimalTest {

    @Test
    public void getId() {
        NormalAnimal newNormalAnimal = new NormalAnimal (1, "rhino",2001);
        assertEquals( 1, newNormalAnimal.getId());

    }

    @Test
    public void getName() {
        NormalAnimal newNormalAnimal = new NormalAnimal(1, "rhino",2001);
        assertEquals("rhino",newNormalAnimal.getName());
    }

    @Test
    public void getTimestamp() {
        NormalAnimal newNormalAnimal = new NormalAnimal(1, "rhino",2001);
        assertEquals(2001, newNormalAnimal.getTimestamp());
    }
}