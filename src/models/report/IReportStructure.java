package models.report;

import com.itextpdf.text.pdf.PdfPTable;

public interface IReportStructure {
	PdfPTable getHeader();
	PdfPTable getFooter();
	PdfPTable getBody(PdfPTable table);
}
