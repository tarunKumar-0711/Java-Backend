package javaPractice;

public class StaticVariable {

	static int a = m1();
	
	static {
		System.out.println("Inside static block");
	}
	
	
	public static int m1() {
		System.out.println("Inside m1");
		return 20;
	}
	
	public static void main(String args[]) {
		System.out.println("Inside main");
		System.out.println("a = "+a);
	}
}
