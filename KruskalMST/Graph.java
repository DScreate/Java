import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int V;
    private LinkedList<Edge> adj[];
    private LinkedList<Edge> edges;
    public boolean[] Mark;

    public Graph(int V)
    {
        this.V = V;
        adj = new LinkedList[V];
        for(int i = 0; i < V; i++)
            adj[i] = new LinkedList<Edge>();
        Mark = new boolean[V];
    }

    public void addEdge(Edge e){
        int v = e.v,  w = e.w;
        adj[v].add(e);
        adj[w].add(new Edge(w,v,e.weight()));
    }


    public Iterable<Edge> edges() {
        List<Edge> list = new ArrayList<Edge>();
        for (int v = 0; v < V; v++) {
            int selfLoops = 0;
            for (Edge e : adj[v]) {
                if (e.other(v) > v) {
                    list.add(e);
                }
                else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) list.add(e);
                    selfLoops++;
                }
            }
        }
        return list;
    }


    public void setMark(int v, boolean visited) {
        Mark[v] = visited;
    }

    public boolean getMark(int v) {
        return Mark[v];
    }
    public boolean isEdge(Edge w) {
        if (w == null || w.v >= adj.length) return false;

        LinkedList list = adj[w.v];
        return list.contains(w);
    }

    public Edge first(int v) {
        return adj[v].element();
    }

    public Edge next(Edge w) {
        if (w == null) return null;

        int v = w.v;
        LinkedList list = adj[v];
        int i = list.indexOf(w);
        if(i != -1) {
            if(list.size() <= i+1) return null;

            return (Edge)list.get(i+1);
        }
        return null;
    }

    public int v2(Edge w) {
        return w.w;
    }

    public int V() {
        return V;
    }
}
