package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (this.isFull()) {
			throw new QueueOverflowException();
		} else {	
			try {
				this.stack1.push(element);
			} catch (StackOverflowException e) {				
				e.printStackTrace();				
			}
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		
		Stack1ToStack2();
		T retorno = null;
		
		try {
			retorno = stack2.pop();
			Stack2ToStack1();
		} catch (StackUnderflowException e) {
			e.printStackTrace();
		}
		
		return retorno;
	}

	private void Stack2ToStack1() {
		while (!this.stack2.isEmpty()) {                   //transferindo da stack2 para stack1
			
			try {
				T element = stack2.pop();
				stack1.push(element);
			} catch (StackUnderflowException | StackOverflowException e) {
				e.printStackTrace();
			}

		}
		
	}
	
	private void Stack1ToStack2() {
		while (!this.stack1.isEmpty()) {                   //transferindo da stack1 para stack2
			
			try {
				T element = stack1.pop();
				stack2.push(element);
			} catch (StackUnderflowException | StackOverflowException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public T head() {
		Stack1ToStack2();
		T retorno = stack2.top();
		Stack2ToStack1();
		return retorno;
	}

	@Override
	public boolean isEmpty() {
		
		boolean retorno = false;
		
		if (stack1.isEmpty()) {
			retorno = true;
		}
		
		return retorno;
	}

	@Override
	public boolean isFull() {
		boolean retorno = false;
		
		if (stack1.isFull()) {
			retorno = true;
		}
		
		return retorno;
	}

}
