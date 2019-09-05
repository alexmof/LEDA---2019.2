package orderStatistic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestOrderStatistics {
	
	private Integer[] vetorTamPar = {9, 20, 2, 21, 16, 28};
	private Integer[] vetorTamImpar = {22, 6, 4, 30, 27};
	private Integer[] vetorVazio= {};
	private Integer[] vetorValoresRepetidos = {24, 13, 6, 4, 13, 6};
	private Integer[] vetorValoresIguais = {3, 3, 3, 3, 3};
	
	public OrderStatistics<Integer> implementation = new OrderStatisticsSelectionImpl<>();
	
	

	@Test
	public void testVetorPar1() {
		 Integer retorno = implementation.getOrderStatistics(vetorTamPar, 1);
		 assertEquals((Integer) 2, retorno);
	}

	@Test
	public void testVetorPar2() {
		 Integer retorno = implementation.getOrderStatistics(vetorTamPar, vetorTamPar.length - 1);
		 assertEquals((Integer) 28, retorno);
	}
}
