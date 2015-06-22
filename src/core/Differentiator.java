package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Differentiator {
	
	/**
	 * Differentiate the mathematical expression
	 * @param expression
	 * @return diff result of differentiation
	 */
	public static String differentiate(String expression){
		String diff = new Parser(new Lexer(expression)).parse().differentiate("x").toString();
		return diff;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("> ");
			String expression;
			while ((expression = br.readLine()) != null){
				try {
					String diff = Differentiator.differentiate(expression);
					System.out.println(diff);
				} catch (RuntimeException e){
					System.out.println(e.getMessage());
				}
				System.out.print("> ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
