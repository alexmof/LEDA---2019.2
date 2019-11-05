package adt.bst;

import java.util.ArrayList;
import java.util.List;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

   protected BSTNode<T> root;

   public BSTImpl() {
      root = new BSTNode<T>();
   }

   public BSTNode<T> getRoot() {
      return this.root;
   }

   @Override
   public boolean isEmpty() {
      return root.isEmpty();
   }

   @Override
   public int height() {
      int retorno = -1;

      if (!isEmpty()) {
         retorno = height(getRoot());
      }

      return retorno;
   }

   private int height(BSTNode<T> node) {
      if (node.isEmpty()) {
         return -1;
      } else {
         int leftH = 1 + height((BSTNode<T>) node.getLeft());
         int rightH = 1 + height((BSTNode<T>) node.getRight());
         return Math.max(leftH, rightH);
      }
   }

   @Override
   public BSTNode<T> search(T element) {
      BSTNode<T> retorno = createNullNode();

      if (!isEmpty()) {
         retorno = search(element, getRoot());
      }

      return retorno;
   }

   private BSTNode<T> search(T element, BSTNode<T> node) {
      BSTNode<T> retorno = createNullNode();
      if (node.isEmpty()) {
         retorno = createNullNode();
      } else if (node.getData().equals(element)) {
         retorno = node;
      } else {
         if (element.compareTo(node.getData()) < 0) {
            retorno = search(element, (BSTNode<T>) node.getLeft());
         } else if (element.compareTo(node.getData()) > 0) {
            retorno = search(element, (BSTNode<T>) node.getRight());
         }
      }

      return retorno;

   }

   @Override
   public void insert(T element) {
      if (element != null) {
         insert(element, getRoot());
      }

   }

   private void insert(T element, BSTNode<T> node) {
      if (node.isEmpty()) {
         node.setData(element);
         node.setLeft(new BSTNode.Builder().parent(node).build());
         node.setRight(new BSTNode.Builder().parent(node).build());

      } else {
         if (element.compareTo(node.getData()) < 0) {
            insert(element, (BSTNode<T>) node.getLeft());
         } else if (element.compareTo(node.getData()) > 0) {
            insert(element, (BSTNode<T>) node.getRight());
         }
      }

   }

   public BSTNode<T> createNullNode() {
      BSTNode<T> node = (BSTNode<T>) new BSTNode.Builder<T>().data(null).left(null).right(null).parent(null).build();
      return node;
   }

   @Override
   public BSTNode<T> maximum() {
      BSTNode<T> retorno = null;

      if (!isEmpty()) {
         retorno = maximum(getRoot());
      }

      return retorno;
   }

   private BSTNode<T> maximum(BSTNode<T> node) {
      if (node.getRight().isEmpty()) {
         return node;
      } else {
         return maximum((BSTNode<T>) node.getRight());
      }
   }

   @Override
   public BSTNode<T> minimum() {
      BSTNode<T> retorno = null;

      if (!isEmpty()) {
         retorno = minimum(getRoot());
      }

      return retorno;
   }

   private BSTNode<T> minimum(BSTNode<T> node) {
      if (node.getLeft().isEmpty()) {
         return node;
      } else {
         return minimum((BSTNode<T>) node.getLeft());
      }
   }

   @Override
   public BSTNode<T> sucessor(T element) {
      BSTNode<T> retorno = null;

      if (element != null) {

         BSTNode<T> node = search(element);

         if (!node.isEmpty()) {
            if (!node.getRight().isEmpty()) {
               retorno = minimum((BSTNode<T>) node.getRight());
            } else if (node.isLeaf() || node.getRight().isEmpty()) {
               retorno = TreeUp(node);
            }
         }
      }

      return retorno;
   }

   private BSTNode<T> TreeUp(BSTNode<T> node) {
      BSTNode<T> parent = (BSTNode<T>) node.getParent();

      while (parent != null && parent.getData().compareTo(node.getData()) < 0) {
         node = parent;
         parent = (BSTNode<T>) node.getParent();
      }

      return parent;
   }

   @Override
   public BSTNode<T> predecessor(T element) {
      BSTNode<T> retorno = null;

      if (element != null) {

         BSTNode<T> node = search(element);

         if (node != minimum()) {
            if (!node.isEmpty()) {
               if (!node.getLeft().isEmpty()) {
                  retorno = maximum((BSTNode<T>) node.getRight());
               } else if (node.isLeaf() || node.getLeft().isEmpty()) {
                  retorno = TreeUp(node);
               }
            }
         }

      }

      return retorno;
   }

   @Override
   public void remove(T element) {
      BSTNode<T> node = search(element);

      if (!node.isEmpty()) {
         if (node.isLeaf()) {
            node.setData(null);

         } else if (hasOneChild(node)) {
            if (node.getParent() != null) {
               if (!node.getParent().getLeft().equals(node)) {
                  if (!node.getLeft().isEmpty()) {
                     node.getParent().setRight(node.getLeft());
                     node.getLeft().setParent(node.getParent());
                  } else {
                     node.getParent().setRight(node.getRight());
                     node.getRight().setParent(node.getParent());
                  }

               } else {
                  if (!node.getLeft().isEmpty()) {
                     node.getParent().setLeft(node.getLeft());
                     node.getLeft().setParent(node.getParent());
                  } else {
                     node.getParent().setLeft(node.getRight());
                     node.getRight().setParent(node.getParent());
                  }
               }
            } else {
               if (node.getLeft().isEmpty()) {
                  this.root = (BSTNode<T>) node.getRight();
               } else {
                  this.root = (BSTNode<T>) node.getLeft();
               }
               this.root.setParent(null);
            }
         } else {
            T sucessorNode = sucessor(node.getData()).getData();
            remove(sucessorNode);
            node.setData(sucessorNode);
         }
      }
   }

   private boolean hasOneChild(BSTNode<T> node) {

      return ((node.getRight().isEmpty() && !node.getLeft().isEmpty() || node.getLeft().isEmpty()
            && !node.getRight().isEmpty()));
   }

   @Override
   public T[] preOrder() {
      @SuppressWarnings("unchecked")
      T[] arrayResult = (T[]) new Comparable[this.size()];
      List<T> aux = new ArrayList<T>();

      if (!this.isEmpty()) {
         preOrder(this.root, aux);

         aux.toArray(arrayResult);
      }
      return arrayResult;
   }

   private void preOrder(BSTNode<T> node, List<T> array) {

      if (!node.isEmpty()) {
         array.add(node.getData());
         preOrder((BSTNode<T>) node.getLeft(), array);
         preOrder((BSTNode<T>) node.getRight(), array);
      }
   }

   @Override
   public T[] order() {
      @SuppressWarnings("unchecked")
      T[] arrayResult = (T[]) new Comparable[this.size()];
      List<T> aux = new ArrayList<T>();

      if (!this.isEmpty()) {
         Order(this.root, aux);

         aux.toArray(arrayResult);
      }
      return arrayResult;
   }

   private void Order(BSTNode<T> node, List<T> array) {

      if (!node.isEmpty()) {
         Order((BSTNode<T>) node.getLeft(), array);
         array.add(node.getData());
         Order((BSTNode<T>) node.getRight(), array);
      }
   }

   @Override
   public T[] postOrder() {
      @SuppressWarnings("unchecked")
      T[] arrayResult = (T[]) new Comparable[this.size()];
      List<T> aux = new ArrayList<T>();

      if (!this.isEmpty()) {
         postOrder(this.root, aux);

         aux.toArray(arrayResult);
      }
      return arrayResult;
   }

   private void postOrder(BSTNode<T> node, List<T> array) {

      if (!node.isEmpty()) {
         postOrder((BSTNode<T>) node.getLeft(), array);
         postOrder((BSTNode<T>) node.getRight(), array);
         array.add(node.getData());
      }
   }

   /**
    * This method is already implemented using recursion. You must understand
    * how it work and use similar idea with the other methods.
    */
   @Override
   public int size() {
      return size(root);
   }

   private int size(BSTNode<T> node) {
      int result = 0;
      // base case means doing nothing (return 0)
      if (!node.isEmpty()) { // indusctive case
         result = 1 + size((BSTNode<T>) node.getLeft()) + size((BSTNode<T>) node.getRight());
      }
      return result;
   }

}
