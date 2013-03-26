package assignment02;
/**
 * The cosine function is continuous and hence
 * can be integrated numerically
 *
 * @author CS 140
 *
 */
public class CosineFunction implements Integrable
{
    /**
     * The Java Math class provides the cosine
     * function
     * @param x input to the cosine function
     * @return the value of cos x
     */
    public double value(double x)
    {
        return Math.cos(x);
    }
} 