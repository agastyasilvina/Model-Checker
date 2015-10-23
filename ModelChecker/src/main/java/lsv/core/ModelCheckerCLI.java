package lsv.core;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.antlr.runtime.RecognitionException;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import lsv.grammar.CTL;
import lsv.grammar.Formula;

/**
 * The Main class. 
 * This class consists of all the components used to build a
 * model checker. (i.e. ModelGenerator, SimpleGraph, and SimpleParser)
 * The algorithm for the model checker is implemented here. 
 * */
public class ModelCheckerCLI {

	@SuppressWarnings("resource")
	public static void main(String [] args) {
	
		ModelGenerator model = null;
		showMenu();
	    Scanner input = new Scanner (System.in);
		System.out.print("Select options:");
		 while (!input.hasNextInt())  {
			  System.out.println("Enter valid input...");
			  System.out.print("Select options:");
			  input.next();
		  }
		int option = input.nextInt();
		while(option != 4) {
			if(option ==1) {
				//input model:
				System.out.print("Enter file path: ");
				String filePath = input.next();
				try {
					model = new ModelGenerator(filePath);
					System.out.println();
				} catch (FileNotFoundException e) {
					System.out.println("File not found..");
				}
				
				if(model != null) {
					System.out.println("Model created");
				}
				
			} else if (option == 2) {
				if(model == null) {
					System.out.println("Please insert a model..");
				} else {
					//Enter Query
					System.out.print("Enter CTL filePath: ");
					String filePath = input.next();
					try {
						CTL ctl = CTL.createCTL(filePath);
						Formula formula = SimpleParser.parseCTL(ctl.getFormula());
						Formula.addActions(ctl, formula);
						//TODO: IMPLEMENT THE MODEL CHECKER
								
					} catch (JsonIOException e) {
						System.out.println("JSON error..");
						//e.printStackTrace();
					} catch (JsonSyntaxException e) {
						System.out.println("JSON syntax error..");
						//e.printStackTrace();
					} catch (FileNotFoundException e) {
						System.out.println("File not found..");
						//e.printStackTrace();
					} catch (RecognitionException e) {
						System.out.println("Unable to recognize pattern..");
						//e.printStackTrace();
					}
				}
			} else if (option == 3){
				showMenu();
			}
			
			System.out.print("Select options:");
			while (!input.hasNextInt())  {
				System.out.println("Enter valid input...");
				System.out.print("Select options:");
				input.next();
			}
			option = input.nextInt();
		}		
	}
	
	public static void showMenu() {
		System.out.println("Please select from this following options:");
		System.out.println("1 -> Input a model");
		System.out.println("2 -> Enter a query");
		System.out.println("3 -> Show Menu");
		System.out.println("4 -> Quit");
	}
}
