package com.reflect.integration.api.reporting.settings.serialization;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.reflect.integration.api.reporting.settings.Metric;

public class MetricDeserializer implements JsonDeserializer<Metric> {
	@Override
	public Metric deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
		String str = arg0.getAsString();
		return new Metric(str);
	}
}
