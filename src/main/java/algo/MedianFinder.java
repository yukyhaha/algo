package main.java.algo;

import java.util.ArrayList;

public class MedianFinder {
    
    public ArrayList<Integer> maxHeap = new ArrayList<Integer>();
    public ArrayList<Integer> minHeap = new ArrayList<Integer>();
 
    
    public void swap(ArrayList<Integer> heap, int i, int j){
    	int tmp = heap.get(i);
    	heap.set(i, heap.get(j));
    	heap.set(j, tmp);
    }
    
    public void insertToMaxHeap(int num){
    	int size = maxHeap.size();
    	if(size == 0){
    		maxHeap.add(num);
    	}else{
    		maxHeap.add(num);
    		int parentIndex = (size - 1) / 2;
    		int i = size;
    		while(parentIndex >= 0){
    			if(maxHeap.get(parentIndex) < maxHeap.get(i)){
    				swap(maxHeap, parentIndex, i);
    				i = parentIndex;
    				parentIndex = (i - 1)/2;
    			}else{
    				break;
    			}
    		}
    	}
    }
    
    public void insertToMinHeap(int num){
    	int size = minHeap.size();
    	if(size == 0){
    		minHeap.add(num);
    	}else{
    		minHeap.add(num);
    		int parentIndex = (size - 1) / 2;
    		int i = size;
    		while(parentIndex >= 0){
    			if(minHeap.get(parentIndex) > minHeap.get(i)){
    				swap(minHeap, parentIndex, i);
    				i = parentIndex;
    				parentIndex = (i - 1)/2;
    			}else{
    				break;
    			}
    		}
    	}
    }
    
    public void heapifyMax(int i, int size){
    	int largestIndex = i;
    	int left = 2 * i + 1;
    	int right = 2 * i + 2;
    	if(left < size && maxHeap.get(largestIndex) < maxHeap.get(left)){
    		largestIndex = left;
    	}
    	
    	if(right < size && maxHeap.get(largestIndex) < maxHeap.get(right)){
    		largestIndex = right;
    	}
    	
    	if(largestIndex != i){
    		swap(maxHeap, i, largestIndex);
    		heapifyMax(largestIndex, size);
    	}
    }
    
    public void heapifyMin(int i, int size){
    	int smallestIndex = i;
    	int left = 2 * i + 1;
    	int right = 2 * i + 2;
    	if(left < size && minHeap.get(smallestIndex) > minHeap.get(left)){
    		smallestIndex = left;
    	}
    	
    	if(right < size && minHeap.get(smallestIndex) > minHeap.get(right)){
    		smallestIndex = right;
    	}
    	
    	if(smallestIndex != i){
    		swap(minHeap, i, smallestIndex);
    		heapifyMin(smallestIndex, size);
    	}
    }
    
    public void extractMaxHeap(){
    	int size = maxHeap.size();
    	int lastNum = maxHeap.remove(size - 1);
    	if(maxHeap.isEmpty())
    		return;
    	maxHeap.set(0, lastNum);
    	heapifyMax(0, size - 1);
    }
    
    public void extractMinHeap(){
    	int size = minHeap.size();
    	int lastNum = minHeap.remove(size - 1);
    	if(minHeap.isEmpty())
    		return;
    	minHeap.set(0, lastNum);
    	heapifyMin(0, size - 1);
    }
    
    // Adds a number into the data structure.
    public void addNum(int num) {   	
    	int maxSize = maxHeap.size();
    	int minSize = minHeap.size();
    	if(maxSize == 0 && minSize == 0){
    		maxHeap.add(num);
    		return;
    	}
    	
    	
    	if(maxSize == minSize){
    		if(num < maxHeap.get(0)){
    			insertToMaxHeap(num);
    		}else if(num > minHeap.get(0)){
    			insertToMinHeap(num);
    		}else{
    			insertToMaxHeap(num);
    		}
    		
    	}else if(maxSize > minSize){
    		if(num < maxHeap.get(0)){
    			insertToMinHeap(maxHeap.get(0));
    			extractMaxHeap();
    			insertToMaxHeap(num);
    		}else {
    			insertToMinHeap(num);
    		}
    	}else{
    		if(num > minHeap.get(0)){
    			insertToMaxHeap(minHeap.get(0));
    			extractMinHeap();
    			insertToMinHeap(num);
    		}else{
    			insertToMinHeap(num);
    		}
    	}
        
    }

    // Returns the median of current data stream
    public double findMedian() {
    	int maxSize = maxHeap.size();
    	int minSize = minHeap.size();
    	
    	if(maxSize == 0 && minSize == 0){
    		return -1;
    	}
    	if(maxSize == 0 && minSize != 0){
    		return minHeap.get(0);
    	}
    	if(minSize == 0 && maxSize != 0){
    		return maxHeap.get(0);
    	}
    	
    	int maxNum = maxHeap.get(0);
    	int minNum = minHeap.get(0);
    	
    	if(maxSize == minSize){
    		return (float) (maxNum + minNum)/2;
    	}else if(maxSize > minSize){
    		return maxNum;
    	}else{
    		return minNum;
    	}
    		
        
   }
    
   public static void main(String args[]){
	   MedianFinder t = new MedianFinder();
	  	   
	   t.addNum(-1);
	   System.out.println(t.findMedian());
	   t.addNum(-2);
	   System.out.println(t.findMedian());
	   t.addNum(-3);
	   System.out.println(t.findMedian());
	   t.addNum(-4);
	   System.out.println(t.findMedian());
	   t.addNum(-5);
	   System.out.println(t.findMedian());
/*	   t.addNum(15);
	   System.out.println(t.findMedian());
	   t.addNum(1);
	   System.out.println(t.findMedian());
	   t.addNum(11);
	   System.out.println(t.findMedian());
	   t.addNum(6);
	   System.out.println(t.findMedian());
	   t.addNum(17);
	   System.out.println(t.findMedian());
	   t.addNum(14);
	   System.out.println(t.findMedian());
	   t.addNum(8);
	   System.out.println(t.findMedian());
	   t.addNum(17);
	   System.out.println(t.findMedian());
	   t.addNum(6);
	   System.out.println(t.findMedian());
	   t.addNum(4);
	   System.out.println(t.findMedian());
	   t.addNum(16);
	   System.out.println(t.findMedian());
	   t.addNum(8);
	   System.out.println(t.findMedian());
	   t.addNum(10);
	   System.out.println(t.findMedian());
	   t.addNum(2);
	   System.out.println(t.findMedian());
	   t.addNum(12);
	   System.out.println(t.findMedian());
	   t.addNum(0);
	   System.out.println(t.findMedian());*/

   }
};