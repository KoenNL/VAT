package Domain;

public class Sphere extends Shape {

    private final String type = "sphere";
    private double radius;

    /**
     * @param radius double
     */
    public Sphere(double radius) {
        this.radius = radius;
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

    @Override
    public double calculateVolume() {
        return 4 / 3 * Math.PI * Math.pow(this.radius, 3);
    }
}
