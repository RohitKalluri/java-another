// C++ implementation 
#include <vector>
using namespace std; 

// An utility function to add an edge in an 
// undirected graph. 
void addEdge(vector<int> v[], 
			int x, 
			int y) 
{ 
	v[x].push_back(y); 
	v[y].push_back(x); 
} 

// A function to print the path between 
// the given pair of nodes. 
void printPath(vector<int> stack) 
{ 
	int i; 
	for (i = 0; i < (int)stack.size() - 1; 
		i++) { 
		cout << stack[i] << " -> "; 
	} 
	cout << stack[i]; 
} 

// An utility function to do 
// DFS of graph recursively 
// from a given vertex x. 
void DFS(vector<int> v[], 
		bool vis[], 
		int x, 
		int y, 
		vector<int> stack) 
{ 
	stack.push_back(x); 
	if (x == y) { 

		// print the path and return on 
		// reaching the destination node 
		printPath(stack); 
		return; 
	} 
	vis[x] = true; 

	// A flag variable to keep track 
	// if backtracking is taking place 
	int flag = 0; 
	if (!v[x].empty()) { 
		for (int j = 0; j < v[x].size(); j++) { 
			// if the node is not visited 
			if (vis[v[x][j]] == false) { 
				DFS(v, vis, v[x][j], y, stack); 
				flag = 1; 
			} 
		} 
	} 
	if (flag == 0) { 

		// If backtracking is taking 
		// place then pop 
		stack.pop_back(); 
	} 
} 

// A utility function to initialise 
// visited for the node and call 
// DFS function for a given vertex x. 
void DFSCall(int x, 
			int y, 
			vector<int> v[], 
			int n, 
			vector<int> stack) 
{ 
	// visited array 
	bool vis[n + 1]; 

	memset(vis, false, sizeof(vis)); 

	// DFS function call 
	DFS(v, vis, x, y, stack); 
} 

// Driver Code 
int main() 
{ 
	int n = 10; 
	vector<int> v[n], stack; 

	// Vertex numbers should be from 1 to 9. 
	addEdge(v, 1, 2); 
	addEdge(v, 1, 3); 
	addEdge(v, 2, 4); 
	addEdge(v, 2, 5); 
	addEdge(v, 2, 6); 
	addEdge(v, 3, 7); 
	addEdge(v, 3, 8); 
	addEdge(v, 3, 9); 

	// Function Call 
	DFSCall(4, 8, v, n, stack); 

	return 0; 
} 
