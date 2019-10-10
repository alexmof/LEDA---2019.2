package adt.linkedList.set;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import adt.linkedList.LinkedList;

public class SetLinkedListImplTest {

	protected SetLinkedListImpl<Integer> lista1;
	protected LinkedList<Integer> lista2;
	
	
	@Before
	public void setUp() throws Exception {
		
		getImplementations();
		
		lista1.insert(7);
		lista1.insert(5);
		lista1.insert(7);
		lista1.insert(2);
		//lista1.insert(5);
		lista1.insert(7);
	}
	
	private void getImplementations() {
		lista1 = new SetLinkedListImpl<>();
		lista2 = new SetLinkedListImpl<>();
	}

	@Test
	public void removeDuplicatesTest() {
		Assert.assertFalse(lista1.isEmpty());
		lista1.removeDuplicates();
		Assert.assertArrayEquals(new Integer[] { 7, 5, 2}, lista1.toArray());
		
		lista1.insert(5);
		lista1.insert(9);
		lista1.removeDuplicates();
		Assert.assertArrayEquals(new Integer[] { 7, 5, 2, 9}, lista1.toArray());
	}

}
