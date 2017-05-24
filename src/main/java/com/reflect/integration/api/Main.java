package com.reflect.integration.api;

import static spark.Spark.*;

import com.reflect.integration.api.reporting.ReportRunner;
import com.reflect.integration.api.reporting.ReportRunnerFactory;
import com.reflect.integration.api.reporting.StatementCompiler;
import com.reflect.integration.api.reporting.settings.ReportSettings;

public class Main {
    public static void main(String[] args) {
        post("/report", (req, res) -> {
        	// Decode report settings from the JSON request.
        	final ReportSettings settings =  ReportSettings.fromJson(req.body());
        	
        	// Turn it in to a SQL statement to execute against the database.
        	final StatementCompiler compiler = new StatementCompiler(settings);
        	
        	// Actually run the report and format.
        	ReportRunner runner = ReportRunnerFactory.getReportRunner(compiler);
        	
        	// Have the runner actually execute the query and format the results.
        	return runner.runReport();
        }, new JsonTransformer());
    }
}
