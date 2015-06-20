package core.expression;

/**
 * 
 * @author tzimuto1
 *
 */
public class Add implements Expression {
	private final Expression left;
	private final Expression right;
	/**
	 * Representation of an addition expression
	 * @param left mathematical Expression. Should not be null.
	 * @param right mathematical Expression. Should not be null.
	 */
	public Add(Expression left, Expression right){
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
		return "(" + left.toString() + "+" + right.toString() + ")";
	}
}
