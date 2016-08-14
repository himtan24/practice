import java.util.*;

class DFSGraph{
	ArrayList<ArrayList<Integer>> graph;
	public DFSGraph(int n){
		graph = new ArrayList<ArrayList<Integer>>();

		for(int i = 0; i < n; i++){
			graph.add(new ArrayList<Integer>());
		}
	}
	public void addEdge(int u, int v){
		graph.get(u).add(v);
	}
	public void dfs(int s){
		boolean[] visited = new boolean[graph.size()];
		Stack<Integer> st = new Stack<Integer>();
		st.push(s);
		while(!st.isEmpty()){
			int num = st.pop();
			if(!visited[num]){
				visited[num] = true;
				System.out.println(num);
			}
			for(int i = 0; i < graph.get(num).size(); i++){
				if(!visited[graph.get(num).get(i)])
					st.push(graph.get(num).get(i));
			}
		}
	}
	public static void main(String[] args) {
		DFSGraph g = new DFSGraph(10);

		g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(4,5);
        g.addEdge(4,6);
        g.addEdge(6,8);
        g.addEdge(8,9);
        g.addEdge(2,7);
        g.addEdge(7,9);

        g.dfs(0);
	}
}