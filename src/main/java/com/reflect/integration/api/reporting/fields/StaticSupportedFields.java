package com.reflect.integration.api.reporting.fields;

import java.util.Map;

import com.google.common.collect.Maps;

public class StaticSupportedFields extends SupportedFields {

	@Override
	public Map<String, FieldType> getFields() {
		Map<String, FieldType> fields = Maps.newHashMap();
		fields.put("RowId", FieldType.NUMBER);
		fields.put("OrderId", FieldType.NUMBER);
		fields.put("OrderDate", FieldType.DATE);
		fields.put("OrderPriority", FieldType.TEXT);
		fields.put("OrderQuantity", FieldType.NUMBER);
		fields.put("AvgSales", FieldType.NUMBER);
		fields.put("SumSales", FieldType.NUMBER);
		fields.put("SumDiscount", FieldType.NUMBER);
		fields.put("ship_mode", FieldType.TEXT);
		fields.put("SumProfit", FieldType.NUMBER);
		fields.put("SumUnitPrice", FieldType.NUMBER);
		fields.put("SumShippingCost", FieldType.NUMBER);
		fields.put("CustomerName", FieldType.TEXT);
		fields.put("City", FieldType.TEXT);
		fields.put("ZipCode", FieldType.NUMBER);
		fields.put("State", FieldType.TEXT);
		fields.put("Region", FieldType.TEXT);
		fields.put("CustomerSegment", FieldType.TEXT);
		fields.put("ProductCategory", FieldType.TEXT);
		fields.put("ProductSubCategory", FieldType.TEXT);
		fields.put("ProductName", FieldType.TEXT);
		fields.put("ProductContainer", FieldType.TEXT);
		fields.put("AvgProductBaseMargin", FieldType.NUMBER);
		fields.put("ShipDate", FieldType.DATE);
		return fields;
	}
	
}
