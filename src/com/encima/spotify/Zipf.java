package com.encima.spotify;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class Zipf {

	public static void main(String[] args) {
		try{
			BufferedReader br = 
	                      new BufferedReader(new InputStreamReader(System.in));
	 
			String input;
			int albumLength = -1;
			int retNo = -1;
			int track = -1;
			Vector<Integer> plays = new Vector<Integer>();
			Vector<String> songs = new Vector<String>();
			Map<Double, String> qis = new HashMap<Double, String>();
			
			while((input=br.readLine())!=null) {
				String[] values = input.split(" ");	
				if(values.length == 2) {
					albumLength = Integer.parseInt(values[0]);
					retNo = Integer.parseInt(values[1]);
					track = 0;
					break;
				}else{
					System.err.println("2 values needed");
				}
			}
			
			while((input=br.readLine())!=null && track < albumLength) {
				String[] values = input.split(" ");
				if(values.length == 2) {
					plays.add(Integer.parseInt(values[0]));
					songs.add(values[1]);
					track++;
				}else{
					System.err.println("2 values needed");
				}
				if(track == albumLength) break;
			}
			
			for(int i = 0; i < plays.size(); i++) {
				String song = songs.get(i);
				int fi1 = plays.get(i);
				int pos = i+1;
				double zi = (double) (plays.get(0)/pos);
				double qi = (double) (fi1/zi);
				qis.put(qi, song);
			}
			
			Map<Double, String> treeMap = new TreeMap<Double, String>(qis).descendingMap();
			Iterator<Double> keys = treeMap.keySet().iterator();
			int i = 0;
			while(keys.hasNext() && i < retNo) {
				System.out.println(treeMap.get(keys.next()));
				i++;
			}
			
			
	 
		}catch(IOException io){
			io.printStackTrace();
		}	

	}

}
