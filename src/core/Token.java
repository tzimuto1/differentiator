package core;



/**
 * 
 * @author tzimuto1
 * 
 */

public class Token {
	private final Type type;
	private final String value;
	
	/**
	 * Token represents a token found in a Mathematical expression. The token can be support by the grammar or illegal
	 * @param type - type of a token represented by an ENUM
	 * @param value - value of a token represented by a String
	 */
	public Token(Type type, String value){
		this.type = type;
		this.value = value;
	}
	
	/*
	 * The ENUM to represent the Token types
	 */
	public static enum Type{
        PLUS,//+
        MINUS,//-
        MULTI,//*
        OPEN_PARENTH,//(
        CLOSED_PARENTH,//)
        NUMBER,//Integer or Float
        VARIABLE,//[a-zA-Z]+
        ILLEGAL//Anything else
    }
	
	/**
	 * Get type of the token
	 * @return type of the token
	 */
	public Type getType(){
		return this.type;
	}
	
	/**
	 * Get value of the token
	 * @return value of the token
	 */
	public String getValue(){
		return this.value;
	}
	
	@Override
	public String toString(){
		return type + ":" + value;
	}
	
	@Override
	public boolean equals(Object other){
		if (other == null) return false;
		if (this == other) return true;
		if (!(other instanceof Token)) return false;
		Token otherToken = (Token)other;
		return (otherToken.type == this.type) && (otherToken.value.equals(this.value));
	}
}
