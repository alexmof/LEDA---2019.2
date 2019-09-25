package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		T retorno = null;
		if (!this.isEmpty()) {
			retorno = this.array[top];
		}
		return retorno;
	}

	@Override
	public boolean isEmpty() {
		boolean retorno = false;
		if (top == -1) {
			retorno = true;
		}
		return retorno;
	}

	@Override
	public boolean isFull() {
		boolean retorno = false;
		if (top == (array.length - 1)) {
			retorno = true;
		}
		return retorno;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(!isFull()) {
			if (element != null) {
				top ++;
				array[top] = element;
			}
		} else {
			throw new StackOverflowException();
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(!isEmpty()) {
			T retorno =  array[top];
			top --;
			return retorno;
		} else {
			throw new StackUnderflowException();
		}
	}

}
