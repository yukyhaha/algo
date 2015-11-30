package main.java.algo;

public class HeapSort {

	public HeapSort() {
		// TODO Auto-generated constructor stub
	}
	
	public void swap(int[] arr, int i1, int i2){
		int tmp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = tmp;
	}
	
	public void heapify(int[] arr, int size, int i){
		int l = i * 2 + 1;
		int r = i * 2 + 2;
		int largestIndex = i;
		if(l < size && arr[l] > arr[largestIndex]){
			largestIndex = l;
		}
		
		if(r < size && arr[r] > arr[largestIndex]){
			largestIndex = r;
		}
		if(largestIndex != i){
			swap(arr, largestIndex, i);
			heapify(arr, size, largestIndex);
		}
	}
	
	public void createHeap(int[] arr){
		int len = arr.length;
		for(int i = (len - 2) / 2; i >=0; i --){
			heapify(arr, len, i);
		}		
	}
	
	public void sort(int[] arr){
		int len = arr.length;
		createHeap(arr);
		
		for(int i = len - 1; i > 0; i --){
			swap(arr, i, 0);
			heapify(arr, i, 0);			
		}
		
		for(int i = 0; i < len; i ++){
			System.out.println(arr[i]);
		}
	}
	
	public void kthLargest(int[] arr, int k){
		int len = arr.length;
		createHeap(arr);
		for(int i = len - 1; i >= len - k; i --){
			swap(arr, i, 0);
			heapify(arr, i, 0);
		}
		System.out.println(arr[len - k]);
	}
	
	public static void main(String args[]){
		HeapSort t = new HeapSort();
		int arr[] = {7, 3, 2, 5, 2};
		t.sort(arr);
		t.kthLargest(arr, 4);
	}
	

}
