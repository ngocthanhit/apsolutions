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

 
   String vendorId = request.getParameter("vendorId");
   String invoiceNumber = request.getParameter("invoiceNumber");
   //String vid = request.getParameter("vid");

 
 if( cookieArray != null) { 
 
 		  //System.out.println("Cookie Set");
 
 		  for( int i = cookieArray.length-1; i >= 0; i-- ) { 
 		    Cookie cookie = cookieArray[i]; 
 		    if(cookie.getName().equals("uid1"))
 		    	cookieuid1 = cookie.getValue();
 		    if(cookie.getName().equals("uid2"))
 		    	cookieuid2 = cookie.getValue();
 		    if(cookie.getName().equals("password"))
 		    	cookiepassword = cookie.getValue();
 		    
 	//	    System.out.println("Cookie name is " + cookie.getName()); 
 	//	    System.out.println("Cookie value is " + cookie.getValue()); 
 		  } 
	}

	
	
	 
	String strURL = "https://docorganiz.quickbase.com/db/";
	
	String login = cookieuid1+"@"+cookieuid2;
	String password = cookiepassword;
 

 	QuickBaseClient qdb = null;


	DataLookup dl = new DataLookup(login,password);
	
	
	  qdb = new QuickBaseClient(login, password, strURL);   		
	  out.print(dl.isVendorInvoiceExist(vendorId,invoiceNumber));
	  
	 // if(voucherNumber!=null){
	  	System.out.println("Voucher");
	  	out.print(dl.isVoucherExist(voucherNumber));
	 // }else if((invoiceNumber!=null)&&(vendorId!=null)){
	 // 	out.print(dl.isVendorInvoiceExist(voucherNumber,invoiceId));
	 // }
	  
	/*	
  	//String[] nat1 = dl.getNaturalAccount();
	
	try{
   		System.out.println("IN TRY check value"+voucherNumber);
   		qdb = new QuickBaseClient(login, password, strURL);   		
		out.print(dl.isLoginFailure());
 		if(dl.isLoginFailure()){
 			//response.sendRedirect("/docorganiz/login.jsp?ac="+ac+"&vid="+vid);
 		} 
 		
 		//out.println("<h5>"+dl.isVoucherExist(voucherNumber)+"</h5>");
   		//out.print("document.voucherInvoiceAllocation.voucher_no.style.backgroundColor='green';");	
   	}catch(Exception e){
   		System.out.println("LOGIN FAILED");
   		//response.sendRedirect("/docorganiz/login.jsp?ac="+ac+"&vid="+vid); 
  	}
 */
  	
%>	
