package javaPractice;

class Helper{
	public static int Multiply(int a,int b) {
		return a*b;
	}
	
	public static double Multiply(double a,double b) {
		return a*b;
	}
	
	public static int Multiply(int a,int b, int c) {
		return a*b*c;
	}
}

public class StaticPolymorphism {
	
	public static void main(String args[]) {
		
		System.out.println(Helper.Multiply(2,4));
		System.out.println(Helper.Multiply(2.0,4.3));
		System.out.println(Helper.Multiply(2,4,4));
	}
}
