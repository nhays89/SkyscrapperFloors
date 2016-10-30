import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	static Scanner s;
	static int startIndex;
	static int endIndex;
	static int numOfFloors;
	static int elevators;
	static ArrayList<LinkedList<Integer>> elevatorArray;
	static LinkedList<Integer> allElevatorStops;
	public static void main(String[] args) {
		s = new Scanner(System.in);
		int numOfCases = s.nextInt();
		for(int i = 0; i < numOfCases; i++) {
			numOfFloors = s.nextInt();
			elevators = s.nextInt();
			elevatorArray = new ArrayList<LinkedList<Integer>>(elevators);
			allElevatorStops = new LinkedList<Integer>;
			startIndex = s.nextInt();
			endIndex = s.nextInt();
			for(int j = 0; j < elevators; j++) {
				int mod = s.nextInt();
				int startFloor = s.nextInt();
				for(int k = startFloor; k < numOfFloors; k= k + mod)
				elevatorArray.get(k).add(k);
			}
		}
	}
	
	public void addStops(LinkedList<Integer> eleToMatch) {
		int index = allElevatorStops.removeFirst();
		Iterator<Integer> itrMatch = eleToMatch.iterator();
		Iterator<Integer> itrAllStops = allElevatorStops.iterator();
		while(itr.hasNext()) {
			Integer theStop = itrMatch.next();
			while(theStop)
		}
	}

}
