package F28DA_CW2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.AsSubgraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.util.SupplierUtil;


public class FlyingPlanner implements IFlyingPlannerPartB<Airport,Flight>, IFlyingPlannerPartC<Airport,Flight> {
    
	private Graph<Airport, Flight> fg = new SimpleDirectedWeightedGraph<>(Flight.class); 
	private HashMap<String, Airport> airsMap;
	private HashMap<String, Flight> flightsMap;
	
	
	public FlyingPlanner()	{
		airsMap = new HashMap<String, Airport>();
		flightsMap = new HashMap<String, Flight>();
	}
	
	
	/* public Graph<Airport, DefaultWeightedEdge> getGraph()	{
		return fg;
	}
	
	public Collection<Flight> getFlightMap()	{
		return flightsMap.values();
	}	*/
	
	
	@Override
	public boolean populate(FlightsReader fr) {
		try {
			HashSet<String[]> air = fr.getAirports();
			HashSet<String[]> flights = fr.getFlights();
			populate(air, flights);
			}
		catch(Exception e)	{
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	

	@Override
	public boolean populate(HashSet<String[]> airports, HashSet<String[]> flights) {
		try	{
			for(String[] a : airports) {
				Airport airport = new Airport(a[0],a[2]);
				fg.addVertex(airport);
				airsMap.put(a[0], airport);
			}
			
			for(String[] f : flights)	{
				Flight fl = new Flight(f[0], airsMap.get(f[1]), f[2], airsMap.get(f[3]), f[4], f[5]);
				fg.addEdge(fl.getFrom(), fl.getTo(),fl);
				fg.setEdgeWeight(fl, Integer.parseInt(f[5]));
				flightsMap.put(f[0], fl);
			}
			
		}
		catch(Exception e)	{
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	

	
	
	@Override
	public Airport airport(String code) {
		return airsMap.get(code);
	}

	@Override
	public Flight flight(String code) {
		return flightsMap.get(code);
	}
	
	
	public void printTable(String s, String t)	{
		System.out.println("Journey for " + airsMap.get(s).getName() + " (" + s + ") to " + airsMap.get(t).getName() + " (" + t + ")");
		String format = "%1$-4s %2$-75s %3$-7s %4$-8s %5$-75s %6$-5s \n";
		System.out.format(format, "Leg", "Leave", "At", "On", "Arrive", "At");
		
		DijkstraShortestPath<Airport, Flight> p = new DijkstraShortestPath<Airport, Flight>(fg);
		GraphPath<Airport, Flight> path = p.getPath(airsMap.get(s), airsMap.get(t));
		List<Flight> connections = path.getEdgeList();
		Journey j = new Journey(path);
		
		for(int i = 0; i < connections.size(); i++) {
			System.out.format(format, i+1, connections.get(i).getFrom().getName() + " (" + connections.get(i).getFrom().getCode() + ")", connections.get(i).getFromGMTime(), connections.get(i).getFlightCode(), connections.get(i).getTo().getName() + " (" + connections.get(i).getTo().getCode() + ")", connections.get(i).getToGMTime());

		}
		
		
		
		/*for(Flight conn : connections)	{
			System.out.format(format, "0", conn.getFrom().getName() + " (" + conn.getFrom().getCode() + ")", conn.getFromGMTime(), conn.getFlightCode(), conn.getTo().getName() + " (" + conn.getTo().getCode() + ")", conn.getToGMTime());
		}*/
		
		System.out.println("Total Journey Cost: " + "?" + (int) path.getWeight());
		System.out.println("Total Time in the Air: " + j.airTime());
	}	

	@Override
	public Journey leastCost(String from, String to) throws FlyingPlannerException {
		// TODO Auto-generated method stub
		Airport f = airsMap.get(from);
		Airport t = airsMap.get(to);
		DijkstraShortestPath<Airport, Flight> p = new DijkstraShortestPath<Airport, Flight>(fg);
		GraphPath<Airport, Flight> path = p.getPath(f, t);
		
		Journey j = new Journey(path);
		return j;
		
	}

	
	@Override
	public Journey leastHop(String from, String to) throws FlyingPlannerException {
		// TODO Auto-generated method stub
		Airport f = airsMap.get(from);
		Airport t = airsMap.get(to);
		DijkstraShortestPath<Airport, Flight> p = new DijkstraShortestPath<Airport, Flight>(fg);
		GraphPath<Airport, Flight> path = p.getPath(f, t);
		List<Flight> conns = path.getEdgeList();
		AsSubgraph<Airport, Flight> ag = new AsSubgraph<Airport, Flight>(fg);
		
		
		for(Flight fl : ag.getAllEdges(f, t)) {
			ag.setEdgeWeight(fl, 1);
		}
		
		List<Flight> connects = path.getEdgeList();
		
		Journey j = new Journey(path);
		return j;
		
	}

	@Override
	public Journey leastCost(String from, String to, List<String> excluding)
			throws FlyingPlannerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Journey leastHop(String from, String to, List<String> excluding)
			throws FlyingPlannerException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Set<Airport> directlyConnected(Airport airport) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setDirectlyConnected() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDirectlyConnectedOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<Airport> getBetterConnectedInOrder(Airport airport) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String leastCostMeetUp(String at1, String at2) throws FlyingPlannerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String leastHopMeetUp(String at1, String at2) throws FlyingPlannerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String leastTimeMeetUp(String at1, String at2, String startTime) throws FlyingPlannerException {
		// TODO Auto-generated method stub
		return null;
	}


}
