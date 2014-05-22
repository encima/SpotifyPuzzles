package com.encima.spotify;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class ReverseBinary{
 
	public static void main (String args[]) {
 
	try{
		BufferedReader br = 
                      new BufferedReader(new InputStreamReader(System.in));
 
		String input;
 
		while((input=br.readLine())!=null){
			int userInt = Integer.parseInt(input);
			String userBin = Integer.toBinaryString(userInt);
			StringBuilder userRev = new StringBuilder(userBin);
			userRev = userRev.reverse();
			System.out.println(Integer.parseInt(userRev.toString(), 2));
		}
 
	}catch(IOException io){
		io.printStackTrace();
	}	
  }
}