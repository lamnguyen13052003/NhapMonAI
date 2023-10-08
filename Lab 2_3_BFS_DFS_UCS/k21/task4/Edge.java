package k21.task4;

public class Edge implements Comparable<Edge> {
    private Node begin;
    private Node end;
    private double weight;

    public Edge(Node begin, Node end, double weight) {
        super();
        this.begin = begin;
        this.end = end;
        this.weight = weight;
    }

    public Edge(Node begin, Node end) {
        super();
        this.begin = begin;
        this.end = end;
        this.weight = 1;
    }

    public Node getBegin() {
        return begin;
    }

    public Node getEnd() {
        return end;
    }

    public double getWeight() {
        return weight;
    }

    public void setEnd(Node end) {
        this.end = end;
    }

    @Override
    public int compareTo(Edge o) {
        return -this.end.getLabel().compareTo(o.getEnd().getLabel());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Edge((Node) this.begin.clone(), (Node) this.end.clone(), this.weight);
    }
}
