package test.core;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import core.Lexer;
import core.Token;
import core.Token.Type;

public class LexerTest {
	//Tests
	//	getTokens():
	//		empty string, just space, 1 legal character, string with all legal characters,
	//		>1 legal characters + space(s),
	//		>1 illegal character
	@Test
	public void testGetTokensEmptyString(){
		String expression = "";
		Lexer lexer = new Lexer(expression);
		ArrayList<Token> expectedTokens = new ArrayList<Token>();
		assertArrayEquals(expectedTokens.toArray(), lexer.getTokens().toArray());
	}
	
	@Test
	public void testGetTokensSpace(){
		String expression = "  ";
		Lexer lexer = new Lexer(expression);
		ArrayList<Token> expectedTokens = new ArrayList<Token>();
		assertArrayEquals(expectedTokens.toArray(), lexer.getTokens().toArray());
	}
	
	@Test
	public void testGetTokensLegalChar(){
		String expression = "x";
		Lexer lexer = new Lexer(expression);
		ArrayList<Token> expectedTokens = new ArrayList<Token>();
		expectedTokens.add(new Token(Type.VARIABLE, "x"));
		assertArrayEquals(expectedTokens.toArray(), lexer.getTokens().toArray());
	}
	
	@Test
	public void testGetTokensLegalChars(){
		String expression = "1.23+2-*()tawaz";
		Lexer lexer = new Lexer(expression);
		ArrayList<Token> expectedTokens = new ArrayList<Token>();
		
		expectedTokens.add(new Token(Type.NUMBER, "1.23"));
		expectedTokens.add(new Token(Type.PLUS, "+"));
		expectedTokens.add(new Token(Type.NUMBER, "2"));
		expectedTokens.add(new Token(Type.MINUS, "-"));
		expectedTokens.add(new Token(Type.MULTI, "*"));
		expectedTokens.add(new Token(Type.OPEN_PARENTH, "("));
		expectedTokens.add(new Token(Type.CLOSED_PARENTH, ")"));
		expectedTokens.add(new Token(Type.VARIABLE, "tawaz"));
		
		ArrayList<Token> actualTokens = lexer.getTokens();
		assertArrayEquals(expectedTokens.toArray(), actualTokens.toArray());
	}
	
	@Test
	public void testGetTokensLegalCharsSpace(){
		String expression = "x +   y";
		Lexer lexer = new Lexer(expression);
		ArrayList<Token> expectedTokens = new ArrayList<Token>();
		
		expectedTokens.add(new Token(Type.VARIABLE, "x"));
		expectedTokens.add(new Token(Type.PLUS, "+"));
		expectedTokens.add(new Token(Type.VARIABLE, "y"));
		assertArrayEquals(expectedTokens.toArray(), lexer.getTokens().toArray());
	}
	
	
	@Test(expected = RuntimeException.class)
	public void testGetTokensIllegalChars(){
		String expression = "x _";
		Lexer lexer = new Lexer(expression);
		lexer.getTokens();
	}
}
