package models.entity;

import java.util.Date;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import models.report.IReportStructure;
import models.report.PDFCell;
import models.report.PDFTable;

public abstract class Contract implements IReportStructure
{
	private long farmerUserID;
	private long retailerUserID;
	private Bid agreedBid;
	private Date signdate = new Date();
	private StockFrequency stockFrequency;
	private StringBuilder contractConstraints = new StringBuilder();
	
	public Contract()
	{
	}
	
	public abstract double getPriceOnFrequency();
	
	public abstract StringBuilder getContractConstraints();
	
	@Override
	public String toString()
	{
		return "Farmer ID : "+farmerUserID+" "+"Retailer ID : "+retailerUserID+" "+"Agreed Date : "+signdate+" Placed Bid : "+agreedBid.toString();
	}

	public long getFarmerUserID()
	{
		return farmerUserID;
	}

	public void setFarmerUserID( long farmerUserID )
	{
		this.farmerUserID = farmerUserID;
	}

	public long getRetailerUserID()
	{
		return retailerUserID;
	}

	public void setRetailerUserID( long retailerUserID )
	{
		this.retailerUserID = retailerUserID;
	}

	public Bid getAgreedBid()
	{
		return agreedBid;
	}

	public void setAgreedBid( Bid agreedBid )
	{
		this.agreedBid = agreedBid;
	}

	public Date getSigndate()
	{
		return signdate;
	}

	public void setSigndate( Date signdate )
	{
		this.signdate = signdate;
	}

	public StockFrequency getStockFrequency()
	{
		return stockFrequency;
	}

	public void setStockFrequency( StockFrequency stockFrequency )
	{
		this.stockFrequency = stockFrequency;
	}

	public void setContractConstraints( StringBuilder contractConstraints )
	{
		this.contractConstraints = contractConstraints;
	}	
	
	@Override
	public PdfPTable getFooter() {
		PdfPTable table = new PdfPTable(2);
		table.addCell(table);
		PDFCell cell1 = new PDFCell("Signed Date : ");
		PDFCell cell2 = new PDFCell(getSigndate().toString());
		table.addCell(cell1.getCell());
		table.addCell(cell2.getCell());
		return table;
	}
	@Override
	public PdfPTable getHeader() {
			PdfPTable table = new PdfPTable(2);			
			table.addCell(table);
			PDFCell cell1 = new PDFCell("Contract");
			table.addCell(cell1.getCell());
			return table;
	}
	@Override
	public PdfPTable getBody(PdfPTable  table) {
		table.addCell(new PdfPCell(new Phrase("Farmer ID : "+farmerUserID)));
		table.addCell(new PdfPCell(new Phrase("Retailer ID : "+retailerUserID)));
		table.addCell(new PdfPCell(new Phrase("Delevery Frequency : "+stockFrequency)));
	    return table;
	}
	
	
}
