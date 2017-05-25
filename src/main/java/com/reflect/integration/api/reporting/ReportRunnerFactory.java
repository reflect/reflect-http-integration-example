package com.reflect.integration.api.reporting;

import com.reflect.integration.api.reporting.runners.StaticReportRunner;

public class ReportRunnerFactory {
	public static ReportRunner getReportRunner(Statement statement) {
		return new StaticReportRunner(statement);
	}
}
