package com.bke1.domain;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.bke1.domain.*;
public  class Bill
	implements java.io.Serializable
	{

		private static final long serialVersionUID = 1234567890L;
		
		// id1
		private String id1;
		public String getId1(){return id1;}
		public void setId1(String id1){this.id1=id1;}
	
		// id
		private String id;
		public String getId(){return id;}
		public void setId(String id){this.id=id;}

		// vendorId
		private String vendorId;
		public String getVendorId(){return vendorId;}
		public void setVendorId(String vendorId){this.vendorId=vendorId;}

		// vendorName
		private String vendorName;
		public String getVendorName(){return vendorName;}
		public void setVendorName(String vendorName){this.vendorName=vendorName;}


	  // invoiceNumber
		private String invoiceNumber;
		public String getInvoiceNumber(){return invoiceNumber;}
		public void setInvoiceNumber(String invoiceNumber){this.invoiceNumber=invoiceNumber;}


		// invoiceDate
		private String invoiceDate;
		public String getInvoiceDate(){return invoiceDate;}
		public void setInvoiceDate(String invoiceDate){this.invoiceDate=invoiceDate;}


		// invoiceAmount
		private String invoiceAmount;
		public String getInvoiceAmount(){return invoiceAmount;}
		public void setInvoiceAmount(String invoiceAmount){this.invoiceAmount=invoiceAmount;}


	
		// paymentAmount
		private String paymentAmount;
		public String getPaymentAmount(){return paymentAmount;}
		public void setPaymentAmount(String paymentAmount){this.paymentAmount=paymentAmount;}

	  // invoiceDueDate
		private String invoiceDueDate;
		public String getInvoiceDueDate(){return invoiceDueDate;}
		public void setInvoiceDueDate(String invoiceDueDate){this.invoiceDueDate=invoiceDueDate;}

	
	
		// status
		private String status;
		public String getStatus(){return status;}
		public void setStatus(String status){this.status=status;}

	
		// residualAmount
		private String residualAmount;
		public String getResidualAmount(){return residualAmount;}
		public void setResidualAmount(String residualAmount){this.residualAmount=residualAmount;}

	
	
		// notes
		private String notes;
		public String getNotes(){return notes;}
		public void setNotes(String notes){this.notes=notes;}

	
		// image
		private String image;
		public String getImage(){return image;}
		public void setImage(String image){this.image=image;}

	
		public String toString(){
			return 	" id :"+id;
		}
	
		
	}
