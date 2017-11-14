package org.fintx.accounting.service;

public interface Verifier<T> {

    public boolean verify(T verifiable);

}
