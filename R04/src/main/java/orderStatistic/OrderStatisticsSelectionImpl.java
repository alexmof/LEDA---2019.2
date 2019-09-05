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
			int indexLastLower = 0;
			return OrderStatistics(array, k, indexLastLower, k);
		}
	}

	private T OrderStatistics(T[] array, int k, int indexLastLower, int cont) {
		if (cont > 0) {	
			int indexCurrentLower = 0;
			for (int i = 0; i < array.length; i++) {
				if (i != indexLastLower && array[i].compareTo(array[indexLastLower]) > 0 && array[i].compareTo(array[indexCurrentLower]) < 0) {
					indexCurrentLower = i;
				}
			}
			indexLastLower = indexCurrentLower;
			cont--;
			return OrderStatistics(array, k, indexLastLower, cont);
		} else {
			return array[indexLastLower];
		}
	}

}

