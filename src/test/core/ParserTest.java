package test.core;

import static org.junit.Assert.*;

import org.junit.Test;

import core.Lexer;
import core.Parser;
import core.expression.*;

public class ParserTest {
	//Tests
	//	parseAdd(Expression left):
	//		expr = (x+, 3), (3+ x), (3+ ( 
	//
	@Test
	public void testAddNumVar(){
		Parser parser = new Parser(new Lexer("3)"));
		Expression left = new Variable("x");
		Expression actualExpr = parser.parseAdd(left);
		//expected
		Expression expectedExpr = new Add(new Variable("x"), new core.expression.Number("3"));
		//assert
		assertEquals(expectedExpr, actualExpr);
	}
}
