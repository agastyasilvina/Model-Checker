package lsv.model;

/**
 * The state represent a state of a model.
 * a state has a name (i.e. represented using an integer)
 * It has the Array of label and a identifier whether
 * a certain state is an initial state. 
 * 
 * */
public class State {
	private boolean init;
	private int name;
	private String [] label;
	
	/**
	 * Returns the identifier for an initial state
	 * @return boolean init 
	 * */
	public boolean isInit() {
		return init;
	}
	
	/**
	 * Returns the name of the state
	 * @return integer name 
	 * */
	public int getName() {
		return name;
	}
	
	/**
	 * Returns the label of the state
	 * @return Array of string label
	 * */
	public String[] getLabel() {
		return label;
	}
	
}