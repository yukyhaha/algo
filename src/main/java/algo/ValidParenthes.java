package main.java.algo;

import java.util.Stack;

public class ValidParenthes {

	public ValidParenthes() {
		// TODO Auto-generated constructor stub
	}
	
	public int longestValid(String s){
		int len = s.length();
		boolean dp[][] = new boolean[len][len];
		int longest = Integer.MIN_VALUE;
		
		for(int i = 0; i < len - 1; i ++){
			if(s.charAt(i) == '(' && s.charAt(i + 1) == ')'){
				dp[i][i + 1] = true;
				longest = 2;	
			}
		}
		
		
		for(int i = 4; i <= len; i+=2){
			for(int j = 0; j <= len - i; j ++){
				int end = j + i - 1;
			    dp[j][end] = (dp[j + 2][end] && s.charAt(j)=='(' && s.charAt(j + 1) == ')')
			     || (dp[j][end - 2] && s.charAt(end)=='(' && s.charAt(end - 1) == ')') 
			     || (dp[j + 1][end - 1] && s.charAt(j)=='(' && s.charAt(end) == ')');
		
				if(dp[j][end]){
					if(end - j + 1 > longest){
						longest = end - j + 1; 
					}
				}			
			}			
		}
		
		return longest;
			
		
	}
	
	public int longestValid2(String s){
		Stack<Integer> stack = new Stack<Integer>();
		int maxLen = 0;
		stack.push(-1);
		for(int i = 0; i < s.length(); i ++){
			if(s.charAt(i) == '('){
				stack.push(i);
			}else{
				if(stack.peek() != -1 && s.charAt(stack.peek()) == '('){
					stack.pop();
					maxLen = Math.max(maxLen, i - stack.peek());
				}else{
					stack.push(i);
				}
			}
		} 
		
		return maxLen;
	
	}
	
	public static void main(String[] args){
		ValidParenthes test = new ValidParenthes();
		System.out.println(test.longestValid2("((()"));
	}

}
