package com.hrustalyov.utils.json.builder;

import com.hrustalyov.utils.json.JsonIntegerValue;
import com.hrustalyov.utils.json.JsonObjectValue;
import com.hrustalyov.utils.json.JsonStringValue;
import com.hrustalyov.utils.json.JsonValue;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class JsonBuilder {
	private final Map<String, JsonValue> valueMap;

	public JsonBuilder() {
		this.valueMap = new LinkedHashMap<String, JsonValue>();
	}

	public JsonBuilder add(String name, String value) {
		valueMap.put(name, new JsonStringValue(value));
		return this;
	}

	public JsonBuilder add(String name, long value) {
		valueMap.put(name, new JsonIntegerValue(value));
		return this;
	}

	public JsonBuilder add(String name, JsonBuilder builder) {
		valueMap.put(name, new JsonObjectValue(builder));
		return this;
	}

	public String build() {
		try {
			Iterator keys = this.valueMap.keySet().iterator();
			StringBuffer sb = new StringBuffer("{");

			while (keys.hasNext()) {
				if (sb.length() > 1) {
					sb.append(',');
				}
				Object o = keys.next();
				sb.append('"' + o.toString() + '"');
				sb.append(':');
				sb.append(this.valueMap.get(o).getValue());
			}
			sb.append('}');
			return sb.toString();
		} catch (Exception e) {
			return null;
		}
	}
}
