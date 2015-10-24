package lsv.model;

/**
 * The Model class is the template class for the model.json.
 * The properties of the object is adjusted to the JSON file (e.g. model.json)
 * The instance of Model is used to generate the graph used for implementing the
 * model checker. 
 * A model is consist of states and transitions
 * */
public class Model {
		State [] states;
		Transition [] transitions;
		
		/**
		 * Returns the list of the state
		 * @return list of state for the given model
		 * */
		public State[] getStates() {
			return states;
		}
		
		/**
		 * Returns the list of transition
		 * @return list of transition for the given model
		 * */
		public Transition[] getTransitions() {
			return transitions;
		}
		

}

