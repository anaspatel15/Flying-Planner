package F28DA_CW2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;

public class Journey implements IJourneyPartB<Airport, Flight>, IJourneyPartC<Airport, Flight> {
	
	private Airport start;
	private Airport end;
	private List<Flight> fList;
	private GraphPath<Airport, Flight> gp;
	

	public Journey(GraphPath<Airport, Flight> gp) {
		this.start = start;
		this.end = end;
		this.gp = gp;
	}
	
	
	
	@Override
	public List<String> getStops() {
		List<String> stopCodes = new ArrayList<String>();
		// TODO Auto-generated method stub
		List<Airport> stops = gp.getVertexList();
		
		for(Airport stop : stops) {
			stopCodes.add(stop.getCode());
		}
		return stopCodes;
	}

	
	@Override
	public List<String> getFlights() {
		// TODO Auto-generated method stub
		List<String> flightCodes = new ArrayList<String>();
		List<Flight> flights = gp.getEdgeList();
		
		for(Flight f : flights) {
			flightCodes.add(f.getFlightCode());
		}
		return flightCodes;
	}

	
	@Override
	public int totalHop() {
		// TODO Auto-generated method stub
		List<Flight> flights = gp.getEdgeList();
		return flights.size();
	}

	
	@Override
	public int totalCost() {
		// TODO Auto-generated method stub
		return (int) gp.getWeight();
		}

	
	@Override
	public int airTime() {
		// TODO Auto-generated method stub
	
		List<String[]> timings = new ArrayList<String[]>();
		List<int[]> intDepTimes = new ArrayList<int[]>();
		List<int[]> intArrTimes = new ArrayList<int[]>();
		String startTime;
		String endTime;
		int dur = 0;
		
		for(Flight f : fList) {
			startTime = f.getFromGMTime();
			endTime = f.getToGMTime();
			String[] e = {startTime, endTime};
			for(int i = 0; i < e.length; i++) {
				if(e[i].length() == 1) {
					e[i] = "000" + e[i];
				}
				if(e[i].length() == 2) {
					e[i] = "00" + e[i];
				}
				if(e[i].length() == 3) {
					e[i] = "0" + e[i];
				}
			}
			SimpleDateFormat format = new SimpleDateFormat("HHmm");
			
			Date stTime;
			Date finTime;
			try {
				stTime = format.parse(e[0]);
				finTime = format.parse(e[1]);
				long durMs = finTime.getTime() - stTime.getTime();
				
				if(stTime.getTime() > finTime.getTime())	{
					durMs = stTime.getTime() - finTime.getTime();
					dur = (int) ((24*60) - (durMs/60000));
				}
				else	{
					dur = dur + (int) (durMs / 60000);
				}
			} catch (ParseException exc) {
				// TODO Auto-generated catch block
				exc.printStackTrace();
			}	
		}
		return dur;
		}

	@Override
	public int connectingTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int totalTime() {
		// TODO Auto-generated method stub
		return 0;
	}

}
