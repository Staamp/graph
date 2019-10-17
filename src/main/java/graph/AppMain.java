package graph;


import java.util.List;
import java.util.Scanner;

import static graph.Graf.DotFileToGraph;


/**
 * AppMain for launch a graph program
 *
 */
public class AppMain {

    /***
     * Function who launch the interface to create or update a graph in command line
     */
    public static void commandLine() {
        System.out.println("Welcome on GraphSoft !");
        System.out.println("Choose an action :");
        System.out.println("1- Load a graph with dot file.");
        System.out.println("2- Create an empty graph.");
        System.out.println("0- Quit.");
        Scanner sc = new Scanner(System.in);
        String menu1 = sc.nextLine();

        Graf g = new Graf();

        switch (Integer.parseInt(menu1)) {
            case 1 : {
                System.out.println("Load a graph with dot file.");
                System.out.println("Enter the path of the dot file to open.");
                String path = sc.nextLine();
                g = DotFileToGraph(path);
            }
            break;
            case 2 : {
                System.out.println("Create an empty graph.");
            }
            break;
            default: {
                System.out.println("See you soon !");
                Runtime.getRuntime().exit(0);
            }
        }


        while (true) {
            System.out.println("Choose an action :");
            System.out.println("1- Add a node.");
            System.out.println("2- Remove node.");
            System.out.println("3- Add an edge.");
            System.out.println("4- Remove an edge.");
            System.out.println("5- Show the graph in the DOT format.");
            System.out.println("6- Export the graph in the DOT format.");
            System.out.println("7- Reverse the graph.");
            System.out.println("8- Compute the transitive closure of the graph.");
            System.out.println("9- Traverse the graph in DSF.");
            System.out.println("10- Traverse the graph in BSF.");
            System.out.println("11- Show the nodes of graph.");
            System.out.println("12- Show the edges of graph.");
            System.out.println("13- Generate a PDF image of the graph with dot file.");
            System.out.println("0- Quit.");
            String menu2 = sc.nextLine();
            String value1 = "";
            String value2 = "";
            switch (Integer.parseInt(menu2)) {
                case 1: {
                    System.out.println("Add a node.");
                    System.out.println("Number of node.");
                    value1 = sc.nextLine();
                    System.out.println("Name of node.");
                    value2 = sc.nextLine();
                    Node n = new Node(value2, Integer.parseInt(value1));
                    g.addNode(n);
                    System.out.println("Node (" + value1 + ", " + value2 + ") is added");
                }
                break;
                case 2: {
                    System.out.println("Remove node.");
                    System.out.println("Number of node.");
                    value1 = sc.nextLine();
                    g.removeNode(new Node(Integer.parseInt(value1)));
                }
                break;
                case 3: {
                    System.out.println("Add an edge.");
                    System.out.println("Number of node from.");
                    value1 = sc.nextLine();
                    System.out.println("Number of node to.");
                    value2 = sc.nextLine();
                    g.addEdge(new Node(Integer.parseInt(value1)), new Node(Integer.parseInt(value2)));
                }
                break;
                case 4: {
                    System.out.println("Remove an edge.");
                    System.out.println("Number of node from.");
                    value1 = sc.nextLine();
                    System.out.println("Number of node to.");
                    value2 = sc.nextLine();
                    g.removeEdge(new Node(Integer.parseInt(value1)), new Node(Integer.parseInt(value2)));

                }
                break;
                case 5: {
                    System.out.println("Show the graph in the DOT format.");
                    System.out.println(g.toDotString());
                }
                break;
                case 6: {
                    System.out.println("Export the graph to a DOT file.");
                    g.toDotFile();
                }
                break;
                case 7: {
                    System.out.println("Reverse the graph.");
                    Graf ng = g.getReverseGraph();
                }
                break;
                case 8: {
                    System.out.println("Compute the transitive closure of the graph.");
                    Graf ng = g.getTransitiveClosure();
                }
                break;
                case 9: {
                    System.out.println("Traverse the graph in DSF.");
                    List<Node> dfs = g.getDFS(new Node(1));
                    printList(dfs);
                }
                break;
                case 10: {
                    System.out.println("Traverse the graph in BSF.");
                    List<Node> bfs = g.getBFS(new Node(1));
                    printList(bfs);
                }
                break;
                case 11: {
                    System.out.println("Show the nodes of graph.");
                    g.getAllNodes();
                }
                break;
                case 12: {
                    System.out.println("Show the edges of graph.");
                    g.getAllEdges();
                }
                break;
                case 13: {
                    System.out.println("Generate a PDF image of the graph with dot file.");
                    g.DotFileToPDFImage();
                }
                break;
                default: {
                    System.out.println("See you soon !");
                    Runtime.getRuntime().exit(0);
                }
            }
        }
    }

    /***
     * Function who print a list
     *
     * @param l list printed
     */
    public static void printList(List l) {
        int lsize = l.size();
        for (int i = 0; i < lsize; i++) {
            String list = l.get(i).toString();
            System.out.println(list);
        }
    }



    public static void main( String[] args ) {
        commandLine();
    }


}
