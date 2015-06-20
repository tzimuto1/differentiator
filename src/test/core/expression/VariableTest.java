package test.core.expression;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
	
}
