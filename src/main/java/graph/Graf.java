package graph;

import java.util.*;
import java.util.Collections;

/***
 * Graph is the class who create nodes, edges and realize many manipulation on graph
 */
public class Graf {

    Map<Node, List<Node>> adjList;
    List<Node> listNode;
    List<Edge> listEdge;

    /***
     * Constructor of a graph
     *
     * @param adjList map with node and list of node
     * @param listNode list of node
     * @param listEdge list of edge
     */
    public Graf(Map<Node, List<Node>> adjList, List<Node> listNode, List<Edge> listEdge) {
        this.adjList = new HashMap<Node, List<Node>>();
        this.listNode = new ArrayList<>();
        this.listEdge = new ArrayList<>();
    }

    /***
     * Constructor who create a graph with nodes and edges with successor array formalism
     *
     * @param node list of node with successor array formalism
     */
    public Graf(int ... node) {
        this.adjList = new HashMap<Node, List<Node>>();
        this.listNode = new ArrayList<>();
        this.listEdge = new ArrayList<>();
        int nodeNbr = node.length;
        int compteur = 1;
        for (int i = 0; i < nodeNbr -1; i++) {
            if (node[i] == 0) {
                continue;
            }
            Node n = new Node(node[i]);
            addNode(n);
        }

    }



/*
 *
 * Nodes and Edges
 *
 */


    /***
     * Function who add a node
     *
     * @param n the node added
     */
    public void addNode(Node n) {
        if (!listNode.contains(n)) {
            listNode.add(n);
        }
    }

    /***
     * Function who check if the node already exist
     *
     * @param n the node to control
     * @return a boolean who say the edge exist
     */
    public boolean existsNode(Node n) {
        if (listNode.contains(n)) {
            return true;
        }
        return false;
    }

    /***
     * Function who check if the edge already exist
     *
     * @param e the edge to control
     * @return a boolean who say the edge exist
     */
    public boolean existsEdge(Edge e) {
        if (listEdge.contains(e)) {
            return true;
        }
        return false;
    }

    /***
     * Function who create a new edge with two node
     *
     * @param n1 the node from of edge
     * @param n2 the node to of edge
     */
    public void addEdge(Node n1, Node n2) {
        if(!existsNode(n1)) {
            System.out.println("The first node doesn't exists. He is added");
            addNode(n1);
        }
        if(!existsNode(n2)) {
            System.out.println("The second node doesn't exists. He is added");
            addNode(n2);
        }
        Edge e = new Edge(n1, n2);
        if (!existsEdge(e)) {
            listEdge.add(e);
        } else {
            System.out.print("The node " + e.toString() + " already exist. Please create a new edge with other node.");
        }

    }

    /***
     * Function who remove one node with one node given in parameters and check if the node exist
     *
     * @param n node who where remove
     */
    public void removeNode(Node n) {
        if (existsNode(n)) {
            int numberEdge = numberOfEdge();
            for (int i = 0; i < numberEdge; i++) {
                if (listEdge.get(i).getFrom().equals(n) || listEdge.get(i).getTo().equals(n)) {
                    removeEdge(listEdge.get(i).getFrom(), listEdge.get(i).getTo());
                }
            }
            listNode.remove(n);
        }
    }

    /***
     *  Function who remove one edge with two nodes given in parameters and check if the edge exist
     *
     * @param n1 node from of edge
     * @param n2 node to of edge
     */
    public void removeEdge(Node n1, Node n2) {
        if (existsNode(n1) && existsNode(n2)) {
            int numberEdge = numberOfEdge();
            for (int i = 0; i < numberEdge; i++) {
                if (listEdge.get(i).getFrom().equals(n1) && listEdge.get(i).getTo().equals(n2)) {
                    listEdge.remove(i);
                    break;
                }
            }
        }
    }

    /***
     * Function who where we want to know the successors
     *
     * @param n the node where we want to know the successors
     * @return the list of successors of node n
     */
    public List<Node> getSuccessors(Node n) {
        System.out.println("List of nodes who is successor of node " + n.getNumber() + " :");
        int numberEdge = numberOfEdge();
        List<Node> successors = new ArrayList<>();
        for (int i = 0; i < numberEdge; i++) {
            if (listEdge.get(i).getFrom().getNumber() == n.getNumber()) {
                successors.add(listEdge.get(i).getTo());
            }
            if (listEdge.get(i).getTo().getNumber() == n.getNumber()) {
                successors.add(listEdge.get(i).getFrom());
            }
        }
        return successors;
    }

