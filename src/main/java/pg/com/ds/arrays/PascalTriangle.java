package pg.com.ds.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		int noRows = 6;
		for(List<Integer> list : getPascalTriangles(noRows)) {
			System.out.println(list);
		}
		System.out.println("==================================");
		System.out.println(getPascalTriangleRow(3));
	}

	public static List<List<Integer>> getPascalTriangles(int noRows){
		List<List<Integer>> triangle = new ArrayList<>();
		List<Integer> firstRow = new ArrayList<>();
		firstRow.add(1);
		triangle.add(firstRow);
		
		for(int i = 1; i < noRows; i++) {
			List<Integer> newRow = new ArrayList<>();
			newRow.add(1);
			
			List<Integer> prevRow = triangle.get(i-1);
			for(int j = 1 ; j < i; j++) {
				newRow.add(prevRow.get(j-1) + prevRow.get(j));
			}
			newRow.add(1);
			triangle.add(newRow);
		}
		
		return triangle;
	}
	
	public static List<Integer> getPascalTriangleRow(int rowIndex){
		List<Integer> resultRow = new ArrayList<>();
		for(int i=0; i <= rowIndex;  i++) {
			resultRow.add(nCr(rowIndex,i));
		}
		
		return resultRow;
	}

	private static int nCr(int n, int r) {
		if(n==0 || r==0 || r== n) {
			return 1;
		}
		return nCr(n-1,r-1) + nCr(n-1, r);
	}
	
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<>();

		long c = 1;
		for (int j = 0; j <= rowIndex; j++) {
			result.add((int) c);
			c *= rowIndex - j;
			c /= j + 1;
		}
		return result;
	}
}
