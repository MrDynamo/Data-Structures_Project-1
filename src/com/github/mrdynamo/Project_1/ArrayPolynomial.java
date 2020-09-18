package com.github.mrdynamo.Project_1;

public class ArrayPolynomial implements Polynomial {

    /*** Class Variables ***/

    // Declare new array to initialize later
    private double[] coeff;

    /*** Class Methods ***/

    // Default constructor
    public ArrayPolynomial() {
        coeff = new double[100];
    }

    // Constructor for usage in mult(Polynomial) function
    public ArrayPolynomial(double[] coeffArray) {
        coeff = coeffArray;
    }

    // Print degree of polynomial
    @Override
    public int degree() {
        int deg = 0;

        // Iterate through array
        for (int i = 0; i < coeff.length; i++) {
            // If number at index != 0, set degree to index
            if (coeff[i] != 0.0) {
                deg = i;
            }
        }
        // Returns highest index, AKA degree
        return deg;
    }

    // Return coefficient of given power
    @Override
    public double getCoefficient(int power) throws ExponentOutOfRangeException {
        // Throw exception degree > 100 (out of range)
        if (power > 100)
            throw new ExponentOutOfRangeException("Maximum power cannot exceed 100");
        // Else return coefficient at given power
        else
            return coeff[power];
    }

    // Set coefficient of given power
    @Override
    public void setCoefficient(double newCoefficient, int power) throws ExponentOutOfRangeException {
        // Throw exception if degree > 100 (out of range)
        if (power > 100)
            throw new ExponentOutOfRangeException("Maximum power cannot exceed 100");
        // Else set the coefficient to new coefficient
        else
            coeff[power] = newCoefficient;
    }

    // Add this polynomial to Polynomial p, return new polynomial with result
    @Override
    public Polynomial add(Polynomial p) {
        // Declare and initialize new polynomial for result
        Polynomial result = new ArrayPolynomial();

        for (int i = 0; i < coeff.length; i++) {
            // Set coefficient of result to the sum of this and p
            result.setCoefficient(coeff[i] + p.getCoefficient(i), i);
        }

        // Return the new polynomial containing the result
        return result;
    }

    // Multiply this polynomial by Polynomial p, return new polynomial with result
    @Override
    public Polynomial mult(Polynomial p) throws ExponentOutOfRangeException {
        // Declare and initialize new double array for product
        double[] result = new double[100];

        // Throw exception if degree > 100 (out of range)
        if (this.degree() + p.degree() > 100)
            throw new ExponentOutOfRangeException("Maximum power cannot exceed 100");
        else {
            // Iterate through both polynomials, multiplying monomials as you go
            for (int i = 0; i <= this.degree(); i++) {
                for (int j = 0; j <= p.degree(); j++) {
                    result[i + j] += this.coeff[i] * p.getCoefficient(j);
                }
            }
            // Return new polynomial using the result array
            return new ArrayPolynomial(result);
        }
    }

    // Multiply this polynomial by a scalar
    @Override
    public void mult(double scalar) {
        // Declare and initialize new double array
        double[] blank = new double[100];

        // If multiplying by 0.0, result is 0.0
        if (scalar == 0.0)
            coeff = blank;
        else {
            // Else iterate through polynomial and multiply each term by the scalar
            for (int i = 0; i < this.degree(); i++) {
                coeff[i] = coeff[i] * scalar;
            }
        }
    }

    // Evaluate the polynomial at x using Horner's method
    @Override
    public double evaluate(double x) {
        // Declare and initialize result variable
        double result = 0.0;

        // Use Horner's method to evauluate recursively
        for (int i = 1; i < coeff.length; i++) {
            result += coeff[i] * Math.pow(x, i);
        }

        // Return the result of evauluation at x
        return result;
    }

    // Display the full polynomial with formatting
    @Override
    public void displayPolynomial() {
        // Declare and initialize display strings
        String display = "", tmp = "";

        // Add 0th degree to display
        if (coeff[0] != 0.0) {
            display = Double.toString(coeff[0]);
        }

        // Add 1st degree to display
        if (coeff[1] != 0.0) {
            if (coeff[0] == 0.0)
                display = coeff[1] + "x^1";
            else {
                tmp = coeff[1] + "x^1 + ";
                display = tmp + display;
            }
        }

        // Loop through array starting at 2nd degree and add each portion of the polynomial to the display result
        for (int i = 2; i < coeff.length; i++) {
            // Only add to display if coefficient is not 0.0
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

        // Display result if not blank
        if (!display.isBlank())
            System.out.println(display);
        // Else display 0.0
        else
            System.out.println("0.0");

    }
}
