package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		for (int i = 0; i <= rightIndex; i++) {
			int indexMenor = i;
			
			for (int j = i + 1; j <= rightIndex; j++) {
				if(array[j].compareTo(array[indexMenor]) < 0) {
					indexMenor = j;
				}
			}
			
			for (int k = indexMenor; k > i; k--) {		
				T aux = array[k];
				array[k] = array[k - 1];
				array[k - 1] = aux;
			}
		}
	}
}
