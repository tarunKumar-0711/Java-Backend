package com.IOJava;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile {
	public static void main(String[] args) throws IOException{
//		File f = new File("/home/ctp/eclipse-workspace/javaPractice/src/com/IOJava/name.txt");
//		f.createNewFile();
		System.out.println("Hii");
		FileOutputStream fout = new FileOutputStream("name.txt",true);
		String s = "Tarun";
		
		char ch[] = s.toCharArray();
		
		for(int i=0;i<s.length();i++)
			fout.write(ch[i]);
		
		fout.close();
		
	}
}
