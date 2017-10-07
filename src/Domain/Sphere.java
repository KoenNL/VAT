package Domain;

public class Sphere extends Shape {

    /**
     * @param radius double
     */
    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateVolume() {
        return 4 / 3 * Math.PI * Math.pow(this.radius, 3);
    }
}
