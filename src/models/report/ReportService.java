package models.report;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import models.entity.Contract;

public class ReportService
{
	private static ReportService reportService;
	private static AbstractReportCreator reportCreator;
	
	
	private ReportService()
	{
		
	}
	
	public static ReportService getReportServiceInstance() 
	{
		if(reportService == null)
		{
			reportService = new ReportService();
			reportCreator = ReportCreator.getReportServiceInstance();
		}
		return reportService;
	}	
	
	public static void setReportCreator( AbstractReportCreator reportCreator )
	{
		ReportService.reportCreator = reportCreator;
	}

	public void generateContractReport(List<Contract> contracts,String docType,HttpServletResponse response) throws IOException
	{
//		IReport report = createDoc( docType );
//		StringBuilder builder = new StringBuilder();
//		for(Contract contract : contracts)
//		{
//			builder.append( contract.toString() );
//			builder.append( "\n" );
//		}
//		report.generateReport( builder, response );
	}
	
	public String printContract(Contract contract,String docType,HttpServletResponse response) throws IOException
	{
		PDFTable table = new PDFTable(1, 5);
		IReport report;
		String message = "";
		try
		{
			report = reportCreator.reportCreator( docType );
			report.generateReport(PDFBuilder.getCompleteTable(contract, table), response);
		}
		catch ( ReportTypeIsNotImplemented e )
		{
			message = e.getMessage();
		}
		return message;
		
	}
}
