package com.reflect.integration.api.reporting;

import com.reflect.integration.api.reporting.results.Report;

public abstract class ReportRunner {
	private StatementCompiler compiler;
	
	public ReportRunner(StatementCompiler compiler) {
		this.compiler = compiler;
	}
	
	public StatementCompiler getCompiler() {
		return this.compiler;
	}
	
	public abstract Report runReport();
}
