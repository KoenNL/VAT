package Domain;

import java.io.Serializable;

abstract public class Shape implements Serializable {

    private int id = 0;
    protected double length = 0.0;
    protected double width = 0.0;
    protected double height = 0.0;
    protected double radius = 0.0;

    /**
     * Get the length
     * @return double
     */
    public double getLength() {
        return length;
    }

    /**
     * Set the length
     * @param length double
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Get the width
     * @return double
     */
    public double getWidth() {
        return width;
    }

    /**
     * Set the width
     * @param width double
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Get the height
     * @return double
     */
    public double getHeight() {
        return height;
    }

    /**
     * Set the height
     * @param height double
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Get the radius
     * @return double
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Set the radius
     * @param radius double
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Get the type of this shape.
     * @return String
     */
    public String getType() {
        return this.getClass().getSimpleName();
    }

    /**
     * Set the id.
     * @param id int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return the properties as a formatted string.
     * @return String
     */
    public String toString() {
        String string = "";

        string = this.addToString(string, this.getRadius());
        string = this.addToString(string, this.getLength());
        string = this.addToString(string, this.getWidth());
        string = this.addToString(string, this.getHeight());

        return this.getType() + ": " + string + " (" + String.format("%.2f", this.calculateVolume()) + ")";
    }

    /**
     * Add a double to a string and format the string.
     * @param string String
     * @param value double
     * @return String
     */
    private String addToString(String string, double value) {
        if (string.length() > 0 && value > 0) {
            string += ", " + String.format("%.2f", value);
        } else if (value > 0){
            string += String.format("%.2f", value);
        }

        return string;
    }

    /**
     * Get the id of the shape.
     *
     * @return int
     */
    public int getId() {
        return this.id;
    }

    /**
     * Calculate the volume of this shape.
     *
     * @return double
     */
    abstract public double calculateVolume();
}
