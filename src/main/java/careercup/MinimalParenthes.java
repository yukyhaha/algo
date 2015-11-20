package main.java.careercup;

import java.util.Stack;

public class MinimalParenthes {
	public MinimalParenthes(){}
	public int getMinimalParenthes(String s){
		Stack<Character> stack = new Stack<Character>();
		int count = 0;
		for(int i = 0; i < s.length(); i ++){
			char c = s.charAt(i);
			if(c == '('){
				stack.push(c);
			}else{
				if(stack.isEmpty()){
					count ++;
				}else{
					stack.pop();
				}
			}
		}
		
		return count + stack.size();
	}
	
	public static void main(String args[]){
		MinimalParenthes test = new MinimalParenthes();
		System.out.println(test.getMinimalParenthes(")()("));
		
	}
}
