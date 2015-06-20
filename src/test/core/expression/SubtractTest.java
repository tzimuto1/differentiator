package test.core.expression;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import core.expression.Subtract;
import core.expression.Variable;

public class SubtractTest {
	//Tests
		// toString():
		//		x - 3, 3 - x, (x - (x - 3)), ((x-3)-(x-4))
	
	@Test
	public void testToStringVarNum(){
		Subtract subtract = new Subtract(new Variable("x"), new core.expression.Number("3"));
		assertEquals("(x-3)", subtract.toString());
	}
	
	@Test
	public void testToStringNumVar(){
		Subtract expr = new Subtract(new core.expression.Number("3"), new Variable("x"));
		assertEquals("(3-x)", expr.toString());
	}
	
	@Test
	public void testToStringNestedVarAdd(){
		Variable left = new Variable("x");
		Subtract right = new Subtract(new Variable("x"), new core.expression.Number("3"));
		Subtract expr = new Subtract(left, right);
		assertEquals("(x-(x-3))", expr.toString());
	}
	
	@Test
	public void testToStringNestedAdds(){
		Subtract left = new Subtract(new Variable("x"), new core.expression.Number("3"));
		Subtract right = new Subtract(new Variable("x"), new core.expression.Number("4"));
		Subtract expr = new Subtract(left, right);
		assertEquals("((x-3)-(x-4))", expr.toString());
	}
}
