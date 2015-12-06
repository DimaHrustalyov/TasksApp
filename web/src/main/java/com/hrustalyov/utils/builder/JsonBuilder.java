package com.hrustalyov.utils.builder;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class JsonBuilder {
	private final Map<String, String> valueMap;

	public JsonBuilder() {
		this.valueMap = new LinkedHashMap<String, String>();
	}

	public JsonBuilder add(String name, String value) {
		valueMap.put(name, value);
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
				sb.append('"' + this.valueMap.get(o) + '"');
			}
			sb.append('}');
			return sb.toString();
		} catch (Exception e) {
			return null;
		}
	}
}
