package pg.com.ds.strings;

public class RepeatSubstring {

	public static void main(String[] args) {
		String s = "abab";
        int result = repeatedSubstringPattern(s);
        System.out.println("Result: " + result);
	}

	public static int repeatedSubstringPattern(String s) {
        int n = s.length();
        // Try all possible substring lengths
        for (int len = 1; len <= n / 2; len++) {
            if (n % len == 0) {
                String substring = s.substring(0, len);
                StringBuilder repeatedSubstring = new StringBuilder();

                // Repeat the substring to check if it forms the entire string
                for (int i = 0; i < n / len; i++) {
                    repeatedSubstring.append(substring);
                }

                if (repeatedSubstring.toString().equals(s)) {
                    return n / len;  // Return the number of times the substring is repeated
                }
            }
        }

        return 1;  // If no repeated substring is found, return 1 as it can be written as 1 * s
    }
}
