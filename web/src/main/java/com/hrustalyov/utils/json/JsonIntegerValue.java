package com.hrustalyov.utils.json;

import java.math.BigDecimal;

public class JsonIntegerValue implements JsonValueProvider {
	private BigDecimal value;

	public JsonIntegerValue(int value) {
		this.value = new BigDecimal(value);
	}

	public JsonIntegerValue(long value) {
		this.value = new BigDecimal(value);
	}


	public JsonIntegerValue(BigDecimal value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return value.toString();
	}
}
