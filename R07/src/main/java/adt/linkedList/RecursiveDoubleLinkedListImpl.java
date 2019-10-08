package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insertFirst(T element) {
		T aux = this.getData();
		this.setData(element);
		RecursiveDoubleLinkedListImpl<T> second = new RecursiveDoubleLinkedListImpl<T>();
		second.setData(aux);
		second.setPrevious(this);
		
		
		RecursiveDoubleLinkedListImpl<T> third = (RecursiveDoubleLinkedListImpl<T>) this.getNext();
		second.setNext(third);
		
		this.setNext(second);
		third.setPrevious(second);
		
		
	}

	@Override
	public void removeFirst() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
