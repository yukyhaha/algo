package main.java.algo;

import java.util.ArrayList;

/*
 * Print all permutations of a string
 * */

public class PermutationString {

	public PermutationString() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<String> getPermus(String s){
		ArrayList<String> res = new ArrayList<String>();
		res.add(s.charAt(0) + "");		
		for(int i = 1; i < s.length(); i ++){
			char c = s.charAt(i);
			int size = res.size();
			for(int j = size - 1; j >= 0; j --){
				String currStr = res.remove(res.size() - 1);
				int strLen = currStr.length();
				for(int p = 0; p < strLen + 1; p ++){
					StringBuilder stringBuilder = new StringBuilder(currStr);
					res.add(0, stringBuilder.insert(p, c).toString());
				}
			}
		}
		
		for(int i = 0; i < res.size(); i ++){
			System.out.println(res.get(i));
		}
		return res;
	}
	
	public static void main(String args[]){
		PermutationString t = new PermutationString();
		t.getPermus("123");
	}

}
