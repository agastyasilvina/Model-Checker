package lsv.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import lsv.model.State;
import lsv.model.Transition;


public class ModelGeneratorTest {

    private ModelGenerator model;
    
    @Before
    public void before() throws Throwable {
        String modelFilePath = "src/test/resources/model.json";
        model = new ModelGenerator(modelFilePath);
    };
    

    @Test 
    public void ModelConstructorTest() throws FileNotFoundException {
        assertNotNull(model);
    }
    
    @Test 
    public void getGraph() {
    	Map<String, ArrayList<Transition>> graph =  model.getGraph();
    	assertEquals(graph.size(), 3);
    	assertEquals(graph.get("s0").get(0).getActions()[0], "act");   	
    }
    
    @Test
    public void getStates() {
    	State [] states = model.getStates();
    	assertEquals(states[0].getName(),"s0");
    	assertTrue(states[0].isInit());
    	assertTrue(states[0].getLabel()[0].equalsIgnoreCase("a"));  	
    }
    
    @Test
    public void getTransitions() {
    	Transition [] transitions = model.getTransitions();
    	assertEquals(transitions.length, 4);
    	assertEquals(transitions[0].getSource(), "s0");
    	assertEquals(transitions[1].getTarget(), "s2");
    }
    
    @Test
    public void isKripke() {
    	assertTrue(model.isKripke());
    	System.out.println();
    }
    
    @Test 
    public void getConstraint() {
    	assertNotNull(model.getConstraint());
    }
    
    

}
