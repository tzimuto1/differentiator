package test.core;

import static org.junit.Assert.*;

import org.junit.Test;

import core.Lexer;
import core.Parser;
import core.expression.*;

public class ParserTest {
	//Tests
	//	parse[Add/Subtract/Multiply](Expression left):
	//      These test cases cover the test cases for the parseOperatorHelper() method. Thus
	//      tests that use the "-" and "*" operators have been left out
	//		expr = (x+, 3), (3+ x), (x+ 3 illegal, (3+ x illegal, (x + 3, (3 + x
	
	@Test
	// (x + 3)
	public void testParseAddVarNum(){
		Expression left = new Variable("x");
		Parser parser = new Parser(new Lexer("3)"));
		Expression actualExpr = parser.parseAdd(left);
		//expected
		String expected = "(x+3)";
		//assert
		assertEquals(expected, actualExpr.toString());
	}
	
	@Test
	// (3 + x)
	public void testParseAddNumVar(){
		Expression left = new core.expression.Number("3");
		Parser parser = new Parser(new Lexer("x)"));//right part of expression
		Expression actualExpr = parser.parseAdd(left);
		//expected
		String expected = "(3+x)";
		//assert
		assertEquals(expected, actualExpr.toString());
	}
	
	//  parse() It implicitly covers the parseExpression() method:
	//		LEGAL EXPRESSIONS
	//  	single variable (x), number (3), 2 single-layer expression plus (x + 3), 
	//  	2 single-layer expression subtract (x - 3), 2 single-layer expression multi (x * 3)
	//		double layer expression [(x + (x - 3)), ((x-3) + 2), ((x +1) + (x + 2))],
	//		deeply nested expression (((x + (3 * 4)) + 3) -3)
	//  	unnecessary brackets1 (((x))), unnecessary brackets 2 ((x +3))
	//      ILLEGAL EXPRESSIONS
	//      single token (, double token (x (3 (+ (),
	//      missing parens x + 1, unbalanced parens (x + (x +1), 
	//      missing operator (3x, 
	
	@Test
	// (x)
	public void testParseSingleVariable(){
		//actual
		Parser parser = new Parser(new Lexer("(x)"));
		Expression actual = parser.parse();
		
		String expected = "x";
		assertEquals(expected, actual.toString());
		
	}
	
	@Test
	// (3)
	public void testParseSingleNumber(){
		//actual
		Parser parser = new Parser(new Lexer("(3)"));
		Expression actual = parser.parse();
		
		String expected = "3";
		assertEquals(expected, actual.toString());	
	}
	
	@Test
	// (x + 3)
	public void testParseSingleLayerAddExpression1(){
		//actual
		Parser parser = new Parser(new Lexer("(x + 3)"));
		Expression actual = parser.parse();
		
		String expected = "(x+3)";
		assertEquals(expected, actual.toString());
	}
	
	@Test
	// (3 + x)
	public void testParseSingleLayerAddExpression2(){
		//actual
		Parser parser = new Parser(new Lexer("(3 + x)"));
		Expression actual = parser.parse();
		
		String expected = "(3+x)";
		assertEquals(expected, actual.toString());
	}
	
	@Test
	// (x - 3)
	public void testParseSingleLayerSubtractExpression1(){
		//actual
		Parser parser = new Parser(new Lexer("(x - 3)"));
		Expression actual = parser.parse();
		
		String expected = "(x-3)";
		assertEquals(expected, actual.toString());
		
	}
	
	@Test
	// (3 - x)
	public void testParseSingleLayerSubtractExpression2(){
		//actual
		Parser parser = new Parser(new Lexer("(3 - x)"));
		Expression actual = parser.parse();
		
		String expected = "(3-x)";
		assertEquals(expected, actual.toString());
		
	}
	
	@Test
	// (x * 3)
	public void testParseSingleLayerMultiplyExpression1(){
		//actual
		Parser parser = new Parser(new Lexer("(x * 3)"));
		Expression actual = parser.parse();
		
		String expected = "(x*3)";
		assertEquals(expected, actual.toString());
	}
	
