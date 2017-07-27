package org.fintx.ledger.service;

public interface Verifer<T> {
	
	public boolean verify(T verifiable);

}
