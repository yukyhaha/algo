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

//no synchronized keyworkd version----------------------------------------------------------
public class Singleton {
private Singleton() {}

private static class SingletonHolder { 
    private static final Singleton INSTANCE = new Singleton();
}

public static Singleton getInstance() {
    return SingletonHolder.INSTANCE;
}
}