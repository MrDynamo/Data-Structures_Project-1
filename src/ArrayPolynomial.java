public class ArrayPolynomial implements Polynomial {

    // Initialize array to size 100
    private double[] polyArray;

    // Default constructor
    public ArrayPolynomial() {
        polyArray = new double[100];
    }

    @Override
    public int degree() {
        int deg = 0;

        // Iterate through array
        for (int i = 0; i < polyArray.length; i++) {
            // If number at index != 0, set degree to highest index
            if (polyArray[i] != 0.0) {
                deg = i;
            }
        }

        return deg;
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
        String display = "", tmp = "";

        // Loop through array and add each portion of the polynomial to the display result
        for (int i = 0; i < polyArray.length; i++) {
            if (polyArray[i] != 0.0) {
                tmp = polyArray[i] + "^" + i + " ";
            }

            display = tmp + display;
        }

        // Display result if not blank, else display 0.0
        if (!display.isBlank())
            System.out.println(display);
        else
            System.out.println("0.0");

    }
}
