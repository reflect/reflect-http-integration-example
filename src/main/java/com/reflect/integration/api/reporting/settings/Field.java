package com.reflect.integration.api.reporting.settings;

public class Field {
	public Field(String name) {
		this.name = name;
	}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getColumn() {
		// TODO: Translate the field name to the actual column name.
		return this.name;
	}
}
