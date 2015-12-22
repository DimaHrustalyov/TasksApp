package com.hrustalyov.utils.json.factory;

import com.hrustalyov.utils.json.builder.JsonBuilder;

public class JsonBuilderFactoryImpl implements JsonBuilderFactory {
	@Override
	public JsonBuilder createJsonBuilder() {
		return new JsonBuilder();
	}
}
