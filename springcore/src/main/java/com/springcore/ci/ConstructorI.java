package com.springcore.ci;
import java.util.*;

public class ConstructorI {
	private String name;
	private int personId;
	private C obj;
	private List<Integer> lst;
	
	public ConstructorI(String name ,int personId ,C obj ,List<Integer> lst) {
		this.name=name;
		this.personId=personId;
		this.obj=obj;
		this.lst = lst;
	}
	
	
	public ConstructorI() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString()
	{
		return this.name+" : "+this.personId+"{"+this.obj+"}"+lst;
	}
}
