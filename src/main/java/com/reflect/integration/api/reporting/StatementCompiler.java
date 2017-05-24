package com.reflect.integration.api.reporting;

import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;
import com.reflect.integration.api.reporting.settings.ReportSettings;

import spark.utils.StringUtils;

public class StatementCompiler {
	public static final String PRIMARY_TABLE = "my_table";
	
	private ReportSettings reportSettings;
	
	public StatementCompiler(ReportSettings settings) {
		this.reportSettings = settings;
	}
	
	public ReportSettings getReportSettings() {
		return this.reportSettings;
	}
	
	public String toSql() {
		// Let's get all the columns for the metrics and dimensions.
		List<String> dimensions = Lists.transform(reportSettings.getDimensions(), (dim) -> dim.getColumn());
		List<String> metrics = Lists.transform(reportSettings.getMetrics(), (met) -> met.getExpression());
		
		String allDimensions = StringUtils.collectionToDelimitedString(dimensions, ", ");
		String allMetrics  = StringUtils.collectionToDelimitedString(metrics, ", ");
		
		return "SELECT "+allDimensions+", "+allMetrics+" FROM " + PRIMARY_TABLE;
	}
}
