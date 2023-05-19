package javaPractice;

public class StaticFinal {
	static int a = 10;
	static int b;
	
	static {
		System.out.println("Inside Static block");
		b=a*4;
	}
	
	public static void main(String[] args) {
		System.out.println("From main");
		System.out.println("a = "+a);
		System.out.println("b = "+b);
		
	}

}
