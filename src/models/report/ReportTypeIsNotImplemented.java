package models.report;

public class ReportTypeIsNotImplemented extends Exception
{
	@Override
	public String getMessage()
	{
		return "Report type is not implemented";
	}
}
