package com.reflect.integration.api.reporting.settings;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.reflect.integration.api.reporting.settings.serialization.DimensionDeserializer;
import com.reflect.integration.api.reporting.settings.serialization.FilterDeserializer;
import com.reflect.integration.api.reporting.settings.serialization.MetricDeserializer;
import com.reflect.integration.api.reporting.settings.serialization.SortConfigurationDeserializer;

public class ReportSettings {
	private List<Dimension> dimensions;
	
	private List<Metric> metrics;
	
	private List<Filter> filters;
	
	private SortConfiguration sort;
	
	public List<Dimension> getDimensions() {
		return dimensions;
	}
	
	public void setDimensions(List<Dimension> dimensions) {
		this.dimensions = dimensions;
	}
	
	public List<Metric> getMetrics() {
		return metrics;
	}
	
	public void setMetrics(List<Metric> metrics) {
		this.metrics = metrics;
	}
	
	public static ReportSettings fromJson(String json) {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Metric.class, new MetricDeserializer());
		builder.registerTypeAdapter(Dimension.class, new DimensionDeserializer());
		builder.registerTypeAdapter(Filter.class, new FilterDeserializer());
		builder.registerTypeAdapter(SortConfiguration.class, new SortConfigurationDeserializer());
		
		Gson gson = builder.create();
		return gson.fromJson(json, ReportSettings.class);
	}

	public List<Filter> getFilters() {
		return filters;
	}

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}

	public SortConfiguration getSort() {
		return sort;
	}

	public void setSort(SortConfiguration configuration) {
		this.sort = configuration;
	}
}
