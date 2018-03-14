import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class DataAccessLayer {
	public DataAccessLayer(){
	
	}
	public Map<PatientNeeds, Integer> readFile() throws IOException{
		BufferedReader buff = new BufferedReader(new FileReader("data.txt"));
		Map<PatientNeeds, Integer> map=new HashMap<PatientNeeds, Integer>();
		String line;
		while((line = buff.readLine())!=null){
			String[] keyvalue=line.split("\\%");
			
			map.put(PatientNeeds.valueOf(keyvalue[0]),Integer.parseInt(keyvalue[1]));

		}
		buff.close();
		return  map;
	}
}