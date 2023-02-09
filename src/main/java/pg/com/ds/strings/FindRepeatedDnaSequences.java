package pg.com.ds.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindRepeatedDnaSequences {

	public static void main(String[] args) {
		String s = "";

	}
	
	public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> all = new HashSet<>();
        HashSet<String> ans = new HashSet<>();
        for(int i=0;i+10<=s.length();i++){
            String x = s.substring(i , i+10);
            if(!all.add(x)){
                ans.add(x);
            }
        }
        List<String> a = new ArrayList<>(ans);
        return a;           
    }

}
