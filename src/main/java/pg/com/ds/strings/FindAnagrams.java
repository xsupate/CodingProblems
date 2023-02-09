package pg.com.ds.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams {

	public static void main(String[] args) {
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String p = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		findAnagrams(s,p).forEach(t -> System.out.print(t + " "));
	}

	public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s.length() < p.length()){
            System.out.println("Source is less than pattern");
            return result; 
         }
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> pmap = new HashMap<>();
        
        for(int i = 0; i < p.length(); i++){
            pmap.put(p.charAt(i), pmap.getOrDefault(p.charAt(i), 0)+1);
        }
        
        for(int i = 0; i < p.length(); i++){
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0)+1);
        }
        
        int i = p.length();
        while(i < s.length()){
            if(compare(smap,pmap)){
                result.add(i-p.length());
            }
            
            Character cha = s.charAt(i);
            smap.put(cha, smap.getOrDefault(cha, 0) + 1);
            
            Character chr = s.charAt(i-p.length());
            if(smap.getOrDefault(chr, 0) == 1){
                smap.remove(chr);
            }else{
                smap.put(chr, smap.get(chr) - 1); 
            }
            i++;
        }
        
        if(i == s.length() && compare(smap,pmap)){
            result.add(i-p.length());
        }
        
        return result;
    }
    
    private static boolean compare(Map<Character, Integer> smap, Map<Character, Integer> pmap){
        for(Character ch : smap.keySet()){
            if(pmap.getOrDefault(ch,0).compareTo(smap.get(ch)) != 0){
                return false;
            }
        }
        return true;
    }
}
