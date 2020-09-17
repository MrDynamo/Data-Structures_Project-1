public class ArrayPolynomial implements Polynomial {

    /*** Variables ***/

    // Initialize array to size 100
    private double[] coeff;

    /*** Methods ***/

    // Default constructor
    public ArrayPolynomial() {
        coeff = new double[100];
    }

    public ArrayPolynomial(int size) {
        coeff = new double[size];
    }

    // Print degree of polynomial (highest index)
    @Override
    public int degree() {
        int deg = 0;

        // Iterate through array
        for (int i = 0; i < coeff.length; i++) {
            // If number at index != 0, set degree to highest index
            if (coeff[i] != 0.0) {
                deg = i;
            }
        }
        return deg;
    }

    // Return coefficient of given power
    @Override
    public double getCoefficient(int power) throws ExponentOutOfRangeException {
        return coeff[power];
    }

    // Set coefficient of given power
    @Override
    public void setCoefficient(double newCoefficient, int power) throws ExponentOutOfRangeException {
        coeff[power] = newCoefficient;
    }

    @Override
    public Polynomial add(Polynomial p) {
        Polynomial result = new ArrayPolynomial();

        for (int i = 0; i < coeff.length; i++) {
            result.setCoefficient(coeff[i] + p.getCoefficient(i), i);
            result.setCoefficient(coeff[i] + p.getCoefficient(i), i);
        }

        return result;
    }

    @Override
    public Polynomial mult(Polynomial p) throws ExponentOutOfRangeException {
        Polynomial result = new ArrayPolynomial(coeff.length + p.degree() - 1);

        for (int i = 0; i < coeff.length; i++) {
            for (int j = 0; j < p.degree(); j++) {
                result.setCoefficient(coeff[i] * p.getCoefficient(j),i + j);
            }
        }

        return result;
    }

    @Override
    public void mult(double scalar) {
        for (int i = 0; i < coeff.length; i++) {
            coeff[i] = coeff[i] * scalar;
        }
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
        if (coeff[0] != 0.0) {
            //System.out.print("debug 1");
            display = Double.toString(coeff[0]);
        }

        // Add 1 degree to display
        if (coeff[1] != 0.0) {
            if (coeff[0] == 0.0)
                display = coeff[1] + "x^1";
            else {
                tmp = coeff[1] + "x^1 + ";
                display = tmp + display;
            }
        }

        // Loop through array and add each portion of the polynomial to the display result
        for (int i = 2; i < coeff.length; i++) {
            // Continue adding to display if coefficient != 0.0
            if (coeff[i] != 0.0) {
                tmp = coeff[i] + "x^" + i + " + ";
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
