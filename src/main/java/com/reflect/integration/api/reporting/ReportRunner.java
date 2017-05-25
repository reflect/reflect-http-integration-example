package com.reflect.integration.api.reporting;

import com.reflect.integration.api.reporting.results.Report;

public abstract class ReportRunner {
	private Statement statement;
	
	public ReportRunner(Statement statement) {
		this.statement = statement;
	}
	
	protected Statement getStatement() {
		return this.statement;
	}
	
	public abstract Report runReport() throws InvalidStatementException;
}
