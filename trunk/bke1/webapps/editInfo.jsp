  <%@ page language="java" import="com.intuit.quickbase.util.*,com.bke1.util.Lookup" %> 
  <%@ page buffer="128kb"%>                           
  <%@ page import="java.util.*,java.io.*,java.text.*,java.sql.Timestamp"%>
  
 <%
 
   System.out.println("Inside editInfo.jsp of docorganiz5");
 
   String cookieuid1="";
   String cookieuid2=""; 

//   System.out.println("MYVAL>>>>>>>>>>>"+request.getParameter("myVal"));
   
   String field = request.getParameter("field").trim();
   String columnId = request.getParameter("columnId").trim();
   String tableId = request.getParameter("tableId").trim();
   String tablePK = request.getParameter("tablePK").trim();
   String vendorId = request.getParameter("vId");
  
  
	System.out.println("Before Hashmap");	
	System.out.println("field : " + field);	
	System.out.println("columnId : " + columnId);	
	System.out.println("tableId : " + tableId);	
	System.out.println("tablePK : " + tablePK);	

  

        String voucherTableId = "bdy8ms9iq";
        String invoiceTableId = "bd77scjia";
        String allocationTableId = "bd77scjib";
          String agentTableId = "bdyvk9utf";
  String userInfoTableId = "bdyvk9utt";	

	String strURL = "https://docorganiz.quickbase.com/db/";
	
	
	Lookup lookup = (Lookup)getServletContext().getAttribute("lookup");
   	int result=0;   
	
	String message="";
	
				HashMap infoHash = new  HashMap();
				Vector vector = null;	
				infoHash.put(columnId, field);
					try{
						System.out.println(" infoHash"+infoHash);
						message = lookup.editRecord(tableId, infoHash,tablePK);
					}catch(Exception e){
						System.out.println("Exception "+e.getMessage());
						message=e.getMessage();
					}
					out.println(message);
%>	
