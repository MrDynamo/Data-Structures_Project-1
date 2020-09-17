public class ArrayPolynomial implements Polynomial {

    // Github test

    // Initialize array to size 100
    private double[] polyArray = new double[100];

    // Default constructor
    public ArrayPolynomial() {

    }

    @Override
    public int degree() {
        return 0;
    }

    @Override
    public double getCoefficient(int power) throws ExponentOutOfRangeException {
        return 0;
    }

    @Override
    public void setCoefficient(double newCoefficient, int power) throws ExponentOutOfRangeException {

    }

    @Override
    public Polynomial add(Polynomial p) {
        return null;
    }

    @Override
    public Polynomial mult(Polynomial p) throws ExponentOutOfRangeException {
        return null;
    }

    @Override
    public void mult(double scalar) {

    }

    @Override
    public double evaluate(double x) {
        return 0;
    }

    // Check indexes of array, print largest index = degree
    @Override
    public void displayPolynomial() {

    }
}
