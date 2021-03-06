package com.hrustalyov.utils.json.builder;

import com.hrustalyov.utils.json.JsonIntegerValue;
import com.hrustalyov.utils.json.JsonObjectValue;
import com.hrustalyov.utils.json.JsonStringValue;
import com.hrustalyov.utils.json.JsonValueProvider;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class JsonBuilderImpl implements JsonBuilder<JsonBuilderImpl> {
	private final Map<String, JsonValueProvider> valueMap;

	public JsonBuilderImpl() {
		this.valueMap = new LinkedHashMap<String, JsonValueProvider>();
	}

	@Override
	public JsonBuilder add(String name, String value) {
		valueMap.put(name, new JsonStringValue(value));
		return this;
	}

	@Override
	public JsonBuilder add(String name, long value) {
		valueMap.put(name, new JsonIntegerValue(value));
		return this;
	}

	@Override
	public JsonBuilder add(String name, JsonBuilderImpl builder) {
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
