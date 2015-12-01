package main.java.design;

class Space{
	private int id;
	private int distanceToEntry;
	private boolean isAvailible;
	
	public Space(int id, int distanceToEntry){
		this.id = id;
		this.distanceToEntry = distanceToEntry;
		this.isAvailible = true;
	}
	
	/*getter/setter*/
	
}

public class ParkingLotsOneCarType {
	private static final int totalSpace = 5;	
	private Space[] spaces = new Space[totalSpace];
	private int availibleSpace;
	public void createSpaces(){
		for(int i = 0; i < totalSpace; i ++){
			spaces[i] = new Space(i, i);
		}
		availibleSpace = totalSpace;
	}
	
	public void heapify(Space[] spaces, int size, int index){
		
	}
	
	public void insertToHeap(Space[] spaces, int i){
		
	}
	
	public void parkCar(){
		Space s = spaces[0];
		spaces[0] = spaces[availibleSpace - 1];
		availibleSpace --;
		heapify(spaces, availibleSpace, 0);
		s.setIsAvailible(false);
	}
	
	public void unParkCar(Space s){
		spaces[availibleSpace] = s;
		insertToHeap(spaces, availibleSpace);
		s.setIsAvailible(true);
	}
	
	
}
