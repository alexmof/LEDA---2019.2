package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}


	@Override
	public boolean isEmpty() {
		boolean retorno = false;
		
		if (getData() == null) {
			retorno = true;
		}
		
		return retorno;
	}

	@Override
	public int size() {		
		if (isEmpty()) {
			return 0;
		} else {
			return 1 + this.next.size();
		}
	}
	
	@Override
	public T search(T element){
		if (isEmpty()) {
			return null;
		} else if (getData().equals(element)) {
			return element;
		} else {
			return getNext().search(element);
		}
	}
	
	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				this.setData(element);
				this.setNext(new RecursiveSingleLinkedListImpl<T>());
			} else {
				this.getNext().insert(element);
			}	
		}
	}


	@Override
	public void remove(T element) {
		if (!isEmpty()) {
			if (this.getData().equals(element)) {
				T aux = this.getData();
				this.setData(this.getNext().getData());
				this.getNext().setData(aux);
				
				this.setNext(this.getNext().getNext());
			} else {
				this.removeRec(element);
			}
		}
	}

	private void removeRec(T element) {
		if (this.getNext().getData().equals(element)) {
			this.setNext(this.getNext().getNext());
		} else {
			this.getNext().removeRec(element);
		}
	}


	@Override
	public T[] toArray() {
		if (isEmpty()) {
			return (T[]) new Object[0];
		} else {
			int cont = 0;
			T[] array = (T[]) new Object[this.size()];
			return toArrayRec(cont, array);
		}
		
	}

	private T[] toArrayRec(int cont, T[] array) {
		if (!isEmpty()) {
			array[cont] = this.getData();
			cont++;
			return this.getNext().toArrayRec(cont, array);
		} else {
			return array;
		}		
	}


	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
