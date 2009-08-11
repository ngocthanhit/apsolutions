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
   String lastVoucherId=""; 
   String lastVoucherNumber="";
   String lastVoucherNumberSub="";
   String lastVoucherNumberStr = ""; 
   String nextVoucherNumberStr = "";   
   int nextVoucherNumber =0;
   int lastVoucherNumberInt = 0;
   int lastVoucherNumberStrInt = 0; 
   int tempValue=0;
   
   String cookiepassword="";
   Cookie[] cookieArray = request.getCookies(); 

   String voucherNumber = "";
    
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
 		    if(cookie.getName().equals("lastVoucherId"))
 		    	lastVoucherId = cookie.getValue();
 		    if(cookie.getName().equals("lastVoucherNumber"))
 		    	lastVoucherNumber = cookie.getValue();
 		  } 
	}
	 
	String strURL = "https://docorganiz.quickbase.com/db/";
	
	String login = cookieuid1+"@"+cookieuid2;
	String password = cookiepassword;
 

 	QuickBaseClient qdb = null;


	DataLookup dl = new DataLookup(login,password);	
	
	  qdb = new QuickBaseClient(login, password, strURL);   		
	
	 // voucherNumber = dl.getLastVoucherNumber();
	
	  System.out.println("Last Voucher Number is "+voucherNumber);
	
	 if( (lastVoucherNumber.length()>0) && (lastVoucherId.length()>0)){	  
	 	  
	  	System.out.println("Has VoucherID and Number"+lastVoucherNumber);
	
	        for (int i=0;i<lastVoucherNumber.length();i++) {
		            if((lastVoucherNumber.charAt(i)>=65 && lastVoucherNumber.charAt(i)<=90)||(lastVoucherNumber.charAt(i)>=97 && lastVoucherNumber.charAt(i)<=122)) {
		                tempValue=i+1;
		                //System.out.println("TEMP VALUE After---> "+tempValue);
		            }
		        }
		        if(tempValue==1) {		            
		            lastVoucherNumberSub =lastVoucherNumber.substring(0,1);
		            lastVoucherNumberStr = lastVoucherNumber.substring(1,11);
		            //System.out.println("lastVoucherNumberSub-----> "+lastVoucherNumberSub);		            
		            lastVoucherNumberStrInt = Integer.parseInt(lastVoucherNumberStr);
		            System.out.println ("LastVoucherNumer ========= "+lastVoucherNumberStr);
		            lastVoucherNumberStrInt++;
		            System.out.println("NEXT VOCU NUM FOR K1-----> "+lastVoucherNumberStrInt);
		            String s1=lastVoucherNumberSub+lastVoucherNumberStrInt; 
		            nextVoucherNumberStr = s1;		            
		             
		        } else if(tempValue==2) {		            
		            lastVoucherNumberSub = lastVoucherNumber.substring(0,2);
		            lastVoucherNumberStr = lastVoucherNumber.substring(2,11);
		            //System.out.println("lastVoucherNumberSub-----> "+lastVoucherNumberSub);		            
		            lastVoucherNumberStrInt = Integer.parseInt(lastVoucherNumberStr);
		            System.out.println("LastVoucherNumer ========= "+lastVoucherNumberStr);
		            lastVoucherNumberStrInt++;
		            System.out.println("NEXT VOCU NUM FOR K2-----> "+lastVoucherNumberStrInt);
		            String s2=lastVoucherNumberSub+lastVoucherNumberStrInt;
		            nextVoucherNumberStr = s2;		            
		            
		        } else {		            
		            lastVoucherNumberSub =lastVoucherNumber.substring(0,3);
		            lastVoucherNumberStr = lastVoucherNumber.substring (3,11);
		            //System.out.println("lastVoucherNumberSub-----> "+lastVoucherNumberSub);
		            lastVoucherNumberStrInt = Integer.parseInt(lastVoucherNumberStr);
		            System.out.println ("LastVoucherNumer ========= "+lastVoucherNumberStr);
		            lastVoucherNumberStrInt++;
		            //System.out.println("NEXT VOCU NUM FOR K3-----> "+lastVoucherNumberStrInt);
		            String s3=lastVoucherNumberSub+lastVoucherNumberStrInt; 
		            nextVoucherNumberStr = s3;
		            
		        }
		        //nextVoucherNumberStr =lastVoucherNumberSub+lastVoucherNumberStr;
		        //System.out.println("NEXTVoucherNumber "+nextVoucherNumberStr); 
		        //System.out.println("NEXTVoucherNumber "+nextVoucherNumberStr);
                        out.print(nextVoucherNumberStr);
	}  else {	
	  	System.out.println("No cookie value");	  
	  //	out.print(dl.isVendorInvoiceExist(vendorId,invoiceNumber));
	  }
	  
%>