package DataStorage;

import Domain.*;

import java.io.*;
import java.util.ArrayList;

public class FileShapeDAO extends ShapeDAO {

    private String fileType;
    private File file;
    private String CSVDelimiter = ";";

    /**
     * @param fileName String
     */
    public FileShapeDAO(File fileName) {
        this.file = fileName;
        this.fileType = FileShapeDAO.getFileExtension(this.file);
    }

    /**
     * Get the file extension of the given file.
     *
     * @param file File
     * @return String
     */
    public static String getFileExtension(File file) {
        String extension = "";
        String s = file.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1) {
            extension = s.substring(i + 1).toLowerCase();
        }
        return extension;
    }

    @Override
    public boolean save() throws DAOException {
        switch (this.fileType) {
            case "csv":
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
            case "csv":
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

    /**
     * Save the list of shapes to a CSV file.
     *
     * @return boolean
     * @throws DAOException on error
     */
    private boolean saveToCSV() throws DAOException {
        try {
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(this.file)));

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
            throw new DAOException("File " + this.file + " not found.", exception);
        } catch (IOException exception) {
            throw new DAOException("Unable to save CSV file.", exception);
        }

        return true;
    }

    /**
     * Load a CSV file with shapes and put them into a list.
     *
     * @return boolean
     * @throws DAOException on error
     */
    private boolean loadFromCSV() throws DAOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.file));

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
            throw new DAOException("File " + this.file + " not found.", exception);
        } catch (IOException exception) {
            throw new DAOException("Unable to load from data file.", exception);
        }
        return true;
    }

    /**
     * Save shapes as an object stream to a binary file.
     *
     * @return boolean
     * @throws DAOException on error
     */
    private boolean saveToData() throws DAOException {
        try {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(this.file));

            stream.writeObject(new Integer(this.shapes.size()));

            for (Shape shape : this.shapes) {
                stream.writeObject(shape);
            }

            stream.close();
        } catch (FileNotFoundException exception) {
            throw new DAOException("File " + this.file + " not found.", exception);
        } catch (IOException exception) {
            throw new DAOException("Unable to save data file.", exception);
        }
        return true;
    }

    /**
     * Load shapes from a binary object stream file and put them into a list.
     *
     * @return boolean
     * @throws DAOException on error
     */
    private boolean loadFromData() throws DAOException {
        ObjectInputStream stream;
        try {
            stream = new ObjectInputStream(new FileInputStream(this.file));

            Shape shape;

            try {
                while ((shape = (Shape) stream.readObject()) != null) {
                    this.shapes.add(shape);
                }
            } catch (EOFException exception) {
                stream.close();
            }
        } catch (FileNotFoundException exception) {
            throw new DAOException("File " + this.file + " not found.", exception);
        } catch (IOException exception) {
            throw new DAOException("Unable to load from data file.", exception);
        } catch (ClassNotFoundException exception) {
            throw new DAOException("Invalid data found in given file.", exception);
        }
        return true;
    }
}
