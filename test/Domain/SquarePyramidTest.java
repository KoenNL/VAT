package Domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquarePyramidTest {
    @Test
    public void calculateVolume() throws Exception {
        SquarePyramid squarePyramid = new SquarePyramid(2.0, 4.0);
        assertEquals(5.33333, squarePyramid.calculateVolume(), 0.00001);

        squarePyramid.setLength(14.65);
        squarePyramid.setHeight(34.76);
        assertEquals(2486.75937, squarePyramid.calculateVolume(), 0.00001);

        squarePyramid.setLength(43.53235);
        squarePyramid.setHeight(12.435);
        assertEquals(7855.04648, squarePyramid.calculateVolume(), 0.00001);
    }

}