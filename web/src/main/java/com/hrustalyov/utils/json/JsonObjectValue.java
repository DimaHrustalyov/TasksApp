package com.hrustalyov.utils.json;

import com.hrustalyov.utils.json.builder.JsonBuilder;

public class JsonObjectValue implements JsonValueProvider {
	private JsonBuilder jsonBuilder;

	public JsonObjectValue(JsonBuilder jsonBuilder) {
		this.jsonBuilder = jsonBuilder;
	}

	@Override
	public String getValue() {
		return jsonBuilder.build();
	}
}
