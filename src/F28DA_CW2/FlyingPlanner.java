package F28DA_CW2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

public class FlyingPlanner implements IFlyingPlannerPartB<Airport,Flight>, IFlyingPlannerPartC<Airport,Flight> {
    
	private Graph<Airport, DefaultWeightedEdge> fg = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class); 
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
			for(String[] a : air) {
				Airport airport = new Airport(a[0],a[2]);
				fg.addVertex(airport);
				airsMap.put(a[0], airport);
			}
			
			for(String[] f : flights)	{
				Flight fl = new Flight(f[0], airsMap.get(f[1]), f[2], airsMap.get(f[3]), f[4], f[5]);
				fg.addEdge(fl.getFrom(), fl.getTo());
				fg.setEdgeWeight(fg.getEdge(fl.getFrom(), fl.getTo()), Integer.parseInt(f[5]));
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
	public boolean populate(HashSet<String[]> airports, HashSet<String[]> flights) {
		try	{
			for(String[] a : airports) {
				Airport airport = new Airport(a[0],a[2]);
				fg.addVertex(airport);
				airsMap.put(a[0], airport);
			}
			
			for(String[] f : flights)	{
				Flight fl = new Flight(f[0], airsMap.get(f[1]), f[2], airsMap.get(f[3]), f[4], f[5]);
				fg.addEdge(fl.getFrom(), fl.getTo());
				fg.setEdgeWeight(fg.getEdge(fl.getFrom(), fl.getTo()), Integer.parseInt(f[5]));
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
		// TODO Auto-generated method stub
		return flightsMap.get(code);
	}
	

	@Override
	public Journey leastCost(String from, String to) throws FlyingPlannerException {
		// TODO Auto-generated method stub
		Airport f = airsMap.get(from);
		Airport t = airsMap.get(to);
		Journey j = new Journey(f, t);
		return j;
	}

	
	@Override
	public Journey leastHop(String from, String to) throws FlyingPlannerException {
		// TODO Auto-generated method stub
		return null;
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
