package pg.com.ds.matrix;

public class SpiralPrintMatrix {

	public static void main(String[] args) {
		int a[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		spriralPrintOfMatrix(a);
	}

	public static void spriralPrintOfMatrix(int[][] matrix) {
		int m = matrix.length; //number of row 
		int n = matrix[0].length; // number of col
		int i, k = 0, l = 0;
		 
        /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
        */
 
        while (k < m && l < n) {
            // Print the first row from the remaining rows
            for (i = l; i < n; ++i) {
                System.out.print(matrix[k][i] + " ");
            }
            k++;
 
            // Print the last column from the remaining
            // columns
            for (i = k; i < m; ++i) {
                System.out.print(matrix[i][n - 1] + " ");
            }
            n--;
 
            // Print the last row from the remaining rows */
            if (k < m) {
                for (i = n - 1; i >= l; --i) {
                    System.out.print(matrix[m - 1][i] + " ");
                }
                m--;
            }
 
            // Print the first column from the remaining
            // columns */
            if (l < n) {
                for (i = m - 1; i >= k; --i) {
                    System.out.print(matrix[i][l] + " ");
                }
                l++;
            }
        }
	}
}
