package pg.com.ds.matrix;

/*Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.

You must do it in place.

Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
*/

public class SetMatrixZeroes {
	public static void main(String[] args) {

	}
	
	public void setZeroes(int[][] matrix) {
        if(matrix == null || (matrix.length == 0 && matrix[0].length==0))
            return ;
        
        boolean firstRowHasZero= false;
        boolean firstColHasZero= false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i = 0; i < n; i++){
            if(matrix[0][i] == 0){
               firstRowHasZero = true;
                break;
            }
                
        }
        
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
               firstColHasZero = true;
                break;
            }
                
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0; //make first element of columns as zero
                    matrix[i][0] = 0; //make row element of columns as zero
                }
            }
        }
        
      //make whole column as zero if first element of column is zero
        for(int j = 1; j < n; j++){
           if(matrix[0][j] == 0){
               colNullify(matrix, m, n, j);
           }
        }
       
      //make whole row as zero if first element of row is zero
        for(int i = 1; i < m; i++){
           if(matrix[i][0] == 0){
               rowNullify(matrix, m, n, i);
           }
        }
        
        if(firstRowHasZero)
           rowNullify(matrix, m, n, 0); 
        
        if(firstColHasZero)
           colNullify(matrix, m, n, 0);
    }
    
    private void rowNullify(int[][] matrix , int m, int n, int row){
        for(int i=0; i < n; i++)
           matrix[row][i] = 0; 
    }
    
    private void colNullify(int[][] matrix , int m, int n, int col){
        for(int i=0; i < m; i++)
           matrix[i][col] = 0; 
    }
}
