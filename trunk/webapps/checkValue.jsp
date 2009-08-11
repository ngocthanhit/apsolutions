  <%@ page language="java" import="com.intuit.quickbase.util.*,com.docorganiz.util.*,com.docorganiz.domain.*" %> 
  <%@ page buffer="128kb"%>  
  <%@ page import="java.util.*,java.io.*,java.text.*,java.sql.Timestamp"%>  
  <%@ page import="java.text.SimpleDateFormat"%>      
  <%@ page import="java.lang.reflect.Array"%>  
  <%@ page import="org.w3c.dom.Document"%>  
  <%@ page import="org.xml.sax.InputSource"%>  
  <%@ page import="org.w3c.dom.Element"%>  
  <%@ page import="org.w3c.dom.NodeList"%>  
  <%@ page import="org.w3c.dom.Node"%>                  
                                                      
 <%
 
   String cookieuid1="";
   String cookieuid2=""; 
  
   String cookiepassword="";
   Cookie[] cookieArray = request.getCookies(); 

   String voucherNumber = request.getParameter("voucherNumber");
   String invoiceNumber = request.getParameter("invoiceNumber");
   String vendorId = request.getParameter("vendorId");
   //String vid = request.getParameter("vid");

System.out.println("Inside Check Value Calling lookup") 
 

 	Lookup dl = (Lookup)getServletContext().getAttribute("lookup");
	System.out.println("After Lookup");
	 
	  if((voucherNumber!=null)&&(invoiceNumber==null)){
	  	System.out.println("Checking for Voucher");
	  	out.print(dl.isVoucherExist(voucherNumber)&&(voucherNumber==null));
	  }else if((invoiceNumber!=null)&&(vendorId!=null)){	
	  	System.out.println("vendorId "+vendorId+"  invoiceNumber "+invoiceNumber);	  
	  	out.print(dl.isVendorInvoiceExist(vendorId,invoiceNumber));
	  }
	
  	
%>	
