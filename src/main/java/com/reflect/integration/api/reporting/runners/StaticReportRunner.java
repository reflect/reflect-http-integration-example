package com.reflect.integration.api.reporting.runners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reflect.integration.api.reporting.InvalidStatementException;
import com.reflect.integration.api.reporting.ReportRunner;
import com.reflect.integration.api.reporting.Statement;
import com.reflect.integration.api.reporting.results.Report;

public class StaticReportRunner extends ReportRunner {
	final static Logger logger = LoggerFactory.getLogger(StaticReportRunner.class);
	
	public StaticReportRunner(Statement statement) {
		super(statement);
	}

	@Override
	public Report runReport() throws InvalidStatementException {
		logger.info("Executing query: {}", this.getStatement().toSql());
		
		// TODO: Run the actual query and serialize it to a result set.
		return new Report();
	}
}
