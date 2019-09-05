package problems;

import java.util.Arrays;

/**
 * Calcula o floor e ceil de um numero em um array usando a estrategia de busca
 * binaria.
 * 
 * Restricoes: 
 * - Algoritmo in-place (nao pode usar memoria extra a nao ser variaveis locais) 
 * - O tempo de seu algoritmo deve ser O(log n).
 * 
 * @author Adalberto
 *
 */
public class FloorCeilBinarySearch implements FloorCeil {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		if (x < array[0]) {
			return null;
		} else {
			auxFloor()
			Arrays.copyOfRange(array, 0, array.length/2);
			Arrays.copyOfRange(array, (array.length / 2) + 1, array.length);
		}
	}

	@Override
	public Integer ceil(Integer[] array, Integer x) {
		// TODO implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
