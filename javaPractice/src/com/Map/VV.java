package com.Map;

class check {

	@Override
	protected void finalize() throws Throwable {
		System.out.println("HELLO");
	}
	
}

public class VV {

	// Java program to demonstrate working of finalize()

	public static void main(String[] args) {
		Integer t = new Integer(3);
		VV v = new VV();
		check c = new check();
		System.out.println(t.hashCode());
		c = null;
		t = null;
		v = null;
		// calling garbage collector
		System.gc();

		System.out.println("end");
	}

	@Override
	protected void finalize() {
		System.out.println("finalize method called");
	}

}
