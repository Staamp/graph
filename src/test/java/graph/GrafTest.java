package graph;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Unit test for graf.
 */
public class GrafTest {

    Map<Node, List<Node>> adjList;
    List<Node> listNode;
    List<Edge> listEdge;
    @Before
    public void begin(){

    }

    @Test
    public void addOneNode() {
        Node n = new Node("test", 1);
        Graf g = new Graf(adjList, listNode, listEdge);
        g.addNode(n);
        g.getAllNodes();
    }

    @Test
    public void addTwoNode() {
        Node n1 = new Node("test", 1);
        Node n2 = new Node(2);
        Graf g = new Graf(adjList, listNode, listEdge);
        g.addNode(n1);
        g.addNode(n2);
        g.getAllNodes();
    }

    @Test
    public void addTwoRemoveOneNode() {
        Node n1 = new Node("test", 1);
        Node n2 = new Node(2);
        Graf g = new Graf(adjList, listNode, listEdge);
        g.addNode(n1);
        g.addNode(n2);
        g.getAllNodes();
        g.removeNode(n1);
        g.getAllNodes();
    }

    @Test
    public void addNodeRemoveOneEgdeAndCheckNode() {
        Node n1 = new Node("test", 1);
        Node n2 = new Node(2);
        Graf g = new Graf(adjList, listNode, listEdge);
        g.addNode(n1);
        g.addNode(n2);
        g.addEdge(n1, n1);
        g.addEdge(n1, n2);
        g.getAllNodes();
        g.getAllEdges();
        g.removeNode(n2);
        g.getAllNodes();
        g.getAllEdges();
    }

    @Test
    public void removeNodeNotExist() {
        Node n1 = new Node("test", 1);
        Graf g = new Graf(adjList, listNode, listEdge);
        g.getAllNodes();
        g.removeNode(n1);
        g.getAllNodes();
    }

    @Test
    public void addNodesWithEdge() {
        Node n1 = new Node("test", 1);
        Node n2 = new Node(2);
        Graf g = new Graf(adjList, listNode, listEdge);
        g.addNode(n1);
        g.addNode(n2);
        g.addEdge(n1, n2);
        g.getAllNodes();
        g.getAllEdges();
    }

    @Test
    public void addNodesWithEdgeWithOneEdgeNotExist() {
        Node n1 = new Node("test", 1);
        Node n2 = new Node(2);
        Graf g = new Graf(adjList, listNode, listEdge);
        g.addNode(n1);
        g.addEdge(n1, n2);
        g.getAllNodes();
        g.getAllEdges();
    }

