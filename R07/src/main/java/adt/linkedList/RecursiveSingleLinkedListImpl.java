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

	/*@Override
	public int size() {
		int retorno = 0;
		
		if (!isEmpty()) {
			int size = 1;
			RecursiveSingleLinkedListImpl<T> node = this;
			retorno = size(size, node);
		} 		
		
		return retorno;
	}

	private int size(int size, RecursiveSingleLinkedListImpl<T> node) {
		if (node.getData() == null) {
			return size;
		} else {
			size++;
			node = node.getNext();
			return size(size, node);
		}
	}*/
	
	@Override
	public int size() {		
		if (isEmpty()) {
			return 0;
		} else {
			return 1 + getNext().size();
		}
	}


	/*@Override
	public T search(T element) {
		T retorno = null;
		
		if (!isEmpty()) {
			RecursiveSingleLinkedListImpl<T> node = this;
			retorno = search(element, node);
		}
		
		return retorno;
	}

	private T searchRe(T element) {
		if (node.getData().equals(element)) {
			return element;
		} else {
			node = node.getNext();
			return node.search(element);
		}
	}*/
	
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


	/*@Override
	public void insert(T element) {
		if (isEmpty()) {
			this.setData(element);
		} else {
			RecursiveSingleLinkedListImpl<T> node = this;
			insert(element, node);
		}
	}

	private void insert(T element, RecursiveSingleLinkedListImpl<T> node) {
		if (node.getData() == null) {
			node.setData(element);
		} else {
			node = node.getNext();
			insert(element, node);
		}
	}*/
	
	@Override
	public void insert(T element) {
		if (isEmpty()) {
			this.setData(element);
			this.setNext(new RecursiveSingleLinkedListImpl<T>());
		} else {
			this.getNext().insert(element);
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
