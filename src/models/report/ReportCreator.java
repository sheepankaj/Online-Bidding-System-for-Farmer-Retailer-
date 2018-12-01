package models.report;

public class ReportCreator extends AbstractReportCreator
{
	private static ReportCreator instance;
	
	private ReportCreator()
	{
		
	}
	
	public static AbstractReportCreator getReportServiceInstance() 
	{
		if(instance == null)
		{
			instance = new ReportCreator();
		}
		return instance;
	}
	
	@Override
	public IReport reportCreator( String type ) throws ReportTypeIsNotImplemented
	{
		IReport report = null;
		if(type.equals( "PDF" ))
		{
			report = new PDFReport();
		}
		else
		{
			throw new ReportTypeIsNotImplemented();
		}
		return report;
	}

}
