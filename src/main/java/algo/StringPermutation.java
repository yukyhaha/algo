package main.java.algo;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

	public StringPermutation() {
		// TODO Auto-generated constructor stub
	}
	
	public List<String> getStringPermutation(String s){
		List<String> results = new ArrayList<String>();
		results.add(s.substring(0, 1));
		helper(s, results);
	}
	

	public static void main(String args[]){
		
	}
}
