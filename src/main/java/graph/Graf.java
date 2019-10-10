package graphNV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
    //ERREUR REVOIR 03/10/2019
    public Graf(int ... node) {
        this.adjList = new HashMap<Node, List<Node>>();
        this.listNode = new ArrayList<>();
        this.listEdge = new ArrayList<>();
        int nodeNbr = node.length;
        if (nodeNbr != 0) {
            Node n1 = new Node(1);
            addNode(n1);
        }
        //System.out.println("Node nbr " + nodeNbr);
       /* for (int i = 0; i <= nodeNbr -1; i++) {
            //System.out.println("ADD NODE " + nodeNbr);
            Node n2 = new Node(n1.getNumber());
            if (node[i] == 0) {
                if (i <= nodeNbr) {
                    n1.setNumber(node[i + 1]);
                }
                continue;
            }
            Node n3 = new Node(node[i]);
            addNode(n3);
            addEdge(n2, n3);
        }*/
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
        for (int i = 0, c = listEdge.size(); i < c; i++) {
            if ((e.getFrom().getNumber() == listEdge.get(i).getFrom().getNumber()) && (e.getTo().getNumber() == listEdge.get(i).getTo().getNumber())) {
                return true;
            }
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
     * Function who return the list of incident edge of node n
     *
     * @param n the node where we want to know the incident edge
     * @return the list of incident edge of node n
     */
    public List<Edge> getIncidentEdges(Node n) {
        List<Edge> listIncident = new ArrayList();
        listIncident.addAll(getOutEdge(n));
        listIncident.addAll(getInEdge(n));
        return listIncident;
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


    /***
     * Function who create a dot format of a graph given
     *
     * @return a string of a dot representation
     */
    public String toDotString() {
        String dotStringGraph = "digraph g {\n";
        int numberEdge = numberOfEdge();
        for (int i = 0; i < numberEdge; i++) {
            dotStringGraph += " " + listEdge.get(i).getFrom().getNumber() + " -> " + listEdge.get(i).getTo().getNumber() + ";\n";
        }
        dotStringGraph += "}";
        return  dotStringGraph;
    }

    /***
     * Function who exporting the graph as a file in the DOT syntax
     */
    public void toDotFile() {
       //String pathOfFileOutput = "D:/Github/file.dot";
       String pathOfFileOutput = System.getProperty("user.dir") + "/" + "graph.dot"; //Current directory
        try {
            File ff = new File(pathOfFileOutput);
            ff.createNewFile();
            FileWriter ffw = new FileWriter(ff);
            try {
                ffw.write(toDotString());
            } finally {
                ffw.close();
            }
        } catch (Exception e) {
            System.out.println("Error. Could not create file");
        }
    }

    /***
     * Create a PDF Image of a given graph with the DOT file
     */
    public void DotFileToPDFImage() {
        toDotFile();
        try {
            Runtime.getRuntime().exec("dot -Tpdf graph.dot -o graph.pdf");
        } catch (Exception e) {
            System.out.println("Error. Could not create the pdf image of the graph.");
        }
    }

    /***
     * Function who read a file with dot formalism and create a graph
     *
     * @param path of the dot file
     * @return a graph
     */
    public static Graf DotFileToGraph(String path) {
        List<String> listDot = new  ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                listDot.add(line);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error. Could not open the dot file.");
        }

        int nbLineDotFile = listDot.size();
        Graf g = null;


        for (int i = 0; i < nbLineDotFile; i++) {
            if (listDot.get(i).equals("\n")) {
                continue;
            }
            if (i == 0) {
                String[] line1 = listDot.get(i).split(" ");
                if (line1[0].equals("digraph")) {
                    g = new Graf();
                }
                if (line1[0].equals("graph")) {
                    g = new UndirectedGraf();
                }
            }
            String[] arrOfStr = listDot.get(i).split("");
            /*for (int j = 0; j < arrOfStr.length; j++) {
                System.out.println(arrOfStr[j]);
            }*/
            if (i != 0 && i != nbLineDotFile-1) {
                //System.out.println("length of line of string " + arrOfStr.length);
                if (arrOfStr.length > 6) {
                    //System.out.println(arrOfStr[1]);
                    //System.out.println(arrOfStr[6] + "\n");
                    Node n1 = new Node(Integer.parseInt(arrOfStr[1]));
                    Node n2 = new Node(Integer.parseInt(arrOfStr[6]));
                    g.addNode(n1);
                    g.addNode(n2);
                    g.addEdge(n1, n2);
                }
            }
        }

        return g;
    }

    /***
     * Function who create a connected graph
     *
     * @return a connected graph
     */
    public static Graf connectedGraph() {
        Graf cg = new Graf();
        int low = 5;
        int high = 50;
        int nodes = (int)(Math.random()*((high - low) + 1) + low);
        //int nodes = 10;
        System.out.println("Number of nodes with math random " + nodes);

        for (int i = 1; i < nodes; i++) {
            cg.addNode(new Node(i));
        }
        int lowEdge = 1;
        int maxEdge = nodes * nodes;
        int edges = (int)(Math.random()*((maxEdge - lowEdge) + 1) + lowEdge);
        System.out.println("Number of edges with math random " + edges);
        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i < edges; i++) {
            do {
                n1 = (int) ((Math.random() * nodes) + 1);
                n2 = (int) ((Math.random() * nodes) + 1);
            } while (cg.existsEdge(new Edge(new Node(n1), new Node(n2))));
            cg.addEdge(new Node(n1), new Node(n2));
        }
        cg.sortListOfEdge();

        for (int i = 1; i < nodes; i++) {
            if (cg.getIncidentEdges(new Node(i)).size() == 0) {
                cg.removeNode(new Node(i));
            }
        }

        return cg;
    }

    /***
     * Function who create a dense graph (with density drawing near to 1)
     *
     * @return a dense graph
     */
    public static Graf denseGraph() {
        Random r = new Random();
        int low = 5;
        int high = 50;
        int nodes = r.nextInt(high - low) + high;
        System.out.println("Number of nodes with random : " + nodes);

        Graf dg = new Graf();

        for (int i = 1; i < nodes; i++) {
            dg.addNode(new Node(i));
        }

        for (int i = 1; i < nodes; i++) {
            for (int j = 1; j < nodes; j++) {
                if (!dg.existsEdge(new Edge(new Node(i), new Node(j)))) {
                    dg.addEdge(new Node(i), new Node(j));
                }
            }
        }
        return dg;
    }

    /***
     * Function who create a sparse graph (with density drawing near to 0)
     *
     * @return a sparse graph
     */
    public static Graf sparseGraph() {
        return null;
    }

    /***
     * Function who create a parameterized graph
     *
     * @param nodes number of node
     * @param edges number of edge
     * @param probability edge probability distribution
     * @return a parameterized graph
     */
    public static Graf parameterizedGraph(int nodes, int edges, int probability) {
        Graf pg = new Graf();
        for (int i = 1; i < nodes + 1; i++) {
            pg.addNode(new Node(i));
        }

        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i < edges; i++) {
            do {
                n1 = (int) ((Math.random() * nodes) + 1);
                n2 = (int) ((Math.random() * nodes) + 1);
            } while (pg.existsEdge(new Edge(new Node(n1), new Node(n2))));
            pg.addEdge(new Node(n1), new Node(n2));
        }
        pg.sortListOfEdge();

        return pg;
    }

    /***
     * Function who create a DAG (Directed acyclic graph)
     *
     * @return a DAG
     */
    public static Graf DAG() {
        return null;
    }
}
