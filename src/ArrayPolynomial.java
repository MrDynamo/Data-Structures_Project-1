public class ArrayPolynomial implements Polynomial {

    /*** Variables ***/

    // Initialize array to size 100
    private double[] polyArray;

    /*** Methods ***/

    // Default constructor
    public ArrayPolynomial() {
        polyArray = new double[100];
    }

    // Print degree of polynomial (highest index)
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

    // Return coefficient of given power
    @Override
    public double getCoefficient(int power) throws ExponentOutOfRangeException {
        return polyArray[power];
    }

    // Set coefficient of given power
    @Override
    public void setCoefficient(double newCoefficient, int power) throws ExponentOutOfRangeException {
        polyArray[power] = newCoefficient;
    }

    @Override
    public Polynomial add(Polynomial poly) {
        Polynomial result = new ArrayPolynomial();

        for (int i = 0; i < polyArray.length; i++) {
            result.setCoefficient(polyArray[i] + poly.getCoefficient(i), i);
        }

        return result;
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

    // Display the full polynomial with formatting
    @Override
    public void displayPolynomial() {
        String display = "", tmp = "";

        // Add 0 degree to display
        if (polyArray[0] != 0.0) {
            //System.out.print("debug 1");
            display = Double.toString(polyArray[0]);
        }

        // Add 1 degree to display
        if (polyArray[1] != 0.0) {
            if (polyArray[0] == 0.0)
                display = polyArray[1] + "x^1";
            else {
                tmp = polyArray[1] + "x^1 + ";
                display = tmp + display;
            }
        }

        // Loop through array and add each portion of the polynomial to the display result
        for (int i = 2; i < polyArray.length; i++) {
            // Continue adding to display if coefficient != 0.0
            if (polyArray[i] != 0.0) {
                tmp = polyArray[i] + "x^" + i + " + ";
                display = tmp + display;
            }
        }

        // Display result if not blank, else display 0.0
        if (!display.isBlank())
            System.out.println(display);
        else
            System.out.println("0.0");

    }
}
