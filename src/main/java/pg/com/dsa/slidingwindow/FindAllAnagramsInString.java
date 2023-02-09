package pg.com.dsa.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInString {

	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		
		findAnagrams(s,p).forEach(e-> System.out.print(e + " "));
	}

	public static List<Integer> findAnagrams(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        List<Integer> result = new ArrayList<>();
        if(slen < plen)
            return result;
        int arrSize = 26;
        int[] sArr = new int[arrSize];
        int[] pArr = new int[arrSize];
        int i = 0;
        for(; i < plen; i++){
           sArr[s.charAt(i) - 'a']++; 
           pArr[p.charAt(i) - 'a']++;    
        }
        
        if(Arrays.equals(sArr,pArr))
            result.add(i-plen);
        
        for(;i < slen; i++){
            sArr[s.charAt(i) - 'a']++;
            sArr[s.charAt(i-plen) - 'a']--;
            if(Arrays.equals(sArr,pArr))
            result.add(i-plen+1);
        }
        
        return result;
    }
}
