import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;


//Literally the only reason this is named PathFinder and not Dijkstra is because I was constantly mispelling it
public class PathFinder {
    private double[] distTo;
    private Edge[] edgeTo;
    private PriorityQueue<Elem> pq;

    public PathFinder(Graph g, int source) {
        distTo = new double[g.V()+1];
        edgeTo = new Edge[g.V()+1];

        for(int v = 0; v < g.V()+1; v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[source] = 0.0;


        pq = new PriorityQueue<Elem>(100, Elem.BY_DIST);
        pq.add(new Elem(source, distTo[source]));
        while(!pq.isEmpty()) {
            Elem u = pq.remove();
            int v = u.getVert();
            for(Edge e: g.adj(v)) {
                int from = e.from();
                int to = e.to();
                if(distTo[to] > distTo[from] + e.weight()) {

                    distTo[to] = distTo[from] + e.weight();
                    edgeTo[to] = e;
                    pq.remove(new Elem(to, distTo[from]));
                    pq.add(new Elem(to, distTo[to]));
                }
            }

        }
    }

    public boolean pathExists(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public Iterable<Edge> pathTo(int v) {
        if(!pathExists(v)) return null;

        Stack<Edge> path = new Stack<Edge>();
        for(Edge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }
}

// Thank you Tony for providing us with this sample code!
class Elem {
    private double weight;
    private int vert;

    public Elem(int vert,double weight) {
        this.weight = weight;
        this.vert = vert;
    }

    public int getVert() {
        return this.vert;
    }

    @Override
    public String toString() {
        String ret = "(";
        ret = ret + this.weight + "," + this.vert + ")";
        return ret;
    }

    @Override
    public boolean equals(Object other) {
        if(other == null) return false;
        if ( ! (other instanceof Elem) ) {
            return false;
        }
        Elem b = (Elem) other;

        if(b.weight == this.weight && b.vert == this.vert)
            return true;
        else
            return false;
    }//end of equals

    public final static Comparator<Elem> BY_DIST = new ElemComparator();
    private static class ElemComparator implements Comparator<Elem> {
        @Override
        public int compare(Elem e, Elem f) {
            if (e.weight < f.weight) return -1;
            if (e.weight > f.weight) return +1;

            return 0;
        }// end of compare
    }//end of Comparator

}//end of Elem
