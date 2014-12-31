package ood;

import java.util.List;
import java.util.Set;

public class ElevatorControlSystem {

    /*
     * Only my solution.
     * 
     * unfinished
     */
    enum Status {
	Up, Down, Idle;
    }

    class Request {
	int curFloor;
	boolean direction;
    }

    /*
     * there may be different types of elevator. Like passanger elevator or
     * cargo elevator
     */
    class Elevator {
	int capacity; // int weight;
	int curFloor;
	List<Integer> stops;
	Status status;

	public void run() {
	    if (!stops.isEmpty()) {
		// ...
	    }

	}
    }

    class ControlSystem {
	Set<Elevator> elevators;

	public void listener() {
	    // react once a button in a diaboard is triggered
	}

	private void addRequest(Request q) {

	}

    }
}
