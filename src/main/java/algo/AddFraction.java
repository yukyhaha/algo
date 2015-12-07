package main.java.algo;

public class AddFraction {

	public AddFraction() {
		// TODO Auto-generated constructor stub
	}

	public String addFraction(String f1, String f2){
		int num = 0;
		int up1 = 0; 
		int down1 = 0;
		int up2 = 0;
		int down2 = 0;
		for(int i = 0; i < f1.length(); i ++){
			if(f1.charAt(i) != '/'){
				num = num * 10 + f1.charAt(i) - '0';
			}else{
				up1 = num;
				num = 0;				
			}
			
			if(i == f1.length() - 1){
				down1 = num;
			}
		}
						
		num = 0;
		
		for(int i = 0; i < f2.length(); i ++){
			if(f2.charAt(i) != '/'){
				num = num * 10 + f2.charAt(i) - '0';
			}else{
				up2 = num;
				num = 0;				
			}
			
			if(i == f2.length() - 1){
				down2 = num;
			}
		}
		
		
		if(up1 == 0 && up2 == 0){
			return "0";
		}else if(up1 == 0){
			return f2;
		}else if(up2 == 0){
			return f1;
		}
		
		int minDown = 0;
		int maxDown = 0;
		int gcd = 0;
		if(down1 < down2){
			minDown = down1;
			maxDown = down2;

		}else{
			minDown = down2;
			maxDown = down1;

		}
		
		gcd = getGCD(minDown, maxDown);
		
		int resultDown = maxDown * (minDown / gcd);
		int resultUp = up1 * (resultDown / down1) + up2 * (resultDown / down2);
		
		gcd = getGCD(Math.min(resultDown, resultUp), Math.max(resultDown, resultUp));
		
		resultDown = resultDown / gcd;
		resultUp = resultUp / gcd;
		
		return resultUp + "/" + resultDown;

		
	}
	
	public int getGCD(int n1, int n2){
		while(n1 != 0 && n2 != 0){
			int t = n2;
			n2 = n1 % n2;
			n1 = t;
		}
		
		return n1;
	}
	
	public static void main(String args[]){
		AddFraction t = new AddFraction();
		System.out.println(t.addFraction("0/4", "5/10"));
	}
}
