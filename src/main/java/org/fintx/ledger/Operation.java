package org.fintx.ledger;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.fintx.lang.Pair;



public class Operation {
	private Voucher voucher;
	private ArrayList<Pair<String, BigDecimal>> freezeEntrys;
	private ArrayList<Pair<String, BigDecimal>> unfreezeEntrys;
	public static class Builder{
		private Operation operation = new Operation();
		private Verifer<Operation> verifer = null;
		private static final Verifer<Operation> defaultVerifer=new OperationVerifer();
		
		public Builder associate(Voucher voucher) {
			return this;
		}
	
		
		public  Builder freeze(String acctNo, BigDecimal amt) {
			return this;
		}

		public Builder unfreeze(String acctNo, BigDecimal amt) {
			return this;
		}
		
		public Builder close(String acctNo) {
			return this;
		}
		
		public Builder operationVerifer(Verifer<Operation> verifer) {
			
			return this;
		}
		public Operation build() {
			if (null == verifer) {

			}
			return operation;
		};
		
		public static class OperationVerifer implements Verifer<Operation> {
			
			public boolean verify(Operation operation) {
				return true;
			};

		}
		
	}
	
}
