package com.hrustalyov.utils.json;

public class JsonStringValue implements JsonValueProvider {
	private String value;

	public JsonStringValue(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return '"' + value + '"';
	}
}
