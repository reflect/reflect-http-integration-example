package com.reflect.integration.api.reporting;

public class ReportRunnerFactory {
	public static ReportRunner getReportRunner(StatementCompiler compiler) {
		return new StaticReportRunner(compiler);
	}
}
