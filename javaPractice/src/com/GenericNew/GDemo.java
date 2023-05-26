package com.GenericNew;

public class GDemo {
	public static void main(String args[]) {
		Generic<Integer> obj = new Generic<>(10);
		obj.show();
		System.out.println(obj.getObj());
		
		
		Generic<String> obj1 = new Generic<>("tarun");
		obj1.show();
		System.out.println(obj1.getObj());
		
		Generic<Character> obj2 = new Generic<>('a');
		obj2.show();
		System.out.println(obj2.getObj());
	}
}
