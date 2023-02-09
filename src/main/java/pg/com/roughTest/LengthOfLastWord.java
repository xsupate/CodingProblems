package pg.com.roughTest;

public class LengthOfLastWord {

	public static void main(String[] args) {
       System.out.println("Length of last word : " + getLength("Hello World"));
	}
  
	public static int getLength(String st) {
		String[] words = st.split(" ");
		if(words.length == 0)
			return 0;
		return words[words.length-1].trim().length();
	}
}
