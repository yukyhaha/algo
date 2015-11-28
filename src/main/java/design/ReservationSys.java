public Class Reservation{
	public int people;
	public Date time;
	public String name;

	public Reservation(int name, Date time, String people){
		this.people = people;
		this.time = time;
		this.name = name;
	}



}

public class ReservationSys{
	
	private HashTable<String,ArrayList<Reservation>> hashTable = new HashTable<String, ArrayList<Reservation>>();

	public void addReservation(int name, Date time, String people){

		ArrayList<Reservaton> list = new ArrayList<Reservation>();
		list.add(new Reservation(name, time, people));
		hashTable.add(name, list);
	}

	public void delReservation(Reservation reservation){
			ArrayList<Reservaton> list = hashTable.get(reservation.name);
			int size = list.size();
			for(int i = 0; i < size; i ++){
				Reservation res = list.get(i);
				if(res.time.equals(reservation.time) && res.people.equals(reservation.people)){
					list.remove(i);
				}
			}
				
	}

	public ArrayList<Reservaton> getReservation(String name){
		return hashTable.get(name);
	}

}



