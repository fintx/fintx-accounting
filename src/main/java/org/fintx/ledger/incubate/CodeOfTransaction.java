package org.fintx.ledger.incubate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CodeOfTransaction {
	private String transactionCode;

	private String transactionName;

	private String transactionCtrl;

	private String debitRecordAcctsNo;

	private String creditRecordAcctsNo;
	
	private String receiptAndPayRecordAcctsNo;
}