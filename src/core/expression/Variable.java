package core.expression;

/**
 * 
 * @author tzimuto1
 *
 */
public class Variable implements Expression {

	private String variable;
	
	/**
	 * Representation of a Variable expression
	 * @param variable the variable
	 */
	public Variable(String variable){
		this.variable = variable;
	}
	
	@Override
	public Expression differentiate() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString(){
		return variable;
	}

}
