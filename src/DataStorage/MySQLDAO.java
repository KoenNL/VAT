package DataStorage;

import BusinessLogic.ExceptionHandler;
import BusinessLogic.ShapeFactory;
import Domain.*;
import Main.Config;

import java.sql.*;
import java.util.ArrayList;

public class MySQLDAO extends ShapeDAO {

    private Connection connection;

    public MySQLDAO(Config config, ArrayList<Shape> shapes) throws DAOException {
        super(config, shapes);
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "root");
        } catch (SQLException exception) {
            throw new DAOException("Could not make a connection with the database", exception);
        }

    }

    @Override
    public boolean save() throws DAOException {
        try {
            String sql = "INSERT INTO `Shape` VALUES(?, ?, ?, ?, ?, ?);";

            PreparedStatement statement = this.connection.prepareStatement(sql);

            for (Shape shape : this.shapes) {
                this.prepareShapeValues(statement, shape);
                statement.execute();
            }
        } catch (SQLException exception) {
            throw new DAOException("Could not save shapes to database", exception);
        }

        return true;
    }

    /**
     * Prepare the values for inserting or updating shapes.
     *
     * @param statement PreparedStatement
     * @param shape     Shape
     * @throws SQLException
     * @throws DAOException
     */
    private void prepareShapeValues(PreparedStatement statement, Shape shape) throws SQLException, DAOException {
        statement.setInt(1, shape.getId());
        statement.setString(2, shape.getClass().getSimpleName());

        switch (shape.getClass().getSimpleName()) {
            case "Sphere":
                Sphere sphere = ShapeFactory.toSphere(shape);
                statement.setDouble(3, 0);
                statement.setDouble(4, 0);
                statement.setDouble(5, 0);
                statement.setDouble(6, sphere.getRadius());
                break;
            case "Cylinder":
                Cylinder cylinder = ShapeFactory.toCylinder(shape);
                statement.setDouble(3, 0);
                statement.setDouble(4, 0);
                statement.setDouble(5, cylinder.getHeight());
                statement.setDouble(6, cylinder.getRadius());
                break;
            case "Cone":
                Cone cone = ShapeFactory.toCone(shape);
                statement.setDouble(3, 0);
                statement.setDouble(4, 0);
                statement.setDouble(5, cone.getHeight());
                statement.setDouble(6, cone.getRadius());
                break;
            case "RectangularPrism":
                RectangularPrism rectangularPrism = ShapeFactory.toRectangularPrism(shape);
                statement.setDouble(3, rectangularPrism.getLength());
                statement.setDouble(4, rectangularPrism.getWidth());
                statement.setDouble(5, rectangularPrism.getHeight());
                statement.setDouble(6, 0);
                break;
            case "SquarePyramid":
                SquarePyramid squarePyramid = ShapeFactory.toSquarePyramid(shape);
                statement.setDouble(3, squarePyramid.getLength());
                statement.setDouble(4, squarePyramid.getWidth());
                statement.setDouble(5, squarePyramid.getHeight());
                statement.setDouble(6, 0);
                break;
            default:
                throw new DAOException("Invalid shape " + shape.getClass().getSimpleName());
        }
    }

    @Override
    public boolean load() throws DAOException {
        try {
            String sql = "SELECT * FROM `Shape`";

            PreparedStatement statement = this.connection.prepareStatement(sql);

            statement.execute();

            ResultSet resultSet = statement.getResultSet();

            this.shapes = this.resultToShapes(resultSet);

            if (this.shapes.size() > 0) {
                return true;
            }

        } catch (SQLException exception) {
            throw new DAOException("Could not load shapes to database", exception);
        }

        return false;
    }

    /**
     * Convert a result set to an array list of shape objects.
     *
     * @param resultSet ResultSet
     * @return ArrayList<Shape>
     * @throws SQLException
     * @throws DAOException
     */
    private ArrayList<Shape> resultToShapes(ResultSet resultSet) throws SQLException, DAOException {
        ArrayList<Shape> shapes = new ArrayList<Shape>();

        while (resultSet.next()) {
            switch (resultSet.getString("type")) {
                case "Sphere":
                    Sphere sphere = new Sphere(resultSet.getDouble("radius"));

                    shapes.add(sphere);
                    break;
                case "Cylinder":
                    Cylinder cylinder = new Cylinder(
                            resultSet.getDouble("raduis"),
                            resultSet.getDouble("height")
                    );

                    shapes.add(cylinder);
                    break;
                case "Cone":
                    Cone cone = new Cone(
                            resultSet.getDouble("raduis"),
                            resultSet.getDouble("height")
                    );

                    shapes.add(cone);
                    break;
                case "RectangularPrism":
                    RectangularPrism rectangularPrism = new RectangularPrism(
                            resultSet.getDouble("length"),
                            resultSet.getDouble("width"),
                            resultSet.getDouble("height")
                    );

                    shapes.add(rectangularPrism);
                    break;
                case "SquarePyramid":
                    SquarePyramid squarePyramid = new SquarePyramid(
                            resultSet.getDouble("length"),
                            resultSet.getDouble("width"),
                            resultSet.getDouble("height")
                    );

                    shapes.add(squarePyramid);
                    break;
                default:
                    throw new DAOException(
                            "Invalid type '" + resultSet.getString("type") + "' for fetching shape from database."
                    );
            }
        }

        return shapes;
    }

    @Override
    public boolean delete() throws DAOException {
        try {
            String sql = "DELETE FROM `Shape`";

            PreparedStatement statement = this.connection.prepareStatement(sql);

            return statement.execute();
        } catch (SQLException exception) {
            throw new DAOException("Unable to delete shapes from database.", exception);
        }
    }
}
