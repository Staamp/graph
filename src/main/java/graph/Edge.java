package graph;

import java.util.LinkedList;

public class Edge implements Comparable<Edge> {

    private Node from;
    private Node to;
    //private LinkedList<Integer>[] adj;


    public Edge(Node from, Node to) {
        this.from = from;
        this.to = to;

        //this.adj = new LinkedList[];

        //for (int i = 0; i < adj.length; i++) {
        //    adj[i] = new LinkedList<Integer>();
        //}
    }

    public Node getFrom() {
        return from;
    }

    public Node getTo() {
        return to;
    }

    public void setFrom(Node from) {
        this.from = from;
    }

    public void setTo(Node to) {
        this.to = to;
    }

    public String toString() {
        return "[" + getFrom() + ", " + getTo() + "]";
    }


    public int compareTo(Edge e) {
        if (this.getFrom().equals(e.getFrom()) && this.getTo().equals(e.getTo())) {
            return 0 ;
        }
        return -1;
    }
}