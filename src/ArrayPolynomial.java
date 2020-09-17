public class ArrayPolynomial implements Polynomial {

    // Initialize array to size 100
    private double[] polyArray;

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

    @Override
    public double getCoefficient(int power) throws ExponentOutOfRangeException {
        return polyArray[power];
    }

    @Override
    public void setCoefficient(double newCoefficient, int power) throws ExponentOutOfRangeException {
        polyArray[power] = newCoefficient;
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

    // Display the full polynomial with formatting
    @Override
    public void displayPolynomial() {
        String display = "", tmp = "";
        boolean prevPositive = true;

        // Add 0 degree to display
        if (polyArray[0] != 0.0) {
            //System.out.print("debug 1");
            display = Double.toString(polyArray[0]);
            if (polyArray[0] < 0.0)
                prevPositive = false;
        }

        // Loop through array and add each portion of the polynomial to the display result
        for (int i = 1; i < polyArray.length; i++) {
            // Continue adding to display if coefficient != 0.0
            if (polyArray[i] != 0.0) {

                tmp = polyArray[i] + "x^" + i + " + ";

                /*
                // If coefficient before is positive, add +
                if (prevPositive) {
                    //System.out.print("debug 2");
                    tmp = polyArray[i] + "x^" + i + " + ";
                } else
                    // Else if negative, add -
                    if (polyArray[i - 1] < 0.0) {
                        //System.out.print("debug 3");
                        tmp = polyArray[i] + "x^" + i + " - ";
                }

                if (polyArray[i] < 0.0)
                    prevPositive = false;
                else
                    prevPositive = true;
                 */

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
