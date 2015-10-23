package lsv.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * The CTL class is the template class for the JSON file 
 * of the CTL formula for the model. The properties
 * of the object is adjusted to the JSON file. (e.g. /data/ctl.json)
 * The instance of CTL is used by the parser to generate a Formula 
 * object
 * 
 * */
public class CTL {

	String formula;
	Map <Character, String []> actionMap;
	
	public String getFormula() {
		return formula;
	}

	public Map<Character, String[]> getActionMap() {
		return actionMap;
	}
	
	public CTL(String formula, Map<Character,String[]> actionMap) {
		this.formula = formula;
		this.actionMap = actionMap;
	}
	
	/**
	 * Returns an instance of CTL generated from a JSON file (e.g /data/ctl.json)
	 * @param filePath the path of the JSON file.
	 * @return CTL object 
	 * */
	public static CTL createCTL(String filePath) throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		 Gson gson = new Gson();
		 CTL result = null;
		 String formula = "";
		 Map<Character, String[]> actionMap = new HashMap<>();
	            JsonParser parser = new JsonParser();
	            JsonElement jsonElement = parser.parse(new FileReader(filePath));
	            JsonObject jsonObject = jsonElement.getAsJsonObject();
	            
	            formula = jsonObject.get("formula").getAsString();
	            System.out.println(formula);
	            for(int i = 97; i < 123; i++) {
					String [] str = gson.fromJson(jsonObject.get((char) i+""), String[].class);
					if(str != null) {
						actionMap.put((char) i, str);
					}
	            }   
	            
	            result = new CTL(formula, actionMap);
		  return result;
	}
	
	/**
	 * Returns an instance of CTL generated from a JSON object 
	 * @param filePath the path of the JSON object that represent a CTL Formula
	 * @return CTL object 
	 * */
	public static CTL createCTL(JsonObject jsonObject) {
		 Gson gson = new Gson();
		 CTL result = null;
		 String formula = "";
		 Map<Character, String[]> actionMap = new HashMap<>();
	     formula = jsonObject.get("formula").getAsString();
	     System.out.println(formula);
	        for(int i = 97; i < 123; i++) {
	        	String [] str = gson.fromJson(jsonObject.get((char) i+""), String[].class);
				if(str != null) {
					actionMap.put((char) i, str);
			}
	      }   
	      result = new CTL(formula, actionMap);
		  return result;
	}
	

	
}
