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
		int indexMaior = 0;
		
		for (int j = 1; j < array.length; j++) {                // ACHANDO 
			if (array[j].compareTo(array[indexMaior]) > 0) {
				indexMaior = j;
			}
		}
		
		swap(array, indexMaior, array.length);
	}

	private void swap(T[] array, int indexMaior, int length) {
		for(int i = indexMaior; i <= length; i++) {
			  
		}
		
	}	
}
