package core.expression;

public class Subtract implements Expression {
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
	public Expression differentiate() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString(){
		return "(" + left.toString() + "-" + right.toString() + ")";
	}

}
