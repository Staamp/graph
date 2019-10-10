package graphNV;

import java.util.Objects;

/***
 * Node is the class who create and compare the Nodes
 */
public class Node {

    private int number;
    private String name;

    /***
     * Constructor who create a node with a name and a number
     *
     * @param name the name of one node
     * @param number the number of one node
     */
    public Node(String name, int number) {
        this.number = number;
        this.name = name;
    }

    /***
     * Default constructor
     */
    public Node() {
        this.number = -1;
        this.name = "";
    }

    /***
     * Constructor who create a node with a number and without a name
     *
     * @param number the number of one node
     */
    public Node(int number) {
        this.number = number;
    }

    /***
     * Setter on name of node
     *
     * @param name set the name of one node
     */
    public void setName(String name) {
        this.name = name;
    }

    /***
     * Setter on number of node
     *
     * @param number set the number of one node
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /***
     * Getter on name of node
     *
     * @return the name of one node
     */
    public String getName() {
        return name;
    }

    /***
     * Getter on number of node
     *
     * @return the number of one node
     */
    public int getNumber() {
        return number;
    }

    /***
     * Function who return a string of one node
     *
     * @return one string of one node with only number
     */
    @Override
    public String toString() {
        return "" + number + "";
    }

    /***
     * Function who compare two nodes together
     *
     * @param obj  node to compare with an another
     * @return the result of the comparison
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) {
            return  false;
        }
        if (!(obj instanceof Node)) {
            return false;
        }
        Node n = (Node) obj;
        //return this.getNumber() == n.getNumber() && this.getName().equals(n.getName());
        return this.getNumber() == n.getNumber();
    }

    /***
     * Function who realize a hashcode of one object node
     *
     * @return the result of hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }
}
