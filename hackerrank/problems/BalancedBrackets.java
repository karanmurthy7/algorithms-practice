package hackerrank.problems;

import java.util.Scanner;
import java.util.Stack;

/*
 * A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].
 * Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or { ) 
 * occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. 
 * There are three types of matched pairs of brackets: [], {}, and ().
 * A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. 
 * For example, {[(])} is not balanced because the contents in between { and } are not balanced. 
 * The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of 
 * parentheses encloses a single, unbalanced closing square bracket, ].
 */

/*
 * The following class takes t strings as inputs and prints YES if a string is balanced and NO otherwise.
 */
public class BalancedBrackets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
        in.close();
    }

	private static boolean isBalanced(String expression) {
		
		Stack<Character> bracketStack = new Stack<Character>();
		
		for(int i = 0; i < expression.length(); i++){
			if(expression.charAt(i) == '{' || expression.charAt(i) == '[' || expression.charAt(i) == '('){
				bracketStack.push(expression.charAt(i));
			}else{
				if(!bracketStack.isEmpty()){
					char value = bracketStack.pop();
					if(value == '{' && expression.charAt(i) != '}'){
							return false;
					}else if(value == '[' && expression.charAt(i) != ']'){
							return false;
					}else if(value == '(' && expression.charAt(i) != ')'){
							return false;
					}
				}else{
					return false;
				}
			}
		}
		
		if(bracketStack.isEmpty())
			return true;
		else
			return false;
	}

}
