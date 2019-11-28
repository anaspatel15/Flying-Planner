package F28DA_CW2;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FlyingPlannerMainPartBC {

	public static void main(String[] args) throws FileNotFoundException, FlyingPlannerException {

		// Your implementation should be in FlyingPlanner.java, this class is only to
		// run the user interface of your programme.

		FlyingPlanner fi;
		fi = new FlyingPlanner();
		try {
			System.out.println(fi.populate(new FlightsReader()));
			String s = "1234";
			
			
			
			String time1 = "1710";
			String time2 = "0730";
			
		
			SimpleDateFormat format = new SimpleDateFormat("HHmm");
			Date date1;
			Date date2;
			try {
				date1 = format.parse(time1);
				date2 = format.parse(time2);
				long difference = date1.getTime() - date2.getTime();
				//System.out.println(date2.getTime()/60000);
				System.out.println((24*60)-(difference/60000));

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// Implement here your user interface using the methods of Part B. You could
			// optionally expand it to use the methods of Part C.
		
		} catch (FileNotFoundException | FlyingPlannerException e) {
			e.printStackTrace();
		}
		
		
		
		}

}
