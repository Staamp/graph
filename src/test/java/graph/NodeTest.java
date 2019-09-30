package graph;

import graph.Node;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for node.
 */
public class NodeTest {

    //Valeur(s) globale(s)
    Node node1;

    @Before
    public void begin(){
        node1 = new Node("node1",1);
    }

    @Test
    public void constructorNull_OK(){
        Node nodeNull = new Node();
        assertEquals(nodeNull.getName(),"");
        assertEquals(nodeNull.getNumber(),-1);

    }

    @Test
    public void toStringNode_OK(){
        assertEquals(node1.toString(),"1");
    }

    @Test
    public void toStringNode_KO(){
        assertNotEquals(node1.toString(),"2");
    }


    @Test
    public void getName_OK(){
        assertEquals(node1.getName(),"node1");
    }



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
