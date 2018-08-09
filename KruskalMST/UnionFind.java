public class UnionFind {
    private int[] id;
    private int size;

    public UnionFind(int size) {
        this.size = size;
        id = new int[size];
        for(int i = 0; i < size; i++)
            id[i] = i;
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pID = id[p];
        int qID = id[q];

        if(pID == qID)
            return;

        for(int i = 0; i < id.length; i++) {
            if(id[i] == pID)
                id[i] = qID;
        }

        size--;
    }
}
