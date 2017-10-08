package BusinessLogic;

import Domain.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeManagerTest {
    @Test
    public void calculateTotalVolume() throws Exception {
        ShapeManager shapeManager = new ShapeManager();
        assertEquals(0.0, shapeManager.calculateTotalVolume(), 0.00001);

        Sphere sphere = new Sphere(2.0);
        Cylinder cylinder = new Cylinder(2.0, 4.0);
        Cone cone = new Cone(2.0, 3.0);
        RectangularPrism rectangularPrism = new RectangularPrism(2.0, 4.0, 5.0);
        SquarePyramid squarePyramid = new SquarePyramid(2.0, 4.0);

        shapeManager.addShape(sphere);
        shapeManager.addShape(cylinder);
        shapeManager.addShape(cone);
        shapeManager.addShape(rectangularPrism);
        shapeManager.addShape(squarePyramid);

        assertEquals(141.6755, shapeManager.calculateTotalVolume(), 0.0001);

        sphere.setRadius(12.54);
        cylinder.setRadius(32.76);
        cylinder.setHeight(14.23);
        cone.setRadius(3.45);
        cone.setHeight(5.67);
        rectangularPrism.setLength(23.54);
        rectangularPrism.setWidth(34.77);
        rectangularPrism.setHeight(54.12);
        squarePyramid.setLength(14.65);
        squarePyramid.setHeight(34.76);

        assertEquals(103091.95182, shapeManager.calculateTotalVolume(), 0.0001);

        sphere.setRadius(22.9881);
        cylinder.setRadius(12.32532);
        cylinder.setHeight(13.43);
        cone.setRadius(4.45291);
        cone.setHeight(5.673);
        rectangularPrism.setLength(18.514);
        rectangularPrism.setWidth(43.75755);
        rectangularPrism.setHeight(2.1232);
        squarePyramid.setLength(43.53235);
        squarePyramid.setHeight(12.435);

        assertEquals(66988.32171, shapeManager.calculateTotalVolume(), 0.0001);
    }

}