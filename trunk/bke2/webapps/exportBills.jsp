<%@ page language="java" import="com.intuit.quickbase.util.*,com.bke2.util.*" %><%@ page import="ibizqb.*"%> <%@ page buffer="256kb"%>  <%@ page import="java.util.*"%><%@ page import="java.text.SimpleDateFormat"%>      <%@ page import="java.lang.reflect.Array"%>  <%@ page import="org.w3c.dom.Document"%>  <%@ page import="org.xml.sax.InputSource"%>  <%@ page import="org.w3c.dom.Element"%>  <%@ page import="org.w3c.dom.NodeList"%>  <%@ page import="org.w3c.dom.Node"%> <%@ include file="include.jsp" %> <%  //    if (request.getMethod().equalsIgnoreCase("POST")) {	    	 	// Lookup lookup = (Lookup)getServletContext().getAttribute("lookup");		  String strURL = "https://docorganiz.quickbase.com/db/";		  		  String vendorId = request.getParameter("vid");		  String serverURL = "http://10.100.42.85:2080";		  //String serverURL = "http://localhost:2080";		  		  if(vendorId==null){		  		return;		  }		  		  String s1 ="{'90'.EX.'"+vendorId+"'}AND{'27'.EX.'Accept'}";		  String s2 = "13.14.112.23.24.124.25.3";		  String s3 = "3";		  String s4 = "sortorder-AD";		  ServletContext context = this.getServletContext() ;  				String invoiceTableId = context.getInitParameter( "invoiceTableId" ); 			String itemTableId = context.getInitParameter( "itemTableId" );			String vendorTableId = context.getInitParameter( "vendorTableId" );		 		  String s2a = "16.17.22.15";		  String s3a = "16";		 				String u = "QuickBaseAdmin@docorganiz.com";		String p = "QBadd1234#*";		 		 QuickBaseClient qdb12 = new QuickBaseClient(u ,p , strURL);		 Vector vector = qdb12.doQuery(invoiceTableId,s1, s2, s3, s4);		 HashMap hashmap1 = null;		 HashMap hashmap2 = null;		 System.out.println("entering");		 String headerID = null;		 System.out.println("****************Count"+vector.size());		 String vendor = null;		 String accountNo = null;		 String terms = null;		 String invoiceNum = null;		 String invoiceDate = null;		 String invDueDate = null;		 String invDate = null;		 String countApp = null;		 String invoiceDueDate = null;		 Bill bills = new Bill();		 String primaryKey = null;		 String lineAmt = null;		 String lineDesc = null;		 String accName = null;		 String accNum = null;		 int lineItemAmt = 0;		 bills.setQBConnectionString("URL='"+serverURL+"'");		 		 bills.reset();			 HashMap infoHash = new  HashMap();		 SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd"); 		 		 for(int j = 0; j <= vector.size() - 1; j++)         {           	hashmap1 = (HashMap)vector.elementAt(j);            Iterator iterator = hashmap1.values().iterator();         	while (iterator.hasNext()) 			{						/* System.out.println("1 \t"+iterator.next());			 System.out.println("2 \t"+iterator.next());			 System.out.println("3 \t"+iterator.next());			 System.out.println("4 \t"+iterator.next());			 System.out.println("5 \t"+iterator.next());			 System.out.println("6 \t"+iterator.next());			 System.out.println("7 \t"+iterator.next());			 System.out.println("8 \t"+iterator.next());*/			 						 //header #			 headerID=(String)iterator.next();			 //System.out.println("header"+headerID);			 			 //Account Number			 accountNo = (String)iterator.next();			 //System.out.println("acc num"+accountNo);			 //invoice due date			 invoiceDueDate = (String)iterator.next();			 invDueDate = new SimpleDateFormat  (  "MM/dd/yyyy"  ).format(new Date(Long.parseLong(invoiceDueDate) + 86400000l));			 //System.out.println("due date"+invDueDate);			 			 //invoice date			 invoiceDate = (String)iterator.next();			 invDate = new SimpleDateFormat  (  "MM/dd/yyyy"  ).format(new Date(Long.parseLong(invoiceDate) + 86400000l));			 //System.out.println("inv date"+invDate);						 //Invoice Number			 invoiceNum = (String)iterator.next();				 ///System.out.println("invoice num"+invoiceNum);			 			 // terms			 terms = (String)iterator.next();				 //System.out.println("terms"+terms);			 			 //Count App			 countApp = (String)iterator.next();			 //System.out.println("count"+countApp);			 			 //vendor name			 vendor = (String)iterator.next();			 //System.out.println("vendor"+vendor);			 				 //inserting in quickbooks						 			 System.out.println("vendor"+vendor);			 bills.setVendorName(vendor.trim());			 System.out.println("accountNo "+accountNo);			 bills.setMemo(accountNo);			 //bills.setTermsName(terms);			 System.out.println("invoiceNum "+invoiceNum);			 bills.setRefNumber(invoiceNum);			 System.out.println("invDate "+invDate);			 bills.setTransactionDate(invDate);			 System.out.println("invDueDate "+invDueDate);			 bills.setDueDate(invDueDate);			 			   			 //query corresponding Line Item			  Vector lineItemVector = qdb12.doQuery(lineItemTableId,"{'6'.EX."+headerID+"}", s2a, s3a, s4);			  			  bills.setExpenseCount(lineItemVector.size());			  			  //Set Expenses			  for(int i = 0; i <= lineItemVector.size() - 1; i++)              {           	     hashmap2 = (HashMap)lineItemVector.elementAt(i);                 Iterator iterator2 = hashmap2.values().iterator();				          	     while (iterator2.hasNext()) 			     {				    /*//Amount			        System.out.println("1 \t"+iterator2.next());					//Desc			        System.out.println("2 \t"+iterator2.next());					//Acc Name			        System.out.println("3 \t"+iterator2.next());					//Acc Num			        System.out.println("4 \t"+iterator2.next());*/										lineAmt = (String)iterator2.next();					//System.out.println("lineAmt"+lineAmt);		 			lineDesc = (String)iterator2.next();					//System.out.println("lineDesc"+lineDesc);		 			accName = (String)iterator2.next();					//System.out.println("accName"+accName);		 			accNum = (String)iterator2.next();					//System.out.println("accNum"+accNum);									System.out.println("linet Item # >>  "+i);			 					try{												lineItemAmt = Float.valueOf(lineAmt.trim()).intValue();						lineItemAmt = lineItemAmt*100;						System.out.println("line amt amount"+lineItemAmt);					  bills.setExpenseAmount(i, lineItemAmt);						System.out.println("accName "+accName);						bills.setExpenseAccountName(i, accName.trim());						//bills.setExpenseAccountId(i, "21"); //accNum.trim()						System.out.println("lineDesc "+lineDesc);			 		  bills.setExpenseMemo(i,lineDesc);									 		}catch(Exception e1){						e1.printStackTrace();					}							 			     }//end while			 			 } //end for			  			 //add			 try{			 		System.out.println("Before Pushing the package to iBiz");			 			 	  bills.add();				  infoHash.put("46","Exported");			 	  primaryKey = qdb12.editRecord(invoiceTableId, infoHash,headerID );				  System.out.println("Successfully added"+infoHash);			 } catch(Exception iBizQBException)			 {			   System.out.println("iBizQBException "+iBizQBException.getMessage());			 }						 			 		 	}		 		 }		   //}		  %>