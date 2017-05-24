package com.reflect.integration.api.reporting.settings.serialization;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.reflect.integration.api.reporting.settings.Field;
import com.reflect.integration.api.reporting.settings.Metric;
import com.reflect.integration.api.reporting.settings.SortConfiguration;

public class SortConfigurationDeserializer  implements JsonDeserializer<SortConfiguration>{

	@Override
	public SortConfiguration deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		JsonObject obj = json.getAsJsonObject();
		
		return new SortConfiguration(
			new Field(obj.get("field").getAsString()),
			SortConfiguration.Direction.valueOf(obj.get("direction").getAsString())
		);
	}

}
