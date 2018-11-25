/**
 * Implementation of Data Structures
 * Small Project 12
 * Team mates-
 *          Ketki Mahajan
 *          Meghana Mathur
 **/
package krm150330;

import rbk.BFSOO;
import rbk.Graph;
import rbk.Graph.Vertex;
import java.util.Scanner;
import java.io.File;


public class DiameterOfTree
{
    public static void main(String[] args) throws Exception
    {
        String string = "10 9   1 2 2   1 3 3   2 4 5   3 5 4   2 6 1   6 7 7   3 8 1   8 10 4   8 9 7 1";
        Scanner in ;

        // If there is a command line argument, use it as file from which
        // input is read, otherwise use input from string.
        in = args.length > 0 ? new Scanner(new File(args[0])) : new Scanner(string);
        // Read graph from input
        Graph g = Graph.readGraph(in);
        g.printGraph(false);


        DiameterOfTree diameterOfTree = new DiameterOfTree();

        int result = diameterOfTree.diameter(g);

        System.out.println(result);

    }


    int diameter(Graph g) {

        if(g.size()>0)
        {
            Vertex src = g.getVertex(1);
            BFSOO b = BFSOO.breadthFirstSearch(g,src);
            Vertex maxVertex= findMaximumDistanceVertex(g,b);

            b = BFSOO.breadthFirstSearch(g,maxVertex);

            maxVertex = findMaximumDistanceVertex(g,b);
            return b.getDistance(maxVertex);
        }
        return 0;

    }

    public Vertex findMaximumDistanceVertex(Graph g, BFSOO bfs){
        int maxDistance=0;
        Vertex maxDistanceVertex = null;

        for(Vertex u: g){
            if( bfs.getDistance(u) > maxDistance ){
                maxDistance= bfs.getDistance(u);
                maxDistanceVertex = u;

            }
        }
        return maxDistanceVertex;
    }
}
