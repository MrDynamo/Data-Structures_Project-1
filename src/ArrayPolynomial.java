public class ArrayPolynomial implements Polynomial {

    /*** Variables ***/

    // Initialize array to size 100
    private double[] coeff;

    /*** Methods ***/

    // Default constructors
    public ArrayPolynomial() {
        coeff = new double[100];
    }

    public ArrayPolynomial(double[] coeffArray) {
        coeff = coeffArray;
    }

    // Returns an instance of the coefficient array
    public double[] getCoeffArray(Polynomial p) {
        double[] coeffArr = this.coeff;
        return coeffArr;
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
        if (power > 100)
            throw new ExponentOutOfRangeException("Maximum power cannot exceed 100");
        else
            return coeff[power];
    }

    // Set coefficient of given power
    @Override
    public void setCoefficient(double newCoefficient, int power) throws ExponentOutOfRangeException {
        if (power > 100)
            throw new ExponentOutOfRangeException("Maximum power cannot exceed 100");
        else
            coeff[power] = newCoefficient;
    }

    // Add this polynomial to Polynomial p, return new polynomial with result
    @Override
    public Polynomial add(Polynomial p) {
        Polynomial result = new ArrayPolynomial();

        for (int i = 0; i < coeff.length; i++) {
            result.setCoefficient(coeff[i] + p.getCoefficient(i), i);
            result.setCoefficient(coeff[i] + p.getCoefficient(i), i);
        }

        return result;
    }

    // Multiply this polynomial by Polynomial p, return new polynomial with result
    @Override
    public Polynomial mult(Polynomial p) throws ExponentOutOfRangeException {
        double[] result = new double[100];

        if (this.degree() + p.degree() > 100)
            throw new ExponentOutOfRangeException("Maximum power cannot exceed 100");
        else {
            for (int i = 0; i <= this.degree(); i++) {
                for (int j = 0; j <= p.degree(); j++) {
                    result[i + j] += this.coeff[i] * p.getCoefficient(j);
                }
            }
            return new ArrayPolynomial(result);
        }
    }

    // Multiply this polynomial by a scalar
    @Override
    public void mult(double scalar) {
        double[] blank = new double[100];

        if (scalar == 0.0)
            coeff = blank;
        else {
            for (int i = 0; i < this.degree(); i++) {
                coeff[i] = coeff[i] * scalar;
            }
        }
    }

    // Evaluate the polynomial at x using Horner's method
    @Override
    public double evaluate(double x) {
        double result = 0.0;

        for (int i = 1; i < coeff.length; i++) {
            result += coeff[i] * Math.pow(x, i);
        }

        return result;
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
                // If nothing has been added to display yet, remove the + from the end of display
                if (display.isBlank())
                    display = coeff[i] + "x^" + i;
                else {
                    // Else add to display normally
                    tmp = coeff[i] + "x^" + i + " + ";
                    display = tmp + display;
                }
            }
        }

        // Display result if not blank, else display 0.0
        if (!display.isBlank())
            System.out.println(display);
        else
            System.out.println("0.0");

    }
}
