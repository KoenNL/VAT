package DataStorage;

import Domain.*;

import java.io.*;
import java.util.ArrayList;

public class FileShapeDAO extends ShapeDAO {

    private String fileType, fileName;
    private String CSVDelimiter = ";";

    public FileShapeDAO(String fileType, String fileName) throws DAOException {
        this.fileType = fileType;
        this.fileName = fileName;
    }

    @Override
    public boolean save() throws DAOException {
        switch (this.fileType) {
            case "CSV":
                return this.saveToCSV();
            case "data":
                return this.saveToData();
            default:
                throw new DAOException("File type " + this.fileType + " not supported by file data access object");
        }
    }

    @Override
    public boolean load() throws DAOException {
        this.shapes = new ArrayList<Shape>();
        switch (fileType) {
            case "CSV":
                return this.loadFromCSV();
            case "data":
                return this.loadFromData();
            default:
                throw new DAOException("File type " + fileType + " not supported by file data access object");
        }
    }

    @Override
    public boolean delete() throws DAOException {
        return false;
    }

    private boolean saveToCSV() throws DAOException {
        try {
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(this.fileName)));

            String line;

            for (Shape shape : this.shapes) {
                line = shape.getId() + this.CSVDelimiter +
                        shape.getType() + this.CSVDelimiter +
                        shape.getRadius() + this.CSVDelimiter +
                        shape.getLength() + this.CSVDelimiter +
                        shape.getWidth() + this.CSVDelimiter +
                        shape.getHeight() + this.CSVDelimiter;
                printWriter.println(line);
            }

            printWriter.close();
        } catch (FileNotFoundException exception) {
            throw new DAOException("File " + this.fileName + " not found.", exception);
        } catch (IOException exception) {
            throw new DAOException("Unable to save CSV file.", exception);
        }

        return true;
    }

    private boolean loadFromCSV() throws DAOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.fileName));

            String line;

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(this.CSVDelimiter);

                if (columns.length != 6) {
                    throw new DAOException("Invalid data detected in given CSV file.");
                }

                Shape shape;

                switch (columns[1]) {
                    case "Sphere":
                        shape = new Sphere(Double.parseDouble(columns[2]));
                        shape.setId(Integer.parseInt(columns[0]));
                        this.shapes.add(shape);
                        break;
                    case "Cylinder":
                        shape = new Cylinder(Double.parseDouble(columns[2]), Double.parseDouble(columns[5]));
                        shape.setId(Integer.parseInt(columns[0]));
                        this.shapes.add(shape);
                        break;
                    case "Cone":
                        shape = new Cone(Double.parseDouble(columns[2]), Double.parseDouble(columns[5]));
                        shape.setId(Integer.parseInt(columns[0]));
                        this.shapes.add(shape);
                        break;
                    case "RectangularPrism":
                        shape = new RectangularPrism(
                                Double.parseDouble(columns[3]),
                                Double.parseDouble(columns[4]),
                                Double.parseDouble(columns[4])
                        );
                        shape.setId(Integer.parseInt(columns[0]));
                        this.shapes.add(shape);
                        break;
                    case "SquarePyramid":
                        shape = new Cone(Double.parseDouble(columns[3]), Double.parseDouble(columns[5]));
                        shape.setId(Integer.parseInt(columns[0]));
                        this.shapes.add(shape);
                        break;
                }
            }

            reader.close();
        } catch (FileNotFoundException exception) {
            throw new DAOException("File " + this.fileName + " not found.", exception);
        } catch (IOException exception) {
            throw new DAOException("Unable to load from data file.", exception);
        }
        return true;
    }

    private boolean saveToData() throws DAOException {
        try {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(this.fileName));

            for (Shape shape : this.shapes) {
                stream.writeObject(shape);
            }

            stream.close();
        } catch (FileNotFoundException exception) {
            throw new DAOException("File " + this.fileName + " not found.", exception);
        } catch (IOException exception) {
            throw new DAOException("Unable to save data file.", exception);
        }
        return true;
    }

    private boolean loadFromData() throws DAOException {
        try {
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(this.fileName));

            Shape shape;

            while ((shape = (Shape) stream.readObject()) != null) {
                this.shapes.add(shape);
            }

            stream.close();
        } catch (FileNotFoundException exception) {
            throw new DAOException("File " + this.fileName + " not found.", exception);
        } catch (IOException exception) {
            throw new DAOException("Unable to load from data file.", exception);
        } catch (ClassNotFoundException exception) {
            throw new DAOException("Invalid data found in given file.", exception);
        }
        return true;
    }
}
