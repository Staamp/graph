package graph;

import java.util.LinkedList;

public class Graf {
    private int V;


    public Graf(int v) {
        V = v;

    }

    public int getV() {
        return V;
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }

    public void setV(int v) {
        V = v;
    }

    public void setAdj(LinkedList<Integer>[] adj) {
        this.adj = adj;
    }
}
