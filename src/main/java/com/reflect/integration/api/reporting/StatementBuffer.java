package com.reflect.integration.api.reporting;

import java.util.List;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.reflect.integration.api.reporting.Statement.Condition;
import com.reflect.integration.api.reporting.Statement.Field;

import spark.utils.StringUtils;

public class StatementBuffer {
	private StringBuffer buffer;
	
	public StatementBuffer() {
		this.buffer = new StringBuffer("SELECT ");
	}
	

	public void appendTable(Statement s) throws InvalidStatementException {
		String table = s.getTable();
		
		if (StringUtils.isBlank(table)) {
			throw new InvalidStatementException("table cannot be blank");
		}
		
		buffer.append(" FROM ");
		buffer.append(table);
	}
	
	public void appendOrder(Statement statement) {
		if (StringUtils.isBlank(statement.getOrder())) {
			return;
		}
		
		buffer.append(" ORDER BY ");
		buffer.append(statement.getOrder());
		buffer.append(" ");
		
		// If there's no direction, we'll use a standard one.
		if (statement.getDirection() == null) {
			buffer.append("ASC ");
		} else {
			buffer.append(statement.getDirection().toString());
		}
	}
	
	public void appendGroups(Statement s) {
		List<String> groups = Lists.newArrayList();
		List<Field> fields = s.getFields(); 
		
		for (String alias : s.getGroups()) {
			int idx = Iterators.indexOf(fields.iterator(), (f) -> f.alias.equals(alias));
			groups.add(Integer.toString(idx + 1));
		}
		
		if (groups.size() > 0) {
			buffer.append(" GROUP BY ");
			buffer.append(StringUtils.collectionToDelimitedString(groups, ", "));
		}
	}

	public void appendFields(Statement s) throws InvalidStatementException {
		List<Field> fields = s.getFields();
		int size = fields.size();
		
		if (size < 1) {
			throw new InvalidStatementException("statement must select at least one field");
		}
		
		for (int i = 0; i < size; i++) {
			Field f = fields.get(i);
			
			buffer.append(f.expression);
			buffer.append(" AS ");
			buffer.append(f.alias);
			
			if (i < (size - 1)) {
				buffer.append(", ");
			}
		}
	}
	
	public void appendConditions(Statement s) {
		List<Condition> conditions = s.getConditions();
		int size = conditions.size();
		
		if (size < 1) {
			return;
		}
		
		for (int i = 0; i < size; i++) {
			Condition c = conditions.get(i);
			buffer.append(c.column);
			buffer.append(" ");
			buffer.append(c.operation.toString());
			buffer.append(" '");
			buffer.append(c.value);
			buffer.append("'");
			
			if (i < (size - 1)) {
				buffer.append(" AND ");
			}
		}
	}
	
	public String toString() {
		return buffer.toString();
	}
	
}
