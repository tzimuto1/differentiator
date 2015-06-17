package core;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import core.Token.Type;

/**
 * 
 * @author tzimuto1
 *
 */

public class Lexer {
	private String expression;
//	private static final Pattern exprRegex=Pattern.compile(
//	            "X:\\s*\\d+|T:.+|C:.+|L:\\s*\\d+\\/\\d+|M:\\s*((C\\|)|[C]|[\\d+][\\/][\\d+])|Q:\\s*\\d+|V:\\s*.+|K:\\s*([a-gA-G]|z)(#|b)?(m)?|" +
//	                    "\\(2|\\(3|\\(4|(\\|\\|)|(\\|\\])|(\\|:)|(:\\|)|\\[1|\\[2|\\d*\\/\\d*|[1-9]\\d*|\\||\\s*[a-gA-G]|\\z" +
//	                    "[\\^\\^?]|[__?]|[=]|'+|,+|\\[|\\]|%.+|\\s+|" + 
//	                    "[^CDEFGABcdefgabz]|[^0-9]|[^\\/]|[^\\^]|[^_]|[^=]|[^']|[^,]|[^\\|]|[^\\:]|[^\\[]|[^\\]]|[^\\(]|" +
//	                    "[^%]"); 
	//PLUS, MINUS, MULT, OPEN_PARENTH, CLOSED_PARENTH, NUMBER, VARIABLE
	private static final Pattern exprRegex = Pattern.compile(
			"\\+|\\-|\\*|\\(|\\)|\\d+\\.\\d+|\\d+|[a-zA-Z]+|\\s+|" + 
            "[^\\+]|[^-]|[^\\*]|[^\\(]|[^\\)]|[^\\d]|[^\\.]|[^a-zA-Z]|[^\\s]"
					); 
	private static final Pattern plus    = Pattern.compile("\\+");
    private static final Pattern minus     = Pattern.compile("\\-");
    private static final Pattern multi  = Pattern.compile("\\*");
    private static final Pattern openParenth  = Pattern.compile("\\(");
    private static final Pattern closedParenth  = Pattern.compile("\\)");
    private static final Pattern number  = Pattern.compile("\\d+\\.\\d+|\\d+");
    private static final Pattern variable = Pattern.compile("[a-zA-Z]+");
    private static final Pattern spaces  = Pattern.compile("\\s+");
    private static final Pattern unknown    = Pattern.compile(
    		"[^\\+]|[^-]|[^\\*]|[^\\(]|[^\\)]|[^\\d]|[^\\.]|[^a-zA-Z]|[^\\s]"
    		);
    
    private Matcher matcher;
	/**
	 * Tokenizes the mathematical expression into Tokens
	 * @param expression - Mathematical expression to tokenize
	 */
	public Lexer(String expression) {
		this.expression = expression;
	}
	
	/**
	 * Tokenizes the mathematical expression
	 * @throws RuntimeException when the expression has unsupported characters
	 * @return ArrayList<Token>
	 */
	public ArrayList<Token> getTokens(){
		ArrayList<Token> tokens = new ArrayList<Token>();
		matcher = exprRegex.matcher(expression);
		while(matcher.find()){
			String match = matcher.group();
			Matcher plusMatcher = plus.matcher(match);
		    Matcher minusMatcher = minus.matcher(match);
		    Matcher multiMatcher  = multi.matcher(match);
		    Matcher openParenthMatcher = openParenth.matcher(match);
		    Matcher closedParenthMatcher = closedParenth.matcher(match);
		    Matcher numberMatcher = number.matcher(match);
		    Matcher variableMatcher = variable.matcher(match);
		    Matcher spacesMatcher = spaces.matcher(match);
		    
		    if (plusMatcher.find()) tokens.add(new Token(Type.PLUS, match));
		    else if (minusMatcher.find()) tokens.add(new Token(Type.MINUS, match));
		    else if (multiMatcher.find()) tokens.add(new Token(Type.MULTI, match));
		    else if (openParenthMatcher.find()) tokens.add(new Token(Type.OPEN_PARENTH, match));
		    else if (closedParenthMatcher.find()) tokens.add(new Token(Type.CLOSED_PARENTH, match));
		    else if (numberMatcher.find()) tokens.add(new Token(Type.NUMBER, match));
		    else if (variableMatcher.find()) tokens.add(new Token(Type.VARIABLE, match));
		    else if (spacesMatcher.find()) continue;
		    else throw new RuntimeException("Expression has unsupported characters");
		}
		return tokens;
	}
	
}
