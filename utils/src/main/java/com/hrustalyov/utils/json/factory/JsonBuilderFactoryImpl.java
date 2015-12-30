package com.hrustalyov.utils.json.factory;

import com.hrustalyov.utils.json.builder.JsonBuilder;
import com.hrustalyov.utils.json.builder.JsonBuilderImpl;

public class JsonBuilderFactoryImpl implements JsonBuilderFactory {
	@Override
	public JsonBuilder createJsonBuilder() {
		return new JsonBuilderImpl();
	}
}
