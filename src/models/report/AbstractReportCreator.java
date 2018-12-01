package models.report;

public abstract class AbstractReportCreator
{
	public abstract IReport reportCreator(String type) throws ReportTypeIsNotImplemented;
}
