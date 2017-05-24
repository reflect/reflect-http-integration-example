package com.reflect.integration.api.reporting.results;

import java.util.List;

import com.google.common.collect.Lists;

public class Report {
	private List<ResultRow> results;
	
	public Report() {
		this.results = Lists.newArrayList();
	}

	public List<ResultRow> getResults() {
		return results;
	}

	public void setResults(List<ResultRow> results) {
		this.results = results;
	}
}
