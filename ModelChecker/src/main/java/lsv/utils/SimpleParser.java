package lsv.utils;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import lsv.grammar.Formula;
import lsv.grammar.FormulaLexer;
import lsv.grammar.FormulaParser;


/**
 * A CTL Formula parser (Alternatives).
 * The SimpleParser parses the CTL formula provided by the user 
 * from a JSON file (e.g. /data/ctl.json) and generates 
 * an instance of Formula. The Parser and the Lexer is generated
 * using Antlr version 3.x. The Grammar used is shown in /grammar/FormulaAlt.g
 * 
 * */
public class SimpleParser {
	
	/**
	 * Returns the formula generate from the CTL query.
	 * 
	 * @param	input	CTL Query (e.g. "AF(a && AG (a || A(a U b)))" )
	 * @return 	a Formula object 
	 * */
	public static Formula parseCTL(String input) throws RecognitionException {
		ANTLRStringStream in = new ANTLRStringStream(input);
        FormulaLexer lexer = new FormulaLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FormulaParser parser = new FormulaParser(tokens);
        Formula form = parser.query();
        return form;
	}

}
