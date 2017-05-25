package com.reflect.integration.api.reporting;

import java.util.List;

import com.google.common.collect.Lists;
import com.reflect.integration.api.reporting.settings.Filter;
import com.reflect.integration.api.reporting.settings.SortConfiguration;

public class Statement {
	private String table;
	private List<Field> fields;
	private List<Condition> conditions;
	private List<String> groups;
	private String order;
	private SortConfiguration.Direction direction;
	
	public Statement() {
		this.fields = Lists.newArrayList();
		this.conditions = Lists.newArrayList();
		this.groups = Lists.newArrayList();
	}
	
	public void select(String expression, String alias) {
		this.fields.add(new Field(expression, alias));
	}
	
	public void from(String table) {
		this.table = table;
	}
	
	public void where(String column, Filter.FilterOperation operation, String value) {
		this.conditions.add(new Condition(column, operation, value));
	}
	
	public void orderBy(String order, SortConfiguration.Direction direction) {
		this.order = order;
		this.direction = direction;
	}
	
	public void groupBy(String alias) throws InvalidStatementException {
		// Make sure this alias exists in the selected fields.
		if (!this.fieldExists(alias)) {
			throw new InvalidStatementException("Cannot group by field " + alias + " as it is not selected.");
		}
		
		// If we made it here, the field exists so...let's roll with it.
		this.groups.add(alias);
	}
	
	public String toSql() throws InvalidStatementException {
		StatementBuffer buf = new StatementBuffer();
		buf.appendFields(this);
		buf.appendTable(this);
		buf.appendConditions(this);
		buf.appendOrder(this);
		buf.appendGroups(this);
		return buf.toString();
	}
	
	String getTable() {
		return table;
	}

	List<Field> getFields() {
		return fields;
	}

	List<Condition> getConditions() {
		return conditions;
	}

	List<String> getGroups() {
		return groups;
	}

	String getOrder() {
		return order;
	}

	SortConfiguration.Direction getDirection() {
		return direction;
	}
	
	private boolean fieldExists(String alias) {
		for (Field f : this.fields) {
			if (f.alias == alias) {
				return true;
			}
		}
		
		return false;
	}

	public class Field {
		public String expression;
		public String alias;
		
		public Field(String expression, String alias) {
			this.expression = expression;
			this.alias = alias;
		}
	}
	
	public class Condition {
		public String column;
		public Filter.FilterOperation operation;
		public String value;
		
		public Condition(String column, Filter.FilterOperation operation, String value) {
			this.column = column;
			this.operation = operation;
			this.value = value;
		}
	}
}
