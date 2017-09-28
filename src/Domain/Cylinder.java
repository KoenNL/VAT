package Domain;

public class Cylinder extends Shape {

    private final String type = "cylinder";
    private double radius;
    private double height;

    /**
     * @param radius double
     * @param height double
     */
    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    /**
     * Get the radius.
     * @return double
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sdet the radius.
     * @param radius double
     */
    public void setRadius(double radius) {
        this.radius = radius;
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
    public double calculateVolume() {
        return Math.PI * Math.pow(this.radius, 2) * this.height;
    }
}
