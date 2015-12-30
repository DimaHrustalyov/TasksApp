package com.hrustalyov.utils.json.builder;

public interface JsonBuilder<T> {
	JsonBuilder add(String name, String value);
	JsonBuilder add(String name, long value);
	JsonBuilder add(String name, T builder);
	String build();
}
