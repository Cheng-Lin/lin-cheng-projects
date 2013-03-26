package assignment02;
/**
 * Class providing an implementation of integration
 * using the Trapezoidal rule.
 *
 * @author CS 140
 *
 */
public class Integrator {
    /**
     * Compute the area of a set of vertical trapezoidal
     * strips that approximate the area between a function
     * contained in the interface f and the x-axis.
     * The upper and lower limits along the x-axis are
     * a and b, respectively and the width of each string is
     * (b-a)/n
     *
     * @param f interface containing the integrable function
     * @param a lower bound along the x-axis
     * @param b upper bound along the x-axis
     * @param n number of subdivisions of the interval [a,b]
     * @return the approximation of the area under the curve
     */
    private static double trapeziumArea(Integrable f, double a, double b, long n) {
        // DEFINE A double CALLED summation WITH THE
        // INITIAL VALUE EQUAL TO THE AVERAGE OF
        // f.value(a) AND f.value(b)

        // IN A for LOOP FROM int i = 0 WHILE i IS LESS THAN n
        // IN INCREMENTS OF 1--THAT MEANS for(int i = 0; i < n; i++)
        // ADD f.value(a+i*(b-a)/n) TO summation

        // IF YOU WANT TO SEE HOW THE INTEGRATION IS PROGRESSING
        // INCLUDE THE LINES:
        // long power = (long)Math.round(Math.log(n)/Math.log(2));
        // System.out.println("2^" + power + ", strip width=" + ((b-a)/n) + ", area=" +
        //   ((b-a)*summation/n) + ", error=" + (1-(b-a)*summation/n));

        // RETURN (b-a)*summation/n
    	double summation = (f.value(a) + f.value(b)) / 2.0;
    	for (int i = 0; i < n; i++) {
    		summation += f.value(a + i * (b - a) / n);
    	}
        long power = (long)Math.round(Math.log(n)/Math.log(2));
        System.out.println("2^" + power + ", strip width=" + ((b-a)/n) + ", area=" +
      				       ((b-a)*summation/n) + ", error=" + (1-(b-a)*summation/n));
    	return (b - a) * summation / n;
    }

    /**
     * Compute the definite integral between a and b
     * of the function contained in the Integrable
     * object f.
     * @param f object containing the function to be integrated
     * @param a lower bound of the definite integral
     * @param b lower bound of the definite integral
     * @return an approximate definite integral for the
     * given function from a to b.
     */
    static double integral(Integrable f, double a, double b) {
        if (a >= b) {
            throw new IllegalArgumentException("Specified lower bound is " +
                    "not smaller than the upper bound");
        }
        long n = 128;
        double summation0 = 0;
        double summation1 = trapeziumArea(f,a,b,n);
 
        //WRITE A WHILE LOOP THAT RUNS while THE
        //Math.abs(diff) > 1E-10 WHERE diff IS THE
        //DIFFERENCE BETWEEN summation1 and summation0
 
        //IN THE BODY OF THE LOOP, ASSIGN summation1
        //TO summation 0, CHANGE n TO 2*n AND ASSIGN
        //summation1 TO THE NEW VALUE OF trapeziumArea(f,a,b,n)

        //RETURN summation1
        double diff = summation1 - summation0;
        while (Math.abs(diff) > 1E-10) {
        	summation0 = summation1;
        	n *= 2;
        	summation1 =trapeziumArea(f, a, b, n);
        	diff = summation1 - summation0;
        }
        return summation1;
        	
    }
    /**
     * Test of the integral method by computing the
     * definite integral of sin x between 0 and 1
     * numerically.
     * The answer should theoretically be 1.0.
     *
     * @param args command line arguments are ignored
     */
    public static void main(String[] args) {
        double val = integral(new SineFunction(), 0, Math.PI/2);
        System.out.println(val);
    }
}