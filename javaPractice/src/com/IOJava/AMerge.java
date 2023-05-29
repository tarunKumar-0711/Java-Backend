package com.IOJava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class AMerge {
	public static void main(String[] args) throws IOException{
		PrintWriter pw = new PrintWriter("/home/ctp/eclipse-workspace/javaPractice/src/com/IOJava/C.txt");
		BufferedReader br1 = new BufferedReader(new FileReader("/home/ctp/eclipse-workspace/javaPractice/src/com/IOJava/A.txt"));
		String line1 = br1.readLine();
		BufferedReader br2 = new BufferedReader(new FileReader("/home/ctp/eclipse-workspace/javaPractice/src/com/IOJava/B.txt"));
		String line2 = br2.readLine();
		
		while((line1!=null) || (line2!=null)) {
			if(line1!=null) {
				pw.println(line1);
				line1=br1.readLine();
			}
			
			if(line2!=null) {
				pw.println(line2);
				line2=br2.readLine();
			}
		}
		pw.flush();
		br1.close();
		br2.close();
		pw.close();
	}
}
