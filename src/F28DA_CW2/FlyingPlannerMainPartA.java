package F28DA_CW2;

import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import java.util.Scanner;

public class FlyingPlannerMainPartA {

	public static void main(String[] args) {
		
		// The following code is from HelloJGraphT.java of the org.jgrapth.demo package
		
		System.err.println("The example code is from HelloJGraphT.java from the org.jgrapt.demo package.");
		System.err.println("Use similar code to build the small graph from Part A by hand.");
		System.err.println("Note that you will need to use a different graph class as your graph is not just a Simple Graph.");
		System.err.println("Once you understand how to build such graph by hand, move to Part B to build a more substantial graph.");
		// Code is from HelloJGraphT.java of the org.jgrapth.demo package (start)
        Graph<String, DefaultEdge> g = new SimpleGraph<>(DefaultEdge.class);

        String v1 = "v1";
        String v2 = "v2";
        String v3 = "v3";
        String v4 = "v4";

        // add the vertices
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);

        // add edges to create a circuit
        g.addEdge(v1, v2);
        g.addEdge(v2, v3);
        g.addEdge(v3, v4);
        g.addEdge(v4, v1);

        // note undirected edges are printed as: {<v1>,<v2>}
        System.out.println("-- toString output");
        // @example:toString:begin
        System.out.println(g.toString());
        // @example:toString:end
        System.out.println();
		// Code is from HelloJGraphT.java of the org.jgrapth.demo package (start)
        
        Graph<String, DefaultWeightedEdge> flights = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class); 
        Scanner scan = new Scanner(System.in);
        
        String edi = "Edinburgh";
        String lhr = "Heathrow";
        String dxb = "Dubai";
        String syd = "Sydney";
        String kul = "Kuala Lumpur";
        
        flights.addVertex(edi);
        flights.addVertex(lhr);
        flights.addVertex(dxb);
        flights.addVertex(syd);
        flights.addVertex(kul);
        
        
        
        flights.addEdge(edi, lhr);
        flights.addEdge(lhr, dxb);
        flights.addEdge(lhr, syd);
        flights.addEdge(dxb, kul);
        flights.addEdge(dxb, edi);
        flights.addEdge(kul, syd);
        
        flights.addEdge(lhr, edi);
        flights.addEdge(dxb, lhr);
        flights.addEdge(syd, lhr);
        flights.addEdge(kul, dxb);
        flights.addEdge(edi, dxb);
        flights.addEdge(syd, kul);
        
        
        
        flights.setEdgeWeight(flights.getEdge(edi, lhr), 80);
        flights.setEdgeWeight(flights.getEdge(lhr, dxb), 130);
        flights.setEdgeWeight(flights.getEdge(lhr, syd), 570);
        flights.setEdgeWeight(flights.getEdge(dxb, kul), 170);
        flights.setEdgeWeight(flights.getEdge(dxb, edi), 190);
        flights.setEdgeWeight(flights.getEdge(kul, syd), 150);

        flights.setEdgeWeight(flights.getEdge(lhr, edi), 80);
        flights.setEdgeWeight(flights.getEdge(dxb, lhr), 130);
        flights.setEdgeWeight(flights.getEdge(syd, lhr), 570);
        flights.setEdgeWeight(flights.getEdge(kul, dxb), 170);
        flights.setEdgeWeight(flights.getEdge(edi, dxb), 190);
        flights.setEdgeWeight(flights.getEdge(syd, kul), 150);
        
        
        
        System.out.println(flights);
        
        System.out.println("The following airports are used:");
        
        for(String a : flights.vertexSet()) {
        	System.out.println(a);
        }
        
        System.out.println("Please enter the start airport:");
        String start = scan.nextLine();
        
        System.out.println("Please enter the destination airport:");
        String end = scan.nextLine();
        
        System.out.println("Shortest (i.e. cheapest) path:");
        DijkstraShortestPath<String, DefaultWeightedEdge> sp = new DijkstraShortestPath<String, DefaultWeightedEdge>(flights);        
        
        Object path = DijkstraShortestPath.findPathBetween(flights, start, end);
        
        String [] route = path.toString().split(",");
        
        for(int i = 0; i < route.length ; i++)	{
        	String edge = route[i].replace(":", "->" ).replace("(", "").replace(")", "").replace("[", "").replace("]", "");
        	
        	if(i < 1)	{
        		System.out.println((i+1) + ". " + edge);
        	}
        	else	{
        		System.out.println((i+1) + "." + edge);
        	}
        }
       
        System.out.println("Cost of shortest (i.e. cheapest) path = £"+ (int) sp.getPathWeight(start, end));
		}

	
	
}
