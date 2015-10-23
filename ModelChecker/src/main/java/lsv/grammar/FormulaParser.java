package lsv.grammar;

// $ANTLR 3.5.2 /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g 2015-10-22 22:33:30

import org.antlr.runtime.*;

import antlr.NoViableAltException;
import antlr.Parser;
import antlr.RecognitionException;
import antlr.Token;
import antlr.TokenStream;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/**
*This is an Antlr grammar used to generate the parser and lexer
*/
@SuppressWarnings("all")
public class FormulaParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALL", "ATOMIC", "CLOSE", "EXISTS", 
		"FALSE", "OPEN", "TEMPORAL", "TRUE", "UNTIL", "WS", "'!'", "'&&'", "'<=>'", 
		"'=>'", "'||'"
	};
	public static final int EOF=-1;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int ALL=4;
	public static final int ATOMIC=5;
	public static final int CLOSE=6;
	public static final int EXISTS=7;
	public static final int FALSE=8;
	public static final int OPEN=9;
	public static final int TEMPORAL=10;
	public static final int TRUE=11;
	public static final int UNTIL=12;
	public static final int WS=13;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public FormulaParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public FormulaParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return FormulaParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g"; }



	// $ANTLR start "query"
	// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:11:1: query returns [Formula result] : formula EOF ;
	public final Formula query() throws RecognitionException {
		Formula result = null;


		Formula formula1 =null;

		try {
			// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:11:31: ( formula EOF )
			// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:11:33: formula EOF
			{
			pushFollow(FOLLOW_formula_in_query30);
			formula1=formula();
			state._fsp--;

			match(input,EOF,FOLLOW_EOF_in_query32); 
			 result = formula1;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "query"



	// $ANTLR start "formula"
	// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:13:1: formula returns [Formula result] : ( TRUE | FALSE | OPEN first ( op_bool second )? CLOSE | OPEN first op_bool ctl_end CLOSE | neg ctl_init | OPEN ctl_init ( op_bool ctl_end )? CLOSE | EXISTS OPEN first UNTIL second CLOSE | ALL OPEN first UNTIL second CLOSE | EXISTS OPEN first UNTIL ctl_end CLOSE | ALL OPEN first UNTIL ctl_end CLOSE | EXISTS OPEN ctl_init UNTIL ctl_end CLOSE | ALL OPEN ctl_init UNTIL ctl_end CLOSE | TEMPORAL OPEN first op_bool second CLOSE | TEMPORAL OPEN first CLOSE | TEMPORAL OPEN first op_bool ctl_end CLOSE | TEMPORAL OPEN ctl_init ( op_bool ctl_end )? CLOSE );
	public final Formula formula() throws RecognitionException {
		Formula result = null;


		Token UNTIL15=null;
		Token UNTIL18=null;
		Token UNTIL21=null;
		Token UNTIL24=null;
		Token UNTIL27=null;
		Token UNTIL30=null;
		Token TEMPORAL31=null;
		Token TEMPORAL35=null;
		Token TEMPORAL37=null;
		Token TEMPORAL41=null;
		String first2 =null;
		String second3 =null;
		ParserRuleReturnScope op_bool4 =null;
		String first5 =null;
		Formula ctl_end6 =null;
		ParserRuleReturnScope op_bool7 =null;
		boolean neg8 =false;
		Formula ctl_init9 =null;
		Formula ctl_init10 =null;
		Formula ctl_end11 =null;
		ParserRuleReturnScope op_bool12 =null;
		String first13 =null;
		String second14 =null;
		String first16 =null;
		String second17 =null;
		String first19 =null;
		Formula ctl_end20 =null;
		String first22 =null;
		Formula ctl_end23 =null;
		Formula ctl_init25 =null;
		Formula ctl_end26 =null;
		Formula ctl_init28 =null;
		Formula ctl_end29 =null;
		String first32 =null;
		String second33 =null;
		ParserRuleReturnScope op_bool34 =null;
		String first36 =null;
		String first38 =null;
		Formula ctl_end39 =null;
		ParserRuleReturnScope op_bool40 =null;
		Formula ctl_init42 =null;
		Formula ctl_end43 =null;
		ParserRuleReturnScope op_bool44 =null;

		try {
			// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:13:33: ( TRUE | FALSE | OPEN first ( op_bool second )? CLOSE | OPEN first op_bool ctl_end CLOSE | neg ctl_init | OPEN ctl_init ( op_bool ctl_end )? CLOSE | EXISTS OPEN first UNTIL second CLOSE | ALL OPEN first UNTIL second CLOSE | EXISTS OPEN first UNTIL ctl_end CLOSE | ALL OPEN first UNTIL ctl_end CLOSE | EXISTS OPEN ctl_init UNTIL ctl_end CLOSE | ALL OPEN ctl_init UNTIL ctl_end CLOSE | TEMPORAL OPEN first op_bool second CLOSE | TEMPORAL OPEN first CLOSE | TEMPORAL OPEN first op_bool ctl_end CLOSE | TEMPORAL OPEN ctl_init ( op_bool ctl_end )? CLOSE )
			int alt4=16;
			switch ( input.LA(1) ) {
			case TRUE:
				{
				alt4=1;
				}
				break;
			case FALSE:
				{
				alt4=2;
				}
				break;
			case OPEN:
				{
				int LA4_3 = input.LA(2);
				if ( (LA4_3==ATOMIC) ) {
					switch ( input.LA(3) ) {
					case 15:
						{
						int LA4_13 = input.LA(4);
						if ( (LA4_13==ATOMIC) ) {
							alt4=3;
						}
						else if ( (LA4_13==ALL||(LA4_13 >= EXISTS && LA4_13 <= TRUE)||LA4_13==14) ) {
							alt4=4;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 4, 13, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case 18:
						{
						int LA4_14 = input.LA(4);
						if ( (LA4_14==ATOMIC) ) {
							alt4=3;
						}
						else if ( (LA4_14==ALL||(LA4_14 >= EXISTS && LA4_14 <= TRUE)||LA4_14==14) ) {
							alt4=4;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 4, 14, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case 17:
						{
						int LA4_15 = input.LA(4);
						if ( (LA4_15==ATOMIC) ) {
							alt4=3;
						}
						else if ( (LA4_15==ALL||(LA4_15 >= EXISTS && LA4_15 <= TRUE)||LA4_15==14) ) {
							alt4=4;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 4, 15, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case 16:
						{
						int LA4_16 = input.LA(4);
						if ( (LA4_16==ATOMIC) ) {
							alt4=3;
						}
						else if ( (LA4_16==ALL||(LA4_16 >= EXISTS && LA4_16 <= TRUE)||LA4_16==14) ) {
							alt4=4;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 4, 16, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case CLOSE:
						{
						alt4=3;
						}
						break;
					default:
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 4, 8, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}
				else if ( (LA4_3==ALL||(LA4_3 >= EXISTS && LA4_3 <= TRUE)||LA4_3==14) ) {
					alt4=6;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 14:
				{
				alt4=5;
				}
				break;
			case EXISTS:
				{
				int LA4_5 = input.LA(2);
				if ( (LA4_5==OPEN) ) {
					int LA4_10 = input.LA(3);
					if ( (LA4_10==ATOMIC) ) {
						int LA4_18 = input.LA(4);
						if ( (LA4_18==UNTIL) ) {
							int LA4_25 = input.LA(5);
							if ( (LA4_25==ATOMIC) ) {
								alt4=7;
							}
							else if ( (LA4_25==ALL||(LA4_25 >= EXISTS && LA4_25 <= TRUE)||LA4_25==14) ) {
								alt4=9;
							}

							else {
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 4, 25, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 4, 18, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}
					else if ( (LA4_10==ALL||(LA4_10 >= EXISTS && LA4_10 <= TRUE)||LA4_10==14) ) {
						alt4=11;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 4, 10, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 5, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case ALL:
				{
				int LA4_6 = input.LA(2);
				if ( (LA4_6==OPEN) ) {
					int LA4_11 = input.LA(3);
					if ( (LA4_11==ATOMIC) ) {
						int LA4_20 = input.LA(4);
						if ( (LA4_20==UNTIL) ) {
							int LA4_26 = input.LA(5);
							if ( (LA4_26==ATOMIC) ) {
								alt4=8;
							}
							else if ( (LA4_26==ALL||(LA4_26 >= EXISTS && LA4_26 <= TRUE)||LA4_26==14) ) {
								alt4=10;
							}

							else {
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 4, 26, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 4, 20, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}
					else if ( (LA4_11==ALL||(LA4_11 >= EXISTS && LA4_11 <= TRUE)||LA4_11==14) ) {
						alt4=12;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 4, 11, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 6, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case TEMPORAL:
				{
				int LA4_7 = input.LA(2);
				if ( (LA4_7==OPEN) ) {
					int LA4_12 = input.LA(3);
					if ( (LA4_12==ATOMIC) ) {
						switch ( input.LA(4) ) {
						case 15:
							{
							int LA4_27 = input.LA(5);
							if ( (LA4_27==ATOMIC) ) {
								alt4=13;
							}
							else if ( (LA4_27==ALL||(LA4_27 >= EXISTS && LA4_27 <= TRUE)||LA4_27==14) ) {
								alt4=15;
							}

							else {
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 4, 27, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case 18:
							{
							int LA4_28 = input.LA(5);
							if ( (LA4_28==ATOMIC) ) {
								alt4=13;
							}
							else if ( (LA4_28==ALL||(LA4_28 >= EXISTS && LA4_28 <= TRUE)||LA4_28==14) ) {
								alt4=15;
							}

							else {
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 4, 28, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case 17:
							{
							int LA4_29 = input.LA(5);
							if ( (LA4_29==ATOMIC) ) {
								alt4=13;
							}
							else if ( (LA4_29==ALL||(LA4_29 >= EXISTS && LA4_29 <= TRUE)||LA4_29==14) ) {
								alt4=15;
							}

							else {
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 4, 29, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case 16:
							{
							int LA4_30 = input.LA(5);
							if ( (LA4_30==ATOMIC) ) {
								alt4=13;
							}
							else if ( (LA4_30==ALL||(LA4_30 >= EXISTS && LA4_30 <= TRUE)||LA4_30==14) ) {
								alt4=15;
							}

							else {
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 4, 30, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case CLOSE:
							{
							alt4=14;
							}
							break;
						default:
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 4, 22, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
					}
					else if ( (LA4_12==ALL||(LA4_12 >= EXISTS && LA4_12 <= TRUE)||LA4_12==14) ) {
						alt4=16;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 4, 12, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 7, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:14:9: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_formula54); 
					 result = new Formula(true);
					}
					break;
				case 2 :
					// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:15:12: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_formula69); 
					 result = new Formula(false);
					}
					break;
				case 3 :
					// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:16:11: OPEN first ( op_bool second )? CLOSE
					{
					boolean op = false;
					match(input,OPEN,FOLLOW_OPEN_in_formula85); 
					pushFollow(FOLLOW_first_in_formula87);
					first2=first();
					state._fsp--;

					// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:16:44: ( op_bool second )?
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( ((LA1_0 >= 15 && LA1_0 <= 18)) ) {
						alt1=1;
					}
					switch (alt1) {
						case 1 :
							// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:16:45: op_bool second
							{
							pushFollow(FOLLOW_op_bool_in_formula90);
							op_bool4=op_bool();
							state._fsp--;

							pushFollow(FOLLOW_second_in_formula92);
							second3=second();
							state._fsp--;

							op = true;
							}
							break;

					}

					match(input,CLOSE,FOLLOW_CLOSE_in_formula98); 
					 if (op) {
					        	 	  result = new Formula( first2, second3,  (op_bool4!=null?((FormulaParser.op_bool_return)op_bool4).result:null));
					        	  } else {
					        	 	  result = new Formula(first2);
					        	 	} 
					        	
					}
					break;
				case 4 :
					// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:23:11: OPEN first op_bool ctl_end CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_formula123); 
					pushFollow(FOLLOW_first_in_formula125);
					first5=first();
					state._fsp--;

					pushFollow(FOLLOW_op_bool_in_formula127);
					op_bool7=op_bool();
					state._fsp--;

					pushFollow(FOLLOW_ctl_end_in_formula129);
					ctl_end6=ctl_end();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_formula131); 
					result = new Formula(first5, ctl_end6, (op_bool7!=null?((FormulaParser.op_bool_return)op_bool7).result:null));
					}
					break;
				case 5 :
					// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:24:11: neg ctl_init
					{
					pushFollow(FOLLOW_neg_in_formula145);
					neg8=neg();
					state._fsp--;

					pushFollow(FOLLOW_ctl_init_in_formula147);
					ctl_init9=ctl_init();
					state._fsp--;

					 result = new Formula(neg8, ctl_init9); 
					}
					break;
				case 6 :
					// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:25:8: OPEN ctl_init ( op_bool ctl_end )? CLOSE
					{
					boolean op = false;
					match(input,OPEN,FOLLOW_OPEN_in_formula160); 
					pushFollow(FOLLOW_ctl_init_in_formula162);
					ctl_init10=ctl_init();
					state._fsp--;

					// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:25:44: ( op_bool ctl_end )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( ((LA2_0 >= 15 && LA2_0 <= 18)) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:25:45: op_bool ctl_end
							{
							pushFollow(FOLLOW_op_bool_in_formula165);
							op_bool12=op_bool();
							state._fsp--;

							pushFollow(FOLLOW_ctl_end_in_formula167);
							ctl_end11=ctl_end();
							state._fsp--;

							op = true;
							}
							break;

					}

					match(input,CLOSE,FOLLOW_CLOSE_in_formula173); 
					 if (op) {
					        	 	  result = new Formula( ctl_init10,  ctl_end11, (op_bool12!=null?((FormulaParser.op_bool_return)op_bool12).result:null));
					        	 	  } else {
					        	 	  result = ctl_init10;
					        	 	  } 
					}
					break;
				case 7 :
					// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:31:11: EXISTS OPEN first UNTIL second CLOSE
					{
					match(input,EXISTS,FOLLOW_EXISTS_in_formula199); 
					match(input,OPEN,FOLLOW_OPEN_in_formula201); 
					pushFollow(FOLLOW_first_in_formula203);
					first13=first();
					state._fsp--;

					UNTIL15=(Token)match(input,UNTIL,FOLLOW_UNTIL_in_formula205); 
					pushFollow(FOLLOW_second_in_formula207);
					second14=second();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_formula209); 
					 result = new Formula("E", first13, second14, (UNTIL15!=null?UNTIL15.getText():null));
					}
					break;
				case 8 :
					// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:32:11: ALL OPEN first UNTIL second CLOSE
					{
					match(input,ALL,FOLLOW_ALL_in_formula223); 
					match(input,OPEN,FOLLOW_OPEN_in_formula225); 
					pushFollow(FOLLOW_first_in_formula227);
					first16=first();
					state._fsp--;

					UNTIL18=(Token)match(input,UNTIL,FOLLOW_UNTIL_in_formula229); 
					pushFollow(FOLLOW_second_in_formula231);
					second17=second();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_formula233); 
					 result = new Formula("A", first16, second17, (UNTIL18!=null?UNTIL18.getText():null));
					}
					break;
				case 9 :
					// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:33:11: EXISTS OPEN first UNTIL ctl_end CLOSE
					{
					match(input,EXISTS,FOLLOW_EXISTS_in_formula247); 
					match(input,OPEN,FOLLOW_OPEN_in_formula249); 
					pushFollow(FOLLOW_first_in_formula251);
					first19=first();
					state._fsp--;

					UNTIL21=(Token)match(input,UNTIL,FOLLOW_UNTIL_in_formula253); 
					pushFollow(FOLLOW_ctl_end_in_formula255);
					ctl_end20=ctl_end();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_formula257); 
					 result = new Formula("E", first19, ctl_end20, (UNTIL21!=null?UNTIL21.getText():null));
					}
					break;
				case 10 :
					// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:34:11: ALL OPEN first UNTIL ctl_end CLOSE
					{
					match(input,ALL,FOLLOW_ALL_in_formula271); 
					match(input,OPEN,FOLLOW_OPEN_in_formula273); 
					pushFollow(FOLLOW_first_in_formula275);
					first22=first();
					state._fsp--;

					UNTIL24=(Token)match(input,UNTIL,FOLLOW_UNTIL_in_formula277); 
					pushFollow(FOLLOW_ctl_end_in_formula279);
					ctl_end23=ctl_end();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_formula281); 
					 result = new Formula("A", first22, ctl_end23, (UNTIL24!=null?UNTIL24.getText():null));
					}
					break;
				case 11 :
					// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:35:11: EXISTS OPEN ctl_init UNTIL ctl_end CLOSE
					{
					match(input,EXISTS,FOLLOW_EXISTS_in_formula295); 
					match(input,OPEN,FOLLOW_OPEN_in_formula297); 
					pushFollow(FOLLOW_ctl_init_in_formula299);
					ctl_init25=ctl_init();
					state._fsp--;

					UNTIL27=(Token)match(input,UNTIL,FOLLOW_UNTIL_in_formula301); 
					pushFollow(FOLLOW_ctl_end_in_formula303);
					ctl_end26=ctl_end();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_formula305); 
					 result = new Formula( "E",ctl_init25,  ctl_end26, (UNTIL27!=null?UNTIL27.getText():null)); 
					}
					break;
				case 12 :
					// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:36:11: ALL OPEN ctl_init UNTIL ctl_end CLOSE
					{
					match(input,ALL,FOLLOW_ALL_in_formula319); 
					match(input,OPEN,FOLLOW_OPEN_in_formula321); 
					pushFollow(FOLLOW_ctl_init_in_formula323);
					ctl_init28=ctl_init();
					state._fsp--;

					UNTIL30=(Token)match(input,UNTIL,FOLLOW_UNTIL_in_formula325); 
					pushFollow(FOLLOW_ctl_end_in_formula327);
					ctl_end29=ctl_end();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_formula329); 
					 result = new Formula( "A", ctl_init28,  ctl_end29, (UNTIL30!=null?UNTIL30.getText():null)); 
					}
					break;
				case 13 :
					// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:37:11: TEMPORAL OPEN first op_bool second CLOSE
					{
					TEMPORAL31=(Token)match(input,TEMPORAL,FOLLOW_TEMPORAL_in_formula344); 
					match(input,OPEN,FOLLOW_OPEN_in_formula346); 
					pushFollow(FOLLOW_first_in_formula348);
					first32=first();
					state._fsp--;

					pushFollow(FOLLOW_op_bool_in_formula350);
					op_bool34=op_bool();
					state._fsp--;

					pushFollow(FOLLOW_second_in_formula352);
					second33=second();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_formula354); 
					 result = new Formula((TEMPORAL31!=null?TEMPORAL31.getText():null), first32, second33, (op_bool34!=null?input.toString(op_bool34.start,op_bool34.stop):null));
					}
					break;
				case 14 :
					// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:38:11: TEMPORAL OPEN first CLOSE
					{
					TEMPORAL35=(Token)match(input,TEMPORAL,FOLLOW_TEMPORAL_in_formula368); 
					match(input,OPEN,FOLLOW_OPEN_in_formula370); 
					pushFollow(FOLLOW_first_in_formula372);
					first36=first();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_formula374); 
					 result = new Formula((TEMPORAL35!=null?TEMPORAL35.getText():null), first36);
					}
					break;
				case 15 :
					// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:39:11: TEMPORAL OPEN first op_bool ctl_end CLOSE
					{
					TEMPORAL37=(Token)match(input,TEMPORAL,FOLLOW_TEMPORAL_in_formula388); 
					match(input,OPEN,FOLLOW_OPEN_in_formula390); 
					pushFollow(FOLLOW_first_in_formula392);
					first38=first();
					state._fsp--;

					pushFollow(FOLLOW_op_bool_in_formula394);
					op_bool40=op_bool();
					state._fsp--;

					pushFollow(FOLLOW_ctl_end_in_formula396);
					ctl_end39=ctl_end();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_formula398); 
					 result = new Formula((TEMPORAL37!=null?TEMPORAL37.getText():null), first38, ctl_end39, (op_bool40!=null?input.toString(op_bool40.start,op_bool40.stop):null));
					}
					break;
				case 16 :
					// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:40:11: TEMPORAL OPEN ctl_init ( op_bool ctl_end )? CLOSE
					{
					boolean op = false;
					TEMPORAL41=(Token)match(input,TEMPORAL,FOLLOW_TEMPORAL_in_formula414); 
					match(input,OPEN,FOLLOW_OPEN_in_formula416); 
					pushFollow(FOLLOW_ctl_init_in_formula418);
					ctl_init42=ctl_init();
					state._fsp--;

					// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:40:56: ( op_bool ctl_end )?
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( ((LA3_0 >= 15 && LA3_0 <= 18)) ) {
						alt3=1;
					}
					switch (alt3) {
						case 1 :
							// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:40:57: op_bool ctl_end
							{
							pushFollow(FOLLOW_op_bool_in_formula421);
							op_bool44=op_bool();
							state._fsp--;

							pushFollow(FOLLOW_ctl_end_in_formula423);
							ctl_end43=ctl_end();
							state._fsp--;

							op = true;
							}
							break;

					}

					match(input,CLOSE,FOLLOW_CLOSE_in_formula429); 
					 if (op) {
					        	 	  result = new Formula((TEMPORAL41!=null?TEMPORAL41.getText():null), ctl_init42,  ctl_end43, (op_bool44!=null?((FormulaParser.op_bool_return)op_bool44).result:null));
					        	 	  } else {
					        	 	  result = new Formula((TEMPORAL41!=null?TEMPORAL41.getText():null), ctl_init42);
					        	 	  } 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "formula"



	// $ANTLR start "first"
	// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:48:1: first returns [String result] : ATOMIC ;
	public final String first() throws RecognitionException {
		String result = null;


		Token ATOMIC45=null;

		try {
			// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:48:30: ( ATOMIC )
			// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:48:32: ATOMIC
			{
			ATOMIC45=(Token)match(input,ATOMIC,FOLLOW_ATOMIC_in_first460); 
			result = (ATOMIC45!=null?ATOMIC45.getText():null);
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "first"



	// $ANTLR start "second"
	// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:49:1: second returns [String result] : ATOMIC ;
	public final String second() throws RecognitionException {
		String result = null;


		Token ATOMIC46=null;

		try {
			// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:49:31: ( ATOMIC )
			// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:49:33: ATOMIC
			{
			ATOMIC46=(Token)match(input,ATOMIC,FOLLOW_ATOMIC_in_second472); 
			result = (ATOMIC46!=null?ATOMIC46.getText():null);
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "second"



	// $ANTLR start "ctl_init"
	// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:51:1: ctl_init returns [Formula result] : formula ;
	public final Formula ctl_init() throws RecognitionException {
		Formula result = null;


		Formula formula47 =null;

		try {
			// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:51:34: ( formula )
			// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:52:5: formula
			{
			pushFollow(FOLLOW_formula_in_ctl_init489);
			formula47=formula();
			state._fsp--;

			result = formula47;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "ctl_init"



	// $ANTLR start "ctl_end"
	// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:55:1: ctl_end returns [Formula result] : formula ;
	public final Formula ctl_end() throws RecognitionException {
		Formula result = null;


		Formula formula48 =null;

		try {
			// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:55:33: ( formula )
			// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:56:5: formula
			{
			pushFollow(FOLLOW_formula_in_ctl_end510);
			formula48=formula();
			state._fsp--;

			result = formula48;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "ctl_end"



	// $ANTLR start "neg"
	// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:59:1: neg returns [boolean result] : '!' ;
	public final boolean neg() throws RecognitionException {
		boolean result = false;


		try {
			// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:59:31: ( '!' )
			// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:60:4: '!'
			{
			match(input,14,FOLLOW_14_in_neg532); 
			 result = true; 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "neg"


	public static class op_bool_return extends ParserRuleReturnScope {
		public String result;
	};


	// $ANTLR start "op_bool"
	// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:64:1: op_bool returns [String result] : ( '&&' | '||' | '=>' | '<=>' );
	public final FormulaParser.op_bool_return op_bool() throws RecognitionException {
		FormulaParser.op_bool_return retval = new FormulaParser.op_bool_return();
		retval.start = input.LT(1);

		try {
			// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:64:32: ( '&&' | '||' | '=>' | '<=>' )
			int alt5=4;
			switch ( input.LA(1) ) {
			case 15:
				{
				alt5=1;
				}
				break;
			case 18:
				{
				alt5=2;
				}
				break;
			case 17:
				{
				alt5=3;
				}
				break;
			case 16:
				{
				alt5=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:65:6: '&&'
					{
					match(input,15,FOLLOW_15_in_op_bool556); 
					retval.result = "&&";
					}
					break;
				case 2 :
					// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:66:7: '||'
					{
					match(input,18,FOLLOW_18_in_op_bool566); 
					retval.result = "||"; 
					}
					break;
				case 3 :
					// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:67:7: '=>'
					{
					match(input,17,FOLLOW_17_in_op_bool577); 
					retval.result = "=>";
					}
					break;
				case 4 :
					// /Users/luca/Documents/workspace/SimpleModelChecker/src/Formula.g:68:7: '<=>'
					{
					match(input,16,FOLLOW_16_in_op_bool587); 
					retval.result = "<=>";
					}
					break;

			}
			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "op_bool"

	// Delegated rules



	public static final BitSet FOLLOW_formula_in_query30 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_query32 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_formula54 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_formula69 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_formula85 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_first_in_formula87 = new BitSet(new long[]{0x0000000000078040L});
	public static final BitSet FOLLOW_op_bool_in_formula90 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_second_in_formula92 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CLOSE_in_formula98 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_formula123 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_first_in_formula125 = new BitSet(new long[]{0x0000000000078000L});
	public static final BitSet FOLLOW_op_bool_in_formula127 = new BitSet(new long[]{0x0000000000004F90L});
	public static final BitSet FOLLOW_ctl_end_in_formula129 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CLOSE_in_formula131 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_neg_in_formula145 = new BitSet(new long[]{0x0000000000004F90L});
	public static final BitSet FOLLOW_ctl_init_in_formula147 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_formula160 = new BitSet(new long[]{0x0000000000004F90L});
	public static final BitSet FOLLOW_ctl_init_in_formula162 = new BitSet(new long[]{0x0000000000078040L});
	public static final BitSet FOLLOW_op_bool_in_formula165 = new BitSet(new long[]{0x0000000000004F90L});
	public static final BitSet FOLLOW_ctl_end_in_formula167 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CLOSE_in_formula173 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EXISTS_in_formula199 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_OPEN_in_formula201 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_first_in_formula203 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_UNTIL_in_formula205 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_second_in_formula207 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CLOSE_in_formula209 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALL_in_formula223 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_OPEN_in_formula225 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_first_in_formula227 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_UNTIL_in_formula229 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_second_in_formula231 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CLOSE_in_formula233 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EXISTS_in_formula247 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_OPEN_in_formula249 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_first_in_formula251 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_UNTIL_in_formula253 = new BitSet(new long[]{0x0000000000004F90L});
	public static final BitSet FOLLOW_ctl_end_in_formula255 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CLOSE_in_formula257 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALL_in_formula271 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_OPEN_in_formula273 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_first_in_formula275 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_UNTIL_in_formula277 = new BitSet(new long[]{0x0000000000004F90L});
	public static final BitSet FOLLOW_ctl_end_in_formula279 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CLOSE_in_formula281 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EXISTS_in_formula295 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_OPEN_in_formula297 = new BitSet(new long[]{0x0000000000004F90L});
	public static final BitSet FOLLOW_ctl_init_in_formula299 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_UNTIL_in_formula301 = new BitSet(new long[]{0x0000000000004F90L});
	public static final BitSet FOLLOW_ctl_end_in_formula303 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CLOSE_in_formula305 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALL_in_formula319 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_OPEN_in_formula321 = new BitSet(new long[]{0x0000000000004F90L});
	public static final BitSet FOLLOW_ctl_init_in_formula323 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_UNTIL_in_formula325 = new BitSet(new long[]{0x0000000000004F90L});
	public static final BitSet FOLLOW_ctl_end_in_formula327 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CLOSE_in_formula329 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TEMPORAL_in_formula344 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_OPEN_in_formula346 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_first_in_formula348 = new BitSet(new long[]{0x0000000000078000L});
	public static final BitSet FOLLOW_op_bool_in_formula350 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_second_in_formula352 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CLOSE_in_formula354 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TEMPORAL_in_formula368 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_OPEN_in_formula370 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_first_in_formula372 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CLOSE_in_formula374 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TEMPORAL_in_formula388 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_OPEN_in_formula390 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_first_in_formula392 = new BitSet(new long[]{0x0000000000078000L});
	public static final BitSet FOLLOW_op_bool_in_formula394 = new BitSet(new long[]{0x0000000000004F90L});
	public static final BitSet FOLLOW_ctl_end_in_formula396 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CLOSE_in_formula398 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TEMPORAL_in_formula414 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_OPEN_in_formula416 = new BitSet(new long[]{0x0000000000004F90L});
	public static final BitSet FOLLOW_ctl_init_in_formula418 = new BitSet(new long[]{0x0000000000078040L});
	public static final BitSet FOLLOW_op_bool_in_formula421 = new BitSet(new long[]{0x0000000000004F90L});
	public static final BitSet FOLLOW_ctl_end_in_formula423 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CLOSE_in_formula429 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ATOMIC_in_first460 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ATOMIC_in_second472 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_formula_in_ctl_init489 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_formula_in_ctl_end510 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_neg532 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_op_bool556 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_op_bool566 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_op_bool577 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_op_bool587 = new BitSet(new long[]{0x0000000000000002L});
}
