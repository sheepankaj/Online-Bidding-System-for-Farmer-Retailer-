package models.report;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public interface IReport
{	
	void generateReport(Object reportObject,HttpServletResponse response) throws IOException;
	void emailDocument(StringBuilder builder);
}
