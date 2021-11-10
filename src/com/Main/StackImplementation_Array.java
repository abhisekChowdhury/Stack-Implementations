package com.Main;

import java.util.Arrays;
import java.util.EmptyStackException;

public final class StackImplementation_Array<T> implements StackInterface<T>{
	
		private T[] stack;    // Array of stack entries
		private int topIndex=0; // Index of top entry
		private boolean integrityOK = false;
		private static final int DEFAULT_CAPACITY = 50;
		private static final int MAX_CAPACITY = 10000;
	  
	   public StackImplementation_Array()
	   {
	      this(DEFAULT_CAPACITY);
	   }
	  
	   public StackImplementation_Array(int initialCapacity)
	   {
	      integrityOK = false;
	      checkCapacity(initialCapacity);
	      @SuppressWarnings("unchecked")
	      T[] tempStack = (T[])new Object[initialCapacity];
	      stack = tempStack;
			topIndex = -1;
	      integrityOK = true;
	  }

	   private void ensureCapacity()
	   {
	      if (topIndex >= stack.length - 1) // size doubles
	      {
	         int newLength = 2 * stack.length;
	         checkCapacity(newLength);
	         stack = Arrays.copyOf(stack, newLength);
	      } 
	   } 
	   
	   private void checkCapacity(int capacity)
	   {
	      if (capacity > MAX_CAPACITY)
	         throw new IllegalStateException("Attempt to create a list " +
	                                         "whose capacity exceeds " +
	                                         "allowed maximum.");
	   } 

	@Override
	public void push(T newEntry) {
		checkIntegrity();
		ensureCapacity();
		stack[topIndex + 1] = newEntry;
		topIndex++;
		
	}

	@Override
	public T pop() {
		checkIntegrity();
		   if (isEmpty())
		      throw new EmptyStackException();
		   else
		   {
		      T top = stack[topIndex];
		      stack[topIndex] = null;
		      topIndex--;
		      return top;
		   } 
	}

	@Override
	public T peek() {
		checkIntegrity();
		   if (isEmpty())
		      throw new EmptyStackException();
		   else
		      return stack[topIndex];
	}

	@Override
	public boolean isEmpty() {
		return this.topIndex < 0;
	}

	@Override
	public void clear() {
		checkIntegrity() ;

		// Remove all entries in the stack:
		// Remove references to the objects in the stack,
		// but do not deallocate the array
		while ( this.topIndex > -1 )
		{
		this.stack[ this.topIndex ] = null ;
		this.topIndex-- ;
		}
		
	}
	
	private void checkIntegrity(){
		if ( !this.integrityOK )
		{
		throw new SecurityException( "ArrayStack object is not " +
		"initialized properly." ) ;
		}
	}
	
	
	//WILL HAVE TO FIX THIS...
	@Override
    public String toString()
    {
         StringBuilder sb = new StringBuilder();
         sb.append('[');
         for(int i = 0; i < topIndex ;i++) {
             sb.append(stack[i].toString());
             if(i < topIndex-1){
                 sb.append(",");
             }
         }
         sb.append(']');
         return sb.toString();
    }

}
