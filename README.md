Readme for Model Checker 
University of St Andrews
School of Computer Science

September, 2015

1. Introduction
2. Installation
3. CTL Formula Parser

1. Introduction
===============
The Model Checker project is a project to implement a simple model checker.
This model checker consists of several components, 
```
	1) Model Generator 
	   The model generator generates the model into an object of 2D graph. 
	   The graph (i.e. represented as an adjacent list) is created for generating
	   all possible pathways from an initial state. A model may have several
	   initial states. The model generator takes a JSON file (e.g. /data/json) as an input. 
	  "model.json"
	  The model.json is a JSON file that contains a model object. 
	  The model object consist of states,  transitions. It may also have a constraint to 
	  enforce fairness.
	  
	  a state consist of boolean "init" to determine whether the current state
	  is an initial state, integer "name", the "name" is used to give a unique id
	  of a model. The name of the state need to be unique starting from 0
	  (e.g. 0,1,2,3). The model generator assumes that the states obtained
	  from the "model.json" file is unique (i.e. form a sequence from 0 to n states).
	  A state also has an array of "label". Label is an array that acts 
	  as a placeholder for the atomic prepositions (APs) of the current state. 
	  If a state has no atomic preposition the label may be omitted.
	 
	  A transition has a source state (i.e. "source") and a target state (i.e. "target"). 
	  A transition may have actions. If a transition has no action, the actions may be omitted.
	  
	  A constraint in the model is used to enforced fairness. Basically, a constraint is
	  a CTL formula. It may have actions as well. If a model doesn't have constraint, 
	  the constraint may be omitted. (e.g. /data/modelNoConstraint.json)
	  
	2) CTL Parser
	   A CTL parser is a program used to parse a CTL formula to a Formula object used in 
	   this model checker. Using a model checker, a formula for the model can be verified.
	   The CTL Parser takes an input of a JSON file (e.g. /data/ctl.json). The file 
	   contains a formula and actions. The set of action for the action based -CTL 
	   is represented as a Map with small-letter case as its key. 
	   Example:
	   "AaFb"
	   a : [act, act1, act2]
	   b : [act2, act3, act4]
	   
	3) Path Generator and Verifier
	   A path generator is used to generate all possible path for the input model. 
	   Once generated, a formula can be tested against the pathways using a verifier.  
```

2. Installation
================
Note that this Model Checker will not run without Java installed on the host
system. Java can be download from http://java.sun.com.

To run the program, all the libraries (e.g. gson, antlr) are needed. 
The libraries need can be added manually to the project. By default, it's managed 
by a build automation tool. (i.e. gradle)

There is no need to install antlr as the parser and lexer has been generated.
The Antlr library is needed during runtime. (i.e. FormulaLexer.java & FormulaParser.java)
for the CTL formula based on the Formula.g. 

If you are using eclipse or other java IDE, you can import the project to the IDE.
	  
3. CTL Formula Parser
======================
The CTL parser we use in this model is implemented using Antlr 3.X, 
There are two different parsers available to use for this project based on its grammar 
(i.e. Formula.g). Detail of how the CTL is being parse is as below:

Example:
```
	> ApFq ( a && b ); p = ["act", "act2"]; q = ["act3", "act4"]
		quantifier = "AF"
		ap = {a,b}
		operator = "&&"
	> A ( a U AG (c) )
		quantifier = "A"
		ap = {a}
		nestedCTL = {AG (c)}
```
