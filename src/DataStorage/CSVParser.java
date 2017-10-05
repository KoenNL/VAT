package DataStorage;

import Domain.Shape;

import java.io.File;
import java.util.ArrayList;

public class CSVParser implements ShapeFileParser {
    @Override
    public ArrayList<Shape> fromFile(File file) {
        return null;
    }

    @Override
    public boolean toFile(ArrayList<Shape> shapes, File file) {
        return false;
    }
}
