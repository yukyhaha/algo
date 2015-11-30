package main.java.knowledge;

public class SingletonClass {

	private static SingletonClass singleInstance;
	private SingletonClass() {
		// TODO Auto-generated constructor stub
	}
	public synchronized SingletonClass getInstance(){
		if(singleInstance == null)
			singleInstance = new SingletonClass();
		
		return singleInstance;
		
	}

}
