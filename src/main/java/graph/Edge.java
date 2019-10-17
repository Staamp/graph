package graph;

/***
 * Edge is the class who create and compare the edges. This class implements comparable to compare two edges together
 */
public class Edge implements Comparable<Edge> {

    private Node from;
    private Node to;

    /***
     * Constructor of one edge
     *
     * @param from the node from of one edge
     * @param to the node to of one edge
     */
    public Edge(Node from, Node to) {
        this.from = from;
        this.to = to;
    }

    /***
     * Getter on node from of edge
     *
     * @return the node from
     */
    public Node getFrom() {
        return from;
    }

    /***
     * Getter on node to of edge
     *
     * @return the node to
     */
    public Node getTo() {
        return to;
    }

    /***
     * Setter on node from of edge
     *
     * @param from set node from
     */
    public void setFrom(Node from) {
        this.from = from;
    }

    /***
     * Setter on node to of edge
     *
     * @param to set node to
     */
    public void setTo(Node to) {
        this.to = to;
    }

    /***
     * Function who return a string of one edge
     *
     * @return one string of one edge with node from and node to
     */
    @Override
    public String toString() {
        return "(" + getFrom().toString() + ", " + getTo().toString() + ")";
    }

    /***
     * Function who compare two edges together
     *
     * @param e edge to compare with an another
     * @return the result of the comparison
     */
    @Override
    public int compareTo(Edge e) {
        if (this.getFrom().getNumber() > e.getFrom().getNumber()) {
            return 1;
        }
        if (this.getFrom().getNumber() == e.getFrom().getNumber() && this.getTo().getNumber() > e.getTo().getNumber()) {
            return  1;
        }
        if (this.getFrom().equals(e.getFrom()) && this.getTo().equals(e.getTo())) {
            return 0 ;
        }
        return -2;
    }
}