    @Test
    public void addNodesWithEdgeWithOneRemoveEdge() {
        Node n1 = new Node("test", 1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Graf g = new Graf(adjList, listNode, listEdge);
        g.addNode(n1);
        g.addNode(n2);
        g.addNode(n3);
        g.addEdge(n1, n2);
        g.addEdge(n3, n1);
        g.getAllNodes();
        g.getAllEdges();
        g.removeEdge(n3, n1);
        g.getAllNodes();
        g.getAllEdges();
    }

    @Test
    public void addNodesWithManyEdge() {
        Node n1 = new Node("test", 1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Graf g = new Graf(adjList, listNode, listEdge);
        g.addNode(n1);
        g.addEdge(n1, n2);
        g.addEdge(n3, n1);
        g.addEdge(n4, n5);
        g.addEdge(n5, n1);
        g.addEdge(n1, n4);
        g.getAllNodes();
        g.getAllEdges();
    }


    @Test
    public void addManyNodeWithConstructor1() {
        Graf g = new Graf(2, 4, 0, 0, 6, 0, 2, 3, 5, 8, 0, 0, 4, 7, 0, 3, 0, 7, 0);
        g.getAllNodes();
        g.getAllEdges();
    }

    @Test
    public void addManyNodeWithConstructor2() {
        Graf g = new Graf(2, 3, 0, 3, 4, 6, 0, 6, 0, 5, 0, 2, 0, 4, 0);
        g.getAllNodes();
        g.getAllEdges();
    }


    @Test
    public void checkEntranceInNode() {
        Node n1 = new Node("test", 1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Graf g = new Graf(adjList, listNode, listEdge);
        g.addNode(n1);
        g.addEdge(n1, n2);
        g.addEdge(n3, n1);
        g.addEdge(n4, n5);
        g.addEdge(n5, n1);
        g.addEdge(n1, n4);
        g.getAllEdges();
        List<Edge> inN1 = g.getInEdge(n1);
        g.printList(inN1);
    }

    @Test
    public void checkEntranceOutNode() {
        Node n1 = new Node("test", 1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Graf g = new Graf(adjList, listNode, listEdge);
        g.addNode(n1);
        g.addEdge(n1, n2);
        g.addEdge(n3, n1);
        g.addEdge(n4, n5);
        g.addEdge(n5, n1);
        g.addEdge(n1, n4);
        g.getAllEdges();
        List<Edge> outN1 = g.getOutEdge(n1);
        g.printList(outN1);
    }

    @Test
    public void checkEntranceIncidentNode() {
        Node n1 = new Node("test", 1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Graf g = new Graf(adjList, listNode, listEdge);
        g.addNode(n1);
        g.addEdge(n1, n2);
        g.addEdge(n3, n1);
        g.addEdge(n4, n5);
        g.addEdge(n5, n1);
        g.addEdge(n1, n4);
        g.getAllEdges();
        System.out.println("\n");
        List<Edge> inN1 = g.getInEdge(n1);
        g.printList(inN1);
        System.out.println("\n");
        List<Edge> outN1 = g.getOutEdge(n1);
        g.printList(outN1);
        System.out.println("\n");
        List<Edge> incidentN1 = g.getIncidentEdges(n1);
        g.printList(incidentN1);
    }

    @Test
    public void checkSuccessorsOfNode1() {
        Node n1 = new Node("test", 1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Graf g = new Graf(adjList, listNode, listEdge);
        g.addNode(n1);
        g.addEdge(n1, n2);
        g.addEdge(n3, n1);
        g.addEdge(n4, n5);
        g.addEdge(n5, n1);
        g.addEdge(n1, n4);
        g.getAllEdges();
        List<Node> successors = g.getSuccessors(n1);
        g.printList(successors);
    }

    @Test
    public void checkSuccessorsArray() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Graf g = new Graf(adjList, listNode, listEdge);
        g.addEdge(n1, n2);
        g.addEdge(n1, n3);
        g.addEdge(n2, n3);
        g.addEdge(n2, n4);
        g.addEdge(n2, n6);
        g.addEdge(n3, n6);
        g.addEdge(n4, n5);
        g.addEdge(n5, n2);
        g.addEdge(n6, n4);
        int[] tabSA = g.getSuccessorArray();
        int lgtTabSA = tabSA.length;
        System.out.println("Successor array : ");
        for (int i = 0; i < lgtTabSA; i++) {
            System.out.print(tabSA[i]);
        }
    }

    @Test
    public void checkSortOfListEdge() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Graf g = new Graf(adjList, listNode, listEdge);
        g.addEdge(n3, n6);
        g.addEdge(n1, n3);
        g.addEdge(n2, n4);
        g.addEdge(n6, n4);
        g.addEdge(n2, n6);
        g.addEdge(n4, n5);
        g.addEdge(n5, n2);
        g.addEdge(n2, n3);
        g.addEdge(n1, n2);
        g.getAllEdges();
        g.sortListOfEdge();
        g.getAllEdges();
    }

    @Test
    public void checkAdjMatrix() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Graf g = new Graf(adjList, listNode, listEdge);
        g.addEdge(n1, n2);
        g.addEdge(n1, n3);
        g.addEdge(n2, n3);
        g.addEdge(n2, n4);
        g.addEdge(n2, n6);
        g.addEdge(n3, n6);
        g.addEdge(n4, n5);
        g.addEdge(n5, n2);
        g.addEdge(n6, n4);
        int[][] adjMatrix = g.getAdjMatrix();
        int lgtTabSA = adjMatrix.length;
        System.out.println("Adjency Matrix : ");
        for (int i = 0; i < lgtTabSA; i++) {
            for (int j = 0; j < lgtTabSA; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    @Test
    public void checkReverseGraf() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Graf g = new Graf(adjList, listNode, listEdge);
        g.addEdge(n1, n2);
        g.addEdge(n1, n3);
        g.addEdge(n2, n3);
        g.addEdge(n2, n4);
        g.addEdge(n2, n6);
        g.addEdge(n3, n6);
        g.addEdge(n4, n5);
        g.addEdge(n5, n2);
        g.addEdge(n6, n4);
        g.getAllEdges();
        Graf g1 = g.getReverseGraph();
        g1.getAllEdges();
    }

    @Test
    public void checkAdjMatrixToGraf() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Graf g = new Graf(adjList, listNode, listEdge);
        g.addEdge(n1, n2);
        g.addEdge(n1, n3);
        g.addEdge(n2, n3);
        g.addEdge(n2, n4);
        g.addEdge(n2, n6);
        g.addEdge(n3, n6);
        g.addEdge(n4, n5);
        g.addEdge(n5, n2);
        g.addEdge(n6, n4);
        g.getAllEdges();
        int[][] adjMatrix = g.getAdjMatrix();
        int lgtTabSA = adjMatrix.length;
        System.out.println("Adjency Matrix : ");
        for (int i = 0; i < lgtTabSA; i++) {
            for (int j = 0; j < lgtTabSA; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println("");
        }
        Graf g1 = g.adjMatrixToGraf(adjMatrix);
        g1.getAllEdges();
    }

    @Test
    public void checkTransitiveClosure() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Graf g = new Graf(adjList, listNode, listEdge);
        g.addEdge(n1, n1);
        g.addEdge(n1, n2);
        g.addEdge(n1, n4);
        g.addEdge(n2, n2);
        g.addEdge(n2, n3);
        g.addEdge(n3, n3);
        g.addEdge(n3, n3);
        g.addEdge(n3, n4);
        g.addEdge(n4, n4);
        g.getAllEdges();
        Graf g1 = g.getTransitiveClosure();
        g1.getAllEdges();
        int[][] adjMatrix = g1.getAdjMatrix();
        int lgtTabSA = adjMatrix.length;
        System.out.println("Adjency Matrix : ");
        for (int i = 0; i < lgtTabSA; i++) {
            for (int j = 0; j < lgtTabSA; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    @Test
    public void checkDFS() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Graf g = new Graf(adjList, listNode, listEdge);
        g.addEdge(n2,n1);
        g.addEdge(n1,n3);
        g.addEdge(n3,n2);
        g.addEdge(n1,n4);
        g.addEdge(n2,n5);
        List<Node> dfsG = g.getDFS(n1);
        int dfsGSize = dfsG.size();
        for (int i = 0; i < dfsGSize; i++) {
            System.out.print(dfsG.get(i).getNumber());
        }
    }

    @Test
    public void checkBFS() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Graf g = new Graf(adjList, listNode, listEdge);
        g.addEdge(n1,n2);
        g.addEdge(n1,n3);
        g.addEdge(n2,n3);
        g.addEdge(n3,n1);
        g.addEdge(n3,n4);
        g.addEdge(n4,n4);
        List<Node> bfsG = g.getBFS(n3);
        int bfsGSize = bfsG.size();
        for (int i = 0; i < bfsGSize; i++) {
            System.out.print(bfsG.get(i).getNumber());
        }
    }

    @Test
    public void checkToDotString() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Graf g = new Graf(adjList, listNode, listEdge);
        g.addEdge(n1,n2);
        g.addEdge(n1,n3);
        g.addEdge(n2,n3);
        g.addEdge(n3,n1);
        g.addEdge(n3,n4);
        g.addEdge(n4,n4);
        String dotString = g.toDotString();
        System.out.println(dotString);
    }

    @Test
    public void checkToDotFile() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Graf g = new Graf(adjList, listNode, listEdge);
        g.addEdge(n1,n2);
        g.addEdge(n1,n3);
        g.addEdge(n2,n3);
        g.addEdge(n3,n1);
        g.addEdge(n3,n4);
        g.addEdge(n4,n4);
        g.toDotFile();
    }


    @Test
    public void checkDotFileToGraph() {
        String path = "D:/Github/graph/graph.dot";
        System.out.println("Lecture :");
        Graf g = Graf.DotFileToGraph(path);

        g.getAllNodes();
        g.getAllEdges();
    }
}
