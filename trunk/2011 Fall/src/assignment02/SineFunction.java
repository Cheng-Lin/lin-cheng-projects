package assignment02;
/**
 * The sine function is continuous and hence
 * can be integrated numerically
 *
 * @author CS 140
 *
 */
public class SineFunction implements Integrable
{
    /**
     * The Java Math class provides the sine
     * function
     * @param x input to the cosine function
     * @return the value of sin x
     */
    public double value(double x)
    {
        return Math.sin(x);
    }
} 