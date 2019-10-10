package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		boolean retorno = false;
		if (this.head.isNIL()) {
			retorno =  true;
		}
		return retorno;
	}

	@Override
	public int size() {
		int cont = 0;
		
		SingleLinkedListNode<T> aux = this.head;  
		
		while (!aux.isNIL()) {
			cont++;
			aux = aux.getNext();
		}
		
		return cont;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> aux = this.head;  
		T retorno = null;
		
		while (!aux.isNIL()) {
			if (aux.getData().equals(element)) {
				retorno = aux.getData();
			}
			aux = aux.getNext();
		}
		
		return retorno;
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> newNode = new SingleLinkedListNode<>(element, new SingleLinkedListNode<>());
		
		if(this.isEmpty()) {
			this.setHead(newNode);
		} else {
			SingleLinkedListNode<T> aux = this.getHead();
			
			while (!aux.getNext().isNIL()) {
				aux = aux.getNext();
			}
			
			aux.setNext(newNode);
		}
	}

	@Override
	public void remove(T element) {
		if (this.head.getData().equals(element)) {
			this.head = this.head.getNext();
		} else {
			SingleLinkedListNode<T> aux = this.head;
			SingleLinkedListNode<T> previous = new SingleLinkedListNode<>();
			
			while (!aux.isNIL() && !aux.getData().equals(element)) {
				previous = aux;
				aux =  aux.getNext();
			}
			if (!aux.isNIL()) {
				previous.next = aux.getNext();
			}
		}
	}

	@Override
	public T[] toArray() {
		SingleLinkedListNode<T> aux = this.head;
		T[] array = (T[]) new Object[this.size()];
		int cont = 0;
		
		while(!aux.isNIL()) {
			array[cont] = aux.getData();
			cont++;
			aux = aux.getNext();
		}
		
		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
