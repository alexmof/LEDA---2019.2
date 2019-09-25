package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		for(int i = leftIndex; i <= rightIndex; i++) {
			
			int indexMaior = 0;
			
			for (int j = 0; j <= rightIndex - i; j++) {
				if (array[j].compareTo(array[indexMaior]) > 0) {
					indexMaior = j;
				}
			}
			
			//swap
			for (int k = indexMaior + 1; k <= rightIndex - i; k++) {		
				T aux = array[k];
				array[k] = array[indexMaior];
				array[indexMaior] = aux;
				indexMaior++;
			}
			
		}
	}
}
