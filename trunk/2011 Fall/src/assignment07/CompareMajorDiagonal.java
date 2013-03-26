/**
 * 
 */
package assignment07;

import java.util.Comparator;

/**
 * @author Ke-Bang Huang
 *
 */
public class CompareMajorDiagonal implements Comparator<Matrix> {

	/**
	 * Compare matrixes's sum of major diagonal
	 * @param arg0 one of the matrix used to compare
	 * @param arg1 the other matrix used to compare
	 * @return difference between sum of major diagonal of two matrixes
	 */
	@Override
	public int compare(Matrix arg0, Matrix arg1) {
		return arg0.getDiagonal() - arg1.getDiagonal();
	}

}
