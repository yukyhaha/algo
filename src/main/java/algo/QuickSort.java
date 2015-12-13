package main.java.algo;

public class QuickSort {

	public QuickSort() {
		// TODO Auto-generated constructor stub
	}
	
	public void printSortedArray(int[] arr){
		int len = arr.length;
		quickSort(arr, 0, len - 1);
		
		for(int i = 0; i < len; i ++)
			System.out.println(arr[i]);
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
			if(arr[i] < p){
				k ++;
				swap(arr, k, i);
			}			
		}
		swap(arr, k + 1, r);
		return k + 1;
	}
	
	public void quickSort(int[] arr, int l, int r){
			if(l >= r)
				return;
		
			int pivot = partition(arr, l, r);			
			quickSort(arr, l, pivot - 1);
			quickSort(arr, pivot + 1, r);		
	} 
	
	public static void main(String args[]){
		QuickSort t = new QuickSort();
		int[] arr = {6, 4, 3, 2, 8};
	    t.printSortedArray(arr);
		
	}
	

}
