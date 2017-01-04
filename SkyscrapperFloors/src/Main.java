import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	static Scanner s;
	static int startFloor;
	static int endFloor;		
	static int numOfFloors;
	static int elevators;
	static LinkedList<HashMap<Integer, Integer>> elevatorList;
	
	public static void main(String[] args) {
		s = new Scanner(System.in);
		int numOfCases = s.nextInt();
		
		for(int i = 0; i < numOfCases; i++) {
			numOfFloors = s.nextInt();
			elevators = s.nextInt();
			elevatorList = new LinkedList<HashMap<Integer, Integer>>();
			
			startFloor = s.nextInt();
			endFloor = s.nextInt();
			for(int j = 0; j < elevators; j++) {
				int mod = s.nextInt();
				int startFloor = s.nextInt();
				for(int k = startFloor; k < numOfFloors; k= k + mod) {//mark all stops on each elevator
					elevatorList.get(j).put(k, 1);
				}
			}
			boolean foundRoute = false;
			for(int e = 0; e < elevatorList.size(); e++) {// does any 1 elevator stop at the start and end floor
				HashMap<Integer,Integer> elevator = elevatorList.get(e);
				if(elevator.containsKey(startFloor) && elevator.containsKey(endFloor)) {//if so we don't need to merge
					foundRoute = true;
				}
			}
			if(!foundRoute) {//merge the elevators together to find all possible stops if they overlap
				HashMap<Integer, Integer> allElevatorStops = new HashMap<Integer, Integer>();
				boolean keepMerging = true;
				while(keepMerging) {//while there are no elevators left to merge
					allElevatorStops.putAll(elevatorList.removeFirst());
					boolean merged = false;
					for(HashMap<Integer,Integer> elevator : elevatorList ) {//for each elevator remaining
						if(mergeElevators(elevator, allElevatorStops)) {//if merged successful
							elevatorList.remove(elevator);//remove it
							merged = true;
						}
					}
					if(!merged) {// if no elevators are merged, then were done
						keepMerging = false;
					}
		
				}
				if(allElevatorStops.containsKey(startFloor) && allElevatorStops.containsKey(endFloor)) {
					foundRoute = true;
				}
			}
			
			if(foundRoute) {
				System.out.println("It is possible to move the furniture.");
			} else {
				System.out.println("The furniture cannot be moved.");
			}
			
		}
	}
	
	/*
	 * Will merge 'elToMerge' elevator with 'allElevatorStops' elevator only if they have overlapping stops.
	
	 */
	public static boolean mergeElevators(HashMap<Integer, Integer> elToMerge,HashMap<Integer, Integer> allStops ) {
		for(Integer key: elToMerge.keySet()) {
			if(allStops.containsKey(key)) {
				allStops.putAll(elToMerge);
				return true;
			}
		}
		return false;
	}
}
