  <%@ page language="java" import="com.intuit.quickbase.util.*,com.bke2.util.Lookup" %> 
  <%@ page buffer="128kb"%>  
     
   <%
 
   String cId = request.getParameter("cId");
   String type = request.getParameter("type");
   
  // System.out.println("Inside POPULATE DROP DOWN cId"+cId+" type "+type); 
 

 	Lookup lookup = (Lookup)getServletContext().getAttribute("lookup");
	
	//System.out.println("After Lookup");
	 
	  if((type!=null)&&(cId!=null)){
	  //	System.out.println("Checking for getVendorsByClient");
	  	out.print(lookup.getVendorsByClient(cId));
	  }
	
  	
%>	
