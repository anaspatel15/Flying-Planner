package F28DA_CW2;

public class Flight implements IFlight {

	private String code;
	private Airport from;
	private Airport to;
	private String dTime;
	private String aTime;
	private String cost;

	
	public Flight(String code, Airport from, String dTime, Airport to, String aTime, String cost)	{
		this.code = code;
		this.from = from;
		this.dTime = dTime;
		this.to = to;
		this.aTime = aTime;
		this.cost = cost;
	}
	
	@Override
	public String getFlightCode() {
		// TODO Auto-generated method stub4
		return code;
	}

	@Override
	public Airport getTo() {
		// TODO Auto-generated method stub
		return to;
	}

	@Override
	public Airport getFrom() {
		// TODO Auto-generated method stub
		return from;
	}

	@Override
	public String getFromGMTime() {
		// TODO Auto-generated method stub
		return dTime;
	}

	@Override
	public String getToGMTime() {
		// TODO Auto-generated method stub
		return aTime;
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return Integer.parseInt(cost);
	}


}
