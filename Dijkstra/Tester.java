public class Tester {
    public static void main(String[] args) {
        Graph g = new Graph(8);


        g.addEdge(new Edge(1,2,9));
        g.addEdge(new Edge(1, 6, 14));
        g.addEdge(new Edge(1, 7, 15));

        g.addEdge(new Edge(2, 3, 24));

        g.addEdge(new Edge(6, 3, 18));
        g.addEdge(new Edge(6, 5, 30));
        g.addEdge(new Edge(6, 7, 5));

        g.addEdge(new Edge(3, 8, 19));
        g.addEdge(new Edge(3, 5, 2));

        g.addEdge(new Edge(5, 4, 11));
        g.addEdge(new Edge(5, 8, 16));

        g.addEdge(new Edge(4, 3, 6));
        g.addEdge(new Edge(4, 8, 6));

        g.addEdge(new Edge(7, 5, 20));
        g.addEdge(new Edge(7, 8, 44));

        PathFinder pf = new PathFinder(g, 1);

        for(int i = 0; i < g.V()+1; i++) {
            if(pf.pathExists(i)) {
                System.out.print("Path to " + i + ": ");
                for(Edge e: pf.pathTo(i)) {
                    System.out.print(e + " ");
                }

                System.out.print("Total: " + pf.distTo(i));
                System.out.println();
            }
        }
    }
}
