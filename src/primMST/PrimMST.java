package primMST;

public class PrimMST {
	private double weight;
	private Queue<Edge> mst = new Queue<Edge>(); 
	public PrimMST(EdgeWeightedGraph G) {
        boolean[] marked = new boolean[G.V()];
        MinPQ<Edge> pq = new MinPQ<Edge>();
        visit(G, 0, marked, pq);
        while (!pq.isEmpty()) {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w]) continue;
            mst.enqueue(e);
            weight += e.weight();
            if (!marked[v]) visit(G, v, marked, pq);
            if (!marked[w]) visit(G, w, marked, pq);
        }
	}
	private void visit(EdgeWeightedGraph G, int v, boolean[] marked, MinPQ<Edge> pq) {
        marked[v] = true; 
        for (Edge e : G.adj(v)) {
            if (!marked[e.other(v)]) {
                pq.insert(e); 
            }
        }
    }
	public Iterable<Edge> edges() {
        return mst;
    }
    public double weight() {
        return weight;
    }
    public static void main(String[] args) {
    	String nameFile = "\\Users\\User\\Desktop\\Javapro\\PhanTichThietKeThuatToan\\src\\primMST\\test.txt";
    	EdgeWeightedGraph g = new EdgeWeightedGraph(nameFile);
    	PrimMST p = new PrimMST(g);
    	for(Edge e : g.edges()) {
    		System.out.println(e.toString());
    	}
    	System.out.println();
    	for(Edge e : p.mst) {
    		System.out.println(e.toString());
    	}
    	System.out.println(p.weight);
	}
}
