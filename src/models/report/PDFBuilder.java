package models.report;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;

public class PDFBuilder {

	public static PdfPTable getCompleteTable(IReportStructure structure, PDFTable table) 
	{
		table.getpTable().addCell(new Phrase(structure.getHeader().toString())); // adding header
		table.getpTable().addCell(structure.getBody(new PdfPTable(1))); // this is the body
		table.getpTable().addCell(new Phrase(structure.getFooter().toString())); // this is the footer
		return table.getpTable();
	}

}
