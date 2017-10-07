package DataStorage;

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
    private void prepareShapeValues(PreparedStatement statement, Shape shape) throws SQLException {
        statement.setInt(1, shape.getId());
        statement.setString(2, shape.getType());

        statement.setDouble(3, shape.getLength());
        statement.setDouble(4, shape.getWidth());
        statement.setDouble(5, shape.getHeight());
        statement.setDouble(6, shape.getRadius());
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
