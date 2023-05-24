package com.Collections;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.LinkedBlockingDeque;

public class ListIteratorNew {
	public static void main(String args[]) {
		LinkedList lL = new LinkedList();
		lL.add("A");
		lL.add("B");
		lL.add("C");
		lL.add("D");
		System.out.println(lL);
		ListIterator itr = lL.listIterator();
		while(itr.hasNext()) {
			String s = (String)itr.next();
			if(s.equals("A"))
				itr.remove();
			else if(s.equals("D"))
				itr.add("R");
			else if(s.equals("C"))
				itr.set("F");
		}
		System.out.println(lL);
	}
}
