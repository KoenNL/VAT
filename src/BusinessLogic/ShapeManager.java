package BusinessLogic;

import DataStorage.DAOException;
import DataStorage.ShapeDAO;
import Domain.Shape;
import Main.Config;

import java.util.ArrayList;

public class ShapeManager {

    private ArrayList<Shape> shapes;
    private ArrayList<String> shapeTypes;
    private ShapeDAO DAO;
    private Config config;

    public ShapeManager(Config config) {
        this.shapeTypes = new ArrayList<String>();
        this.shapeTypes.add("Sphere");
        this.shapeTypes.add("Cylinder");
        this.shapeTypes.add("Cone");
        this.shapeTypes.add("RectangularPrism");
        this.shapeTypes.add("SquarePyramid");

        this.shapes = new ArrayList<Shape>();

        this.config = config;
    }

    /**
     * Add a shape to the manager and set it's id if it doesn't have one.
     *
     * @param shape Shape
     */
    public void addShape(Shape shape) {
        this.shapes.add(shape);

        if (shape.getId() == 0) {
            shape.setId(this.shapes.indexOf(shape) + 1);
        }
    }

    /**
     * Get all shapes.
     *
     * @return ArrayList<Shape>
     */
    public ArrayList<Shape> getShapes() {
        return this.shapes;
    }

    /**
     * Get all shape types.
     *
     * @return ArrayList<String>
     */
    public ArrayList<String> getShapeTypes() {
        return this.shapeTypes;
    }

    /**
     * Set the data access object.
     *
     * @param DAO ShapeDAO
     */
    public void setDAO(ShapeDAO DAO) throws BusinessLogicException {
        try {
            this.DAO = DAO;
            this.DAO.setConfig(this.config);
        } catch (DAOException exception) {
            System.out.println(config.getDatabaseHost());
            System.out.println(config.getDatabaseName());
            System.out.println(config.getDatabasePassword());
            System.out.println(config.getDatabaseUser());
            throw new BusinessLogicException("Invalid config", exception);
        }
    }

    /**
     * Get the type of loaded DAO. If no DAO is loaded null is returned.
     *
     * @return String
     */
    public String getDAOType() {
        if (this.DAO == null) {
            return null;
        }
        return this.DAO.getClass().getSimpleName();
    }

    /**
     * Calculate the total volume of all set shapes.
     *
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
     *
     * @return boolean
     * @throws BusinessLogicException
     */
    public boolean save() throws BusinessLogicException {
        if (this.DAO == null) {
            throw new BusinessLogicException("No DAO set for saving data.");
        }

        try {
            this.DAO.setShapes(this.shapes);

            return this.DAO.save();
        } catch (DAOException exception) {
            throw new BusinessLogicException("Unable to save shapes.", exception);
        }
    }

    /**
     * Load a list of shapes with the set DAO.
     *
     * @return boolean
     * @throws BusinessLogicException
     */
    public boolean load() throws BusinessLogicException {
        if (this.DAO == null) {
            throw new BusinessLogicException("No DAO set for loading data.");
        }

        try {
            this.DAO.load();
            this.shapes = this.DAO.getShapes();

            return true;
        } catch (DAOException exception) {
            throw new BusinessLogicException("Unable to load shapes.", exception);
        }
    }

    /**
     * Delete a shape from the list.
     *
     * @param shape Shape
     * @return boolean
     */
    public boolean deleteShape(Shape shape) {
        if (this.shapes.size() == 0 || this.shapes.indexOf(shape) == -1) {
            return false;
        }
        this.shapes.remove(shape);
        return true;
    }

}
