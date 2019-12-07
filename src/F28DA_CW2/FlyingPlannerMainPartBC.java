package F28DA_CW2;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class FlyingPlannerMainPartBC {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the start airport:");
        String start = scan.nextLine();
        
        System.out.println("Please enter the destination airport:");
        String end = scan.nextLine();
        
        
		// Your implementation should be in FlyingPlanner.java, this class is only to
		// run the user interface of your programme.

		FlyingPlanner fi;
		fi = new FlyingPlanner();
		try {
			fi.populate(new FlightsReader());
			fi.printTable(start, end);
			// Implement here your user interface using the methods of Part B. You could
			// optionally expand it to use the methods of Part C.

		} catch (FileNotFoundException | FlyingPlannerException e) {
			e.printStackTrace();
		}

	}

}
