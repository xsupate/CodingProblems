package pg.com.roughTest;

public class ArraySumTest {

	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
	    int sum = 0;
	     
	    for (int i = 0; i < matrix.length; i++) {
	      sum += matrix[i][i];
	    }
	     
	    System.out.println(sum);
	}

}
