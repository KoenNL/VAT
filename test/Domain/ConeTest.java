package Domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConeTest {
    @Test
    public void calculateVolume() throws Exception {
        Cone cone = new Cone(2.0, 3.0);
        assertEquals(12.56637, cone.calculateVolume(), 0.00001);

        cone.setRadius(3.45);
        cone.setHeight(5.67);
        assertEquals(70.6724, cone.calculateVolume(), 0.00001);

        cone.setRadius(4.45291);
        cone.setHeight(5.673);
        assertEquals(117.79565, cone.calculateVolume(), 0.00001);
    }

}