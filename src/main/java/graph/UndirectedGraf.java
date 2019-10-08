package graphNV;


import java.util.List;
import java.util.Map;

public class UndirectedGraf extends Graf {

    public UndirectedGraf(Map<Node, List<Node>> adjList, List<Node> listNode, List<Edge> listEdge) {
        super(adjList, listNode, listEdge);
    }

    public UndirectedGraf() {
        super();
    }
}
