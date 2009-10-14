  <%@ page language="java" import="com.intuit.quickbase.util.*,com.bke1.util.Lookup" %> 
   <%@ page import="java.util.HashMap"%>
 
  <%@ page buffer="128kb"%>  
     
   <%
	 
	 
   String invoiceNumber = request.getParameter("invoiceNumber");
   String vendorId = request.getParameter("vendorId");


 	Lookup lookup = (Lookup)getServletContext().getAttribute("lookup");
	
	System.out.println("After Lookup");
	
	
	String message ="";
	
		try{
		 
	 			//Insert Group
	  		if( (vendorId!=null)&&(invoiceNumber!=null) ) {
   	  		message=""+lookup.isVendorInvoiceExist(vendorId,invoiceNumber);
	  		}else {
	  			message ="Internal error caused by the fact vendorId OR invoiceNumber being NULL";
	  		}
	  	}catch(Exception ebk1){
					//System.out.println("Exception at here"+ebk1.getMessage());
					message =ebk1.getMessage();
		  }
	
	out.print(message);
  	
%>	
   	
  