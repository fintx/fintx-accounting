package org.fintx.accounting.util;

import org.fintx.util.UniqueId;

public final class Ids {
	private Ids() {
		throw new RuntimeException("Not allowed to create Ids instance");
	}

	public static String getId() {
		return UniqueId.get().toBase64String();
	}
	
}
