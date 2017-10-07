package Domain;

public class SquarePyramid extends Pyramid {

    /**
     * @param length double
     * @param width double
     * @param height double
     */
    public SquarePyramid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateVolume() {
        return 1.0 / 3.0 * this.length * this.width * this.height;
    }
}
