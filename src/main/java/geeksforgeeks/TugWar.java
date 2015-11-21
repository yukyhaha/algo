package main.java.geeksforgeeks;

public class TugWar {

	public TugWar() {
		
		// TODO Auto-generated constructor stub
	}
	
	public int minDiff = Integer.MAX_VALUE;
	
	public void doTugofWar(int[] nums){
		int len = nums.length;
		int totalSum = 0;
		for(int i = 0; i < len; i ++){
			totalSum += nums[i];
		}
		int[] finalMark = new int[len];
		int[] mark = new int[len];
		doTugofWarHelper(0, nums, len/2, mark, finalMark, 0, totalSum);
		int sum = 0;
		for(int i = 0; i < len; i ++){
			if(finalMark[i]==0){
				System.out.print(nums[i] + " , ");
				sum += nums[i];
			}
		}
		
		System.out.println("-----" + sum);
		
		sum = 0;
		
		for(int i = 0; i < len; i ++){
			if(finalMark[i]==1){
				System.out.print(nums[i] + " , ");
				sum += nums[i];
			}
		}
		
		System.out.println("-----" + sum);
		
	}
	
	public void doTugofWarHelper(int start, int[] nums, int k, int[] mark, int[] finalMark, int sum, int totalSum){
		
		if(k == 0){
			if(minDiff > Math.abs(totalSum - sum - sum)){
				minDiff = Math.abs(totalSum - sum - sum);
				for(int i = 0; i < nums.length; i ++){
					finalMark[i] = mark[i];
				}
			}
			return;
		}
		
		for(int i = start; i < nums.length; i ++){
			
			mark[i] = 1;
			sum += nums[i];
			doTugofWarHelper(i + 1, nums, k - 1, mark, finalMark, sum, totalSum);
			sum -= nums[i];
			mark[i] = 0;
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TugWar test = new TugWar();
		int[] nums = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
		test.doTugofWar(nums);
	}

}