    /***
     * Function who return the list of in edge of node n
     *
     * @param n the node where we want to know the in edge
     * @return the list of in edge of node n
     */
    public List<Edge> getInEdge(Node n) {
        //System.out.println("List of edges who entrance of node " + n.getNumber() + " :");
        int numberEdge = numberOfEdge();
        List<Edge> inEdge = new ArrayList<>();
        for (int i = 0; i < numberEdge; i++) {
            if (n.getNumber() == listEdge.get(i).getTo().getNumber()) {
                inEdge.add(listEdge.get(i));
            }
        }
        return  inEdge;
    }

    /***
     * Function who return the list of out edge of node n
     *
     * @param n the node where we want to know the out edge
     * @return the list of out edge of node n
     */
    public List<Edge> getOutEdge(Node n) {
        //System.out.println("List of edges who out of node " + n.getNumber() + " :");
        int numberEdge = numberOfEdge();
        List<Edge> outEdge = new ArrayList<>();
        for (int i = 0; i < numberEdge; i++) {
            if (n.getNumber() == listEdge.get(i).getFrom().getNumber()) {
                outEdge.add(listEdge.get(i));
            }
        }
        return  outEdge;
    }

    /***
     * Function who return the number of node in graph
     *
     * @return the number of node in graph
     */
    public int numberOfNode() {
        return listNode.size();
    }

    /***
     * Function who return the number of edge in graph
     *
     * @return the number of edge in graph
     */
    public int numberOfEdge() {
        return listEdge.size();
    }

    /***
     * Function who return a list of all nodes in graph
     *
     * @return a list of all nodes in graph
     */
    public List<Node> getAllNodes() {
        int numberNode = numberOfNode();
        System.out.println("List of nodes (number of nodes : " + numberNode + ") : ");
        for (int i = 0; i < numberNode; i++) {
            String nodeNumber = listNode.get(i).toString();
            System.out.println(nodeNumber);
        }
        return listNode;
    }

    /***
     * Function who return a list of all edges in graph
     *
     * @return a list of all edges in graph
     */
    public List<Edge> getAllEdges() {
        System.out.println("List of edges : ");
        int numberEdge = numberOfEdge();
        for (int i = 0; i < numberEdge; i++) {
            String nodeEdge = listEdge.get(i).toString();
            System.out.println(nodeEdge);
        }
        return listEdge;
    }

    /***
     * Function who print a list
     *
     * @param l list printed
     */
    public void printList(List l) {
        int lsize = l.size();
        for (int i = 0; i < lsize; i++) {
            String list = l.get(i).toString();
            System.out.println(list);
        }
    }



/*
 *
 * Graph Representation
 *
 */


    /***
     * Function who realize a successor array
     *
     * @return an array for obtaining a representation of the graph in the successor array formalism
     */
    public int[] getSuccessorArray() {
        sortListOfEdge();
        int sizeEdge = this.numberOfEdge();
        int sizeTab = sizeEdge + this.numberOfNode();
        int[] successorArray = new int[sizeTab];
        int numberStart = 1;
        for (int i = 0, j = 0; i < sizeEdge; i++) {
            System.out.println(listEdge.get(i).toString());
            if (numberStart != listEdge.get(i).getFrom().getNumber()) {
                numberStart = listEdge.get(i).getFrom().getNumber();
                successorArray[j] = 0;
                j++;
            }
            if (numberStart == listEdge.get(i).getFrom().getNumber()) {
                successorArray[j] = listEdge.get(i).getTo().getNumber();
                j++;
            }

        }
        return  successorArray;
    }

    public List<Edge> sortListOfEdge() {
        Collections.sort(listEdge, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.compareTo(o2);
            }
        });
        return listEdge;
    }

    /***
     * Function who create an adjacency matrix with the graph given
     *
     * @return the matrix of the given graph
     */
    public int[][] getAdjMatrix() {
        int numberNode = numberOfNode();
        int[][] adjMatrix = new int[numberNode][numberNode];
        int [] SA = getSuccessorArray();
        int SALength = SA.length;
        for (int i = 0; i < numberNode-1; i++) {
            for (int j = 0; j < numberNode-1; j++) {
                adjMatrix[i][j] = 0;
            }
        }
        //int numberStart = listNode.get(0).getNumber();
        int numberStart = 1;
        for (int i = 0; i < SALength; i++) {
            if (SA[i] == 0) {
                numberStart++;
                continue;
            }
            adjMatrix[numberStart-1][SA[i]-1] = 1;
        }
        return adjMatrix;
    }



