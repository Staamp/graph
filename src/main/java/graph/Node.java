package graph;

import java.util.Objects;

public class Node {

    private int number;
    private String name;

    public Node(String name, int number) {
        this.number = number;
        this.name = name;
    }

    public Node() {
        this.number = -1;
        this.name = "";
    }

    public Node(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

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

        return this.getNumber() == n.getNumber() && this.getName().equals(n.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }
}
