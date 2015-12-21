package main.java.algo;

public class TestString {

	public String s;
	
	public void change(TestString t){
		t.s = "hello2";
	}
	
	public TestString() {
		// TODO Auto-generated constructor stub
		
	}
	
	public static void main(String args[]){
		TestString test = new TestString();
		test.s = "hello";
		test.change(test);
		System.out.println(test.s);
	}

}
