package com.Collections;

import java.util.*;

public class EnumerationNew {
	public static void main(String args[]) {
		Vector vector = new Vector();
		vector.addElement(1);
		vector.addElement(2);
		vector.addElement(57);
		for(int i=3;i<10;i++) {
			vector.add(i);
		}
		
		Enumeration<Integer> e = vector.elements();
		while(e.hasMoreElements()) {
			Integer a = (Integer)e.nextElement();
			System.out.println(a);
		}
		
		System.out.print(vector);
	}
}
