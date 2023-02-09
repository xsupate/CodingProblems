package pg.com.ds.matrix;

import java.util.HashSet;
import java.util.Set;

public class ValidateSudko {

	public static void main(String[] args) {
		char[][] board = {
				 {'5','3','.','.','7','.','.','.','.'}
				,{'6','.','.','1','9','5','.','.','.'}
				,{'1','9','8','.','.','.','.','6','.'}
				,{'8','.','.','.','6','.','.','.','3'}
				,{'4','.','.','8','.','3','.','.','1'}
				,{'7','.','.','.','2','.','.','.','6'}
				,{'.','6','.','.','.','.','2','8','.'}
				,{'.','.','.','4','1','9','.','.','5'}
				,{'.','.','.','.','8','.','.','7','9'}};
		System.out.println("Is this a valid sudko : " + isValidSudoku(board));
	}
	
	public static boolean isValidSudoku(char[][] board) {
		Set<String> meet = new HashSet<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
            	char ch = board[i][j];
                if(ch != '.'){
                   if(!meet.add(ch+"row"+i) || !meet.add(ch+"col"+j)
                     || !meet.add(ch+"box"+i/3+"-"+j/3)){
                       return false;
                   }
                }
            }
        }
        return true;
    }

}
