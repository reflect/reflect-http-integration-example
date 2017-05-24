package com.reflect.integration.api.reporting;

import com.reflect.integration.api.reporting.results.Report;

public class StaticReportRunner extends ReportRunner {
	public StaticReportRunner(StatementCompiler compiler) {
		super(compiler);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Report runReport() {
		return new Report();
	}
}
