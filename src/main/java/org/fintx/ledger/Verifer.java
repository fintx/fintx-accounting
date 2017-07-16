package org.fintx.ledger;

public interface Verifer<T> {
	
	public boolean verify(T verifiable);

}
