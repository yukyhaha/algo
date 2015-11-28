package main.java.algo;

public class PrimsMST {
	public int[] parent;
	public PrimsMST(){}
	public void doPrimsMST(int graph[][]){
		int len = graph.length;
		boolean[] visited = new boolean[len];
		int[] key = new int[len];
		parent = new int[len];
		parent[0] = -1;
		for(int i = 1; i < len; i ++){
			key[i] = Integer.MAX_VALUE; 
		}
		
		for(int i = 0; i < len; i ++){
			int minKey = Integer.MAX_VALUE;
			int minKeyIndex = 0;
			for(int j = 0; j < len; j ++){
				if(!visited[j]){
					if(key[j] < minKey){						
						minKey = key[j];
						minKeyIndex = j;
					}
				}
			}
			
			visited[minKeyIndex] = true;

			
			for(int j = 0; j < len; j ++){
				if(graph[minKeyIndex][j] != 0 && graph[minKeyIndex][j] < key[j] && !visited[j]){
					key[j] = graph[minKeyIndex][j];
					parent[j] = minKeyIndex;
				}
			}
		}
		
	}
	
	public static void main(String args[]){
		int[][] graph = {{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0},
               };
		
		PrimsMST mst = new PrimsMST();
		mst.doPrimsMST(graph);
		
		for(int i = 1; i < graph.length; i ++){
			System.out.println(mst.parent[i] + " " + i + " " + graph[i][mst.parent[i]]);
		}
		
		
		
	}
}
