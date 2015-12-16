package main.java.algo;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

	public StringPermutation() {
		// TODO Auto-generated constructor stub
	}
	
	public List<String> getStringPermutation(String s){
		List<String> results = new ArrayList<String>();
		helper("", s, results);
		return results;
	}
	
	public void helper(String sub, String s, List<String> results){
		if(s.length() == 0){
			results.add(sub);
			System.out.println(sub);
			return;
		}
		for(int i = 0; i < s.length(); i ++){
			helper(sub + s.charAt(i), s.substring(0, i) + s.substring(i + 1), results);			
		}
	}
	

	public static void main(String args[]){
		StringPermutation t = new StringPermutation();
		t.getStringPermutation("abc");
	}
}
