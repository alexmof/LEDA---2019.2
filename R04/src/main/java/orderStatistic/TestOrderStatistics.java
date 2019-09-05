package orderStatistic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestOrderStatistics {
	
	private Integer[] vetorTamPar = {9, 20, 2, 21, 16, 28};
	private Integer[] vetorTamImpar = {22, 6, 4, 30, 27};
	private Integer[] vetorVazio = {};
	
	public OrderStatistics<Integer> implementation = new OrderStatisticsSelectionImpl<>();
	
	

	@Test
	public void testVetorPar1() {
		 Integer retorno = implementation.getOrderStatistics(vetorTamPar, 1);
		 assertEquals((Integer) 2, retorno);
	}

	@Test
	public void testVetorPar2() {
		 Integer retorno = implementation.getOrderStatistics(vetorTamPar, vetorTamPar.length);
		 assertEquals((Integer) 28, retorno);
	}
	
	@Test
	public void testVetorPar3() {
		 Integer retorno = implementation.getOrderStatistics(vetorTamPar, 4);
		 assertEquals((Integer) 20, retorno);
	}
	
	@Test
	public void testVetorTamImpar1() {
		Integer retorno = implementation.getOrderStatistics(vetorTamImpar, 1);
		assertEquals((Integer) 4, retorno);
	}
	
	@Test
	public void testVetorTamImpar2() {
		Integer retorno = implementation.getOrderStatistics(vetorTamImpar, vetorTamImpar.length);
		assertEquals((Integer) 30, retorno);
	}
	
	@Test
	public void testVetorTamImpar3() {
		Integer retorno = implementation.getOrderStatistics(vetorTamImpar, 3);
		assertEquals((Integer) 22, retorno);
	}
	
	@Test
	public void testVetorVazio1() {
		Integer retorno = implementation.getOrderStatistics(vetorVazio, 1);
		assertEquals(null, retorno);
	}
	
	@Test
	public void testVetorVazio2() {
		Integer retorno = implementation.getOrderStatistics(vetorVazio, 0);
		assertEquals(null, retorno);
	}
}
