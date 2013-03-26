/**
 * 
 */
package assignment07;

import java.util.Comparator;

/**
 * @author Ke-Bang Huang
 *
 */
public class CompareDeterminant implements Comparator<Matrix> {

	/**
	 * Compare matrixes's determinant
	 * @param arg0 one of the matrix used to compare
	 * @param arg1 the other matrix used to compare
	 * @return difference between determinant of two matrixes
	 */
	@Override
	public int compare(Matrix arg0, Matrix arg1) {
		return arg0.getDeterminant() - arg1.getDeterminant();
	}

}
