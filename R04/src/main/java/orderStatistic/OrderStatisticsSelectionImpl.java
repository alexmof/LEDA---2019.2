package orderStatistic;

public class OrderStatisticsSelectionImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Esta eh uma implementacao do calculo da estatistica de ordem seguindo a estrategia 
	 * de usar o selection sem modificar o array original. Note que seu algoritmo vai 
	 * apenas aplicar sucessivas vezes o selection ate encontrar a estatistica de ordem 
	 * desejada sem modificar o array original. 
	 * 
	 * Restricoes:
	 * - Preservar o array original, ou seja, nenhuma modificacao pode ser feita no 
	 *   array original
	 * - Nenhum array auxiliar deve ser criado e utilizado.
	 * - Voce nao pode encontrar a k-esima estatistica de ordem por contagem de
	 *   elementos maiores/menores, mas sim aplicando sucessivas selecoes (selecionar um elemento
	 *   como o selectionsort mas sem modificar nenhuma posicao do array).
	 * - Caso a estatistica de ordem nao exista no array, o algoritmo deve retornar null. 
	 * - Considerar que k varia de 1 a N 
	 * - Sugestao: o uso de recursao ajudara sua codificacao.
	 */
	@Override
	public T getOrderStatistics(T[] array, int k) {
		if (k <= 0 || k > array.length) {
			return null;
		} else {
			int max = getMaximo(array);
			int min = getMinimo(array);
			int aux = max;
			return OrderStatistics(array, k, min, aux, max, k - 1);
		}
	}	

	private T OrderStatistics(T[] array, int k, int indexMin, int aux, int indexMax, int cont) {
		if (cont > 0) {	
			for(int i = 0; i < array.length; i++) {
				if (array[i].compareTo(array[indexMin]) > 0 && array[i].compareTo(array[aux]) < 0) {
					aux = i;
				}
			}
			indexMin = aux;
			aux = indexMax;
			cont--;
			return OrderStatistics(array, k, indexMin, aux, indexMax, cont);
		} else {
			return array[indexMin];
		}
	}
	
	private int getMinimo(T[] array) {
		int min = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i].compareTo(array[min]) < 0) {
				min = i;
			}
		}
		return min;
	}

	private int getMaximo(T[] array) {
		int max = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i].compareTo(array[max]) > 0) {
				max = i;
			}
		}
		return max;
	}
}

