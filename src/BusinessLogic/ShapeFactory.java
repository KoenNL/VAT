package BusinessLogic;

import Domain.*;

public class ShapeFactory {

    public static Sphere toSphere(Shape shape) {
        if (!shape.getClass().getSimpleName().equals("Sphere")) {
            return null;
        }

        return new Sphere(shape.getRadius());
    }

    public static Cylinder toCylinder(Shape shape) {
        if (!shape.getClass().getSimpleName().equals("Cylinder")) {
            return null;
        }

        return new Cylinder(shape.getRadius(), shape.getHeight());
    }

    public static Cone toCone(Shape shape) {
        if (!shape.getClass().getSimpleName().equals("Cone")) {
            return null;
        }

        return new Cone(shape.getRadius(), shape.getHeight());
    }

    public static RectangularPrism toRectangularPrism(Shape shape) {
        if (!shape.getClass().getSimpleName().equals("RectangularPrism")) {
            return null;
        }

        return new RectangularPrism(shape.getLength(), shape.getWidth(), shape.getHeight());
    }

    public static SquarePyramid toSquarePyramid(Shape shape) {
        if (!shape.getClass().getSimpleName().equals("SquarePyramid")) {
            return null;
        }

        return new SquarePyramid(shape.getLength(), shape.getWidth(), shape.getHeight());
    }

}
