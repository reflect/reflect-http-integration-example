package com.reflect.integration.api.reporting.settings.serialization;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.reflect.integration.api.reporting.settings.Field;
import com.reflect.integration.api.reporting.settings.Filter;
import com.reflect.integration.api.reporting.settings.Filter.FilterOperation;

public class FilterDeserializer  implements JsonDeserializer<Filter> {

	@Override
	public Filter deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		JsonObject obj = json.getAsJsonObject();
		
		return new Filter(
			new Field(obj.get("field").getAsString()),
			Filter.FilterOperation.valueOf(obj.get("op").getAsString()),
			obj.get("value").getAsString()
		);
	}
}
