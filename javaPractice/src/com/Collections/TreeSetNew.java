package com.Collections;

import java.util.TreeSet;

public class TreeSetNew {
	public static void main(String args[]) {
		TreeSet t = new TreeSet();
		//t.add(null);null pointer exception
//		t.add(new StringBuffer("Q"));
//		t.add(new StringBuffer("D"));
//		t.add(new StringBuffer("T"));
//		t.add(new StringBuffer("W"));
//		t.add(new StringBuffer("A"));
//		System.out.println("A".compareTo(null));
		System.out.println("A".compareTo("A"));
		System.out.println("A".compareTo("Z"));
		System.out.println("Z".compareTo("G"));
		System.out.println(t);
	}
}
