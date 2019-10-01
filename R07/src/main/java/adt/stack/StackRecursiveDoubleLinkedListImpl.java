package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.RecursiveDoubleLinkedListImpl;
import adt.linkedList.RecursiveSingleLinkedListImpl;

public class StackRecursiveDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackRecursiveDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new RecursiveDoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException();
		} else {
			this.top.insertFirst(element);
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (this.top.isEmpty()) {
			throw new StackUnderflowException();
		} else {
			T retorno = this.top();
			this.top.removeFirst();
			return retorno;	
		}
	}

	@Override
	public T top() {
		return ((RecursiveSingleLinkedListImpl<T>) this.top).getData();
	}

	@Override
	public boolean isEmpty() {
		boolean retorno = false;
		
		if (this.top.isEmpty()) {
			retorno = true;
		}
		
		return retorno;
	}

	@Override
	public boolean isFull() {
		boolean retorno = false;
		
		if (this.size == top.size()) {
			retorno = true;
		}
		
		return retorno;
	}

}
