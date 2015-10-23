package lsv.utils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.RecognitionException;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lsv.grammar.Formula;
import lsv.model.CTL;
import lsv.model.Model;
import lsv.model.State;
import lsv.model.Transition;

/**
 * The ModelGenerator is a class for generating the model. It allows the user to 
 * upload the model (i.e defined  a JSON file) into the application.
 * The ModelGenerator object provides the graph implementation and
 * the JSON object of the model input by the user.
 * An example of the JSON file for the model is shown in /data/model.json.
 * Each model has transitions and states. From both transitions and
 * states we generate a graph (i.e represented using an adjacent Matrix)
 * */
public class ModelGenerator {
	
	private Map<Integer, ArrayList<Transition>> graph;

	private Transition [] transitions;
	private State [] states;
	
	//added for Formula Alternatives;
	private Formula constraintAlt;
	
	private boolean kripke;
	
	public Map<Integer, ArrayList<Transition>> getGraph() {
		return this.graph;
	}


	public State[] getStates() {
		return this.states;
	}

	public Transition [] getTransitions() {
		return this.transitions;
	}
	
	public boolean isKripke() {
		return this.kripke;
	}

	

	public Formula getConstraintAlt() {
		return this.constraintAlt;
	}
    /** 
     * ModelGenerator constructor.
     * Generate the model graph (Using adjacent list) and the model object
     * from the input file given (e.g. /data/model.json)
     * @param filePath	filePath of the JSON file
     * @throws FileNotFoundException 
     */
	public ModelGenerator(String filePath) throws FileNotFoundException {
		Gson gson = new Gson();
		
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		Model model = gson.fromJson(br, Model.class);
		
		//Initialize
		this.states = model.getStates();
		this.transitions = model.getTransitions();
		this.graph = new HashMap<Integer,  ArrayList<Transition>>();
		boolean [] isKripke = new boolean[model.getStates().length];
		
		createGraph(model, isKripke, this);				
		checkKripke(isKripke, this);	
        //for the formula alt... 
        addConstraintAlt(filePath, this);
        	
	}


	//For the formula Alternatives...
	private static void addConstraintAlt(String filePath, ModelGenerator mg) throws FileNotFoundException {
		System.out.println("Generate Constraint into FormulaAlt object...");
		JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(new FileReader(filePath));
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        jsonObject = jsonObject.getAsJsonObject("constraint");
        if(jsonObject != null) {
	        CTL ctl = CTL.createCTL(jsonObject);
			try {
				mg.constraintAlt = SimpleParser.parseCTL(ctl.getFormula());
				Formula.addActions(ctl, mg.constraintAlt);
	
			} catch (RecognitionException e) {
				System.out.println("Unable to generate CTL formula:");
				e.printStackTrace();
			}
        }
	}

	

	private static void createGraph(Model model, boolean[] isKripke, ModelGenerator mg) {
		for(int i = 0; i < model.getTransitions().length; i++) {
			Transition curr = model.getTransitions()[i];
			isKripke[curr.getSource()] = true;
			if(mg.graph.containsKey(curr.getSource())) {
				mg.graph.get(curr.getSource()).add(curr);
			} else {
				mg.graph.put(curr.getSource(), new ArrayList<Transition>());
				mg.graph.get(curr.getSource()).add(curr);
			}
			
		}
	}

	private static void checkKripke(boolean[] isKripke, ModelGenerator mg) {
		mg.kripke = true;
		for(int i = 0; i < isKripke.length; i++) {
			if(!isKripke[i]) {
				mg.kripke = false;
				break;
			}
		}
	}
	
}
