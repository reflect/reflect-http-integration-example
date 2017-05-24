package com.reflect.integration.api.reporting.settings;

public class Filter {
	private Field field;
	private FilterOperation operation;
	private String value;
	
	public Filter(Field field, FilterOperation operation, String value) {
		this.field = field;
		this.operation = operation;
		this.value = value;
	}

	public enum FilterOperation {
		EQUALS("="),
		NOT_EQUALS("!="),
		GREATER_THAN(">"),
		GREATER_THAN_OR_EQUAL_TO(">="),
		LESS_THAN("<"),
		LESS_THAN_OR_EQUAL_TO("<="),
		CONTAINS("=!");
		
		private final String id;
		
		FilterOperation(String id) {
			this.id = id;
		}
	}
}
