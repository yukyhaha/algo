package main.java.geeksforgeeks;

public class dijkstras {
	public int[] distance;
	
	public dijkstras(){}
	
	public void doDijkstras(int[][] graph){
		int len = graph.length;		
		distance = new int[len];
		boolean[] visited = new boolean[len];
		
		for(int i = 1; i < len; i ++){
			distance[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < len; i ++){
			int minDistance = Integer.MAX_VALUE;
			int minIndex = 0;
			for(int j = 0; j < len; j ++){
				if(minDistance > distance[j] && !visited[j]){
					minDistance = distance[j];
					minIndex = j;
				}
			}
			
			visited[minIndex] = true;
			
			for(int j = 0; j < len; j ++){
				if(!visited[j] && graph[minIndex][j] != 0 && distance[j] > graph[minIndex][j] + distance[minIndex]){
					distance[j] = graph[minIndex][j] + distance[minIndex];
				}
			}
		}
		
		for(int i = 0; i < len; i ++)
			System.out.println(i + " " + distance[i]);
		
	}
	
	public static void main(String args[]){
		int[][] graph = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 0, 10, 0, 2, 0, 0},
                {0, 0, 0, 14, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
               };
		dijkstras d = new dijkstras();
		d.doDijkstras(graph);
	}
	
}
