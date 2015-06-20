package core;

import java.util.ArrayList;

import core.expression.*;

/**
 * 
 * @author tzimuto1
 *
 */
public class Parser {
	
	ArrayList<Token> tokens;
	
	/**
	 * The mathematical expression parser
	 * @param lexer the lexer with the expression tokens
	 */
	public Parser(Lexer lexer) {
		tokens = lexer.getTokens();
	}
	
	/**
	 * Parses the Add expression
	 * @param left the already parsed left expression of the Add expression
	 * @return Expression whose concrete type is Add
	 */
	public Expression parseAdd(Expression left) {
		// TODO Auto-generated method stub
		return null;
	}

}
