package com.Main;

import static java.lang.System.exit;

@SuppressWarnings("rawtypes")
public class StackImplementation_LinkedList implements StackInterface{
	
	Node topNode;
	 
    static class Node {
        Object data;
        Node next;
 
        Node(Object newEntry) { this.data = newEntry; }
    }

	@Override
	public void push(Object newEntry) {
		Node newNode = new Node(newEntry);
		 
        if (topNode == null) {
            topNode = newNode;
        }
        else {
            Node temp = topNode;
            topNode = newNode;
            newNode.next = temp;
        }
        System.out.println(newEntry + " pushed to stack");
	}

	@Override
	public Object pop() {
		Object popped = Integer.MIN_VALUE;
        if (topNode == null) {
            System.out.println("Stack is Empty");
        }
        else {
            popped = topNode.data;
            topNode = topNode.next;
        }
        return popped;
	}

	@Override
	public Object peek() {
		if (topNode == null) {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
        else {
            return topNode.data;
        }
	}

	@Override
	public boolean isEmpty() {
		if (topNode == null) {
            return true;
        }
        else
            return false;
	}

	@Override
	public void clear() {
		topNode = null;
	}
	
	
	//Need to fix this...
	public void display()
    {
        // check for stack underflow
        if (topNode == null) {
            System.out.printf("\nStack Underflow");
            exit(1);
        }
        else {
            Node temp = topNode;
            while (temp != null) {
 
                // print node data
                System.out.printf("%d->", temp.data);
 
                // assign temp link to temp
                temp = temp.next;
            }
        }
    }
    
}
