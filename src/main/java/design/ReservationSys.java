import java.util.ArrayList;
import java.util.Hashtable;

class People{
	private String firstName;
	private String lastName;
	private int phoneNumber;
	
	public People(String firstName, String lastName, int phoneNumber){}
	
	/*setter/getter*/
}

class Reservation{
	private People people;
	private String time;
	private int partyNum;

	public Reservation(People people, String time, int partyNum){
		this.people = people;
		this.time = time;
		this.partyNum = partyNum;
	}

	/*getter/setter*/

}

public class ReservationSys{
	
	private Hashtable<Integer,Reservation> hashTable = new Hashtable<Integer, Reservation>();

	
	
	public void addReservation(String firstName, String lastName, int phoneNumber, String time, int partyNum){
		People people = new People(firstName, lastName, phoneNumber);
		Reservation res = new Reservation(people, time, partyNum);
		hashTable.put(phoneNumber, res);
	}

	public void delReservation(Reservation reservation){
		int phoneNum = reservation.getPoeple().getPhonenum();
		if(hashTable.containsKey(phoneNum))
			hashTable.remove(phoneNum);

	}

	public Reservation getReservation(int phoneNum){
		if(hashTable.containsKey(phoneNum))
			hashTable.remove(phoneNum);
	}

}



