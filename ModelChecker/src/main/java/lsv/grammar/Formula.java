package lsv.grammar;

/**
 * FormulaAlt class.
 * This is an alternatives option for parsing the CTL formula. 
 * It's more compact that the Formula class.
 * Example: AG( a && b)
 *          EF( b || AG (c) )
 *          EF( AG(c) || (b)) 
 *          Note that if a formula consist of an atomic preposition in the second place,
 *          a parenthesis is needed.
 *          A( a U AG ( c && b ) )
 * */
public class Formula {

	
	private Formula parent;

	private boolean negation;
	
	private String quantifier;
	
	private String operator;
	
	
	private String [] ap;
	private boolean [] apNeg;
	private boolean singleAp;


	private String [] tautology;
	private boolean singleTt;
	
	private Formula [] nestedCTL;	
	private String [][] actions;
	
	
	/**
	 * Returns the parents of the FormulaAlt, if the formula is a nested formula.
	 * Example: 
	 * 		For AF ( a U AG (c) ):
	 * 		> AG (c) is a nested formula.
	 * @return parent FormulaAlt
	 * */
	public Formula getParent() {
		return parent;
	}

	/**
	 * Returns the negation of the Formula
	 * Example:
	 *    For !EF (c):
	 *    > negation is true;
	 * @return negation identifier
	 * */
	public boolean isNegation() {
		return negation;
	}

	/**
	 * Returns the quantifier/ the temporal of the CTL formula
	 * Example: 
	 * 	  For EG ( a && b )
	 * 	  > quantifier = "EG"
	 * 	  For A ( a pUq b )
	 * 	  > quantifier = "A"
	 * @return quantifier of the formula
	 * */
	public String getQuantifier() {
		return quantifier;
	}

	/**
	 * Returns the array of the atomic preposition a formula may have.
	 * Example: 
	 * 	 For AF ( a || c ) 
	 * 	 > ap = ["a", "c"]
	 * @return list of atomic preposition listed in the formula (ap)
	 * */
	public String[] getAp() {
		return ap;
	}

	/**
	 * Returns the negation of the formula's atomic preposition
	 * Example: 
	 * 	 For AF ( !a && b )
	 * 	  > ap = ["a", "b"]
	 *    > apNeg = [true, false]
	 * @return the negation of the formula's atomic preposition
	 * */
	public boolean[] getApNeg() {
		return apNeg;
	}

	/**
	 * Returns true if the formula only consist of a single atomic preposition
	 * Example:
	 * 		For a
	 *  	> ap = ["a", null]
	 *      > singleAp = true;
	 * @return single atomic preposition identifier
	 * */
	public boolean isSingleAp() {
		return singleAp;
	}

	/**
	 * Returns the tautology of a formula
	 * Example:
	 * 	  For EF (True)
	 *    > tautology = ["True", null]
	 *    For A ( True yUz False )
	 *    > tautology = ["True", "False"]
	 * @return array of formula tautology
	 * */
	public String[] getTautology() {
		return tautology;
	}

	/**
	 * Returns True if a formula only consist of a single tautology (e.g. True, False)
	 * @return tautology identifier.
	 * */
	public boolean isSingleTt() {
		return singleTt;
	}

	/**
	 * Returns the nested formula 
	 * Example:
	 * 		AF( a && AG (c) )
	 * 		> ap = ["a", null] , nestedCTL = [null, AG(c)]
	 * @return nestedCTL, array of nested formula
	 * */
	public Formula[] getNestedCTL() {
		return nestedCTL;
	}

	/**
	 * Returns the action of a formula. 
	 * Example:
	 * 	 For A( a pUq b ); p = ["act", "act1"]; q = ["act2", "act3", "act4"]
	 *   > actions[0] = ["act", "act1"]
	 *   > actions[1] = ["act2", "act3", "act4"]
	 * @return the action of a formula the query input (e.g. /data/ctl.json)
	 * */
	public String[][] getActions() {
		return actions;
	}

	/**
	 * Returns the operator of a formula
	 * Example: 
	 * 	For AF ( a && b )
	 *  > operator = "&&"
	 *  For A  ( a pU b )
	 *  > operator = "U"
	 *  For EF ( a || b )
	 *  > operator = "||"
	 *  @return the operator of a formula
	 * */
	public String getOperator() {
		return operator;
	}
	
	
	//Formula constructor
	public Formula(String ap) {
		this.ap  = new String[2];
		this.apNeg = new boolean[2];
		putAp(ap, 0);
		singleAp = true;
		
	}
	
	public Formula(String temporal, String ap) {
		this.ap = new String[2];
		this.apNeg = new boolean[2];
		putAp(ap, 0);
		this.quantifier = temporal;
	}
	
	public Formula(String temporal, Formula formula) {
		initializeArrays();
		putFormula(formula, 0);
		this.quantifier = temporal;
	}
	

