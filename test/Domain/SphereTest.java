package Domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class SphereTest {
    @Test
    public void calculateVolume() throws Exception {
        Sphere sphere = new Sphere(2.0);
        assertEquals(33.51032, sphere.calculateVolume(), 0.00001);

        sphere.setRadius(12.54);
        assertEquals(8260.02228, sphere.calculateVolume(), 0.00001);

        sphere.setRadius(22.9881);
        assertEquals(50885.94478, sphere.calculateVolume(), 0.00001);
    }

}