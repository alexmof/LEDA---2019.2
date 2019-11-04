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
		int balance = -1;
		
		if (node != null) {
			int heightR = heightRec((BSTNode<T>) node.getRight(), -1);
			int heightL = heightRec((BSTNode<T>) node.getLeft(), -1);
			
			balance = heightL - heightR;
		}
		
		return balance;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		if (node != null) {
			int balance =  calculateBalance(node);
			
			if (Math.abs(balance) > 1) {
				if (balance > 0) {
					int balanceL = calculateBalance((BSTNode<T>) node.getLeft());
					if (balanceL >= 1 || Math.abs(balanceL) <= 1) {
						
					}
				} else if (balance < 0) {
					
				}
			}
		}
		
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		if (node != null) {
			BSTNode<T> parent = (BSTNode<T>) node.getParent();
			
			while (parent != null) {
				rebalance(parent);
				parent = (BSTNode<T>) parent.getParent();
			}
		}
	}
}
