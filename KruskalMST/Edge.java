import java.util.Comparator;

public class Edge implements Comparable<Edge> {
    public int v,  w;
    private final double weight;
    public Edge(int v, int w, double weight)
    {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }


    public double weight()
    {  return weight; }

    public final static Comparator<Edge> BY_WEIGHT = new ByWeightComparator();
    private static class ByWeightComparator implements Comparator<Edge>
    {
        public int compare(Edge e, Edge f)
        {
            if (e.weight < f.weight) return -1;
            if (e.weight > f.weight) return +1;
            return 0;
        }
    }

    public int compareTo(Edge that)
    {
        if      (this.weight < that.weight) return -1;
        else if (this.weight > that.weight) return +1;
        else				      			return  0;
    }

    public int getV() {
        return v;
    }

    public int other(int vert) {
        if(this.v == vert)
            return w;
        else
            return this.v;
    }
}
