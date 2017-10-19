package Main;

import BusinessLogic.ExceptionHandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private String databaseHost = "localhost",
            databaseName = "vat",
            databaseUser = "root",
            databasePassword = "root";

    private boolean debug = false;

    public Config() {
        try {
            Properties properties = new Properties();
            InputStream inputStream = new FileInputStream("config.properties");

            properties.load(inputStream);

            this.databaseHost = properties.getProperty("databaseHost");
            this.databaseName = properties.getProperty("databaseName");
            this.databaseUser = properties.getProperty("databaseUser");
            this.databasePassword = properties.getProperty("databasePassword");
            this.debug = Boolean.getBoolean(properties.getProperty("debug"));
        } catch (FileNotFoundException exception) {
            ExceptionHandler.handleException(exception, "No config file found.");
        } catch (IOException exception) {
            ExceptionHandler.handleException(exception, "Invalid config file.");
        }
    }

    /**
     * Get the database host.
     *
     * @return String
     */
    public String getDatabaseHost() {
        return databaseHost;
    }

    /**
     * Get the database name.
     *
     * @return String
     */
    public String getDatabaseName() {
        return databaseName;
    }

    /**
     * Get the database user.
     *
     * @return String
     */
    public String getDatabaseUser() {
        return databaseUser;
    }

    /**
     * Get the database password.
     *
     * @return String
     */
    public String getDatabasePassword() {
        return databasePassword;
    }

    /**
     * Check if debug is set.
     *
     * @return boolean
     */
    public boolean isDebug() {
        return debug;
    }
}
