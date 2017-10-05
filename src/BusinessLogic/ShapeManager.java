package BusinessLogic;

import DataStorage.DAOException;
import DataStorage.ShapeDAO;
import Domain.Shape;

import java.util.ArrayList;

public class ShapeManager {

    private ArrayList<Shape> shapes;
    private ShapeDAO DAO;

    /**
     * Add a shape to the manager.
     * @param shape Shape
     */
    public void addShape(Shape shape) {
        // Set the id of the shape.
        if (this.shapes.get(shape.getId()) == null) {
            shape.setId(this.shapes.size());
        }

        this.shapes.add(shape);
    }

    /**
     * Set the data access object.
     * @param DAO ShapeDAO
     */
    public void setDAO(ShapeDAO DAO) {
        this.DAO = DAO;
    }

    /**
     * Calculate the total volume of all set shapes.
     * @return double
     */
    public double calculateTotalVolume() {
        double totalVolume = 0.0;

        for (Shape shape : this.shapes) {
            totalVolume += shape.calculateVolume();
        }

        return totalVolume;
    }

    /**
     * Save the current list of shapes with the set DAO.
     * @return boolean
     * @throws ManagerException
     */
    public boolean save() throws ManagerException {
        if (this.DAO == null) {
            throw new ManagerException("No DAO set for saving data.");
        }

        try {
            this.DAO.setShapes(this.shapes);

            return this.DAO.save();
        } catch (DAOException exception) {
            throw new ManagerException("Unable to save shapes.", exception);
        }
    }

    /**
     * Load a list of shapes with the set DAO.
     * @return boolean
     * @throws ManagerException
     */
    public boolean load() throws ManagerException  {
        if (this.DAO == null) {
            throw new ManagerException("No DAO set for loading data.");
        }

        try {
            this.DAO.load();
            this.shapes = this.DAO.getShapes();

            return true;
        } catch (DAOException exception) {
            throw new ManagerException("Unable to load shapes.", exception);
        }
    }

}
