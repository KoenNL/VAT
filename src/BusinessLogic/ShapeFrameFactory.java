package BusinessLogic;

import Domain.*;
import Presentation.*;

public class ShapeFrameFactory {

    /**
     * Create a new frame with a new empty shape.
     *
     * @param type String
     * @throws BusinessLogicException
     */
    public static void createShapeFrame(String type) throws BusinessLogicException {
        ShapeFrame shapeFrame = new ShapeFrame(type);
        ShapePanel shapePanel;
        switch (type) {
            case "Sphere":
                shapePanel = new SpherePanel(new Sphere(0.0));
                break;
            case "Cylinder":
                shapePanel = new CylinderPanel(new Cylinder(0.00, 0.00));
                break;
            case "Cone":
                shapePanel = new ConePanel(new Cone(0.00, 0.00));
                break;
            case "RectangularPrism":
                shapePanel = new RectangularPrismPanel(new RectangularPrism(0.00, 0.00, 0.00));
                break;
            case "SquarePyramid":
                shapePanel = new SquarePyramidPanel(new SquarePyramid(0.00, 0.00, 0.00));
                break;
            default:
                throw new BusinessLogicException("Invalid type '" + type + "' provided for a new shape.");
        }

        shapeFrame.setShapePanel(shapePanel);
        shapeFrame.setShapeButtonPanel(new ShapeButtonPanel(shapePanel));
    }

    /**
     * Create a new frame with an existing shape.
     *
     * @param shape Shape
     * @throws BusinessLogicException
     */
    public static void createShapeFrame(Shape shape) throws BusinessLogicException {
        ShapeFrame shapeFrame = new ShapeFrame(shape.getType());
        ShapePanel shapePanel;
        switch (shape.getType()) {
            case "Sphere":
                shapePanel = new SpherePanel(shape);
                break;
            case "Cylinder":
                shapePanel = new CylinderPanel(shape);
                break;
            case "Cone":
                shapePanel = new ConePanel(shape);
                break;
            case "RectangularPrism":
                shapePanel = new RectangularPrismPanel(shape);
                break;
            case "SquarePyramid":
                shapePanel = new SquarePyramidPanel(shape);
                break;
            default:
                throw new BusinessLogicException("Invalid type '" + shape.getType() + "' provided for a new shape.");
        }

        shapeFrame.setShapePanel(shapePanel);
        shapeFrame.setShapeButtonPanel(new ShapeButtonPanel(shapePanel));
    }

}
