package pg.com.ds.matrix;

public class findRowWithMaximumOnes {
	public static void main(String[] args) {
	   int mat[][] = { { 0, 0, 0, 1 }, { 0, 1, 1, 1 }, { 0, 0, 1, 1 }, { 0, 0, 0, 0 } };
       System.out.println("Index of row with maximum 1s is " + findRowWithMaxOne(mat));
	}

	public static int findRowWithMaxOne(int[][] matrix) {
        int row = 0;
        int j = matrix[0].length-1;
        int maxSoFar = 0;
        for(int i = 0; i < matrix.length; i++) {
        	while(j >=0 && matrix[i][j] == 1) {
        		j--;
        	}
        	if(maxSoFar < matrix.length-j) {
        		row = i;
        		maxSoFar = matrix.length-j;
        	}
        }
        return row;
	}
}
