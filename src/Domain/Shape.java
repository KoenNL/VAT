package Domain;

abstract public class Shape {

    private int id;
    private final String type = "shape";

    /**
     * Get the type of shape.
     * @return String
     */
    public String getType() {
        return this.type;
    }

    /**
     * Set the id.
     * @param id int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the id of the shape.
     * @return int
     */
    public int getId() {
        return this.id;
    }

    /**
     * Calculate the volume of this shape.
     * @return double
     */
    abstract public double calculateVolume();
}
