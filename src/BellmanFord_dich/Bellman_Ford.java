package BellmanFord_dich;

public class Bellman_Ford {
	private double[] distFrom;     
    private DirectedEdge[] edgeFrom;    
    private boolean[] onQueue;      
    private Queue<Integer> queue;    
    private int cost;                      
    private Iterable<DirectedEdge> cycle; 
    public Bellman_Ford(EdgeWeightedDigraph g, int s) {
    	this.distFrom = new double[g.V()];
    	this.edgeFrom = new DirectedEdge[g.V()];
    	this.onQueue = new boolean[g.V()];
    	for(int i = 0; i < g.V(); i++) {
    		this.distFrom[i] = Double.POSITIVE_INFINITY;
    	}
    	this.distFrom[s] = 0;
    	queue = new Queue<Integer>();
    	queue.enqueue(s);
    	onQueue[s] = true;
    	while(!queue.isEmpty() && !hasNegativeCycle()) {
    		int v = queue.dequeue();
    		onQueue[v] = false;
    		relax(g, v);
    	}
    }
    public void relax(EdgeWeightedDigraph g, int v) {
    	for(DirectedEdge e : g.adj(v)) {
    		int w = e.from();
            if (distFrom[w] > distFrom[v] + e.Weight()) {
            	distFrom[w] = distFrom[v] + e.Weight();
                edgeFrom[w] = e;
                if (!onQueue[w]) {
                    queue.enqueue(w);
                    onQueue[w] = true;
                }
            }
            if (cost++ % g.V() == 0) {
                findNegativeCycle();
                if (hasNegativeCycle()) return;
            }
    	}
    }
    public boolean hasNegativeCycle() {
        return cycle != null;
    }
    public Iterable<DirectedEdge> negativeCycle() {
        return cycle;
    }
    private void findNegativeCycle() {
        int V = edgeFrom.length;
        EdgeWeightedDigraph spt = new EdgeWeightedDigraph(V);
        for (int v = 0; v < V; v++)
            if (edgeFrom[v] != null)
                spt.addEdge(edgeFrom[v]);
        EdgeWeightedDirectedCycle finder = new EdgeWeightedDirectedCycle(spt);
        cycle = finder.cycle();
    }
    public double distFrom(int v) {
        validateVertex(v);
        if (hasNegativeCycle())
            throw new UnsupportedOperationException("Negative cost cycle exists");
        return distFrom[v];
    }
    public boolean hasPathFrom(int v) {
        validateVertex(v);
        return distFrom[v] < Double.POSITIVE_INFINITY;
    }
    public Iterable<DirectedEdge> pathFrom(int v) {
        validateVertex(v);
        if (hasNegativeCycle())
            throw new UnsupportedOperationException("Negative cost cycle exists");
        if (!hasPathFrom(v)) return null;
        Stack<DirectedEdge> tmp = new Stack<DirectedEdge>();
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = edgeFrom[v]; e != null; e = edgeFrom[e.to()]) {
            tmp.push(e);
        }
        while(!tmp.isEmpty()) {
        	path.push(tmp.pop());
        }
        return path;
    }
    private void validateVertex(int v) {
        int V = distFrom.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException();
    }
    public static void main(String[] args) {
    	String name = "src/BellmanFord_dich/text.txt";
		EdgeWeightedDigraph g = new EdgeWeightedDigraph(name);
		Bellman_Ford sp = new Bellman_Ford(g, 0);
		if (sp.hasNegativeCycle()) {
            for (DirectedEdge e : sp.negativeCycle())
                System.out.print(e + " ");
        } else {
            for (int v = 0; v < g.V(); v++) {
                if (sp.hasPathFrom(v)) {
                	System.out.println(v + " -> 0( " + sp.distFrom(v) + "): " );
                    for (DirectedEdge e : sp.pathFrom(v)) {
                        System.out.print(e + " ");
                    }
                    System.out.println();
                }
                else {
                    System.out.println("không thấy");
                }
            }
        }
	}
}
