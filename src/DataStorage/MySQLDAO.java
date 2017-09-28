package DataStorage;

import BusinessLogic.ExceptionHandler;
import Domain.*;
import Main.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLDAO extends ShapeDAO {

    private Connection connection;

    public MySQLDAO(Config config, ArrayList<Shape> shapes) {
        super(config, shapes);
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "root");
        } catch (SQLException exception) {
            ExceptionHandler.handleException(exception, "Could not make a connection with the database");
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
            ExceptionHandler.handleException(exception, "Could not save shapes to database");
        }

        return true;
    }

    private void prepareShapeValues(PreparedStatement statement, Shape shape) throws SQLException, DAOException {
        statement.setInt(1, shape.getId());
        statement.setString(2, shape.getClass().getSimpleName());

        switch (shape.getClass().getSimpleName()) {
            case "Sphere":
                this.prepareSphereValues(statement, shape);
                break;
            case "Cylinder":
                this.prepareCylinderValues(statement, shape);
                break;
            case "Cone":
                this.prepareConeValues(statement, shape);
                break;
            case "RectangularPrism":
                this.prepareRectangularPrismValues(statement, shape);
                break;
            case "SquarePyramid":
                this.prepareSquarePyramidValues(statement, shape);
                break;
            default:
                throw new DAOException("Invalid shape " + shape.getClass().getSimpleName());
        }
    }

    private void prepareSphereValues(PreparedStatement statement, Sphere sphere) throws SQLException {
        statement.setDouble(3, 0);
        statement.setDouble(4, 0);
        statement.setDouble(5, 0);
        statement.setDouble(6, sphere.getRadius());
    }

    private void prepareCylinderValues(PreparedStatement statement, Cylinder cylinder) throws SQLException {
        statement.setDouble(3, 0);
        statement.setDouble(4, 0);
        statement.setDouble(5, cylinder.getHeight());
        statement.setDouble(6, cylinder.getRadius());
    }

    private void prepareConeValues(PreparedStatement statement, Cone cone) throws SQLException {
        statement.setDouble(3, 0);
        statement.setDouble(4, 0);
        statement.setDouble(5, cone.getHeight());
        statement.setDouble(6, cone.getRadius());
    }

    private void prepareRectangularPrismValues(PreparedStatement statement, RectangularPrism rectangularPrism) throws SQLException {
        statement.setDouble(3, rectangularPrism.getLength());
        statement.setDouble(4, rectangularPrism.getWidth());
        statement.setDouble(5, rectangularPrism.getHeight());
        statement.setDouble(6, 0);
    }

    private void prepareSquarePyramidValues(PreparedStatement statement, SquarePyramid squarePyramid) throws SQLException {
        statement.setDouble(3, squarePyramid.getLength());
        statement.setDouble(4, squarePyramid.getWidth());
        statement.setDouble(5, squarePyramid.getHeight());
        statement.setDouble(6, 0);
    }

    @Override
    public boolean load() throws DAOException {
        return false;
    }

    @Override
    public boolean delete() throws DAOException {
        return false;
    }
}
