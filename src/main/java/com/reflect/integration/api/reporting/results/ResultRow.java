package com.reflect.integration.api.reporting.results;

import java.util.List;

public class ResultRow {
	private List<String> dimensions;
	private List<Double> metrics;
	
	public List<String> getDimensions() {
		return dimensions;
	}
	
	public void setDimensions(List<String> dimensions) {
		this.dimensions = dimensions;
	}
	
	public List<Double> getMetrics() {
		return metrics;
	}
	
	public void setMetrics(List<Double> metrics) {
		this.metrics = metrics;
	}
}
