package Domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class CylinderTest {
    @Test
    public void calculateVolume() throws Exception {
        Cylinder cylinder = new Cylinder(2.0, 4.0);
        assertEquals(50.26548, cylinder.calculateVolume(), 0.00001);

        cylinder.setRadius(32.76);
        cylinder.setHeight(14.23);
        assertEquals(47978.04627, cylinder.calculateVolume(), 0.00001);

        cylinder.setRadius(12.32532);
        cylinder.setHeight(13.43);
        assertEquals(6409.47256, cylinder.calculateVolume(), 0.00001);
    }

}