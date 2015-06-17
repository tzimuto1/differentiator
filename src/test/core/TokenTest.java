package test.core;
import static org.junit.Assert.*;
import org.junit.Test;

import core.Token;
import core.Token.Type;

public class TokenTest {
	//Tests
	//	getType():
	//		LEGAL/ILLEGAL
	//  getValue():
	//		LEGAL/ILLEGAL
	//	equals():
	//		equal by reference, equal by content, one null, not equal neither null
	//	toString():
	//    	LEGAL/ILLEGAL
	@Test
	public void testGetType(){
		Token token = new Token(Type.MULTI, "*");
		assertEquals(Type.MULTI, token.getType());
	}
	
	@Test
	public void testGetValue(){
		Token token = new Token(Type.MULTI, "*");
		assertEquals("*", token.getValue());
	}
	
	@Test
	public void testEqualsByReference(){
		Token token = new Token(Type.MULTI, "*");
		assertTrue(token.equals(token));
	}
	
	@Test
	public void testEqualsByValue(){
		String a = "*saasa";
		String expr1 = a.substring(0, 1);
		String expr2 = "*";
		Token token1 = new Token(Type.MULTI, expr1);
		Token token2 = new Token(Type.MULTI, expr2);
		System.out.println(token1.getValue().hashCode() + " " + token2.getValue().hashCode());
		System.out.println(expr1 == expr2);
		System.out.println(expr1.equals(expr2));
		assertTrue(token1.equals(token2));
	}
	
	@Test
	public void testEqualsNull(){
		Token token1 = new Token(Type.MULTI, "*");
		Token token2 = null;
		assertFalse(token1.equals(token2));
	}
	
	@Test
	public void testEqualsNoEqual(){
		Token token1 = new Token(Type.MULTI, "*");
		Token token2 = new Token(Type.MINUS, "-");
		assertFalse(token1.equals(token2));
	}
	
	
	@Test
	public void testToString(){
		Token token = new Token(Type.MULTI, "*");
		assertEquals("MULTI:*", token.toString());
	}
}
