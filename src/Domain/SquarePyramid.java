package Domain;

public class SquarePyramid extends Shape {

    /**
     * @param length double
     * @param height double
     */
    public SquarePyramid(double length, double height) {
        this.length = length;
        this.height = height;
    }

    @Override
    public double calculateVolume() {
        return Math.pow(this.length, 2) * this.height / 3;
    }
}
