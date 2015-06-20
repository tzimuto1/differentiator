package test.core.expression;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import core.expression.Add;
import core.expression.Variable;

public class AddTest {

	//Tests
	// toString():
	//		x + 3, 3 + x, (x + (x + 3)), ((x+3)+(x+4))
	
	@Test
	public void testToStringVarNum(){
		Add add = new Add(new Variable("x"), new core.expression.Number("3"));
		assertEquals("(x+3)", add.toString());
	}
	
	@Test
	public void testToStringNumVar(){
		Add add = new Add(new core.expression.Number("3"), new Variable("x"));
		assertEquals("(3+x)", add.toString());
	}
	
	@Test
	public void testToStringNestedVarAdd(){
		Variable left = new Variable("x");
		Add right = new Add(new Variable("x"), new core.expression.Number("3"));
		Add expr = new Add(left, right);
		assertEquals("(x+(x+3))", expr.toString());
	}
	
	@Test
	public void testToStringNestedAdds(){
		Add left = new Add(new Variable("x"), new core.expression.Number("3"));
		Add right = new Add(new Variable("x"), new core.expression.Number("4"));
		Add expr = new Add(left, right);
		assertEquals("((x+3)+(x+4))", expr.toString());
	}
}
