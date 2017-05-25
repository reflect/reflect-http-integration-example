package com.reflect.integration.api.reporting.fields;

import com.google.gson.annotations.SerializedName;

public enum FieldType {
	@SerializedName("number")
	NUMBER("number"),
	@SerializedName("date")
	DATE("date"),
	@SerializedName("text")
	TEXT("text");
	
	private String id;
	
	FieldType(String id) {
		this.id = id;;
	}
	
	public String toString() {
		return id.toLowerCase();
	}
}
