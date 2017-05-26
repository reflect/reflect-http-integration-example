package com.reflect.integration.api.reporting.settings;

import com.google.gson.annotations.SerializedName;

public class Filter {
	private Field field;
	private FilterOperation operation;
	private String value;
	
	public Filter(Field field, FilterOperation operation, String value) {
		this.field = field;
		this.operation = operation;
		this.value = value;
	}
	
	public Field getField() {
		return this.field;
	}
	
	public FilterOperation getOperation() {
		return this.operation;
	}
	
	public String getValue() {
		return this.value;
	}

	public enum FilterOperation {
		@SerializedName("=")
		EQUALS("="),
		
		@SerializedName("!=")
		NOT_EQUALS("!="),
		
		@SerializedName(">")
		GREATER_THAN(">"),
		
		@SerializedName(">=")
		GREATER_THAN_OR_EQUAL_TO(">="),
		
		@SerializedName("<")
		LESS_THAN("<"),
		
		@SerializedName("<=")
		LESS_THAN_OR_EQUAL_TO("<="),
		
		@SerializedName("=~")
		CONTAINS("=~");
		
		private final String id;
		
		FilterOperation(String id) {
			this.id = id;
		}
		
		public String toString() {
			return this.id;
		}
	}
}
