package org.fintx.ledger;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.fintx.lang.Pair;

import lombok.Getter;


@Getter
public class Operation {
	private Voucher voucher;
	private ArrayList<Pair<String, BigDecimal>> freezeEntrys;
	private ArrayList<Pair<String, BigDecimal>> unfreezeEntrys;
	public static Builder builder() {
		return new Builder();
	}
	public static class Builder{
		private Builder() {
		}
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
				//acctno type length?? on the setting
				//amount ??on the setting
				return true;
			};

		}
		
	}
	
}
