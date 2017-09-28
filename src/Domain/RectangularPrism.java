package Domain;

public class RectangularPrism extends Shape {

    private double length;
    private double width;
    private double height;

    /**
     * @param length double
     * @param width  double
     * @param height double
     */
    public RectangularPrism(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    /**
     * Get the length.
     *
     * @return double
     */
    public double getLength() {
        return length;
    }

    /**
     * Set the length.
     *
     * @param length double
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Get the width.
     *
     * @return double
     */
    public double getWidth() {
        return width;
    }

    /**
     * Set the width.
     *
     * @param width double
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Get the height.
     *
     * @return double
     */
    public double getHeight() {
        return height;
    }

    /**
     * Set the height.
     *
     * @param height double
     */
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double calculateVolume() {
        return this.length * this.width * this.height;
    }
}