	@Test
	// (3 * x)
	public void testParseSingleLayerMultiplyExpression2(){
		Parser parser = new Parser(new Lexer("(3 * x)"));
		Expression actual = parser.parse();
		
		String expected = "(3*x)";
		assertEquals(expected, actual.toString());
	}
	
	@Test
	//(x + (x - 3))
	public void doubleLayerExpression1(){
		Parser parser = new Parser(new Lexer("(x + (x - 3))"));
		Expression actual = parser.parse();
		
		String expected = "(x+(x-3))";
		assertEquals(expected, actual.toString());
	}
	
	@Test
	//((x - 3) + x)
	public void doubleLayerExpression2(){
		Parser parser = new Parser(new Lexer("((x - 3) + x)"));
		Expression actual = parser.parse();
		
		String expected = "((x-3)+x)";
		assertEquals(expected, actual.toString());
	}
	
	@Test
	//((x +1) + (x + 2))
	public void doubleLayerExpression3(){
		Parser parser = new Parser(new Lexer("((x +1) + (x + 2))"));
		Expression actual = parser.parse();
		
		String expected = "((x+1)+(x+2))";
		assertEquals(expected, actual.toString());
	}
	
	@Test
	//(((x + (3 * 4)) + 3) -3)
	public void testParseDeeplyNestedEpxression(){
		Parser parser = new Parser(new Lexer("(((x + (3 * 4)) + 3) -3)"));
		Expression actual = parser.parse();
		
		String expected = "(((x+(3*4))+3)-3)";
		assertEquals(expected, actual.toString());
	}
	
	@Test
	//(((x)))
	public void testParseExtraParens1(){
		Parser parser = new Parser(new Lexer("(((x)))"));
		Expression actual = parser.parse();
		
		String expected = "x";
		assertEquals(expected, actual.toString());
	}
	
	@Test
	//((x +3))
	public void testParseExtraParens2(){
		Parser parser = new Parser(new Lexer("((x + 3))"));
		Expression actual = parser.parse();
		
		String expected = "(x+3)";
		assertEquals(expected, actual.toString());
	}
	
	//ILLEGAL EXPRESSION
//  ILLEGAL EXPRESSIONS
	
	@Test(expected = RuntimeException.class)
	//(
	public void testParseSingleTokenParen(){
		Parser parser = new Parser(new Lexer("("));
		parser.parse();
	}
	
	@Test(expected = RuntimeException.class)
	//+
	public void testParseSingleTokenAdd(){
		Parser parser = new Parser(new Lexer("+"));
		parser.parse();
	}
	
	@Test(expected = RuntimeException.class)
	//(x
	public void testParseDoubleTokens1(){
		Parser parser = new Parser(new Lexer("(x"));
		parser.parse();
	}
	
	@Test(expected = RuntimeException.class)
	//(3
	public void testParseDoubleTokens2(){
		Parser parser = new Parser(new Lexer("(x"));
		parser.parse();
	}
	
	@Test(expected = RuntimeException.class)
	//(+
	public void testParseDoubleTokens3(){
		Parser parser = new Parser(new Lexer("(+"));
		parser.parse();
	}
	
	@Test(expected = RuntimeException.class)
	//()
	public void testParseDoubleTokens4(){
		Parser parser = new Parser(new Lexer("()"));
		parser.parse();
	}
	
	@Test(expected = RuntimeException.class)
	//x+1
	public void testParseMissingParens1(){
		Parser parser = new Parser(new Lexer("x+1"));
		parser.parse();
	}
	
	@Test(expected = RuntimeException.class)
	//(x+1
	public void testParseMissingParens2(){
		Parser parser = new Parser(new Lexer("(x+1"));
		parser.parse();
	}
	
	@Test(expected = RuntimeException.class)
	//(x+(x+1)
	public void testParseMissingParens3(){
		Parser parser = new Parser(new Lexer("(x+(x+1)"));
		parser.parse();
	}
	
	@Test(expected = RuntimeException.class)
	//(x+(x)+1)
	public void testParseMisplacedParens(){
		Parser parser = new Parser(new Lexer("(x+(x)+1)"));
		parser.parse();
	}
}
