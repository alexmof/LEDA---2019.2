package adt.linkedList.set;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class SetLinkedListImpl<T> extends SingleLinkedListImpl<T> implements SetLinkedList<T> {

	@Override
	public void removeDuplicates() {
		SingleLinkedListNode<T> aux = this.head;
		int size = this.size();
		
		while (aux != null) {
			SingleLinkedListNode<T> aux2 = aux.getNext();
			while (aux2 != null) {
				if (aux.getData().equals(aux2.getData())) {
					aux2.setData(aux2.getNext().getData());
					aux2.setNext(aux2.getNext().getNext());
				} else {
					aux2 = aux2.getNext();
				}
			}
			aux = aux.getNext();
		}
	}

	@Override
	public SetLinkedList<T> union(SetLinkedList<T> otherSet) {
		//TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public SetLinkedList<T> intersection(SetLinkedList<T> otherSet) {
		//TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void concatenate(SetLinkedList<T> otherSet) {
		//TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
