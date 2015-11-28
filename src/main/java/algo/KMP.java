package main.java.algo;

public class KMP {

	public KMP() {
		// TODO Auto-generated constructor stub
	}
	
	public int[] preProcess(String pattern){
		int patterLen = pattern.length();
		int[] pat = new int[patterLen];
		int i = 1;
		int len = 0;
		while(i < patterLen){
			if(pattern.charAt(i) == pattern.charAt(pat[len])){
				len ++;
				pat[i] = len;
				i ++;
				
			}else{
				if(len != 0){
					len = pat[len - 1];
				}else{
					pat[i] = 0;
					i ++;
				}
			}
			
		}
		
		return pat;
		
	}
	
	public void patternMatch(String text, String pattern){
		
		int[] pat = preProcess(pattern);
		int i = 0;
		int j = 0;
		int textLen = text.length();
		int patternLen = pattern.length();
		while(i < textLen){
			if(text.charAt(i) == pattern.charAt(j)){
				if(j == patternLen - 1){
					System.out.println("matched at index " + (i - j));
				}
				
				i ++;
				j ++;
			}else{
				if(j >= 1){
					j = pat[j - 1];
				}else{
					i ++;
				}

			}
		}
		
	}

	
	public static void main(String args[]){
		KMP test = new KMP();
		test.patternMatch("ABABDABACDABABCABAB", "ABABCABAB");
		
	}
}
