package models.report;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import models.entity.Contract;

public class ReportService
{
	public static ReportService reportService;
	
	private ReportService()
	{
		
	}
	
	public static ReportService getReportServiceInstance() 
	{
		if(reportService == null)
		{
			reportService = new ReportService();
		}
		return reportService;
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
			report = createDoc( docType );
			report.generateReport(PDFBuilder.getCompleteTable(contract, table), response);
		}
		catch ( ReportTypeIsNotImplemented e )
		{
			message = e.getMessage();
		}
		return message;		
	}
	
	private IReport createDoc(String docType) throws ReportTypeIsNotImplemented
	{
		IReport report = null;
		if(docType.equals( "PDF" ))
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
