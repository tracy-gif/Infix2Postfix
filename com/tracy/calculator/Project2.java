package com.tracy.calculator;
import java.util.Scanner;

public class Project2 {

	private static Stack operatorStack = new Stack(); //stack for storing operators
	private static String exp = ""; //empty string to store values for tracer
	
	public static void main(String args[]) {
		String infixExp; //infix expression to be read
		String postfixExp; //postfix expression to be computed
		
		Stack S = new Stack(); //stack for converting the infix expression to postfix notation
							   
		
		System.out.print( "Enter an infix expression: ");
		Scanner scan = new Scanner(System.in);
		
		//reading the infix expression
		infixExp = scan.next();
		
		//Calling infixToPostfix method 
		postfixExp = infixToPostfix( infixExp );
		
		//printing out the post fix expression
		System.out.println("The expression in postfix notation is: " 
							+ postfixExp );
		
		//closing the scanner
		scan.close();
	}
	
	//method to convert an infix expression to a postfix expression
	public static String infixToPostfix( String expression ) {
		
		//local variables
		String postFix = "";//string used to store everything
		char c;
		
		
		//going through each character in the string/expression
		for( int i = 0; i < expression.length(); ++i) {
			
			//character that looks at the specific character in the string
			 c = expression.charAt(i);
			
			//if character is an operand
			if (Character.isDigit(c)) {
				
				//then add it to the string
				postFix += c;
				exp += c;
				
				//stack trace
				stackTrace( c , exp, operatorStack );
			}
			
			//If character is an '('
			else if( c == '(') {
				
				//push it into the stack
				operatorStack.stackPush(c);
				
				//stack trace
				stackTrace( c , exp, operatorStack );
			}
			
			//if the character is a ')'
			else if( c == ')') {
				
				//while the stack is not empty and the top element is not an '('
				while((char)operatorStack.stackTop() != '(' ){
					
					//add it to the string
					postFix += (char) operatorStack.stackTop();
					exp += (char)operatorStack.stackTop();
					
					//then pop it
					operatorStack.stackPop();
					
				}
				
				//removing '('
				operatorStack.stackPop();

				//stack trace
				stackTrace( c , exp, operatorStack );
				
			}
			
			//if operator is a '+' or a '-'
			else if( c == '+' || c == '-'){

				//while the stack is not empty and the 
				//top element is an operator
				while(!operatorStack.stackEmpty() && 
						  (operatorStack.stackTop() == '+' ||
						   operatorStack.stackTop() == '-'||
						   operatorStack.stackTop() == '*' ||
						   operatorStack.stackTop() == '/')){
					
					//pop the operator and add it to the string
					postFix += (char)operatorStack.stackTop();
					exp += (char)operatorStack.stackTop();
					
					//then pop it
					operatorStack.stackPop();
					
					//stack trace
					stackTrace( c , exp, operatorStack );
				}
				
				//push the operator into stack
				operatorStack.stackPush(c);
				stackTrace( c , exp, operatorStack );
			}

			//if operator is a '*' or '/'
			else if(c=='*' || c=='/') {
				
				//while the stack is not empty and is either a '*' or '/' operator
				while (!operatorStack.stackEmpty() &&
						(operatorStack.stackTop() == '*' ||
						operatorStack.stackTop() == '/')) {
					
					//add it to the string
					postFix += (char)operatorStack.stackTop();
					exp += (char)operatorStack.stackTop();
					
					//then pop it
					operatorStack.stackPop();
					
					//stack trace
					stackTrace( c , exp, operatorStack );
				}
				
				//push the operator into the stack
				operatorStack.stackPush(c);
				
				//stack trace
				stackTrace( c , exp, operatorStack );
				
			}
			//validation of expression
			else {
				return "Invalid Expression. Please type an infix expression";
			}
		}

			
		//popping all the operators from the stack
		//while the stack is not empty 
		while( !operatorStack.stackEmpty()) {
			
			///add the operator to the strings
			postFix += (char)operatorStack.stackTop();
			exp += (char)operatorStack.stackTop();
			
			//pop the operator
			operatorStack.stackPop();
			
			//stack trace
			stackTrace( ' ', exp, operatorStack);
				
		}
		
		//then return the string
		return postFix;		
	}
	

	//method that prints a stack trace
	public static void stackTrace( char ch, String s,  Stack st ) {
		System.out.println(ch + ":" + "     " + s + "\t" + "<" + st.printCharStack() + " >");
	}
		

}
	
