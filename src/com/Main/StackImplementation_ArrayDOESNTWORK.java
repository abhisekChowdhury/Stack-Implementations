package com.Main;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackImplementation_ArrayDOESNTWORK<T> implements StackInterface<T>{

	private T[] stack;    // Array of stack entries
	private int topIndex; // Index of top entry
    private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
  
   public StackImplementation_ArrayDOESNTWORK()
   {
      this(DEFAULT_CAPACITY);
   } // end default constructor
  
   public StackImplementation_ArrayDOESNTWORK(int initialCapacity)
   {
      integrityOK = false;
      checkCapacity(initialCapacity);
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempStack = (T[])new Object[initialCapacity];
      stack = tempStack;
		topIndex = -1;
      integrityOK = true;
  } // end constructor
   
   private void checkCapacity(int capacity)
   {
      if (capacity > MAX_CAPACITY)
         throw new IllegalStateException("Attempt to create a list " +
                                         "whose capacity exceeds " +
                                         "allowed maximum.");
   } // end checkCapacity

   private void ensureCapacity()
   {
      if (topIndex >= stack.length - 1) // If array is full, double its size
      {
         int newLength = 2 * stack.length;
         checkCapacity(newLength);
         stack = Arrays.copyOf(stack, newLength);
      } // end if
   } // end ensureCapacity
   
   private void checkIntegrity()
   {
      if (!integrityOK)
         throw new SecurityException ("The list object is not initialized properly.");
   } // end checkInitialization

	
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
		   } // end if
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
