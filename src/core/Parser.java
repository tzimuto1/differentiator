package core;

import java.util.ArrayList;
import java.util.ListIterator;

import core.Token.Type;
import core.expression.*;

/**
 * 
 * @author tzimuto1
 *
 */
public class Parser {
	
	ArrayList<Token> tokens;
	ListIterator<Token> iter;
	
	/**
	 * The mathematical expression parser
	 * @param lexer the lexer with the expression tokens
	 */
	public Parser(Lexer lexer) {
		tokens = lexer.getTokens();
		iter = tokens.listIterator();
	}
	
	/**
	 * Parses the full mathematical expression
	 * @return Expression
	 */
	public Expression parse() {
		if (iter.hasNext()){
			Token token = iter.next();
			if (token.getType() == Type.OPEN_PARENTH) return parseExpression();
			else throw new RuntimeException("The expression format invalid");
		}
		throw new RuntimeException("The expression format invalid");
	}
	
	/**
	 * Parses an expression that starts with an open parenthesis
	 * @return Expression
	 */
	private Expression parseExpression(){
		Expression left;
		while(iter.hasNext()){
			Token token = iter.next();
			if (token.getType() == Type.VARIABLE){
				left = new Variable(token.getValue());
				return handleLeftTerminal(left);
			} else if (token.getType() == Type.NUMBER){
				left = new core.expression.Number(token.getValue());
				return handleLeftTerminal(left);
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param left the already parsed number of variable
	 * @return Expression
	 */
	private Expression handleLeftTerminal(Expression left){
		if (iter.hasNext()){
			Token nextToken = iter.next();
			if (nextToken.getType() == Type.CLOSED_PARENTH){
				return left;
			} else if (nextToken.getType() == Type.PLUS){
				return parseAdd(left);
			} else if (nextToken.getType() == Type.MINUS){
				return parseSubtract(left);
			} else if (nextToken.getType() == Type.MULTI){
				return parseMultiply(left);
			} 
		}
		throw new RuntimeException("The expression format invalid");
	}
	/**
	 * Parses the Add expression
	 * @param left the already parsed left expression of the Add expression
	 * @return Expression whose concrete type is Add
	 */
	public Expression parseAdd(Expression left) {
		Expression right = parseOperatorHelper();
		return new Add(left, right);
	}
	
	/**
	 * Parses the Subtract expression
	 * @param left the already parsed left expression of the Subtract expression
	 * @return Expression whose concrete type is Subtract
	 */
	public Expression parseSubtract(Expression left) {
		Expression right = parseOperatorHelper();
		return new Subtract(left, right);
	}
	
	/**
	 * Parses the Multiply expression
	 * @param left the already parsed left expression of the Multiply expression
	 * @return Expression whose concrete type is Multiply
	 */
	public Expression parseMultiply(Expression left) {
		Expression right = parseOperatorHelper();
		return new Multiply(left, right);
	}
	
	/**
	 * Parses the right part of an Add expression
	 * @return Expression
	 */
	private Expression parseOperatorHelper(){
		while(iter.hasNext()){
			Token token = iter.next();
			if (token.getType() == Type.NUMBER){
				if (isExpressionTerminated())return new core.expression.Number(token.getValue());
				else throw new RuntimeException("The expression format invalid");
			} else if (token.getType() == Type.VARIABLE){
				if (isExpressionTerminated()) return new Variable(token.getValue());
				else throw new RuntimeException("The expression format invalid");
			}
			//TODO test other parts of the expression
		}
		throw new RuntimeException("The expression format invalid");
	}
	/**
	 * Determines if the current expression is correctly terminated. A valid expression is
	 * is terminated by a parenthesis 
	 * @return boolean 
	 */
	private boolean isExpressionTerminated(){
		if (iter.hasNext()){
			Token nextToken = iter.next();
			return nextToken.getType() == Type.CLOSED_PARENTH;
		} else return false;
	}

}
