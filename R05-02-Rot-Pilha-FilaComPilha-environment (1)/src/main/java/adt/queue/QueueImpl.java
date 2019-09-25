package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		return this.array[0];
	}

	@Override
	public boolean isEmpty() {
		boolean retorno = false;
		if (tail == -1) {
			retorno = true;
		} 
		return retorno;
	}

	@Override
	public boolean isFull() {
		boolean retorno = false;
		if (tail == (array.length - 1)) {
			retorno = true;
		} 
		return retorno;
	}

	private void shiftLeft() {
		for (int i = 1; i <= tail; i++) {
			array[i - 1] = array[i];
		}
		tail--;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (!isFull()) {
			if (element != null) {
				tail ++;
				array[tail] = element;
	
			}
		} else {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		} else {
			T retorno = array[0];
			shiftLeft();
			return retorno;
		}
	}

}
