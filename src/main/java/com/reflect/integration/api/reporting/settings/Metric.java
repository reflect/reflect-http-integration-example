package com.reflect.integration.api.reporting.settings;

public class Metric extends Field {
	public Metric(String name) {
		super(name);
	}
	
	@Override
	public String getColumn() {
		final String name = this.getName();
		
		if (name.startsWith("Avg") || name.startsWith("Sum") || name.startsWith("Min") || name.startsWith("Max")) {
			return name.substring(3);
		}
		
		if (name.startsWith("Count")) {
			return name.substring(4);
		}
		
		return name;
	}
	
	public String getExpression() {
		final String name = this.getName();
		final String column = this.getColumn();
		
		if (name.startsWith("Avg")) {
			return "AVG("+column+") AS " + this.getName();
		} else if (name.startsWith("Sum")) {
			return "SUM("+column+") AS " + this.getName();
		} else if ( name.startsWith("Min")) { 
			return "MIN("+column+") AS " + this.getName();
		} else if (name.startsWith("Max")) {
			return "MAX("+column+") AS " + this.getName();
		} else if (name.startsWith("Count")) {
			return "COUNT("+column+") AS " + this.getName();
		}
		
		// TODO: What should teh default behavior actually be here?
		return this.getColumn();
	}
}
