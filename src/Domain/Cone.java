package Domain;

public class Cone extends Shape {

    /**
     * @param radius double
     * @param height double
     */
    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double calculateVolume() {
        return 1.0 / 3.0 * Math.PI * Math.pow(this.radius, 2) * this.height;
    }
}
