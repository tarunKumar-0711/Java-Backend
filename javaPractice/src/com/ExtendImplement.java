package com;

import java.util.Arrays;

interface C {
	public int addEl(int a, int b);

	public int addThree(int a, int b, int c);
}

abstract class A {
	public int addEl(int a, int b) {
		return a + b;
	}

//	abstract public int addThree(int a, int b, int c);
//	{
//		return a+b+c;
//	}
}

public class ExtendImplement extends A implements C {
	
	
	@Override
	public int addThree(int a, int b, int c) {
		return a + b + c;
	}

	public static void main(String args[]) {
		ExtendImplement obj = new ExtendImplement();
		System.out.println(obj.addThree(2, 03, 4));
		
		Integer[] b={10,20,30};
        System.out.println(Arrays.toString(b));
	}
}
