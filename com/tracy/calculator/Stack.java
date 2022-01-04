package com.tracy.calculator;

public class Stack {

	private int count = 0; //number of elements in the stack
	private int top = -1; //top element of the stack. 
					 //top == -1 if the stack is empty
	private int MAXSIZE = 1000;  //Physical size of the stack
	

	private int [ ] array = new int[MAXSIZE]; //initializing an array with the max size
	
	
	//constructor
	Stack( ) {
	}
	
	//inspectors
	
	//Returns true if the stack is empty. Otherwise returns false.
	public boolean stackEmpty() {
		return top == -1;
	}
	
	//Returns the top element of the stack
	public int stackTop() {
		return array[top];
	}
	
	//Returns the number of elements in the stack
	public int stackCount() {	
		return count;
	}

	
	//Returns the elements of the stack with the following format:
	//< E1 E2 E3 ... En> where E1 is at the bottom of the stack
	//and En is at the top of the stack.
	public String toString() {

		
		String c = ""; // empty string to store elements
		
		//going through the number of elements
		for( int i = 0; i < top; i++) {
			
			//converting element to a characters
			//and adding them to to the string
			c += (char)array[i] + " ";
		}
			
		return c;
		
	}
	
	//Returns the elements of the stack with the following format:
	//< E1 E2 E3 ... En> where E1 is at the bottom of the stack
	//and Enis at the top of the stack.
	//The elements are printed to the returning string as chars.
	public String printCharStack() {
		
		
		String c = "";	//empty string to store elements
		
		//go through the number of items
		for(int i = 0; i < count; i++) {
			
			//add the convert the element to a character
			//and add it to the empty string
			c += " " + (char)array[i];	
		}
		
		return c;
	}

	//modifiers
	
	//Pushes element to the top of the stack.
	//Assumes that we will not run out of space in the stack.
	public void stackPush(int element) {
		
		//if we run out of space
		if( stackCount() == array.length) {
			
			//make a new array that doubles the size
			int[] newArray = new int[array.length * 2]; 
			
			for( int i = 0; i < array.length; i++) {
				
				//adding stuff to the new array
				newArray[i] = array[i];
			}
			
			//set the array to the new array
			array = newArray;
		}
		
		//set the element to the array
		array[count] = element;
		
		//increment count and top
		count++;
		top++;
	}
	
	//Pops out the top element of the stack.
	//Returns true if the operation was successful.
	//Returns false otherwise.
	public boolean stackPop() {
		
		
		//if the stack is empty return false
		if( stackEmpty()){
			return false;
		}
		//otherwise
		else {
			
			//decrement the top and count and return true
			//"popping"
			top--;
			count--;
			return true;
		}
		
	}
	
}
