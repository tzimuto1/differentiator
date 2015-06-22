package core.expression;

public interface Expression {
	/**
	 * Differentiate this expression TODO show/state the rules that will be used. Also
	 * for now just differentiate with respect to x
	 * @param x variable to differentiate with respect to
	 * @return Expression
	 */
	public Expression differentiate(String x);
	
}
