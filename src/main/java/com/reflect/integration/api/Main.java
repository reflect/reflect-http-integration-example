package com.reflect.integration.api;

import static spark.Spark.*;

import com.reflect.integration.api.reporting.ReportRunner;
import com.reflect.integration.api.reporting.ReportRunnerFactory;
import com.reflect.integration.api.reporting.Statement;
import com.reflect.integration.api.reporting.StatementBuilder;
import com.reflect.integration.api.reporting.fields.SupportedFieldsFactory;
import com.reflect.integration.api.reporting.settings.ReportSettings;

public class Main {
    public static void main(String[] args) {
    	get("/fields", (req, res) -> {
    		return SupportedFieldsFactory.getSupportedFields().getFields();
    	}, new JsonTransformer());
    	
        post("/report", (req, res) -> {
        	// Decode report settings from the JSON request.
        	final ReportSettings settings =  ReportSettings.fromJson(req.body());
        	
        	// Turn it in to a SQL statement to execute against the database.
        	final StatementBuilder compiler = new StatementBuilder();
        	final Statement statement = compiler.build(settings);
        	
        	// Actually run the report and format.
        	ReportRunner runner = ReportRunnerFactory.getReportRunner(statement);
        	
        	// Have the runner actually execute the query and format the results.
        	return runner.runReport();
        }, new JsonTransformer());
    }
}
