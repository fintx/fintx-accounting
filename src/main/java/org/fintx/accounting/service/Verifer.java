package org.fintx.accounting.service;

public interface Verifer<T> {
	
	public boolean verify(T verifiable);

}
