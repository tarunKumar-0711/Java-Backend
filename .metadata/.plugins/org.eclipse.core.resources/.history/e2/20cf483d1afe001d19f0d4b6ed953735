package com;
import java.io.*;
import java.io.Serializable;
class Dog implements Serializable{
		int i=10;
		transient final int j=20;
}
public class SerializableN{
	public static void main (String[] args)throws IOException,ClassNotFoundException
	{
		Dog d1=new Dog();
		
		System.out.println("serialization started");
		FileOutputStream fos= new FileOutputStream("abc.ser");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(d1);
		System.out.println("Serialization ended");
	
		System.out.println("Deserialization started");
		FileInputStream fis=new FileInputStream("abc.ser");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Dog d2=(Dog) ois.readObject();
		System.out.println("Deserialization ended");
		System.out.println("Dog object data");
		System.out.println(d2.i+"\t" +d2.j);
	}
}

