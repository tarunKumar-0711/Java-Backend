package com.GenericNew;

public class Generic<T>{
	T obj;
	public Generic(T obj) {
		this.obj=obj;
	}
	
	public void show() {
		System.out.println("The type of object is "+ obj.getClass().getName());
	}
	public T getObj() {
		return obj;
	}
	
}
