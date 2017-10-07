package Main;

public class Config {

    private String filePath,
            databaseHost = "localhost",
            databaseName = "vat",
            databaseUser = "root",
            databasePassword = "root";

    /**
     * Get the file path.
     *
     * @return String
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Set the file path.
     *
     * @param filePath String
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
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
     * Set the database host.
     *
     * @param databaseHost String
     */
    public void setDatabaseHost(String databaseHost) {
        this.databaseHost = databaseHost;
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
     * Set the database name.
     *
     * @param databaseName String
     */
    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
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
     * Set the database user.
     *
     * @param databaseUser String
     */
    public void setDatabaseUser(String databaseUser) {
        this.databaseUser = databaseUser;
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
     * Set the database password.
     *
     * @param databasePassword String
     */
    public void setDatabasePassword(String databasePassword) {
        this.databasePassword = databasePassword;
    }
}
