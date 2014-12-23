package from061to070;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem067 {
  public static int maxSum(ArrayList<int[]> triangle) {
    int dimension = triangle.size();
    int[][] sumTable = new int[dimension][dimension];
    sumTable[0][0] = triangle.get(0)[0];

    int lastIndex = dimension - 1;
    for (int i = 0; i < lastIndex; i++) {
      for (int j = 0; j < triangle.get(i).length; j++) {
        int tempSum = sumTable[i][j] + triangle.get(i + 1)[j];
        if (tempSum > sumTable[i + 1][j]) {
          sumTable[i + 1][j] = tempSum;
        }

        tempSum = sumTable[i][j] + triangle.get(i + 1)[j + 1];
        if (tempSum > sumTable[i + 1][j + 1]) {
          sumTable[i + 1][j + 1] = tempSum;
        }
      }
    }

    int max = sumTable[lastIndex][0];
    for (int i = 1; i < triangle.get(lastIndex).length; i++) {
      if (sumTable[lastIndex][i] > max) {
        max = sumTable[lastIndex][i];
      }
    }

    return max;
  }

  public static void main(String[] args) {
    ArrayList<int[]> triangle = new ArrayList<int[]>();
    File file = new File("problem/from061to070/Problem067.txt");

    try {
        Scanner fin = new Scanner(file);

        int count = 1;
        while (fin.hasNextLine()) {
            triangle.add(new int[count]);
            for (int i = 0; i < count; i++) {
                triangle.get(count - 1)[i] = fin.nextInt();
            }
            count++;
        }

        fin.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

    System.out.println(maxSum(triangle));
  }
}
