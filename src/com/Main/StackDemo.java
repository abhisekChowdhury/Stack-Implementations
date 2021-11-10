package com.Main;

public class StackDemo {

	public static void main(String[] args) {
		
		/*This part of the code checks whether the brackets are balanced
		 * using a checkBalance() method
		 * 
		 * This works with Array, LinkedList and Vector (No issues here)*/
		System.out.println(checkBalance("a {b [c * (d + e) ] – f}"));	//True
		System.out.println("\n--------------------");
		System.out.println(checkBalance("{a (b * c) / [ d + e ] / f ) − g }"));	//False
		System.out.println("\n--------------------");
		System.out.println(checkBalance("a { b[c − d] e ] ) f"));	//False
		System.out.println("\n--------------------");
		System.out.println(checkBalance("({}())"));	//True
		System.out.println("\n--------------------");

		
		/*
		 * THIS IS WHERE THE PROBLEM IS.
		 * 
		 *  This part of the code pushes and pops elements from the stack using
		 *  the three kinds of implementations (LinkedList, Array and Vector)*/
				
		//Using LinkedList Stack (Does not work correctly)
		System.out.println("Using LinkedList Stack");
		@SuppressWarnings("unchecked")
		StackInterface<Integer> linkedStack = new StackImplementation_LinkedList();
		linkedStack.push(1);
		System.out.println();
		((StackImplementation_LinkedList) linkedStack).display();
		linkedStack.push(2);
		((StackImplementation_LinkedList) linkedStack).display();
		linkedStack.push(3);
		((StackImplementation_LinkedList) linkedStack).display();
		linkedStack.pop();
		((StackImplementation_LinkedList) linkedStack).display();
		System.out.println();
		
		
		
		System.out.println();
		
		
		//Using ArrayStack 
		// (Does not work correctly. Does not push the first element 
		// pushes from the second element...)
		System.out.println("Using Array Stack");
		StackInterface<Integer> stack = new StackImplementation_Array<>();
		stack.push(1);
		System.out.println(stack);
		stack.push(2);
		stack.push(3);
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		
		System.out.println();
		
		
		//Using VectorStack
		// This works fine! :)
		System.out.println("Using Vector Stack");
		StackInterface<Integer> vectorStack = new StackImplementation_Vector<>();
		vectorStack.push(1);
		System.out.println(vectorStack);
		vectorStack.push(2);
		System.out.println(vectorStack);
		vectorStack.push(3);
		System.out.println(vectorStack);
		vectorStack.pop();
		System.out.println(vectorStack);
		

	}
	
	
	
	
   //Checks if the brackets are paired
   private static boolean isPaired(char open, char close)
   {
      return (open == '(' && close == ')') ||
             (open == '[' && close == ']') ||
             (open == '{' && close == '}');
   } // end isPaired
   
   
  /** Checks whether the brackets are balanced
       @param expression  A string to be checked.
       @return  returns true if balanced. */
   public static boolean checkBalance(String expression)
   {
	   @SuppressWarnings("unchecked")
	   /*By default, LinkedList implementation is selected, but you can comment it out
	    * select some other implementation (Vector or Array) */
	//StackInterface<Character> openDelimiterStack = new StackImplementation_Vector<>();  
	//StackInterface<Character> openDelimiterStack = new StackImplementation_Array();
	StackInterface<Character> openDelimiterStack = new StackImplementation_LinkedList();
	   
	      int characterCount = expression.length();
	      boolean isBalanced = true;
	      int index = 0;
	      char nextCharacter = ' ';
	       
	      while (isBalanced && (index < characterCount)) {
	         nextCharacter = expression.charAt(index);
	         switch (nextCharacter) {
	            case '(': case '[': case '{':
	               openDelimiterStack.push(nextCharacter);
	               break;             
	            case ')': case ']': case '}':
	               if (openDelimiterStack.isEmpty())
	                  isBalanced = false;
	               else {
	                  char openDelimiter = openDelimiterStack.pop();
	                  isBalanced = isPaired(openDelimiter, nextCharacter);
	               } 
	               break;
	            default: break; 
	         } 
	         index++;
	      } 
	       
	      if (!openDelimiterStack.isEmpty())
	         isBalanced = false;
	         
	      return isBalanced;
	   } 
   }



