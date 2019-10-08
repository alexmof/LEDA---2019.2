package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			
			int cont = 0;
			int hash = -1;
			
			while (cont < this.capacity()) {
				hash = ((HashFunctionLinearProbing<T>) this.getHashFunction()).hash(element, cont);
				
				if (this.table[hash] != null && !this.table[hash].equals(deletedElement)) {
					cont++;
					this.COLLISIONS++;
				} else {
					break;
				}
			}
			
			if (cont < this.capacity()) {
				this.table[hash] = element;
				this.elements++;
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			int index = indexOf(element);
			
			if (index > -1) {
				this.table[index] = this.deletedElement;
				this.elements--;
			}	
		}
		
	}

	@Override
	public T search(T element) {
		T retorno = null;
		
		if (element != null) {
			int index = indexOf(element);
			
			if (index > -1) {
				retorno = element;
			}
		}
		return retorno;
	}

	@Override
	public int indexOf(T element) {
		int retorno = -1;
		
		if (element != null) {
			int cont = 0;	
			
			while (cont < this.capacity()) {
				int hash = ((HashFunctionLinearProbing<T>) this.getHashFunction()).hash(element, cont);
				
				if (this.table[hash] == null) {
					break;
				} else if (!this.table[hash].equals(element)) {
					cont++;
				} else {
					retorno = hash;
					break;
				}
			}
		}
		return retorno;	
	}

}
