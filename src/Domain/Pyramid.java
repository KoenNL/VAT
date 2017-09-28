package Domain;

abstract public class Pyramid extends Shape {
    protected double length;
    protected double width;
    protected double height;

    /**
     * Get the length.
     * @return double
     */
    public double getLength() {
        return length;
    }

    /**
     * Set the length.
     * @param length double
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Get the width.
     * @return double
     */
    public double getWidth() {
        return width;
    }

    /**
     * Set the width.
     * @param width double
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Get the height.
     * @return double
     */
    public double getHeight() {
        return height;
    }

    /**
     * Set the height.
     * @param height double
     */
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    abstract public double calculateVolume();
}
