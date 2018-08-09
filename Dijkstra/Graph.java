import java.util.LinkedList;

public class Graph {
    private int V; // number of vertices
    private LinkedList<Edge> adj[]; //adj[i] -> all edges connecting to vertex i

    public Graph(int v) {
        this.V = v;
        adj = new LinkedList[V+1];
        for(int i = 0; i < V+1; i++)
            adj[i] = new LinkedList<>();
    }

    public int V() {
        return V;
    }


    public void addEdge(Edge e) {
        int v = e.from();
        int w = e.to();
        adj[v].add(e);
    }

    // returns the edges of the specified vertex
    public Iterable<Edge> adj(int v) {
        return adj[v];
    }
}
