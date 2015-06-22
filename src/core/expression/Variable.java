package core.expression;

/**
 * 
 * @author tzimuto1
 *
 */
public class Variable implements Expression {

	private final String variable;
	
	/**
	 * Representation of a Variable expression
	 * @param variable the variable
	 */
	public Variable(String variable){
		this.variable = variable;
	}
	
	@Override
	public Expression differentiate(String x) {
		return x.equals(variable) ? new Number("1") : new Number("0");
	}
	
	public String toString(){
		return variable;
	}

}
