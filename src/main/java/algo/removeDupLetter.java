package main.java.algo;

import java.util.HashMap;

public class removeDupLetter {

	public removeDupLetter() {
		// TODO Auto-generated constructor stub
	}
	
    public String smallestStr = "";
    public String removeDuplicateLetters(String s) {
        if(s.equals("")){
            return "";
        }
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int total = 0;
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(hashMap.containsKey(c)){
                hashMap.put(c, hashMap.get(c) + 1);
                total ++;
            }else{
                hashMap.put(c, 0);
            }
        }
        helper(s, "", hashMap, total, 0);
        return smallestStr;
    }

        
        public void helper(String s, String currStr, HashMap<Character, Integer> hashMap, int total, int index){
            if(total == 0 && index == s.length()){
                   if(smallestStr.equals("")){
                       smallestStr = currStr;
                   }else{
                       if(currStr.compareTo(smallestStr) < 0){
                           smallestStr = currStr;
                       }
                   }
                   return;
            }
            
            if(s.length() == index){
                return;
            }
            
            char c = s.charAt(index);
            if(hashMap.containsKey(c) && hashMap.get(c) > 0){
                hashMap.put(c, hashMap.get(c) - 1);
                helper(s, currStr, hashMap, total - 1, index + 1);
                hashMap.put(c, hashMap.get(c) + 1);
            }
            helper(s, currStr + c, hashMap, total, index + 1);
            
            
        }
	
	
	public static void main(String args[]){
		removeDupLetter t = new removeDupLetter();
		System.out.println(t.removeDuplicateLetters("cbacdcbc"));
		
	}

}
