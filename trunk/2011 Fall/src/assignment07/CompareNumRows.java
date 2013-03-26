/**
 * 
 */
package assignment07;

import java.util.Comparator;

/**
 * @author Ke-Bang Huang
 *
 */
public class CompareNumRows implements Comparator<Matrix> {

	/**
	 * Compare matrixes's rows
	 * @param arg0 one of the matrix used to compare
	 * @param arg1 the other matrix used to compare
	 * @return difference between numRows of two matrixes
	 */
	@Override
	public int compare(Matrix arg0, Matrix arg1) {
		return arg0.getNumRows() - arg1.getNumRows();
	}

}
