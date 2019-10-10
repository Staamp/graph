package graph;


import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

public class UndirectedGraf extends Graf {

    public UndirectedGraf(Map<Node, List<Node>> adjList, List<Node> listNode, List<Edge> listEdge) {
        super(adjList, listNode, listEdge);
    }

    public UndirectedGraf() {
        super();
    }


    @Override
    public void addNode(Node n) {
        super.addNode(n);
    }

    @Override
    public boolean existsNode(Node n) {
        return super.existsNode(n);
    }

    @Override
    public boolean existsEdge(Edge e) {
        return super.existsEdge(e);
    }

    @Override
    public void addEdge(Node n1, Node n2) {
        super.addEdge(n1, n2);
    }

    @Override
    public void removeNode(Node n) {
        super.removeNode(n);
    }

    @Override
    public void removeEdge(Node n1, Node n2) {
        super.removeEdge(n1, n2);
    }

    @Override
    public List<Node> getSuccessors(Node n) {
        return super.getSuccessors(n);
    }

    @Override
    public List<Edge> getIncidentEdges(Node n) {
        return super.getIncidentEdges(n);
    }

    @Override
    public int numberOfNode() {
        return super.numberOfNode();
    }

    @Override
    public int numberOfEdge() {
        return super.numberOfEdge();
    }

    @Override
    public List<Node> getAllNodes() {
        return super.getAllNodes();
    }

    @Override
    public List<Edge> getAllEdges() {
        return super.getAllEdges();
    }

    @Override
    public void printList(List l) {
        super.printList(l);
    }

    @Override
    public int[] getSuccessorArray() {
        return super.getSuccessorArray();
    }

    @Override
    public List<Edge> sortListOfEdge() {
        return super.sortListOfEdge();
    }

    @Override
    public int[][] getAdjMatrix() {
        return super.getAdjMatrix();
    }

    @Override
    public List<Node> getDFS(Node n) {
        return super.getDFS(n);
    }

    @Override
    public List<Node> getBFS(Node n) {
        return super.getBFS(n);
    }

    @Override
    public void toDotFile() {
        super.toDotFile();
    }

    @Override
    public void DotFileToPDFImage() {
        super.DotFileToPDFImage();
    }

    /***
     * Function who create a dot format of a graph given
     *
     * @return a string of a dot representation
     */
    public String toDotString() {
        String dotStringGraph = "graph g {\n";
        int numberEdge = numberOfEdge();
        for (int i = 0; i < numberEdge; i++) {
            dotStringGraph += " " + listEdge.get(i).getFrom().getNumber() + " -> " + listEdge.get(i).getTo().getNumber() + ";\n";
        }
        dotStringGraph += "}";
        return  dotStringGraph;
    }
}
