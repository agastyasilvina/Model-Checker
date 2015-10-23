package lsv.model;

import java.util.Arrays;

/**
 * The Transition class. 
 * a Transition has a source state and a target state.
 * Each transition may have a set of action to be performed. 
 * 
 * */
public class  Transition {
	private int source;
	private int target;
	private String [] actions;
	
	/**
	 * Returns the source state of a transition.
	 * @return the id (integer) of the source state
	 * */
	public int getSource() {
		return source;
	}
	/**
	 * Returns the target state of a transition.
	 * @return the id (integer) of the target state
	 * */
	public int getTarget() {
		return target;
	}
	/**
	 * Returns the set of action in a transition.
	 * @return a set of action.
	 * */
	public String[] getActions() {
		return actions;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.source+"-");
		sb.append(Arrays.toString(this.actions)+"-");
		sb.append(this.target);
		return sb.toString();
	}
	
}
