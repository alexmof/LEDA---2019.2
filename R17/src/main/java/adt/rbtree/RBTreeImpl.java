package adt.rbtree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;
import adt.rbtree.RBNode.Colour;

public class RBTreeImpl<T extends Comparable<T>> extends BSTImpl<T>
		implements RBTree<T> {

	public RBTreeImpl() {
		this.root = new RBNode<T>();
	}

	protected int blackHeight() {
		int retorno = -1;
		
		if (!isEmpty()) {
			retorno = blackHeight((RBNode<T>) this.root);
		}
		
		return retorno;
	}

	private int blackHeight(RBNode<T> node) {
		if (node.isEmpty()) {
			return 1;
		} else {
			if (node.getColour() == Colour.BLACK) {
				return (1 + blackHeight((RBNode<T>) node.getRight()));
			} else {
				return blackHeight((RBNode<T>) node.getRight());
			}
		}
	}

	protected boolean verifyProperties() {
		boolean resp = verifyNodesColour() && verifyNILNodeColour()
				&& verifyRootColour() && verifyChildrenOfRedNodes()
				&& verifyBlackHeight();

		return resp;
	}

	/**
	 * The colour of each node of a RB tree is black or red. This is guaranteed
	 * by the type Colour.
	 */
	private boolean verifyNodesColour() {
		return true; // already implemented
	}

	/**
	 * The colour of the root must be black.
	 */
	private boolean verifyRootColour() {
		return ((RBNode<T>) root).getColour() == Colour.BLACK; // already
																// implemented
	}

	/**
	 * This is guaranteed by the constructor.
	 */
	private boolean verifyNILNodeColour() {
		return true; // already implemented
	}

	/**
	 * Verifies the property for all RED nodes: the children of a red node must
	 * be BLACK.
	 */
	private boolean verifyChildrenOfRedNodes() {
		boolean retorno = true;
		
		if (!isEmpty()) {
			retorno = verifyChildrenOfRedNodes((RBNode<T>) this.root);
		}
		
		return retorno;
	}

	private boolean verifyChildrenOfRedNodes(RBNode<T> node) {
		if (node.isEmpty()) {
			return true;
		} else {
			if (node.getColour() == Colour.RED) {
				RBNode<T> RNode = (RBNode<T>) node.getRight();
				RBNode<T> LNode = (RBNode<T>) node.getLeft();
				
				if (RNode == Colour.RED || LColour == Colour.RED) {
					return (false && verifyChildrenOfRedNodes(node.getRight()));
				}	
			}
		}
	}

	/**
	 * Verifies the black-height property from the root.
	 */
	private boolean verifyBlackHeight() {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void insert(T value) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public RBNode<T>[] rbPreOrder() {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	// FIXUP methods
	protected void fixUpCase1(RBNode<T> node) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	protected void fixUpCase2(RBNode<T> node) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	protected void fixUpCase3(RBNode<T> node) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	protected void fixUpCase4(RBNode<T> node) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	protected void fixUpCase5(RBNode<T> node) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}
}
