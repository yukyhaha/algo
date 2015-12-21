package main.java.algo;

public class SimpleCalculator {

	public SimpleCalculator() {
		// TODO Auto-generated constructor stub
	}
	
	public float calculator(String s){
		int len = s.length();
		float val = 0;
		float result = 0;
		char lastOperator = '0';
		int lastPosition = 0;
		float cache = 0;
		for(int i = 0; i < len; i ++){
			if(i == len - 1 || s.charAt(i) == '+' || s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '-'){
				if(i == len - 1)
					val = Integer.parseInt(s.substring(lastPosition, i + 1));
				else
					val = Integer.parseInt(s.substring(lastPosition, i));
				if(lastOperator == '0'){
					result = val; 
				}
				if(lastOperator == '+'){
					result = result + val;
					cache = val;
				}
				if(lastOperator == '-'){
					result = result - val;
					cache = -val;
				}
				if(lastOperator == '*'){
					result = (result - cache) + cache * val;
					cache = cache * val;
				}
				if(lastOperator == '/'){
					result = (result - cache) + cache / val;
					cache = cache / val;
				}
				lastOperator = s.charAt(i);	
				lastPosition = i + 1;
			}
		}
		
		return result;
	}
	
	public static void main(String args[]){
		SimpleCalculator t = new SimpleCalculator();
		System.out.println(t.calculator("1*2"));
	}

}
