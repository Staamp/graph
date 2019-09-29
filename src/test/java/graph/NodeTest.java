package projetGraf;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import graph.Node;
import org.junit.Test;

/**
 * Unit test for node.
 */
public class NodeTest {

    @Test
    public void check2NodeEquals() {
        Node n = new Node("test", 1);
        Node v = new Node("test", 1);
        assertTrue( n.equals(v) );
    }

    @Test
    public void check2NodeNotEqualsNumber() {
        Node n = new Node("test", 1);
        Node v = new Node("test", 2);
        assertFalse( n.equals(v) );
    }

    @Test
    public void check2NodeNotEqualsName() {
        Node n = new Node("test1", 1);
        Node v = new Node("test2", 1);
        assertFalse( n.equals(v) );
    }

    @Test
    public void check2NodeNotEquals() {
        Node n = new Node("test1", 1);
        Node v = new Node("test2", 2);
        assertFalse( n.equals(v) );
    }


}
