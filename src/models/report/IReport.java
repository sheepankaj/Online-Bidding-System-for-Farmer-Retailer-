package models.report;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;

public interface IReport
{	
	Document generateReport(StringBuilder builder,HttpServletResponse response) throws IOException;
	void emailDocument(StringBuilder builder);
}
