package com.Collections;
import java.util.*;
public class NewLl {
	public static void main(String[] args)
    {
        int n = 5;
 
  
        List<Integer> ll = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++)
            ll.add(i);
 

        System.out.println(ll);
        ll.remove(3);
 
        System.out.println(ll);
 
        for (int i = 0; i < ll.size(); i++)
            System.out.print(ll.get(i) + " ");
    }
}
