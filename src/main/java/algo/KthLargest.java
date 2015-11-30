package main.java.algo;

public class KthLargest {

	public KthLargest() {
		// TODO Auto-generated constructor stub
	}

	public void getKthLargest(int[] arr, int k){
		int len = arr.length;
		quickSort(arr, 0, len - 1, k);
		System.out.println(arr[k - 1]);
	}
	
	public void swap(int[] arr, int i1, int i2){
		int tmp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = tmp;
	}
	
	public int partition(int[] arr, int l, int r){
		int p = arr[r];
		int k = l - 1;
		for(int i = l; i < r; i ++){
			if(arr[i] >= p){
				k ++;
				swap(arr, k, i);
			}			
		}
		swap(arr, k + 1, r);
		return k + 1;
	}
	
	public void quickSort(int[] arr, int l, int r, int k){
			if(l >= r)
				return;
		
			int pivot = partition(arr, l, r);			
			if(pivot == k - 1)
				return;
			else if(pivot > k -1){
				quickSort(arr, l, pivot - 1, k);
			}else{
				quickSort(arr, pivot + 1, r, k);
			}
					
	} 
	
	public static void main(String args[]){
		KthLargest t = new KthLargest();
		int[] arr = {6, 4, 3, 2, 8};
	    t.getKthLargest(arr, 3);
		
	}
	
}
