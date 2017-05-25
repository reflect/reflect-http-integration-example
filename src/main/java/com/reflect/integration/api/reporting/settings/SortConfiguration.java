package com.reflect.integration.api.reporting.settings;

import com.google.gson.annotations.SerializedName;

public class SortConfiguration {
	private Direction direction;
	private Field field;
	
	public SortConfiguration(Field field, Direction direction) {
		this.field = field;
		this.direction = direction;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}
	
	public enum Direction {
		@SerializedName("ascending")
		ASCENDING("ascending"),
		
		@SerializedName("descending")
		DESCENDING("descending");
		
		private final String id;
		
		Direction(String id) {
			this.id = id;
		}
		
		public String toString() {
			return this.id;
		}
	}
}
