package com.reflect.integration.api.reporting.fields;

public class SupportedFieldsFactory {
	public static SupportedFields getSupportedFields() {
		return new StaticSupportedFields();
	}
}
