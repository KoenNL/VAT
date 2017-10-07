package Domain;

public class RectangularPrism extends Shape {

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

    @Override
    public double calculateVolume() {
        return this.length * this.width * this.height;
    }
}
