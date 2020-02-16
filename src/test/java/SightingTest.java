import org.junit.Test;

import static org.junit.Assert.*;

public class SightingTest {

    @Test
    public void getId() {
        Sighting newSighting = new Sighting(1,"mombasa","Timothy");
        assertEquals(1,newSighting.getId());
    }

    @Test
    public void getLocation() {
        Sighting newSighting = new Sighting(1,"mombasa","Timothy");
        assertEquals("mombasa",newSighting.getLocation());
    }

    @Test
    public void getRangerName() {
        Sighting newSighting = new Sighting(1,"mombasa","Timothy");
        assertEquals("Timothy",newSighting.getRangerName());
    }
}