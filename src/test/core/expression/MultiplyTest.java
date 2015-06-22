package test.core.expression;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import core.expression.Expression;
import core.expression.Multiply;
import core.expression.Variable;

public class MultiplyTest {

	//Tests
		// toString():
		//		x * 3, 3 * x, (x * (x * 3)), ((x*3)*(x*4))
	
	@Test
	public void testToStringVarNum(){
		Multiply expr = new Multiply(new Variable("x"), new core.expression.Number("3"));
		assertEquals("(x*3)", expr.toString());
	}
	
	@Test
	public void testToStringNumVar(){
		Multiply expr = new Multiply(new core.expression.Number("3"), new Variable("x"));
		assertEquals("(3*x)", expr.toString());
	}
	
	@Test
	public void testToStringNestedVarAdd(){
		Variable left = new Variable("x");
		Multiply right = new Multiply(new Variable("x"), new core.expression.Number("3"));
		Multiply expr = new Multiply(left, right);
		assertEquals("(x*(x*3))", expr.toString());
	}
	
	@Test
	public void testToStringNestedMultiplys(){
		Multiply left = new Multiply(new Variable("x"), new core.expression.Number("3"));
		Multiply right = new Multiply(new Variable("x"), new core.expression.Number("4"));
		Multiply expr = new Multiply(left, right);
		assertEquals("((x*3)*(x*4))", expr.toString());
	}
	
	//	differentiate()
	//		x * 1, (covers for 1 * x, x * x)
	@Test
	//x*1
	public void testDifferentiateVarNum(){
		Variable left = new Variable("x");
		core.expression.Number right = new core.expression.Number("1");
		Multiply expr = new Multiply(left, right);
		Expression diff = expr.differentiate("x");
		assertEquals("((x*0)+(1*1))", diff.toString());
	}
}
