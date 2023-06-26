package com.features;

import java.util.stream.IntStream;

public class Class1 {
	public static void main(String args[]) {
		 int total = IntStream.rangeClosed(0,50).map(Integer :: new)
				 .sum();
		 
		 System.out.println(total);
	}
}
