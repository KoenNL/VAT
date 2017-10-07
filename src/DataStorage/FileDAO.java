package DataStorage;

import Domain.Shape;
import Main.Config;

import java.util.ArrayList;

public class FileDAO extends ShapeDAO {

    private final ShapeFileParser fileParser;

    public FileDAO(Config config, String fileType) throws DAOException {
        super(config);

        switch (fileType) {
            case "CSV":
                this.fileParser = new CSVParser();
            default:
                throw new DAOException("File type " + fileType + " not supported by file data access object");
        }
    }

    @Override
    public boolean save() throws DAOException {
        return false;
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
