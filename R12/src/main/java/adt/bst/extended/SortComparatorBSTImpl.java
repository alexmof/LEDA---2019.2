package adt.bst.extended;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Implementacao de SortComparatorBST, uma BST que usa um comparator interno em suas funcionalidades
 * e possui um metodo de ordenar um array dado como parametro, retornando o resultado do percurso
 * desejado que produz o array ordenado. 
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class SortComparatorBSTImpl<T extends Comparable<T>> extends BSTImpl<T> implements SortComparatorBST<T> {

	private Comparator<T> comparator;
	
	public SortComparatorBSTImpl(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}

	@Override
	public T[] sort(T[] array) {
		
	}

	@Override
	public T[] reverseOrder() {
		List<T> retorno = new ArrayList<>();
		
		if (!isEmpty()) {
			reverseOrder(retorno, getRoot());
		}
		return ((T[]) retorno.toArray());
	}

	private void reverseOrder(List<T> list, BSTNode<T> node) {
		if (isEmpty()) {
			return;
		}
		reverseOrder(list, (BSTNode<T>) node.getRight());
		list.add(node.getData());
		reverseOrder(list, (BSTNode<T>) node.getLeft());
		
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
}
