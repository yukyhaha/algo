package main.java.algo;

public class TestString {

	public String s;
	public TestString deepCopy(){
		TestString newClass = new TestString();
		newClass.s = s;
		return newClass;
	}
	
	public TestString() {
		// TODO Auto-generated constructor stub
		
	}
	
	public static void main(String args[]){
		TestString t = new TestString();
		t.s = "hello1";
		TestString copy = t.deepCopy();
		System.out.println(t.s);
		System.out.println(copy.s);
		t.s = "hello2";
		System.out.println(t.s);
		System.out.println(copy.s);
	}

}
