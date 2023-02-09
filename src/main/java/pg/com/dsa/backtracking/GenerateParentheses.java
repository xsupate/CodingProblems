package pg.com.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {
		generateParentheses(3).forEach(s -> System.out.print(s +" "));

	}
	
	public static List<String> generateParentheses(int n){
		List<String> res = new ArrayList<>();
		generateParentheses("", 0, 0, n, res);
		return res;
	}

	private static void generateParentheses(String temp, int open, int close, int n, List<String> res) {
		if(open > n || close > open) {
			return; 
		}
		
		if(open == n && close == n) {
			res.add(temp);
			return;
		}
		generateParentheses(temp + "(", open+1, close, n, res);
		generateParentheses(temp + ")", open, close+1, n, res);
	}
	

}
