package com.reflect.integration.api.reporting;

import com.reflect.integration.api.reporting.settings.Dimension;
import com.reflect.integration.api.reporting.settings.Filter;
import com.reflect.integration.api.reporting.settings.Metric;
import com.reflect.integration.api.reporting.settings.ReportSettings;
import com.reflect.integration.api.reporting.settings.SortConfiguration;

public class StatementBuilder {
	public static final String PRIMARY_TABLE = "my_table";
	
	public Statement build(ReportSettings settings) throws InvalidStatementException {
		Statement statement = new Statement();
		statement.from(PRIMARY_TABLE);
		
		for (Dimension dim : settings.getDimensions()) {
			statement.select(dim.getColumn(), dim.getAlias());
		}
		
		for (Metric met : settings.getMetrics()) {
			statement.select(met.getExpression(), met.getAlias());
		}
		
		// Let's layer in all our filters, too.
		for (Filter filter : settings.getFilters()) {
			statement.where(filter.getField().getAlias(), filter.getOperation(), filter.getValue());
		}

		for (Dimension dim : settings.getDimensions()) {
			statement.groupBy(dim.getAlias());
		}
		
		if (settings.hasSort()) {
			SortConfiguration sort = settings.getSort();
			statement.orderBy(sort.getField().getAlias(), sort.getDirection());
		}
		
		return statement;
	}
}