	public Formula(String ap, String ap2, String op) {
		this.ap  = new String[2];
		this.apNeg = new boolean[2];
		putAp(ap, 0);
		putAp(ap2, 1);
		this.operator = op;
	}
	
	public Formula(String ap, Formula formula2, String op) {
		initializeArrays();
		putFormula(formula2,1);
		putAp(ap, 0);
		this.operator = op;
		
	}
	
	
	public Formula(Formula formula, String ap2, String op) {
		initializeArrays();
		putFormula(formula,0);
		putAp(ap2, 1);
		this.operator = op;
		
	}
	
	
	public Formula(Formula formula, Formula formula2, String op) {
		initializeArrays();
		putFormula(formula,0);
		putFormula(formula2,1);
		this.operator = op;
		
	}
	
	
	public Formula(String quantifier, String ap, String ap2, String op) {
		this.quantifier = quantifier;
		initializeArrays();
		putAp(ap, 0);
		putAp(ap2, 1);
		this.operator = op;
	}
	
	public Formula(String quantifier, Formula formula, Formula formula2, String op) {
		this.quantifier = quantifier;
		initializeArrays();
		putFormula(formula,0);
		putFormula(formula2,1);
		this.operator = op;
	}
	
	public Formula(String quantifier, String ap, Formula formula2, String op) {
		this.quantifier = quantifier;
		initializeArrays();
		putAp(ap,0);
		putFormula(formula2,1);
		this.operator = op;
	}
	
	public Formula(boolean neg, Formula formula) {
		if(formula.negation == neg && formula.negation == true) {
			formula.negation = !formula.negation;
		} else {
			formula.negation = neg;
		}
	
		shallowCopy(formula);
		
	}

	
	
	//true or false (TAUTOLOGY)
	public Formula(boolean tautology) {
		this.tautology = new String[2];
		if(tautology) {
			this.tautology[0] = "True";	
		} else {
			this.tautology[0] = "False";
		}
		this.singleTt = true;
		
		

	}
	
	public static void addActions(CTL ctl, Formula formula) {
		formula.actions = new String[2][];
		if(formula.quantifier != null) {
			if(formula.quantifier.length() > 2) {
			
				//check the second...
				if(ctl.getActionMap().get(formula.quantifier.charAt(1)) != null) {
					formula.actions[0] = ctl.getActionMap().get(formula.quantifier.charAt(1));
				}
				//check the 3/4
				if(ctl.getActionMap().get(formula.quantifier.charAt(2)) != null) {
					formula.actions[1] = ctl.getActionMap().get(formula.quantifier.charAt(2));
				} 
				if(formula.quantifier.length() == 4) {
					formula.actions[1] = ctl.getActionMap().get(formula.quantifier.charAt(3));
				}
				formula.quantifier = formula.quantifier.replaceAll("[a-z]", "");
			}
		}
		if(formula.operator != null && formula.operator.length() > 1 && formula.operator.contains("U")) {
			if(ctl.getActionMap().get(formula.operator.charAt(0)) != null) {
				formula.actions[0] = ctl.getActionMap().get(formula.operator.charAt(0));
			}
			char last = formula.operator.charAt(formula.operator.length()-1);
			if (ctl.getActionMap().get(last) != null) {
				formula.actions[1] = ctl.getActionMap().get(last);
			}
			formula.operator = formula.operator.replaceAll("[a-z]", "");
		}
		
		if(formula.nestedCTL == null) return;
		for(int i = 0; i < formula.nestedCTL.length;i++) {
			if(formula.nestedCTL[i] != null) {
				addActions(ctl, formula.nestedCTL[i]);				
			}
		}
	}
	
	//HELPER FUNCTION
	private void putAp(String ap, int index) {
		if(ap.length()% 2 == 0) {
			apNeg[index] = true;	
		} 
		this.ap[index] = ap.charAt(ap.length()-1) + "";
	}
	

	private void putFormula(Formula formula, int index) {
		if(formula.singleAp) {
			putAp(formula.ap[0], index);
		} else if (formula.singleTt){
			this.tautology[index] = formula.tautology[0];
		} else {
			nestedCTL[index] = formula;
			formula.parent = this;
		}
	}
		
	private void initializeArrays() {
		this.ap  = new String[2];
		this.apNeg = new boolean[2];
		this.nestedCTL = new Formula[2];
		this.tautology = new String[2];
	}
	
	private void shallowCopy(Formula formula) {
		this.ap = formula.ap;
		this.negation = formula.negation;
		this.operator = formula.operator;
		this.quantifier = formula.quantifier;
		this.nestedCTL = formula.nestedCTL;
		this.tautology = formula.tautology;
		this.parent = formula.parent;
		this.singleAp = formula.singleAp;
		this.singleTt = formula.singleTt;
	}
	

	
}
