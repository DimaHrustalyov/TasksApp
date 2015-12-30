package com.hrustalyov.utils.json;

import com.hrustalyov.utils.json.builder.JsonBuilder;

public class JsonObjectValue implements JsonValueProvider {
	private JsonBuilder builder;

	public JsonObjectValue(JsonBuilder builder) {
		this.builder = builder;
	}

	@Override
	public String getValue() {
		return builder.build();
	}
}
