package main.java.design;

import java.util.ArrayList;
import java.util.Arrays;

enum carType{
	motoType,
	regularType,
	truckType
}

class ParkingSlot{
	int id;
	boolean available;
	String position;
	carType type;
	public ParkingSlot(){}
	public carType getCarType(){
		return this.type;
	}
}

public class ParkingLots {
	static int totalSlots = 20;
	static int motoSlots = 2;
	static int normalSlots = 15;
	static int truckSlots = 3;
	
	ParkingSlot[] moto = new ParkingSlot[motoSlots];//false means no car;
	ParkingSlot[] regular = new ParkingSlot[normalSlots];
	ParkingSlot[] truck = new ParkingSlot[truckSlots];
	
	ArrayList<ParkingSlot> availableMoto = new ArrayList<ParkingSlot>(Arrays.asList(moto));
	ArrayList<ParkingSlot> availableRegular = new ArrayList<ParkingSlot>(Arrays.asList(regular));
	ArrayList<ParkingSlot> availableTruck = new ArrayList<ParkingSlot>(Arrays.asList(truck));

	public ParkingSlot carRequest(carType e){
		if(e == carType.motoType){
			 if(availableMoto.isEmpty()){
				 System.out.println("no car available");
				 return null;
			 }else{
				 return availableMoto.remove(0);
			 }
		}
		
		/*
		 * do the same to normal and truck
		 * */
		return null;
	}
	
	public void carLeft(ParkingSlot p){
		if(p.getCarType() == carType.motoType){
			availableMoto.add(p);
		}
		
		/*
		 * do the same to normal and truck
		 * */
	}


}
