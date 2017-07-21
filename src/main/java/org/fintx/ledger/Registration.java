/**
 *  Copyright 2017 FinTx
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fintx.ledger;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.fintx.lang.Pair;

import lombok.Getter;

/**
 * @author bluecreator(qiang.x.wang@gmail.com)
 *
 */
@Getter
public class Registration {
	private Registration() {

	}

	private Voucher voucher;
	
	private ArrayList<Pair<String, BigDecimal>> receiptEntrys;
	private ArrayList<Pair<String, BigDecimal>> payEntrys;
	

	public static class Builder {
		private Builder() {
		}
		private Registration registration = new Registration();
		private Verifer<Registration> verifer = null;
		private static final Verifer<Registration> defaultVerifer=new RegistrationVerifer();
		public  Builder associate(Voucher voucher) {
			return this;
		}
		public Builder receipt(String acctNo, BigDecimal amt) {
			return this;
		}
		public Builder pay(String acctNo, BigDecimal amt) {
			return this;
		}
		public Builder registrationVerifer(Verifer<Registration> verifer) {
			this.verifer = verifer;
			return this;
		}
		public Registration build() {
			if (null == verifer) {
				verifer=defaultVerifer;
			}
			return registration;
		};
		public static class RegistrationVerifer implements Verifer<Registration> {
			
			public boolean verify(Registration registration) {
				//acctno type length?? on the setting
				//amount ??on the setting
				return true;
			};

		}

	}

}
