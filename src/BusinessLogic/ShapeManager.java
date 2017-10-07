package BusinessLogic;

import DataStorage.DAOException;
import DataStorage.ShapeDAO;
import Domain.Shape;

import java.util.ArrayList;

public class ShapeManager {

    private static ArrayList<Shape> shapes = new ArrayList<Shape>();
    private static ShapeDAO DAO;

    /**
     * Add a shape to the manager.
     * @param shape Shape
     */
    public static void addShape(Shape shape) {
        // Set the id of the shape.
        if (ShapeManager.shapes.get(shape.getId()) == null) {
            shape.setId(ShapeManager.shapes.size());
        }

        ShapeManager.shapes.add(shape);
    }

    /**
     * Get all shapes.
     * @return ArrayList<Shape>
     */
    public static ArrayList<Shape> getShapes() {
        return ShapeManager.shapes;
    }

    /**
     * Set the data access object.
     * @param DAO ShapeDAO
     */
    public static void setDAO(ShapeDAO DAO) {
        ShapeManager.DAO = DAO;
    }

    /**
     * Calculate the total volume of all set shapes.
     * @return double
     */
    public static double calculateTotalVolume() {
        double totalVolume = 0.0;

        for (Shape shape : ShapeManager.shapes) {
            totalVolume += shape.calculateVolume();
        }

        return totalVolume;
    }

    /**
     * Save the current list of shapes with the set DAO.
     * @return boolean
     * @throws ManagerException
     */
    public static boolean save() throws ManagerException {
        if (ShapeManager.DAO == null) {
            throw new ManagerException("No DAO set for saving data.");
        }

        try {
            ShapeManager.DAO.setShapes(ShapeManager.shapes);

            return ShapeManager.DAO.save();
        } catch (DAOException exception) {
            throw new ManagerException("Unable to save shapes.", exception);
        }
    }

    /**
     * Load a list of shapes with the set DAO.
     * @return boolean
     * @throws ManagerException
     */
    public static boolean load() throws ManagerException  {
        if (ShapeManager.DAO == null) {
            throw new ManagerException("No DAO set for loading data.");
        }

        try {
            ShapeManager.DAO.load();
            ShapeManager.shapes = ShapeManager.DAO.getShapes();

            return true;
        } catch (DAOException exception) {
            throw new ManagerException("Unable to load shapes.", exception);
        }
    }

}
