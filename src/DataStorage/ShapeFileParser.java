package DataStorage;

import Domain.Shape;

import java.io.File;
import java.util.ArrayList;

interface ShapeFileParser {

    /**
     * Get a list of shapes from the given file.
     * @return ArrayList<Shape>
     */
    public ArrayList<Shape> fromFile(File file);

    /**
     * Write the given list of shapes to a file.
     * @param shapes ArrayList<Shape>
     * @param file File
     * @return
     */
    public boolean toFile(ArrayList<Shape> shapes, File file);

}
