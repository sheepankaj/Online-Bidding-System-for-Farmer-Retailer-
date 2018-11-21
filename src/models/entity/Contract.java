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
	private StockFrequency stockFrequency;
	private StringBuilder contractConstraints = new StringBuilder();
	String type;  // this is only a GSON library requirement for deserializing
	
	public Contract(String type)
	{
		this.type = type;
	}
	
	public Contract() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract double getPriceOnFrequency();
	
	public abstract StringBuilder getContractConstraints();
	
	public abstract String getFarmerDetails();
	
	public abstract String getRetailerDetails();
	
	@Override
	public String toString()
	{
		return "Farmer ID : "+farmerUserID+" "+"Retailer ID : "+retailerUserID+" "+" Placed Bid : "+agreedBid.toString();
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
	public String getFooter() {
//		PdfPTable table = new PdfPTable(2);
//		table.addCell(table);
//		PDFCell cell1 = new PDFCell("Signed Date : ");
//		PDFCell cell2 = new PDFCell(new Date().toString());
//		table.addCell(cell1.getCell());
//		table.addCell(cell2.getCell());
		return "Signed Date : "+new Date().toString();
	}
	@Override
	public String getHeader() {
//			PdfPTable table = new PdfPTable(2);			
//			table.addCell(table);
//			PDFCell cell1 = new PDFCell("Contract");
//			table.addCell(cell1.getCell());
			return "Contract";
	}
	@Override
	public PdfPTable getBody(PdfPTable  table) {
		table.addCell(new PdfPCell(new Phrase(getFarmerDetails())));
		table.addCell(new PdfPCell(new Phrase(getRetailerDetails())));
		table.addCell(new PdfPCell(new Phrase("Delevery Frequency : "+stockFrequency)));
	    return table;
	}
	
	public Contract getContract()
	{
		return this;
	}
	
	
}
