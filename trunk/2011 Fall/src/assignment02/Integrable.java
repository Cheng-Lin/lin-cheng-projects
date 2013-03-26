package assignment02;
/**
 * An interface for functions that have definite
 * integrals, which can be computed numerically.
 * The method used will assume the functions are
 * continuous (no step-like jumps).
 * 
 * In this case a Java interface is used because
 * Java does not allow "function parameters" and
 * interfaces give a way to achieve the same idea.
 *
 * @author CS 140
 *
 */
public interface Integrable {
    /**
     * A function that can be integrated numerically
     * using the Trapezoidal rule (nicely described
     * at Wikipedia)
     * @param x input to the function
     * @return value of the function at the point x
     */
    double value(double x);
} 