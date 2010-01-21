
/**
 * QBWebConnectorQuerySvcSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
package com.intuit.developer;

import java.io.IOException;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.jdom.*;
import org.jdom.Element;
import org.jdom.Text;
import org.jdom.input.*;
import javax.swing.text.DateFormatter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.bke2.util.AccountRet;
import com.bke2.util.Lookup;
import com.bke2.util.VendorRet;
import javax.xml.xpath.*;

import com.bke2.util.Lookup;
import com.intuit.quickbase.util.QuickBaseClient;
import com.intuit.quickbase.util.QuickBaseException;
    /**
     *  QBWebConnectorQuerySvcSkeleton java skeleton for the axisService
     */
    public class QBWebConnectorQuerySvcSkeleton{
        
         String loginID = null;
         String passWord = null;
 		 DateFormat quickBaseInputDateFormatter = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy");
 		 DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
 		 
 		 
  		 String clientId = "7";
 		 String strURL = "https://docorganiz.quickbase.com/db/";
		 String s4 = "sortorder-AD";
		 String accountsTableId = "bes8a4tgv";
		 String vendorTableId ="bes8a4tgu";
		 QuickBaseClient qdb13 = new QuickBaseClient("mgconno@yahoo.com" ,"Bubbaa17", strURL);		
		 QuickBaseClient qdb15 = new QuickBaseClient("sashiatwork@gmail.com" ,"SRquic12", strURL);
		
        /**
         * Auto generated method signature
         * 
                                     * @param sendRequestXML
         */
        
    	public com.intuit.developer.SendRequestXMLResponse sendRequestXML(com.intuit.developer.SendRequestXML sendRequestXML)
    	{
    		SendRequestXMLResponse response = new SendRequestXMLResponse();
    		String inXML;
    		Lookup lookup = new Lookup();
    		
    		//THE FOLLOWING COMMENTED OUT CODE WORKS
    		/*
    		inXML ="<?xml version=\"1.0\" ?>" +
    		"<!DOCTYPE QBXML PUBLIC '-//INTUIT//DTD QBXML QBD 1.0//EN' >" +
    		"<QBXML>" +
    		"<QBXMLMsgsRq onError = \"continueOnError\">" +
    		//"<VendorQueryRq requestID = \"1\">" +
    		//"</VendorQueryRq>" +
    		//"<AccountQueryRq requestID = \"1\">" +
    		//"</AccountQueryRq>" +
    		"<BillQueryRq requestID = \"1\">" +
    		"</BillQueryRq>" +
    		"</QBXMLMsgsRq></QBXML>";
    		 */
    		/*			
    		// In the following BillAddRq I added a made up defMacro. defMacro is required,
    		// but I am not sure what it should look like. I got this from an example on the
    		// web.
    		
    		// When I run this in the WebConnector log the error reads
    		
    		//20091217.21:26:06 UTC	: QBWebConnector.SOAPWebService.do_sendRequestXML() : Request xml received.
    		//20091217.21:26:06 UTC	: QBWebConnector.SOAPWebService.ProcessRequestXML() : Processing request #1
    		//20091217.21:26:06 UTC	: QBWebConnector.SOAPWebService.ProcessRequestXML() : REQUEST: received from application: size (bytes) = 312
    		//20091217.21:26:06 UTC	: QBWebConnector.SOAPWebService.ProcessRequestXML() : Sending request to QuickBooks.
    		//20091217.21:26:06 UTC	: QBWebConnector.SOAPWebService.ProcessRequestXML() : Sending error message back to application:
    		//HRESULT = 0x80040400
    		//Message: QuickBooks found an error when parsing the provided XML text stream.
    		//20091217.21:26:06 UTC	: QBWebConnector.SOAPWebService.ProcessRequestXML() : XML dump follows: -

    		//Request that failed:

    		//<?xml version="1.0" ?><!DOCTYPE QBXML PUBLIC '-//IN......

    		inXML ="<?xml version=\"1.0\" ?>" +
    		"<!DOCTYPE QBXML PUBLIC '-//INTUIT//DTD QBXML QBD 1.0//EN' >" +
    		"<QBXML>" +
    		"<QBXMLMsgsRq onError = \"stopOnError\">" +
    			"<BillAddRq requestID=\"1\">" +
    				"<BillAdd defMacro=\"TxnID:13C4A282-BD56-4975-B450-42A0990E64AF>" +
                		"<VendorRef>" +
                    		"<FullName>Ameritel</FullName>" +
                		"</VendorRef>" +
            		"</BillAdd>" +
    			"</BillAddRq>" +
    		"</QBXMLMsgsRq></QBXML>";
    */
    		
    		inXML ="<?xml version=\"1.0\" ?>" +
    		"<!DOCTYPE QBXML PUBLIC '-//INTUIT//DTD QBXML QBD 1.0//EN' >" +
    		"<QBXML>" +
    		"<QBXMLMsgsRq onError = \"continueOnError\">" +
    		//"<VendorQueryRq requestID = \"1\">" +
    		//"</VendorQueryRq>" +
    		"<AccountQueryRq requestID = \"1\">" +
    		"</AccountQueryRq>" +
    	//	"<BillQueryRq requestID = \"1\">" +
    	//	"</BillQueryRq>" +
    		"</QBXMLMsgsRq></QBXML>";
    
    		/*
    		inXML ="<?xml version=\"1.0\"?>"+ 
    		"<?qbxml version=\"3.0\"?>"+
    		    "<QBXML>"+
    		        "<QBXMLMsgsRq onError=\"stopOnError\" >"+ lookup.exportBills()+   
    		        "</QBXMLMsgsRq>"+
    		    "</QBXML>";
    		 */
    		System.out.println("Final XML STRING: "+ inXML);
    		response.setSendRequestXMLResult(inXML);
    		return response;
    	}
     
         
        /**
         * Auto generated method signature
         * 
         * @param connectionError
         */
        
                 public com.intuit.developer.ConnectionErrorResponse connectionError(com.intuit.developer.ConnectionError connectionError)
                 {
                	 ConnectionErrorResponse response = new ConnectionErrorResponse();
                	 String errorMessage = null;
                	 try {
                		 errorMessage = connectionError.getMessage();
                		 response.setConnectionErrorResult(errorMessage);
                	 } catch (Exception ex) {
                		 	throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#connectionError");
                     }
                	 return response;
                 }
     
         
        /**
         * Auto generated method signature
         * 
         * @param closeConnection
         */
        
                 public com.intuit.developer.CloseConnectionResponse closeConnection(com.intuit.developer.CloseConnection closeConnection)
                 {
              		CloseConnectionResponse connection = new CloseConnectionResponse();
              		try {
              			connection.setCloseConnectionResult("Closing  the connection");
              		}catch (Exception ex){
              			throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#closeConnection");
              		}
              		return connection;	 
              	 }

        /**
         * Auto generated method signature
         * 
         * @param getLastError
         */
        
                 public com.intuit.developer.GetLastErrorResponse getLastError(com.intuit.developer.GetLastError getLastError)
              	 { 
              		GetLastErrorResponse response = new GetLastErrorResponse();
              		response.setGetLastErrorResult(getLastError.getTicket());
              		return response;
              	 }
     
         
        /**
         * Auto generated method signature
         * 
         * @param authenticate
         */
                 public com.intuit.developer.AuthenticateResponse authenticate(com.intuit.developer.Authenticate authenticate)
              	 {
              		AuthenticateResponse response = new AuthenticateResponse();
              	    Lookup lookup = new Lookup();
              	    String login;
              	    String password;

              		try{
              			String[] asRtn = new String[2];
              			asRtn[0] = "{F5FCCBC3-AA13-4d28-9DBF-3E571823F2BB}"; //myGUID.toString();
              			
              			loginID= authenticate.getStrUserName();
              			passWord= authenticate.getStrPassword();
              		    System.out.println("UserName: " + authenticate.getStrUserName());
              			System.out.println("Password: " + authenticate.getStrPassword());
              			boolean isAuthenticated;
              		    isAuthenticated = lookup.isAuthenticated(loginID,passWord);
              			System.out.println("Is Authenticated: "+ isAuthenticated);
              			//Checks for authentication and sends a result back to QBWC
              			if(isAuthenticated) {
              				{asRtn[1] = "";} 
              			} 
              			else {
              				{asRtn[1] = "NVU";}
              			}
              			ArrayOfString asRtn2 = new ArrayOfString();
              			asRtn2.setString(asRtn);
              			response.setAuthenticateResult(asRtn2);
              			
              		}catch (Exception ex){
              			throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#authenticate");
              		}
              		return response;
              	}
     
         
        /**
         * Auto generated method signature
         * 
         * @param receiveResponseXML
         */
        
@SuppressWarnings({ "unchecked", "unchecked", "unchecked" })
				public com.intuit.developer.ReceiveResponseXMLResponse receiveResponseXML(com.intuit.developer.ReceiveResponseXML receiveResponseXML)
             	{
             		ReceiveResponseXMLResponse response = new ReceiveResponseXMLResponse();
             		
            		Element accountQueryRs =null;
            		String requestID =null;
            		
            		try { 
            			System.out.println("Received response  ....");
            			String response1 = receiveResponseXML.getResponse();
            			System.out.println(response1);
            			org.jdom.Document document = null;
            			SAXBuilder builder1 = new SAXBuilder();
             		
            			document = builder1.build(new InputSource(new StringReader(response1)));
            			Element qbxml = document.getRootElement();
            			Element qbxmlrs = (Element)qbxml.getChild("QBXMLMsgsRs");
            			accountQueryRs = (Element)qbxmlrs.getChild("AccountQueryRs");
            			requestID = accountQueryRs.getAttributeValue("requestID");
            			System.out.println("RequestID: "+ requestID);
			                	
					}catch(Exception e1){
						System.out.println("Exception at receiveResponseXML with DOM parsing "+e1.getMessage());
					}
					
					

               		/*	*********************************************/
               		/* 				Get QuickBooks Data             */
               		/************************************************/			
               		
					
					
					Vector quickBooksAccounts=null;
					Vector quickBooksVendors=null;
					
					if(requestID.equals("1")){
						quickBooksAccounts = getQuickBooksAccounts(accountQueryRs);
					}else if(requestID.equals("2")){
					
					}
               		
               		
					
               		/*	*********************************************/
               		/* 				Get QuickBase Data              */
               		/************************************************/			
               		
               		// First check if there are any records at all 
             		Vector quickBaseAccounts = getQuickBaseAccounts();
               		
               		
             		   
             		System.out.println("zzzTotal quickBase Account size>>>>> : " + quickBaseAccounts.size() );
             		System.out.println("Total quickBooksAccount size>>: " + quickBooksAccounts.size() );
               		   
             		
             		
             		syncAccountsInQuickBase(quickBooksAccounts,quickBaseAccounts);

          		   System.out.println("DONE PROCESSING RECORDS XXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
          		   
             		 response.setReceiveResponseXMLResult(100);
             		 return response;
             	}

	public void syncAccountsInQuickBase(Vector quickBooksAccounts, Vector quickBaseAccounts){

		HashMap infoHash2 =null;// new  HashMap();
		HashMap infoHash3 =null;// new  HashMap();
		HashMap infoHash4 =null;// new  HashMap();

		String primaryKey1 ="";
		
   		/*	*********************************************/
   		/* 				Get QuickBase Data              */
   		/************************************************/		

   		Vector tempQuickBooksAccount = quickBooksAccounts;
   		Vector tempQuickBaseAccount = quickBaseAccounts;
   		AccountRet baseAccount = null;
   		AccountRet booksAccount = null;
   		try{
		for (int i = 0; i <= quickBaseAccounts.size()-1; i++) {
				 baseAccount = (AccountRet)quickBaseAccounts.get(i);
   			for (int j = 0;  j<= quickBooksAccounts.size()-1; j++) {
   				   //Updating quickbase records
   				    booksAccount = (AccountRet)quickBooksAccounts.get(j);
   				   //if ( ((AccountRet)quickBaseAccounts.get(i)).getFullName().equals(((AccountRet)quickBooksAccounts.get(j)).getFullName())) {
   				   if( (baseAccount.getFullName().equals(booksAccount.getFullName()))||(baseAccount.getListId().equals(booksAccount.getListId())) ) {
   					//System.out.println("Base is >>>"+baseAccount);
   					//System.out.println("Book is >>>"+booksAccount);
  					 
   					   tempQuickBooksAccount.remove(j);
					   tempQuickBaseAccount.remove(i);
					   //quickBooksAccounts.remove(j);
   					   infoHash3=new HashMap();
   					   
   					   if(!baseAccount.getFullName().equals(booksAccount.getFullName())) 
   					    	infoHash3.put("7",  booksAccount.getFullName());

   					   if(!baseAccount.getAccountNumber().equals(booksAccount.getAccountNumber())) 
   					   infoHash3.put("6",  booksAccount.getAccountNumber());
   					   

   					   if(!baseAccount.getAccountType().equals(booksAccount.getAccountType())) 
   					   infoHash3.put("10", booksAccount.getAccountType());

   					   if(!baseAccount.getDesc().equals(booksAccount.getDesc())) 
   					   infoHash3.put("20", booksAccount.getDesc());

   					   if(!baseAccount.getIsInActive().equals(booksAccount.getIsInActive())) 
   					   infoHash3.put("24", booksAccount.getIsInActive()); // the account is inActive = 0 (active)
   					   
   					   
   					   
   					   if( (booksAccount.getTimeModified()!=null)&&(baseAccount.getTimeModified()!=null)){
   						   if( (baseAccount.getTimeModified().before(booksAccount.getTimeModified())) ){
   							   infoHash3.put("26", booksAccount.getTimeModified().toString());
   						   }
   					   }else if( (booksAccount.getTimeModified()!=null)&&(baseAccount.getTimeModified()==null)){
   						   infoHash3.put("26", booksAccount.getTimeModified().toString());
   					   }
   						   
   					   if(!infoHash3.isEmpty()){
   					   		try{
   					   			primaryKey1 = qdb15.editRecord(accountsTableId, infoHash3, baseAccount.getQuickBasePrimaryKey() );
   					   			System.out.println("Updating primary key"+ baseAccount.getQuickBasePrimaryKey());
   					   			System.out.println("Successfully UPDATEd a Base Record Primary key we are using: "+ infoHash3);
   					   			//System.out.println("Base ACCT: "+ baseAccount);
   					   			//System.out.println("Book ACCT: "+ booksAccount);
 					   
   				   			}catch(Exception e2){
   				   				System.out.println("Problem while editing "+ infoHash3 + "\nwith PK "+baseAccount.getQuickBasePrimaryKey());
   				   				System.out.println("Exception at Edit Record Accounts "+e2.getMessage());
   				   			}
   					   }
					   infoHash3=null;
					   break;	   
   				   }
   			   } // end books for
   		   } //end base for
   		   // For add records
   		
   		   System.out.println("DELETE VECTOR SIZE"+tempQuickBaseAccount.size());
   		for (int k = 0; k <= tempQuickBaseAccount.size()-1; k++) {
   			infoHash4=new HashMap();
   			AccountRet deleteQuickBaseAccount = ((AccountRet)tempQuickBaseAccount.get(k));
   			System.out.println("Value of IsInActive: "+ deleteQuickBaseAccount.getIsInActive());
   			if(deleteQuickBaseAccount.getIsInActive().equals("0")){
   				 
			       infoHash4.put("24", "1");
			       primaryKey1 = qdb15.editRecord(accountsTableId, infoHash4,deleteQuickBaseAccount.getQuickBasePrimaryKey() );               				   
			       System.out.println("SUCCESSFULLY DELETED a Base Record with Primary key: "+deleteQuickBaseAccount.getQuickBasePrimaryKey());
   			}
   		}
   		   
   		   
   		   System.out.println("INSERT VECTOR SIZE >>: " + tempQuickBooksAccount.size());

   		   for (int l = 0; l <= tempQuickBooksAccount.size()-1; l++) {
				    AccountRet addBooksAccount = (AccountRet)tempQuickBooksAccount.get(l);
   			   	infoHash2=new HashMap();
			   	  	infoHash2.put("8", clientId); //Hard Code ClinetID just for Add
			   	  	infoHash2.put("26", addBooksAccount.getTimeModified().toString());
			   	  	infoHash2.put("7",  addBooksAccount.getFullName());
			   	  	infoHash2.put("6",  addBooksAccount.getAccountNumber());
			   	  	infoHash2.put("10", addBooksAccount.getAccountType());
			   	  	infoHash2.put("20", addBooksAccount.getDesc());
			   	  	infoHash2.put("24", addBooksAccount.getIsInActive()); // the account is inActive = 0 (active)
			   	  	infoHash2.put("28", addBooksAccount.getListId());
        	    primaryKey1 = qdb15.addRecord(accountsTableId, infoHash2);
        	    System.out.println ("Insert response"+primaryKey1+"\n infoHash2 "+infoHash2);
   		   }
 		   

 		   System.out.println("DONE SYNCing RECORDS XXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
 		   
 		  
 		} catch (Exception ex){
 			ex.printStackTrace();
 			System.out.println("Message: "+ ex.getMessage());
 			throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#receiveResponseXML");
 		}
		
		
		
	}
    
    public Vector getQuickBooksAccounts(Element accountQueryRs) {


		String accountNumber =null;
		
		String accountType =null;
		
		String accountBalance =null;
		
		String accountDesc =null;
		
		String timeModified =null;		
		
		String timeCreated =null;
		
		
		String fullName =null;
		
		String listId =null;
		
		String isActive =null;
		
		Date quickBooksDate ;
		
    	
    	
    	Vector quickBooksAccounts = new Vector();
		
		
		
		try { 
			System.out.println("Received response  ....");
			//String requestID = accountQueryRs.getAttributeValue("requestID");
			//System.out.println("RequestID: "+ requestID);
    	
			Iterator accountRetList = accountQueryRs.getChildren("AccountRet").iterator();
			while (accountRetList.hasNext()) {
				
				
				Element accountRet1 = (Element)accountRetList.next();
				AccountRet account = new AccountRet();
				
				accountNumber = accountRet1.getChildText("AccountNumber");
				if(accountNumber!=null) account.setAccountNumber(accountNumber);
				else  account.setAccountNumber("");
				
				accountType = accountRet1.getChildText("AccountType");
				if(accountType!=null) account.setAccountType(accountType);
				else  account.setAccountType("");
				
				accountBalance = accountRet1.getChildText("Balance");
				if(accountBalance!=null) account.setBalance(accountBalance);
				else  account.setBalance("");
				
				accountDesc = accountRet1.getChildText("Desc");
				if(accountDesc!=null) account.setDesc(accountDesc);
				else  account.setDesc("");
				
				
				String datetime = accountRet1.getChildText("TimeModified").substring(0,19);				
				quickBooksDate = (Date)formatter.parse(datetime);
				account.setTimeModified(quickBooksDate);
				
				
				
				fullName = accountRet1.getChildText("FullName");
				if(fullName!=null) account.setFullName(fullName);
				else  account.setFullName("");
				
				
				listId = accountRet1.getChildText("ListID");
				if(listId!=null) account.setListId(listId);	
				else  account.setListId("");			
				
				
				isActive = accountRet1.getChildText("IsActive");
				if (isActive.equals("true")){
					account.setIsInActive("0");
				} else {
	   					account.setIsInActive("1");
				}
								
				//account.setSublevel(accountRet1.getChildText("Sublevel"));
				
				//account.setName(accountRet1.getChildText("Name"));
				//account.setTotalBalance(accountRet1.getChildText("TotalBalance"));
				System.out.println("Account: " + account.toString());
				quickBooksAccounts.add(account);
			}
		}catch(Exception e){
			System.out.println("Exception at getQuickBooks Accounts "+e.getMessage());
		}
		return quickBooksAccounts;
    }
   
		public Vector getQuickBaseAccounts() {

			HashMap hashmap1 = null;//new  HashMap();
    	Vector quickBaseAccounts = null;
    	Vector accountRetAccounts = new Vector();
    	AccountRet account = null;
    	String quickBooksDateModifiedInQuickBase ="";
    	try {

    		
			quickBaseAccounts = qdb13.doQuery(accountsTableId, "{8.EX.'"+clientId+"'}", "3.7.10.20.24.6.26.28", "3", s4);
			
			for(int j = 0; j <= quickBaseAccounts.size() - 1; j++)
			   {
				    hashmap1 = (HashMap)quickBaseAccounts.elementAt(j);
				    Iterator iterator = hashmap1.values().iterator();
				    account = new AccountRet();
	           		while (iterator.hasNext()) 
	           		{   
						account.setListId(((String)iterator.next()).trim());
	           			account.setQuickBasePrimaryKey(((String)iterator.next()).trim());
	           			account.setIsInActive(((String)iterator.next()).trim());
	           			account.setDesc(((String)iterator.next()).trim());
	           			account.setAccountType(((String)iterator.next()).trim());
	           			account.setFullName(((String)iterator.next()).trim());
	           			account.setAccountNumber(((String)iterator.next()).trim());
	           			quickBooksDateModifiedInQuickBase = (String)iterator.next();
	           			
	           			System.out.println(" quickBooksDateModifiedInQuickBase "+quickBooksDateModifiedInQuickBase);
	           			if((quickBooksDateModifiedInQuickBase!=null) && (!quickBooksDateModifiedInQuickBase.equals(""))){
	           				account.setTimeModified(new Date(Long.parseLong(quickBooksDateModifiedInQuickBase)));
	           			}else if(quickBooksDateModifiedInQuickBase==null){
	           				account.setTimeModified(null);	           				
	           			}
	           			
           		}
	           		
	           		accountRetAccounts.add(account);
			   }
    	} catch (QuickBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   		return accountRetAccounts;
    	
    }
     
    }
    