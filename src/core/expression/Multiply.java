package core.expression;

public class Multiply implements Expression {

	private final Expression left;
	private final Expression right;
	/**
	 * Representation of a multiplication expression
	 * @param left mathematical Expression. Should not be null.
	 * @param right mathematical Expression. Should not be null.
	 */
	public Multiply(Expression left, Expression right){
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
		return "(" + left.toString() + "*" + right.toString() + ")";
	}
}
