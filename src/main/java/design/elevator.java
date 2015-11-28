public class Elevator{
	public Elevator(){}
	PriorityQueue<Integer> floors = new PriorityQueue<Integer>();
	public void run(){


	}

	public int getCurrentFloor(){

	}

}

class ElevatorSystem{

	int floor;
	Elevator[] elevators;
	public ElavatorSystem(int floor, int elevatorNum){

		this.floor = floor;
		elevators = new Elevator[elevatorNum];

		for(int i = 0; i < elevatorNum; i ++){
			elevators[i] = new Elevator();
		}
	}


	up(int floor){
		//algorithm add this floor to closest elevator;
	}

	down(int floor){
		//algorithm add this floor to closest elevator;
	}






}