/*
 *
 * Graph Transformation
 *
 */


    /***
     *  Function who realize a new reversed graph with one graph given
     *
     * @return the reverse graph given
     */
    public Graf getReverseGraph() {
        Graf g = new Graf();
        int numberEdge = numberOfEdge();
        for (int i = 0; i < numberEdge; i++) {
            Edge e = listEdge.get(i);
            g.addEdge(e.getTo(), e.getFrom());
        }
        return g;
    }

    /***
     * Function who realize transitive closure with one graph
     *
     * @return the graph transformed by the transitive closure
     */
    public Graf getTransitiveClosure() {
        int[][] adjMatrix = getAdjMatrix();
        int numberNode = numberOfNode();
        int[][] result = new int[numberNode][numberNode];

        for (int i = 0; i < numberNode; i++) {
            for (int j = 0; j < numberNode; j++) {
                result[i][j] = adjMatrix[i][j];
            }
        }

        for (int k = 0; k < numberNode; k++) {
            for (int i = 0; i < numberNode; i++) {
                for (int j = 0; j <numberNode; j++) {
                    result[i][j] = (result[i][j] != 0) || ((result[i][k] != 0) && (result[k][j] != 0)) ? 1 : 0;
                }
            }
        }

        return adjMatrixToGraf(result);
    }

    /***
     * Function who realize a graph with adjacency matrix
     *
     * @param adjMatrix
     * @return a graph with one adjacency matrix given in parameters
     */
    public Graf adjMatrixToGraf(int[][] adjMatrix) {
        Graf g = new Graf();
        int lgtAdjMatrix = adjMatrix[0].length;
        for (int i = 0; i < lgtAdjMatrix; i++) {
            for (int j = 0; j < lgtAdjMatrix; j++) {
                if (adjMatrix[i][j] == 1) {
                    Node n1 = new Node(i+1);
                    Node n2 = new Node(j+1);
                    g.addEdge(n1, n2);
                }
            }
        }
        return g;
    }



/*
 *
 * Graph Traversal
 *
 */

    /***
     * Function who realize a dfs starting by the node given in parameters
     *
     * @param n the node by which to start to realize a dfs
     * @return a list of node of the course
     */
    public List<Node> getDFS(Node n) {
        Node nParam = n;
        int numberNode = numberOfNode();
        List<Node> DFS = new ArrayList<>();
        Vector<Boolean> visited = new Vector<Boolean>(numberNode);
        for (int i = 0; i < numberNode+1; i++) {
            visited.add(false);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(nParam.getNumber());

        int[] tab = new int[numberNode];
        int cpt = 0;

        while (!stack.empty()) {
            nParam.setNumber(stack.peek());
            stack.pop();
            if (!visited.get(nParam.getNumber())){
                tab[cpt] = nParam.getNumber();
                cpt++;
                visited.set(nParam.getNumber(), true);
            }
            List<Edge> outEdge = getOutEdge(nParam);
            Iterator<Edge> itr = outEdge.iterator();
            while (itr.hasNext()) {
                int v = itr.next().getTo().getNumber();
                if(!visited.get(v)){
                    stack.push(v);
                }
            }
        }

        for (int i = 0, c = tab.length; i < c; i++) {
            DFS.add(new Node(tab[i]));
        }

        return DFS;
    }

    /***
     * Function who realize a bfs starting by the node given in parameters
     *
     * @param n the node by which to start to realize a bfs
     * @return a list of node of the course
     */
    public List<Node> getBFS(Node n) {
        Node nParam = n;
        int numberNode = numberOfNode();
        List<Node> BFS = new ArrayList<>();

        int[] tab = new int[numberNode];
        int cpt = 0;

        Vector<Boolean> visited = new Vector<Boolean>(numberNode);
        for (int i = 0; i < numberNode+1; i++) {
            visited.add(false);
        }
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited.set(nParam.getNumber(), true);
        queue.add(nParam.getNumber());

        while (queue.size() != 0) {
            nParam.setNumber(queue.poll());
            tab[cpt] = nParam.getNumber();
            cpt++;

            List<Edge> outEdge = getOutEdge(nParam);
            Iterator<Edge> itr = outEdge.iterator();

            while (itr.hasNext()) {
                int v = itr.next().getTo().getNumber();
                if(!visited.get(v)){
                    visited.set(v, true);
                    queue.add(v);
                }
            }
        }

        for (int i = 0, c = tab.length; i < c; i++) {
            BFS.add(new Node(tab[i]));
        }

        return BFS;
    }



/*
 *
 * Graph Export
 *
 */


    public String toDotString() {
        return  "";
    }

    public void toDotFile() {

    }
}
