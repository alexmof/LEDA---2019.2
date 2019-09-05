package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

   @Override
   public void sort(T[] array, int leftIndex, int rightIndex) {
      mergeSort(array, leftIndex, rightIndex);
   }

   private void mergeSort(T[] array, int leftIndex, int rightIndex) {
      if (leftIndex < rightIndex) {
    	 
    	 int middle = (rightIndex + leftIndex) / 2;
         mergeSort(array, leftIndex, middle);
         mergeSort(array, middle + 1, rightIndex);
         
         merge(array, leftIndex, middle, rightIndex);
      }

   }

   private T[] merge(T[] array, int leftIndexL1, int middle, int rightIndexL2) {

      int l1 = leftIndexL1;
      int l2 = middle;

      T[] retorno = ((T[]) new Comparable[array.length]);
      int cont = 0;

      while (l1 <= middle && l2 <= rightIndexL2) {
         if (array[l1].compareTo(array[l2]) < 0) {
            retorno[cont] = array[l1];
            l1++;
         } else if (array[l1].compareTo(array[l2]) > 0) {
            retorno[cont] = array[l2];
            l2++;
         }
         cont++;
      }

      if ((middle - l1) > 0) {
    	  for (int i = l1; i <= middle; i++) {
    		  retorno[cont] = array[i];
    		  cont++;
    	  }
      } else if ((rightIndexL2 - l2) > 0) {
    	  for (int i = l2; i <= rightIndexL2; i++) {
    		  retorno[cont] = array[i];
    		  cont++;
    	  }
      }
      return retorno;
   }
}
