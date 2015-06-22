package test.core.expression;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import core.expression.Expression;
import core.expression.Variable;

public class VariableTest {
	//TODO  differentiatorTest
	
	//Tests
	//	toString()
	//		x, xx

	@Test
	public void testToStringSingleChar(){
		Variable var = new Variable("x");
		assertEquals("x", var.toString());
	}
	
	@Test
	public void testToStringsDoubleChar(){
		Variable var = new Variable("xx");
		assertEquals("xx", var.toString());
	}
	
	//	differentiate(String arg)
	//		(arg, value) = x x, x y
	@Test
	public void testDifferentiateSameArgValue(){
		Variable var = new Variable("x");
		Expression diff = var.differentiate("x");
		assertEquals("1", diff.toString());
	}
	
	@Test
	public void testDifferentiateDifferentArgValue(){
		Variable var = new Variable("y");
		Expression diff = var.differentiate("x");
		assertEquals("0", diff.toString());
	}
}
