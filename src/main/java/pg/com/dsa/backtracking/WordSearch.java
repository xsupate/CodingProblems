package pg.com.dsa.backtracking;

/*
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally 
 * or vertically neighboring. The same letter cell may not be used more than once.
 * 
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 */

public class WordSearch {

	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
	       String word = "ABCCED";
	       System.out.println("Is " + word + " is found in grid : " + exist(board, word));
	}
	
	public static boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(word.charAt(0) == board[i][j] &&
                  exist(board, i, j, word, 0))
                    return true;
            }
        }
        
        return false;
    }
    
    private static boolean exist(char[][] board, int i, int j, String word, int pos){
        if(pos == word.length()) return true;
        if(i < 0 || j < 0|| i >= board.length || j >= board[0].length) return false;
        if(word.charAt(pos) != board[i][j]) return false;
        char temp = board[i][j];
        board[i][j] = '*';
        if(exist(board, i+1, j, word, pos+1) || exist(board, i-1, j, word, pos+1) ||
        		exist(board, i, j+1, word, pos+1) || exist(board, i, j-1, word, pos+1))
        	return true;
        
        board[i][j] = temp;
		return false;
    }

}
