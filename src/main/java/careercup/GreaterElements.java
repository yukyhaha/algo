package main.java.careercup;

/*
 * http://www.careercup.com/question?id=5631660689195008
 * Given an array of elements, return an array of values pertaining 
 * to how many elements are greater than that element remaining in the array. 

Brute force is obvious, but must be done faster than O(n^2) 

Ex. [3,4,5,9,2,1, 3] 
Return [3, 2, 1, 0, 1, 1, 0] 
First element is 3 because 3<4,5,9. Second element is 2 because 4< 5,9 etc
 * 
 * */

public class GreaterElements {
	
	public GreaterElements(){}
	
	public int[] getGreaterElements(int[] nums){
		int len = nums.length;
		int[] index = new int[len];
		for(int i = 0; i < len; i ++){
			index[i] = i;
		}
		
		int[] value = new int[len];
		int[] copy = new int[len];
		int[] copyIndex = new int[len];
		getGreaterElementsHelper(0, len - 1, nums, copy, index, value, copyIndex);
		for(int i = 0; i < len; i ++)
			System.out.println(index[i]);
		return value;		
	}
	
	public void getGreaterElementsHelper(int left, int right, int[] nums, int[] copy, int[] index, int[] value, int[] copyIndex){
		if(left == right){
			return;
		}
			
		int mid = (left + right)/2;
		getGreaterElementsHelper(left, mid, nums, copy, index, value, copyIndex);
		getGreaterElementsHelper(mid + 1, right, nums, copy, index, value, copyIndex);
				
		int l = left, r = mid + 1, i = left;		
		while(l <= mid || r <= right){
			if(l <= mid && r <= right){
				if(nums[l] < nums[r]){
					copy[i] = nums[l];
					copyIndex[i] = index[l];
					value[copyIndex[i]] += right - r + 1;
					l ++;
					i ++;
				}else{
					copy[i] = nums[r];
					copyIndex[i] = index[r];
					r ++; 
					i ++;
				}
			}else if(l <= mid){
				copy[i] = nums[l];
				copyIndex[i] = index[l];
				l ++;
				i ++;
			}else{
				copy[i] = nums[r];
				copyIndex[i] = index[r];
				r ++;
				i ++;
			}			
		}
		
		for(int j = left; j <= right; j ++ ){
			nums[j] = copy[j];
			index[j] = copyIndex[j];
		}
				
		
	}
	
	public static void main(String args[]){
		GreaterElements test = new GreaterElements();
		int[] orgNums ={16, 17, 9, 0, 19, 24, 3, 8};
		int[] nums = {16, 17, 9, 0, 19, 24, 3, 8};
		int[] values = test.getGreaterElements(nums);
		for(int i = 0; i < values.length; i ++){			
			System.out.println(orgNums[i] + " : " + values[i]);
		}
		
	}

}
