package test.core.expression;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import core.expression.Expression;
import core.expression.Variable;

public class NumberTest {

	//Tests
	//	toString():
	//		3, 3.14
	
	@Test
	public void testToStringInt(){
		core.expression.Number num = new core.expression.Number("3");
		assertEquals("3", num.toString());
	}
	
	@Test
	public void testToStringFloat(){
		core.expression.Number num = new core.expression.Number("3.14");
		assertEquals("3.14", num.toString());
	}
	
	//	differentiate(String arg)
	//		(arg, value) = x 0, x 1
	@Test
	public void testDifferentiateZero(){
		core.expression.Number expr = new core.expression.Number("0");
		Expression diff = expr.differentiate("x");
		assertEquals("0", diff.toString());
	}
	
	@Test
	public void testDifferentiateOne(){
		core.expression.Number expr = new core.expression.Number("1");
		Expression diff = expr.differentiate("x");
		assertEquals("0", diff.toString());
	}
	
}
