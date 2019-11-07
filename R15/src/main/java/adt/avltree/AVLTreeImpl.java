package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * 
 * Implementacao de uma arvore AVL
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		Integer balance = null;
		if (node != null) {
			int leftHeight = heightRec((BSTNode<T>) node.getLeft(), -1);
			int rightHeight = heightRec((BSTNode<T>) node.getRight(), -1);
			
			balance = leftHeight - rightHeight;
			
		}
		return balance;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}
}
