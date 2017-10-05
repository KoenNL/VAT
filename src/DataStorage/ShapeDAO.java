package DataStorage;

import Domain.Shape;
import Main.Config;

import java.util.ArrayList;

abstract public class ShapeDAO {

    protected ArrayList<Shape> shapes;
    protected Config config;

    public ShapeDAO(Config config, ArrayList<Shape> shapes) {
        this.config = config;
        this.shapes = shapes;
    }

    /**
     * Get all shapes.
     * @return ArrayList<Shape>
     */
    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    /**
     * Set the shapes.
     * @param shapes ArrayList<Shape>
     */
    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    /**
     * Save the shapes.
     * @return boolean
     */
    abstract public boolean save() throws DAOException;

    /**
     * Load shapes.
     * @return ArrayList<Shape>
     */
    abstract public boolean load() throws DAOException;

    /**
     * Delete shapes.
     * @return boolean
     */
    abstract public boolean delete() throws DAOException;

}
