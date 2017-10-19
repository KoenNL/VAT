package Main;

public class Config {

    private final String databaseHost = "localhost",
            databaseName = "vat",
            databaseUser = "root",
            databasePassword = "root";



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
}
