package graph;

import java.util.LinkedList;

public class Edge {

    private int from;
    private int to;
    private LinkedList<Integer>[] adj;


    public Edge(int from, int to) {
        this.from = from;
        this.to = to;

        this.adj = new LinkedList[];

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public void setTo(int to) {
        this.to = to;
    }
}