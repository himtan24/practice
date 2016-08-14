
import java.util.*;

class Dijkstra{
	int[][] graph;
	boolean[] sptSet;
	int[] dist;
	Dijkstra(int n){
		graph = new int[n][n];
		sptSet = new boolean[n];
		dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
	}

	public void dijkstra(int[][] graph, int start){
		int n = graph.length;
		dist[start] = 0;
		for(int k = 0; k < n -1; k++){
			int u = findMin();
			// if(u != -1){
				sptSet[u] = true;
				for(int i = 0 ; i < n; i++){
					if( !sptSet[i] && graph[u][i] != 0 && dist[u] + graph[u][i] < dist[i]){
						dist[i] = dist[u] + graph[u][i];
					}
				}
			// }
		}
		for(int i = 0; i < n; i++){
			System.out.println(i + "\t" + dist[i]);
		}
	}

	public int findMin(){
		int n = graph.length - 1;
		int min = Integer.MAX_VALUE;
		int index = -1;
		for(int i = 0; i < n; i++){
			if(!sptSet[i] && dist[i] <= min){
				min = dist[i];
				index = i;
			}
		}
		if(min != Integer.MAX_VALUE){
			return index;
		}
		return -1;
	}
	public static void main(String[] args) {
       int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                                  {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                  {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                  {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                  {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                  {0, 0, 4, 0, 10, 0, 2, 0, 0},
                                  {0, 0, 0, 14, 0, 2, 0, 1, 6},
                                  {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                  {0, 0, 2, 0, 0, 0, 6, 7, 0}
                                 };
        Dijkstra t = new Dijkstra(9);
        t.dijkstra(graph, 0);
	}
}