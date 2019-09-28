package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		super();
		this.head = new DoubleLinkedListNode<T>();
		this.last = (DoubleLinkedListNode<T>) this.head;
	}
	
	@Override
	public void insertFirst(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> NIL = new DoubleLinkedListNode<>();
		
			SingleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(element, null, NIL);
			newNode.setNext(getHead());
			getLast().setPrevious((DoubleLinkedListNode<T>)newNode);
		
			if(getHead().isNIL()) {
				setLast((DoubleLinkedListNode<T>) newNode);
			}
		
			head = newNode;
		}		
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()) {
			setHead(getHead().getNext());
			
			if (getHead().isNIL()) {
				setLast((DoubleLinkedListNode<T>) getHead());
			}
			
			getLast().setPrevious(new DoubleLinkedListNode<>());
		}
	}

	@Override
	public void removeLast() {
		/*if (!isEmpty()) {
			if (size() == 1) {
				this.setHead(new DoubleLinkedListNode<>());
				this.setLast(new DoubleLinkedListNode<>());
			} else {
				DoubleLinkedListNode<T> newLast = this.getLast().getPrevious();
				newLast.setNext(new DoubleLinkedListNode<>());
			
				if (size() == 1) {
					this.setHead(newLast);
				}
			
				this.setLast(newLast);
			}
		}*/
		
		if (!getLast().isNIL()) {
			setLast(getLast().getPrevious());
			
			if (getLast().isNIL()) {
				setHead(getLast());
			}
			
			getLast().setNext(new DoubleLinkedListNode<T>());
		}
	}
	
	public void insert(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<>(), new DoubleLinkedListNode<>());
			
			if (isEmpty()) {
				setHead(newNode);
			} else {
				getLast().setNext(newNode);
				newNode.setPrevious(getLast());
				
			}
			setLast(newNode);
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
