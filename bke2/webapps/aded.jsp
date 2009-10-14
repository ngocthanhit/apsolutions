  <%@ page language="java" import="com.intuit.quickbase.util.*,com.bke2.util.*" %> 
  <%@ page buffer="256kb"%>  
  <%@ page import="java.util.*,java.io.*,java.text.*,java.sql.Timestamp"%>
  <%@ page import="java.text.SimpleDateFormat"%>      
  <%@ page import="java.lang.reflect.Array"%>  
  <%@ page import="org.w3c.dom.Document"%>  
  <%@ page import="org.xml.sax.InputSource"%>  
  <%@ page import="org.w3c.dom.Element"%>  
  <%@ page import="org.w3c.dom.NodeList"%>  
  <%@ page import="org.w3c.dom.Node"%>                  
<%
   System.out.println(" HELLO>>>>>>>>>>>>>>>>>>>>>>>>>>> >>>>> 1");
%>
                                                      
 <%
	 Lookup lookup = (Lookup)getServletContext().getAttribute("lookup");
		String u = request.getParameter("u");
   String cookieuid1="";
   String cookieuid2=""; 
   String imageH="";
   String imageV="";
   String imagePosition="1080";
   String cookiepassword="";
   String ac = request.getParameter("ac");
   String vid = request.getParameter("vid");
   String mv = request.getParameter("mv");
   String vid1 = request.getParameter("vid1");
	 String nxt = request.getParameter("nxt");
	 String reportIdArrayStr = request.getParameter("reportIdArrayStr");
    
    System.out.println("mv >>>>>>>>>>>"+mv);
 		 	
   String clientName1 = request.getParameter("clientName");
   String clientId1 = request.getParameter("clientId");

	 if(clientName1 == null) 	clientName1="";
	 if(clientId1 == null) 	clientId1="";
	 if(mv == null) 	mv="";
   System.out.println(" ac >>>>> "+ac);
   System.out.println(" mv >>>>> "+mv);
 
   String skipArray = request.getParameter("skipArray");

	 String qbid = request.getParameter("u");

System.out.println("qbid >" +qbid);

   if(qbid==null) qbid = "";

 
   Cookie[] cookieArray = request.getCookies(); 


   if( cookieArray != null) { 
 
 
 		  for( int i = cookieArray.length-1; i >= 0; i-- ) { 
 		  
 		  
 		    Cookie cookie = cookieArray[i]; 
 		    if(cookie.getName().equals("uid1"))
 		    	cookieuid1 = cookie.getValue();
 		    if(cookie.getName().equals("uid2"))
 		    	cookieuid2 = cookie.getValue();
 		    if(cookie.getName().equals("password"))
 		    	cookiepassword = cookie.getValue();
 		    if(cookie.getName().equals("imageH")){
 		    	imageH = cookie.getValue();
		    	System.out.println("imageH Cookie exists "+imageH);
		    	}
 		    if(cookie.getName().equals("imageV"))
 		    	imageV = cookie.getValue();
 		  } 
	}
	
		 
	String strURL = "https://docorganiz.quickbase.com/db/";
	
	String login = cookieuid1+"@"+cookieuid2;
	String password = cookiepassword;
	int cookieTime = 60*60*24*365;
 
 	if((login.length()<4)||(password==null)||(password.length()<2)){
 		System.out.println("Please logon with your credentials");
 		response.sendRedirect("login.jsp?ac="+ac+"&u="+qbid+"&vid="+vid+"&msg=Please logon with your credentials");
	 	return;	
	}
 
  	
 	System.out.println("QBUID "+qbid);
	System.out.println("Login "+login);
	
	if((qbid.length()>0)&&(!qbid.equalsIgnoreCase(login))){	
 		System.out.println("Please logon with your credentials");
		response.sendRedirect("login.jsp?ac="+ac+"&u="+qbid+"&vid="+vid+"&msg=Please logon with your credentials");
 		return;	
	}
	
			ServletContext context1 = this.getServletContext();  
			String applicationName = context1.getInitParameter( "applicationName" );  
		
	
				String voucherTableId = context1.getInitParameter( "voucherTableId" );  
				String allocationTableId = context1.getInitParameter( "allocationTableId" );  
				String agentTableId = context1.getInitParameter( "agentTableId" );  
				String userInfoTableId = context1.getInitParameter( "userInfoTableId" );  
				
				System.out.println("*************modified for 2.1");
	

	//Sufix CID is Column ID

	String voucherCommCID = "33";
	String vendor_idCID = "22";
	String voucher_noCID = "8";
	String voucher_dateCID = "9";
	String approverCID = "66";
	String process_status_trailCID = "88";
	
	
	String status_dateCID = "30";

	String invoice_dateCID = "8";
	
	String purchaseAmtArrayCID = "8";
	String descriptionCID = "44";
	String cd1CID = "97";
	String cd2CID = "25";
	String cd3CID = "114";
	String purchaseAmountCID = "8";	
	String allocationCommCID = "85";
	String invoiceRecordCID = "9";
	String naturalActCID = "97";
	String pcCID = "25";
	
	String agentNumberCID = "9";
	String allocRecordCID = "6";
	String agentAmtLineCID = "10";
	String agentAccountLineCID = "35";
	String agentChargeLineCID = "11";
	String agentDepLineCID = "12";
	String agentCmtLineCID = "49";


		
	int allocCtr = 0; 


   if( (ac.equalsIgnoreCase("ad"))  ){	
  	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 222"); 	      
    System.out.println("Just load the page for insert @@@@  should be NULLL   :"+request.getParameter("vendor_id"));  	
		//isLogged2QB
		boolean isAuthenticated;
		
	  isAuthenticated = lookup.isAuthenticated(login,password);
	  
	  System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ isAuthenticated  "+isAuthenticated); 	     
	  String storedU=lookup.getUser();
	  //System.out.println("storedU"+storedU+"mv >>"+mv);
	   
	   if(storedU!=null) qbid=storedU;
	  
	  if ( (mv!=null) &&   mv.equals("nb") ){
		  
 			
		  session.setAttribute( "clientName", clientName1 );
		  session.setAttribute( "applicationName", applicationName );
		  session.setAttribute( "voucherTableId", voucherTableId );
		  session.setAttribute( "allocationTableId", allocationTableId );
		  session.setAttribute( "agentTableId", agentTableId );
		  session.setAttribute( "userInfoTableId", userInfoTableId );
		  //session.setAttribute( "franchiseName", franchiseName );
		  //session.setAttribute( "franchiseId",franchiseId );

	  }
	  //System.out.println("qbid >" +qbid+ ">" +login);
	  
	  /*
 		if(!qbid.equalsIgnoreCase(login)){
 			System.out.println("login"+login+"\t  qbid"+qbid+"\t vid "+vid);
 			System.out.println("Please logon with the same credentials that you used in Quick Base Application");
 			response.sendRedirect("login.jsp?ac="+ac+"&u="+qbid+"&vid="+vid+"&msg=Please logon with the same credentials that you used in Quick Base Application");
	 		return;	
		}
		*/
		
  } 
  
  
  
	
	

	if( request.getParameter("mv")!=null){

		if( request.getParameter("mv").equals("sr") ){
				response.sendRedirect("https://docorganiz.quickbase.com/db/"+applicationName);
		}
  }
		
 %>
 
<% if( ac.equals("ad") )  {%>	
		<%@ include file="add.html"%> 
<%}else {%>	
		<%@ include file="edit.html"%> 
<%}%>
 	
