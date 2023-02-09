package pg.com.roughTest;

public class ExcelColNumberAndColNamePrint {

	public static void main(String[] args) {
		System.out.println("Column name is " + getColumnName(2147483647));
		System.out.println("Column number is " + getColumnNumber(getColumnName(2147483647)));
	}

	
	public static String getColumnName(int num) {
		StringBuilder rt = new StringBuilder();
		boolean hasZ = false;
		
		while(num != 0) {
			int index = num % 26;
			char temp;
			if(index == 0) {
				temp = 'Z';
				hasZ = true;
			}else {
				temp = (char)(index -1 + 'A');
			}
			rt.append(temp);
			
			num = num/26;
			if(hasZ) {
				num = num -1;
			}
		}
		return rt.reverse().toString();
	}
	
	public static int getColumnNumber(String columnName) {
		int res = 0;
		int power = 0;
		for(int i = columnName.length()-1; i > -1; i--) {
			res = res + (int)Math.pow(26, power) * ((int)columnName.charAt(i) - 65 + 1);
			power++;
		}
		
		return res;
	}
}
