package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {
		super();
	}
	
	public RecursiveDoubleLinkedListImpl(RecursiveDoubleLinkedListImpl<T> previous, RecursiveDoubleLinkedListImpl<T> next, T data){
		super();
		this.previous = previous;
		this.next = next;
		this.data = data;
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			if (isEmpty()) {
				this.insert(element);
			} else {
				RecursiveDoubleLinkedListImpl<T> newNode = new RecursiveDoubleLinkedListImpl<T>(this, (RecursiveDoubleLinkedListImpl<T>) this.getNext(), this.getData());
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(newNode);
				this.setData(element);
				this.setNext(newNode);
			}	
		}	
	}
	
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				setData(element);
				setNext(new RecursiveDoubleLinkedListImpl<T>(this, null, null));
				if (getPrevious() == null)
					setPrevious(new RecursiveDoubleLinkedListImpl<T>(null, this, null));
			} else {
				this.next.insert(element);
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()) {
			T aux = this.getData();
			this.setData(this.getNext().getData());
			this.getNext().setData(aux);
			this.setNext(this.getNext().getNext());
		}
	}
	
	public void remove(T element) {
		if (element != null) {
			if (!isEmpty()) {
				if (this.getData().equals(element)) {
					this.getPrevious().setNext(this.getNext());
					((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this.getPrevious());
				} else {
					this.getNext().remove(element);
				}
			}
		}
	}

	@Override
	public void removeLast() {
		if (!isEmpty()) {
			((DoubleLinkedList<T>) this.getNext()).removeLast();
		} else {
			if (this.getPrevious().getData() != null) {
				 this.getPrevious().getPrevious().setNext(new RecursiveDoubleLinkedListImpl<>());
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
