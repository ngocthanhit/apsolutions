  <%@ page language="java" import="com.intuit.quickbase.util.*,com.bke2.util.*,com.bke2.domain.*" %> 
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

   Lookup lookup = (Lookup)getServletContext().getAttribute("lookup");

   String u = request.getParameter("u");


   System.out.println(" u >>>>> "+u);
      
   String cookieuid1="";
   String cookieuid2=""; 
   String imageH="";
   String imageV="";
   String imagePosition="1080";
   
   String cookiepassword="";
  
   String ac = request.getParameter("ac");
  
   String logoutac = ac;
  
   String ac1 = ac;
   
   String vid = request.getParameter("vid");
   String mv = request.getParameter("mv");
   String vid1 = request.getParameter("vid1");


   String clientName1 = request.getParameter("clientName");
   String clientId1 = request.getParameter("clientId");
   //String franchiseName = request.getParameter("franchiseName");
   //String franchiseId = request.getParameter("franchiseId");

	 if(clientName1 == null) 	clientName1="";
	 if(clientId1 == null) 	clientId1="";
	 if(mv == null) 	mv="";
	 //if(franchiseName == null) 	franchiseName="";
	 //if(franchiseId == null) 	franchiseId="";
	 
   
   System.out.println(" ac >>>>> "+ac);
   System.out.println(" mv >>>>> "+mv);
   String skipArray = request.getParameter("skipArray");

   if(skipArray==null){
			skipArray = "";
   }

   System.out.println("skipArray Has Value"+skipArray);
	
	 String qbid = request.getParameter("u");
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
 		    
 	//	    System.out.println("Cookie name is " + cookie.getName()); 
 	//	    System.out.println("Cookie value is " + cookie.getValue()); 
 		  } 
	}

	
	
	 
	String strURL = "https://docorganiz.quickbase.com/db/";
	
	String login = cookieuid1+"@"+cookieuid2;
	String password = cookiepassword;
	int cookieTime = 60*60*24*365;
 
 	if((login.length()<4)||(password==null)||(password.length()<2)){
 		System.out.println("Please logon with your credentials 1");
 		response.sendRedirect("/bke2/login.jsp?ac="+ac+"&u="+qbid+"&vid="+vid+"&msg=Please logon with your credentials 1");
	 	return;	
	}
 
  	
 	System.out.println("QBUID "+qbid);
	System.out.println("Login "+login);
	
	if((qbid.length()>0)&&(!qbid.equalsIgnoreCase(login))){	
 		System.out.println("Please logon with your credentials 21");
		response.sendRedirect("/bke2/login.jsp?ac="+ac+"&u="+qbid+"&vid="+vid+"&msg=Please logon with your credentials 2");
 		return;	
	}
	

	
   	System.out.println("AFTER DL");

String applicationName = "bd77scjh5";

        String voucherTableId = "bdy8ms9iq";
        String allocationTableId = "bd77scjib";
				String agentTableId = "bdyvk9utf";
				String userInfoTableId = "bdyvk9utt";	
  

      
	//Sufix CID is Column ID

	String voucherCommCID = "33";
	String vendor_idCID = "22";
	String voucher_noCID = "8";
	String voucher_dateCID = "9";
	String approverCID = "66";
	String process_status_trailCID = "88";
	
	
	String status_dateCID = "30";

	String voucherRecordCID = "106";	
	String invoice_noCID = "9";
	String invoice_dateCID = "8";
	String invoiceCommCID = "52";
	
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

	//For Block the Duplicate AJAX call 
	
	String VendorLocal = "VendorLocal";
	String VoucherLocal = "VoucherLocal";
	String VoucherDateLocal = "VoucherDateLocal";
	String ProStatLocal = "ProStatLocal";
	String InvoiceNoLocal = "InvoiceNoLocal";

	//System.out.println("Here ");
	String voucher_no = request.getParameter("voucher_no");
	String  vendor_id = request.getParameter("vendor_id");
			
			
				
  	//Voucher voucher = new Voucher();

	


	String agentIdStr="";
	String[] agentIdLine = null;

	String agentNumberStr="";
	String[] splitLine = null;

	String agentAmmount="";
	String[] agentAmtLine = null;

	String agentAccount="";
	String[] agentAccountLine = null;

	String agentCharge="";
	String[] agentChargeLine = null;

	String agentDep="";
	String[] agentDepLine = null;

	String agentCmt="";
	String[] agentCmtLine = null;

	String[] purchaseAmtArray = null;

	//String allocRecord = ""; 
	String agentRecord = ""; 	      

	HashMap  voucherHash = null;
	HashMap  invoiceHash = null; 	      
	HashMap  allocHash = null; 	      
	HashMap  agentHash = null;

	int allocCtr = 0; 


   if( (ac.equalsIgnoreCase("ad"))  ){	
  
  System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 222"); 	      
  
	  System.out.println("Just load the page for insert @@@@  should be NULLL   :"+request.getParameter("vendor_id"));  	
	 
		boolean isAuthenticated;
	  isAuthenticated = lookup.isAuthenticated(login,password);
	  System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ isAuthenticated  "+isAuthenticated); 	     
	  
	  
	  
	  String storedU=lookup.getUser();
	  System.out.println("storedU"+storedU+"mv >>"+mv);
	  
	  
	  	qbid=storedU;
	  
	  if ( (mv!=null) &&   mv.equals("nb") ){
		  
		  session.setAttribute( "clientName", clientName1 );
		  session.setAttribute( "clientId", clientId1 );
		  //session.setAttribute( "franchiseName", franchiseName );
		  //session.setAttribute( "franchiseId",franchiseId );

	  }
	  
 		if(!qbid.equalsIgnoreCase(login)){
 			System.out.println("login"+login+"\t  qbid"+qbid+"\t vid "+vid);
 			System.out.println("Please logon with the same credentials that you used in Quick Base Application");
 			response.sendRedirect("/bke2/login.jsp?ac="+ac+"&u="+qbid+"&vid="+vid+"&msg=Please logon with the same credentials that you used in Quick Base Application");
	 		return;	
		}
		
		
  } 
  else if ( (ac.equals("vu"))  && (mv!=null) && (mv.length()>0)	) {
  
  //&& ( mv.equals("nx") ) && vid1!=null) ) (mv.equals("nx")) 
  
  		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 1111111"); 	      
			 
	
		//if( (cookieuid1.length()==0)&&(cookieuid2.length()==0)&&(cookiepassword.length()==0) ){ 
			response.sendRedirect("/bke2/vu.jsp?ac="+ac+"&u="+qbid+"&vid="+vid1); 
		//}
		
  }
  
  
  
	
	
	
	
	if( request.getParameter("mv")!=null){

		if( request.getParameter("mv").equals("sn") ){
			response.sendRedirect("/bke2/vu.jsp?ac=vu");
		}else if( request.getParameter("mv").equals("sr") ){
				response.sendRedirect("https://docorganiz.quickbase.com/db/"+applicationName);
		}
  	}
		
 %>
 
 	<%@ include file="vu.html"%> 
 	
