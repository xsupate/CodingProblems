package pg.com.ds.matrix;

public class TransposeOf2DMatrix {

	public static void main(String[] args) {
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		printMatrix(arr, 3, 3);
		transposeOfMatrix(arr, 3, 3);
		System.out.println("After transpose of Matrix");
		printMatrix(arr, 3, 3);
	}

	public static void printMatrix(int[][] arr, int row, int col) {
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	public static void transposeOfMatrix(int[][] arr, int row, int col) {
		for(int i = 0; i < row; i++) {
			for(int j = i; j < col; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
	}
}
