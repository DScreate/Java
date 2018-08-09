import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Tester {

    public static void main(String[] args) {
        Graph graph = new Graph(8);

        graph.addEdge(new Edge(0,1,4));
        graph.addEdge(new Edge(0,2,6));
        graph.addEdge(new Edge(0,3,16));
        graph.addEdge(new Edge(1,7,24));
        graph.addEdge(new Edge(2,7,23));
        graph.addEdge(new Edge(2,5,5));
        graph.addEdge(new Edge(2,3,8));
        graph.addEdge(new Edge(3,5,10));
        graph.addEdge(new Edge(3,4,21));
        graph.addEdge(new Edge(5,7,18));
        graph.addEdge(new Edge(5,6,11));
        graph.addEdge(new Edge(5,4,14));
        graph.addEdge(new Edge(7,6,9));
        graph.addEdge(new Edge(6,4,7));

        Set<Edge> set = kruskal(graph);
        System.out.println("The MST contains the following edge(s):");
        for(Edge e : set) {
            System.out.println(e.v + "->" + e.w);
        }


    }

    private static Set<Edge> kruskal(Graph G) {
        Set<Edge> mst = new HashSet<Edge>();
        {
            PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
            for(Edge e : G.edges()) {
                pq.add(e);
            }

            UnionFind uf = new UnionFind(G.V());
            while(!pq.isEmpty()) {
                Edge e = pq.poll();
                int v = e.getV();
                int w = e.other(v);
                if (!uf.connected(v, w) )
                {
                    uf.union(e.getV(), e.other(v));
                    mst.add(e);
                }
        }
        return mst;
        }
    }
}
