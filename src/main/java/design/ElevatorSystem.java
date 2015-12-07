package main.java.design;
import java.util.PriorityQueue;

enum status{
	maintance,
	up,
	down,
	stand
}

class Elevator{
	
	private int totalFloor;
	private boolean[] floorRequest = new boolean[totalFloor];
	private status currStatus;
	private int weight;
	/*setter|getter*/
	public Elevator(int totalFloor){
		this.totalFloor = totalFloor;
	}
	

	public int getCurrentFloor(){

	}
	
	public void goUp(int currFloor){
		currStatus  = status.up;
		for(int i = currFloor + 1; i < totalFloor; i ++){
			if(floorRequest[i]){
				open();
				wait();
				close;
				floorRequest[i] = false;
				if(checkFurtherdown(i + 1)){
					continue;
				}else{
					currStatus = status.stand;
					break;
				}
			}
		}
	}
	
	public void goDown(int currFloor){
		currStatus = status.down;
		for(int i = currFloor - 1; i >= 0; i --){
			if(floorRequest[i]){
				open();
				wait();
				close;
				floorRequest[i] = false;
				if(checkFurtherDown(i - 1)){
					continue;
				}else{
					currStatus = status.stand;
					break;
				}
			}
		}
	}
	
	public void setFloorRequest(int i){
		floorRequest[i] = true;
		if(this.currStatus == status.stand){
			if(i > getCurrentFloor()){
				goUp(i);
			}else if( i < getCurrentFloor()){
				goDown(i);
			}
			
		}
	}
	
}

public class ElevatorSystem{

	int totalFloor;
	Elevator[] elevators;
	int elevatorNum;
	public ElevatorSystem(int totalFloor, int elevatorNum){

		this.totalFloor = totalFloor;
		elevators = new Elevator[elevatorNum];

		for(int i = 0; i < elevatorNum; i ++){
			elevators[i] = new Elevator(totalFloor);
		}
	}


	up(int currFloor){
		//algorithm add this floor to closest elevator;
		for(int i = 0; i < elevatorNum; i ++){
			if(elevators[i].getCurrentFloor() == i && elevators[i].getStatus() == stand){
				elevators[i].setFloorRequest(floor);
				break;
			}
		}
		for(int i = 0; i < elevatorNum; i ++){
			if(elevators[i].getCurrentFloor() < floor && elevators[i].getStatus() == up){
				elevators[i].setFloorRequest(floor);
				break;
			}
		}
		for(int i = 0; i < elevatorNum; i ++){
			if(elevators[i].getStatus() == stand){
				elevators[i].setFloorRequest(floor);
				break;
			}
		}
		//pick the lightest one
	}

	down(int floor){
		//algorithm add this floor to closest elevator;
	}






}