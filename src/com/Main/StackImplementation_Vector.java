package com.Main;

import java.util.EmptyStackException;
import java.util.Vector;

public final class StackImplementation_Vector<T> implements StackInterface<T>{

	private Vector<T> stack; 
	   private boolean integrityOK;
		private static final int DEFAULT_CAPACITY = 50;
		private static final int MAX_CAPACITY = 10000;
	  
	   public StackImplementation_Vector()
	   {
	      this(DEFAULT_CAPACITY);
	   } 
	  
	   public StackImplementation_Vector(int initialCapacity)
	   {
	      integrityOK = false;
	      checkCapacity(initialCapacity);
	      stack = new Vector<>(initialCapacity); // Size doubles
	      integrityOK = true;
	   } 
	   
	   private void checkCapacity(int capacity)
	   {
	      if (capacity > MAX_CAPACITY)
	         throw new IllegalStateException("Attempt to create a list " +
	                                         "whose capacity exceeds " +
	                                         "allowed maximum.");
	   } 
	   
	   private void checkIntegrity()
		{
		if ( !this.integrityOK )
		{
		throw new SecurityException( "ArrayStack object is not " +
		"initialized properly." ) ;
		}

		} 
	
	@Override
	public void push(T newEntry) {
		checkIntegrity();
		stack.add(newEntry);

	}

	@Override
	public T pop() {
		checkIntegrity();
		   if (isEmpty())
		      throw new EmptyStackException();
		   else
		      return stack.remove(stack.size() - 1);

	}

	@Override
	public T peek() {
		checkIntegrity();
		   if (isEmpty())
		      throw new EmptyStackException();
		   else
		      return stack.lastElement();
	}

	@Override
	public boolean isEmpty() {
		checkIntegrity();
		return stack.isEmpty();
	}

	@Override
	public void clear() {
		checkIntegrity();
		stack.clear();
	}
	
	@Override
    public String toString()
    {
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (T array : stack) {
		    	sb.append(array + " ");
		}
		sb.append(']');
         return sb.toString();
    }

}
