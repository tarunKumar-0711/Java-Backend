package javaPractice;
class Helper1{
	
	public int Multiply(int a,int b) {
		return a*b;
	}
}

class Helper2 extends Helper1{ 
	
	
	public int Multiply(int a,int b) {
		return a*b;
	}
}
public class DynamicPolymorphism {
	public static void main(String args[]) {
		Helper1 obj;
		
		obj = new Helper1();
		System.out.println(obj.Multiply(2,5));
		obj = new Helper2();
		System.out.println(obj.Multiply(2,3));
	}
}
