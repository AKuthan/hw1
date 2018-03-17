package DataAccessLayer;
//210201016 Ahmet Kuthan Temimhan
//210201008 Caner Karagüler
//Ceng 431 HW1

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import Business.PatientNeeds;


public class DataAccessLayer {
	public DataAccessLayer(){
	
	}
	public Map<PatientNeeds, Integer> readFile(){
		try {
			BufferedReader buff = new BufferedReader(new FileReader("data.txt"));
			Map<PatientNeeds, Integer> map=new HashMap<PatientNeeds, Integer>();
			String line;
			while((line = buff.readLine())!=null){
				String[] keyvalue=line.split("\\%");
				
				map.put(PatientNeeds.valueOf(keyvalue[0]),Integer.parseInt(keyvalue[1]));

			}
			buff.close();
			return  map;
		} catch (Exception e) {
			System.err.println("There is a problem in reading file");
			System.exit(-1);
		}
		return null;
		
	}
}