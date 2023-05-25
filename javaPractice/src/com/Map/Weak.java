package com.Map;

import java.util.HashMap;
import java.util.WeakHashMap;

class Testing {

	@Override
	public String toString() {
		return "Key";
	}

}

public class Weak {

	public static void main(String[] args) {
		Testing testing = new Testing();
//		HashMap<Testing, String> map = new HashMap<>();
		WeakHashMap<Testing, String> map = new WeakHashMap<>();
		map.put(testing, "HelloWorld!!");
		System.out.println(map);
		testing = null;
		System.gc();
		System.out.println(map);
	
	}
}