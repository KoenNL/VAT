package Domain;

public class Cylinder extends Shape {

    /**
     * @param radius double
     * @param height double
     */
    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }
    
    @Override
    public double calculateVolume() {
        return Math.PI * Math.pow(this.radius, 2) * this.height;
    }
}
