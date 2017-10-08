package Domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class RectangularPrismTest {
    @Test
    public void calculateVolume() throws Exception {
        RectangularPrism rectangularPrism = new RectangularPrism(2.0, 4.0, 5.0);
        assertEquals(40.0, rectangularPrism.calculateVolume(), 0.00001);

        rectangularPrism.setLength(23.54);
        rectangularPrism.setWidth(34.77);
        rectangularPrism.setHeight(54.12);
        assertEquals(44296.4515, rectangularPrism.calculateVolume(), 0.00001);

        rectangularPrism.setLength(18.514);
        rectangularPrism.setWidth(43.75755);
        rectangularPrism.setHeight(2.1232);
        assertEquals(1720.06224, rectangularPrism.calculateVolume(), 0.00001);
    }

}