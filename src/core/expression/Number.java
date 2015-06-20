package core.expression;

/**
 * 
 * @author tzimuto1
 *
 */
public class Number implements Expression {
	
	String number;
	/**
	 * Representation of a number
	 * @param number the number represented by this
	 */
	public Number(String number){
		this.number = number;
	}

	@Override
	public Expression differentiate() {
		// TODO Auto-generated method stub
		return new Number("0");
	}
	
	@Override
	public String toString(){
		return number;
	}
}
