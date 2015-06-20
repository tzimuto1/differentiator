package test.core.expression;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
}
