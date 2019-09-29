package graph;


/**
 * Hello world!
 *
 */
public class AppMain
{
    public static void main( String[] args ) {

        Node n = new Node("test", 1);
        Node v = new Node("test", 1);

        if (n.equals(v)){
            System.out.println( "Réussi" );
        }

        System.out.println( "Hello World!" );
    }
}
