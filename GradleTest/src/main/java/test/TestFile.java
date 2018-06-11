package test;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestFile {

	public static void main(String[] args) {
		String path = args[0];
    	try {
			loadFile(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void loadFile(String path)throws IOException{
	final String FILENAME = path;
	ArrayList<EventData> al = new ArrayList<EventData>();
	HashMap<Integer,EventData> itrList = new HashMap<Integer,EventData>();
	BufferedReader br;
	Integer key=0;
	try {
		br = new BufferedReader(new FileReader(FILENAME));

		String sCurrentLine;
		while ((sCurrentLine = br.readLine()) != null) {
			//System.out.println(sCurrentLine);
			ObjectMapper mapper = new ObjectMapper();
			EventData obj = mapper.readValue(sCurrentLine, EventData.class);
			System.out.println("obj.getId() = " + obj.getId());
			System.out.println("obj.getId() = " + obj.getTimestamp());
			itrList.put(key, obj);
			key++;
		}
		
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	for(int i=0; i<itrList.size();i++){
		
		for(int j=i+1; j<itrList.size();j++){
			
			if(itrList.get(i).getId().equals(itrList.get(j).getId())){
			
			long absoluteDiff=Math.abs((itrList.get(i).getTimestamp()-itrList.get(j).getTimestamp()));
			System.out.println("obj id"+itrList.get(i).getId()+" abs time diff "+absoluteDiff);
			EventData obj=new EventData();
			if(absoluteDiff>4){
			obj=itrList.get(i);
			obj.setTimestamp(absoluteDiff);
			obj.setAlert(true);
			al.add(obj);
			}
		
			break;
		}
	
	}
	}
	
	alertEvents.inserAlertedEvents(al);
	
	}
	
}

