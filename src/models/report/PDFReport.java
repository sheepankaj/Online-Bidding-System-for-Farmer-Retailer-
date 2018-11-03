package models.report;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFReport implements IReport
{

	@Override
	public Document generateReport( StringBuilder builder,HttpServletResponse response )
	{
		Document document = null;
		try {
            document = new Document();
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            document.add(new Paragraph(builder.toString()));
            document.add(new Paragraph(new Date().toString()));
            document.close();
        } catch (Exception de) {
            de.printStackTrace();
        }
		return document;
	}

	@Override
	public void emailDocument( StringBuilder builder )
	{
		// TODO Auto-generated method stub
	}

}
