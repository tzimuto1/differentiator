package core.expression;

public class Subtract implements Expression {
	//FIXME Subtraction not fully supported
	private final Expression left;
	private final Expression right;
	/**
	 * Representation of a subtraction expression
	 * @param left mathematical Expression. Should not be null.
	 * @param right mathematical Expression. Should not be null.
	 */
	public Subtract(Expression left, Expression right){
		this.left = left;
		this.right = right;
	}
	
	@Override
	public Expression differentiate(String x) {
		return new Subtract(left.differentiate(x), right.differentiate(x));
	}
	
	@Override
	public String toString(){
		return "(" + left.toString() + "-" + right.toString() + ")";
	}

}
