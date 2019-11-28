package F28DA_CW2;

import java.util.Set;
import java.util.HashSet;

public class Airport implements IAirportPartB, IAirportPartC {
	
	private String code;
	private String name;
	private Set<Airport> dc;
	private int dcOrder;
	
	public Airport(String code, String name)	{
		this.code = code;
		this.name = name;
		dc = new HashSet<Airport>();
		dcOrder = 0;
	}
	
	
	@Override
	public String getCode() {
		// TODO Auto-generated method stub
		return code;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setDicrectlyConnected(Set<Airport> dicrectlyConnected) {
		// TODO Auto-generated method stub
		dc = dicrectlyConnected;
	}

	@Override
	public Set<Airport> getDicrectlyConnected() {
		// TODO Auto-generated method stub
		return dc;
	}


	@Override
	public void setDicrectlyConnectedOrder(int order) {
		// TODO Auto-generated method stub
		dcOrder = order;
	}

	@Override
	public int getDirectlyConnectedOrder() {
		// TODO Auto-generated method stub
		return dcOrder;
	}

}
