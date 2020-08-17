import java.util.*;
public class Graph { 
	private int v; 
	private ArrayList<Integer>[] adjList;
	public Graph(int vertices){ 
		this.v = vertices; 
		initAdjList(); 
	} 
	@SuppressWarnings("unchecked") 
	private void initAdjList() 
	{ 
		adjList = new ArrayList[v]; 
		
		for(int i = 0; i < v; i++) 
		{ 
			adjList[i] = new ArrayList<>(); 
		} 
	} 
	public void addEdge(int u, int v) 
	{ 
		adjList[u].add(v); 
	} 
	public List<Integer> printAllPaths(int s, int d) 
	{ 
		boolean[] isVisited = new boolean[v]; 
		ArrayList<Integer> pathList = new ArrayList<>(); 
		pathList.add(s); 
		return printAllPathsUtil(s, d, isVisited, pathList); 
	} 
	private List<Integer> printAllPathsUtil(Integer u, Integer d, 
									boolean[] isVisited, 
							List<Integer> localPathList) { 
		isVisited[u] = true; 
		if (u.equals(d)) 
		{ 
			isVisited[u]= false; 
			return localPathList; 
		} 
		for (Integer i : adjList[u]) 
		{ 
			if (!isVisited[i]) 
			{ 
				localPathList.add(i); 
				printAllPathsUtil(i, d, isVisited, localPathList);
				localPathList.remove(i); 
			} 
		}
        isVisited[u] = false; 
        return null;
	} 
	public static void main(String[] args) 
	{ 
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of vertices in the graph");
        int n=sc.nextInt();
		Graph g = new Graph(n); 
        int i=0;
        while(i<n-1){
            g.addEdge(sc.nextInt()-1,sc.nextInt()-1);
            i++;
        }
        int u=sc.nextInt();
        int v=sc.nextInt();
        System.out.println("paths between "+u+" and "+v);
        System.out.println( g.printAllPaths(u, v));
        sc.close();
	} 
} 
