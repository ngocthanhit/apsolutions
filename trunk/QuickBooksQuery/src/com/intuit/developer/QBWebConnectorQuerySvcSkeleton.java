 
/**
 * QBWebConnectorQuerySvcSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
package com.intuit.developer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import org.jdom.Element;
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
 		 
 		 
  		 //String clientId = "7";
 		 String strURL = "https://docorganiz.quickbase.com/db/";
		 String s4 = "sortorder-AD";
		 String accountsTableId = "bes8a4tgv";
		 String vendorTableId ="bes8a4tgu";
		
		 QuickBaseClient qdb13 = null;	
		 Lookup lookup = new Lookup();
		 //ServletContext context
 		// lookup = (Lookup)getServletContext().getAttribute("lookup");
 		 //Context initial = new InitialContext();
 		 //Context environment =
 		//(Context)initial.lookup("java:comp/env");

        /**
         * Auto generated method signature
         * 
         * @param sendRequestXML
         */
        
    	public com.intuit.developer.SendRequestXMLResponse sendRequestXML(com.intuit.developer.SendRequestXML sendRequestXML)
    	{
    		SendRequestXMLResponse response = new SendRequestXMLResponse();
    	   
    		String inXML;
    		
    		inXML ="<?xml version=\"1.0\" ?>" +
    		"<!DOCTYPE QBXML PUBLIC '-//INTUIT//DTD QBXML QBD 1.0//EN' >" +
    		"<QBXML>" +
    		"<QBXMLMsgsRq onError = \"continueOnError\">" +
    		"<CompanyQueryRq requestID = \"2\">" +
    		"</CompanyQueryRq>" +
    		"<VendorQueryRq requestID = \"2\">" +
    		"</VendorQueryRq>" +
    		"<AccountQueryRq requestID = \"1\">" +
    		"</AccountQueryRq>" +
    		"</QBXMLMsgsRq></QBXML>";
    		//System.out.println("Final XML STRING: "+ inXML);
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

              		try{
              			String[] asRtn = new String[2];
              		//asRtn[0] = "{F5FCCBC3-AA13-4e28-9DBE-3E571823F2BB}"; //myGUID.toString();
                       
                        String token = String.valueOf(System.currentTimeMillis());

                        String fileName = String.valueOf("QUERY"+token+".txt");
              			
                        asRtn[0] = token; //myGUID.toString();
                        
                       
                  
              			
              			loginID = authenticate.getStrUserName();
              			passWord = authenticate.getStrPassword();
              			
              			
              			
              			

              		    System.out.println("UserName: " + authenticate.getStrUserName());
              			System.out.println("Password: " + authenticate.getStrPassword());
              			boolean isAuthenticated;           			
              		    isAuthenticated = lookup.isAuthenticated(loginID,passWord);
              			System.out.println("Is Authenticated: "+ isAuthenticated);
              			//Checks for authentication and sends a result back to QBWC
              			if(isAuthenticated) {
              				{asRtn[1] = "";}
              				init(loginID,passWord);
              			} 
              			else {
              				{asRtn[1] = "NVU";}
              			}
              			ArrayOfString asRtn2 = new ArrayOfString();
              			asRtn2.setString(asRtn);
              			String finalFileName = new File(".").getCanonicalPath()+"\\"+ fileName;
              			//System.out.println("FILENAME WE ARE USING IN AUTHENTICATE: "+ finalFileName);
                        File fileWithTokenName = new File(finalFileName);
                        boolean isFileCreated = fileWithTokenName.createNewFile();

                        if (isFileCreated) {
                        	System.out.println("File Created ");
                        }
                        else {
                        	System.out.println("Could not create file ");
                        }
                        System.out.println("Writting contents: ");      
              			setContents(fileWithTokenName, "u="+loginID+"p="+passWord);
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
             		
             		String token = receiveResponseXML.getTicket();
             		
                    String fileName = String.valueOf("QUERY"+token+".txt");
                    try{
                    	String finalFileName = new File(".").getCanonicalPath()+"\\"+fileName;             	
                    	File fileWithTokenName = new File(finalFileName);
                    	String userNamePassword = getContents(fileWithTokenName);
                    	int endOfLoginID = userNamePassword.indexOf("p=");         	
                    	this.loginID = userNamePassword.substring(2, endOfLoginID);                  	
                    	this.passWord = userNamePassword.substring(endOfLoginID+2);
                    	init(loginID, passWord);
             		
                    } catch (Exception ex){
                    	System.out.println("Error creating username/password file: "+ ex.getMessage());
                    }
             		
            		Element accountQueryRs = null;
            		Element vendorQueryRs = null;
            		Element companyQueryRs = null;
            		String clientId = null;
            		
            		String localTicket = receiveResponseXML.getTicket();
            		
            		try { 
            			System.out.println("Received response  ....");
            			String response1 = receiveResponseXML.getResponse();
            			System.out.println(response1);
            			org.jdom.Document document = null;
            			SAXBuilder builder1 = new SAXBuilder();
             		
            			document = builder1.build(new InputSource(new StringReader(response1)));
            			Element qbxml = document.getRootElement();
            			Element qbxmlrs = (Element)qbxml.getChild("QBXMLMsgsRs");
            			//accountQueryRs = (Element)qbxmlrs.getChild("AccountQueryRs");
            			vendorQueryRs = (Element)qbxmlrs.getChild("VendorQueryRs");
            			companyQueryRs = (Element)qbxmlrs.getChild("CompanyQueryRs");
           
					}catch(Exception e1){
						System.out.println("Exception at receiveResponseXML with DOM parsing "+e1.getMessage());
					}
					
               		/*	*********************************************/
               		/* 				Get QuickBooks Data             */
               		/************************************************/			
               		
					Vector quickBooksAccounts=null;
					Vector quickBooksVendors=null;
					//quickBooksAccounts = getQuickBooksAccounts(accountQueryRs);
					quickBooksVendors = getQuickBooksVendors(vendorQueryRs);
					clientId = getCompanyName(companyQueryRs);
					System.out.println("ClientId: "+ clientId);
               		
               		// First check if there are any records at all 
             		//Vector quickBaseAccounts = getQuickBaseAccounts(clientId);
             		Vector quickBaseVendors = getQuickBaseVendors(clientId);
             		
             		//System.out.println("Total Number of quickBase Accounts>>>>>: " + quickBaseAccounts.size() );
             		//System.out.println("Total Number of quickBooks Accounts>>>>: " + quickBooksAccounts.size() );
             		
             		System.out.println("Total Number of QuickBase Vendors>>>>>: " + quickBaseVendors.size() );
             		System.out.println("Total Number of QuickBooks Vendors>>>>: " + quickBooksVendors.size() );
             		
             		//syncAccountsInQuickBase(quickBooksAccounts,quickBaseAccounts,clientId);
             		syncVendorsInQuickBase(quickBooksVendors,quickBaseVendors, clientId);

          		    System.out.println("DONE PROCESSING RECORDS XXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
          		   
             		response.setReceiveResponseXMLResult(100);
             		return response;
             	}

	@SuppressWarnings("unchecked")
	public void syncAccountsInQuickBase(Vector quickBooksAccounts, Vector quickBaseAccounts, String clientId){
		System.out.println("VALUE OF LOGINID: "+ this.loginID);
 		System.out.println("VALUE OF PASSWORD: "+ this.passWord);
		HashMap infoHash2 =null;
		HashMap infoHash3 =null;
		HashMap infoHash4 =null;

		String primaryKey1 ="";
		
   		/************************************************/
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
   				    booksAccount = (AccountRet)quickBooksAccounts.get(j);
   				    //if (((AccountRet)quickBaseAccounts.get(i)).getFullName().equals(((AccountRet)quickBooksAccounts.get(j)).getFullName())) {
   				    if((baseAccount.getFullName().equals(booksAccount.getFullName()))||(baseAccount.getListId().equals(booksAccount.getListId())) ) {
   					//System.out.println("QuickBase Account is: >>>"+baseAccount);
   					//System.out.println("QuickBooks Account is: >>>"+booksAccount);
  					 
   					   tempQuickBooksAccount.remove(j);
					   tempQuickBaseAccount.remove(i);
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
   					   		    this.qdb13 = new QuickBaseClient(loginID.trim() ,passWord.trim(), strURL);
   					   			primaryKey1 = qdb13.editRecord(accountsTableId, infoHash3, baseAccount.getQuickBasePrimaryKey() );
   					   			System.out.println("Updating Primary key"+ baseAccount.getQuickBasePrimaryKey());
   					   			System.out.println("Successfully updated a QuickBase Account Record: "+ infoHash3);
   					   			//System.out.println("Base ACCT: "+ baseAccount);
   					   			//System.out.println("Book ACCT: "+ booksAccount);
 					   
   				   			}catch(Exception e2){
   				   				System.out.println("Problem while editing "+ infoHash3 + "\nwith PK "+baseAccount.getQuickBasePrimaryKey());
   				   				System.out.println("Exception while editing an Account record in Quickbase: "+e2.getMessage());
   				   			}
   					   }
					   infoHash3=null;
					   break;	   
   				   }
   			   } // end books for
   		   } //end base for
   		   // For add records
   		
   		   System.out.println("DELETE ACCOUNT VECTOR SIZE"+tempQuickBaseAccount.size());
   		   
   		   for (int k = 0; k <= tempQuickBaseAccount.size()-1; k++) {
   			   infoHash4=new HashMap();
   			   AccountRet deleteQuickBaseAccount = ((AccountRet)tempQuickBaseAccount.get(k));
   			   //System.out.println("Value of IsInActive: "+ deleteQuickBaseAccount.getIsInActive());
   			   if(deleteQuickBaseAccount.getIsInActive().equals("0")){
			       infoHash4.put("24", "1");
			       if (qdb13 == null){
			    	   System.out.println("QB Client is null");
			       }
			       this.qdb13 = new QuickBaseClient(loginID.trim() ,passWord.trim(), strURL);
			       primaryKey1 = qdb13.editRecord(accountsTableId, infoHash4, deleteQuickBaseAccount.getQuickBasePrimaryKey() );               				   
			       System.out.println("SUCCESSFULLY DELETED a Base Record with Primary key: "+deleteQuickBaseAccount.getQuickBasePrimaryKey());
   			}
   		}
   		   
   		   System.out.println("INSERT ACCOUNT VECTOR SIZE >>: " + tempQuickBooksAccount.size());

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
			   this.qdb13 = new QuickBaseClient(loginID.trim() ,passWord.trim(), strURL);
        	   primaryKey1 = this.qdb13.addRecord(accountsTableId, infoHash2);
        	   System.out.println ("Insert response"+primaryKey1+"\n infoHash2 "+infoHash2);
   		   }
 		   System.out.println("DONE SYNCing RECORDS XXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
 		} catch (Exception ex){
 			ex.printStackTrace();
 			System.out.println("Message: "+ ex.getMessage());
 			throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#receiveResponseXML");
 		}
	}

    /*
     * 
     * syncVendorsInQuickBase
     *
     * */
	
	@SuppressWarnings("unchecked")
	public void syncVendorsInQuickBase(Vector quickBooksVendors, Vector quickBaseVendors, String clientId){
		
		HashMap infoHash2 =null;
		HashMap infoHash3 =null;
		HashMap infoHash4 =null;

		String primaryKey1 ="";
		
   		/*	*********************************************/
   		/* 				Get QuickBase Data              */
   		/************************************************/		

   		Vector tempQuickBooksVendor = quickBooksVendors;
   		Vector tempQuickBaseVendor = quickBaseVendors;
   		VendorRet baseVendor = null;
   		VendorRet booksVendor = null;
   		
   		try{
		for (int i = 0; i <= quickBaseVendors.size()-1; i++) {
			baseVendor = (VendorRet)quickBaseVendors.get(i);
   			for (int j = 0;  j<= quickBooksVendors.size()-1; j++) {
   				booksVendor = (VendorRet)quickBooksVendors.get(j);
   				//if( (baseVendor.getName().equals(booksVendor.getName()))||(baseVendor.getListID().equals(booksVendor.getListID())) ) {
   				if(baseVendor.getName().equals(booksVendor.getName())) {
   		   					
   					System.out.println(">>>>>>>>>>> PROCESSING NEW VENDOR WHERE THE NAMES ARE EQUAL >>>>>>>>>>>");
   					System.out.println("\n\nBase is >>>"+baseVendor);
   					System.out.println("Book is >>>"+booksVendor);
  					 
   					tempQuickBooksVendor.remove(j);
   					tempQuickBaseVendor.remove(i);
   					infoHash3=new HashMap();
   					   
   				
   					if(!baseVendor.getCompanyName().equals(booksVendor.getCompanyName())) {
   					   infoHash3.put("11",  booksVendor.getCompanyName());
   					}

   					if(!baseVendor.getCreditLimit().equals(booksVendor.getCreditLimit())){
   	   				    infoHash3.put("25",  booksVendor.getCreditLimit());
   					}else{
   						System.out.println("baseVendor.getCreditLimit() >>>"+baseVendor.getCreditLimit()+"baseVendor.getCreditLimit() >>>"+baseVendor.getCreditLimit());
   					}
   					if(!baseVendor.getName().equals(booksVendor.getName())) {
    				   infoHash3.put("7",  booksVendor.getName());
   					}
   					if(!baseVendor.getType().equals(booksVendor.getType())) {
    				   infoHash3.put("21",  booksVendor.getType());
   					}
   					if(!baseVendor.getTermsRef().equals(booksVendor.getTermsRef())) {
   					   infoHash3.put("8", booksVendor.getTermsRef());
   					}
   					if(!baseVendor.getAccountNumber().equals(booksVendor.getAccountNumber())) {
   					   infoHash3.put("14", booksVendor.getAccountNumber());
   					} 
   					if(!baseVendor.getListID().equals(booksVendor.getListID())) {
    				   infoHash3.put("38", booksVendor.getListID());
   					}
   					if(!baseVendor.getIsInActive().equals(booksVendor.getIsInActive())) {
   					   infoHash3.put("26", booksVendor.getIsInActive()); // the vendor is inActive = 0 (active)
   					}
   					if( (booksVendor.getTimeModified()!=null)&&(baseVendor.getTimeModified()!=null)){
   						if(! (baseVendor.getTimeModified().equals(booksVendor.getTimeModified())) ){
   							   infoHash3.put("36", booksVendor.getTimeModified());
   						}
   					}else if( (booksVendor.getTimeModified()!=null)&&(baseVendor.getTimeModified()==null)){
   						   infoHash3.put("36", booksVendor.getTimeModified());
   					}
   					if(!infoHash3.isEmpty()){
   					   	try{
   					   	    this.qdb13 = new QuickBaseClient(loginID.trim() ,passWord.trim(), strURL);
   					   		primaryKey1 = qdb13.editRecord(vendorTableId, infoHash3, baseVendor.getQuickBasePrimaryKey() );
   					   		System.out.println("Updating primary key"+ baseVendor.getQuickBasePrimaryKey());
   					   		System.out.println("Successfully UPDATEd a Base Record Primary key we are using: "+ infoHash3);
   					   		System.out.println("Updating Base Vendor: "+ baseVendor);
   					   		//System.out.println("Book Vendor: "+ booksVendor);
 					   
   				   			}catch(Exception e2){
   				   				System.out.println("Problem while editing "+ infoHash3 + "\nwith PK "+baseVendor.getQuickBasePrimaryKey());
   				   				System.out.println("Exception at Edit Record Accounts "+e2.getMessage());
   				   			}
   					   }else{
   						   System.out.println("NOTHING TO UPDATE : "+baseVendor.getQuickBasePrimaryKey());
   					   }
					   infoHash3=null;
					   break;	   
   				   }
   			   } // end books for
   		   } //end base for
   		   // For add records
   		
   		   System.out.println("DELETE VECTOR SIZE"+tempQuickBaseVendor.size());
   		for (int k = 0; k <= tempQuickBaseVendor.size()-1; k++) {
   			infoHash4=new HashMap();
   			VendorRet deleteQuickBaseVendor = ((VendorRet)tempQuickBaseVendor.get(k));
   			System.out.println("$$$$$$$$$$$$$$$ Value of IsActive: "+ deleteQuickBaseVendor.getIsInActive());
   			if(deleteQuickBaseVendor.getIsInActive().equals("0")){
			       infoHash4.put("26", "1");
			       this.qdb13 = new QuickBaseClient(loginID.trim() ,passWord.trim(), strURL);
			       primaryKey1 = qdb13.editRecord(vendorTableId, infoHash4,deleteQuickBaseVendor.getQuickBasePrimaryKey() );               				   
			       System.out.println("Set base record to IsInActive to true for a Base Record with Primary key: "+deleteQuickBaseVendor.getQuickBasePrimaryKey());
   			}else{
   				System.out.println("NOTHING TO DELETE"); 
   			}
   		}
   		   System.out.println("INSERT VECTOR SIZE >>: " + tempQuickBooksVendor.size());
   		    if(tempQuickBooksVendor.size()==0){
				System.out.println("NOTHING TO INSERT"); 
			}
   		   for (int l = 0; l <= tempQuickBooksVendor.size()-1; l++) {
   			   
   			       		// 7 is vendorname
				   		// 11 is company name
				   		// 14 is account no
				   		// 21 type
				   		// 26 vendorIsInactive
				   		// 3 is primary key
				   		// 8 is paymentTerms
				   		// 25 is creditLimit
				   		// 36 is quickbooksmodified date
	    		   		// 38 is listID
				    VendorRet addBooksVendor = (VendorRet)tempQuickBooksVendor.get(l);
				    System.out.println("About to insert new vendor record: "+addBooksVendor);
   			   		infoHash2=new HashMap();
   			   		infoHash2.put("12", clientId); //Hard Code ClinetID just for Add
   			   		infoHash2.put("36", addBooksVendor.getTimeModified());			   	  	
   			   		infoHash2.put("7",  addBooksVendor.getName());
   			   		infoHash2.put("11",  addBooksVendor.getCompanyName());
   			   		infoHash2.put("25", addBooksVendor.getCreditLimit());
   			   		infoHash2.put("14", addBooksVendor.getAccountNumber());
   			   		infoHash2.put("21", addBooksVendor.getType());
   			   		infoHash2.put("8", addBooksVendor.getTermsRef());
   			   		infoHash2.put("26", addBooksVendor.getIsInActive());
   			   		infoHash2.put("38", addBooksVendor.getListID()); // the account is inActive = 0 (active)
   			   		this.qdb13 = new QuickBaseClient(loginID.trim() ,passWord.trim(), strURL);
			   	  	primaryKey1 = qdb13.addRecord(vendorTableId, infoHash2);
        	        System.out.println ("SUCCESSFUL INSERT WITH PRIMARY KEY "+primaryKey1+"\n infoHash2 "+infoHash2);
   		   }
 		   System.out.println("DONE SYNCing RECORDS XXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
 		} catch (Exception ex){
 			ex.printStackTrace();
 			System.out.println("Message: "+ ex.getMessage());
 			throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#receiveResponseXML");
 		}
	}  
   public String getCompanyName(Element companyQueryRs){
	   String companyName = null;
	   String clientId = null;
	   Vector quickBaseCompanys = null;
	   HashMap hashmap1 = null;//new  HashMap();
	   try { 
			Iterator companyRetList = companyQueryRs.getChildren("CompanyRet").iterator();
			while (companyRetList.hasNext()) {
				Element companyRet = (Element)companyRetList.next();
				companyName = companyRet.getChildText("CompanyName");
			}
	   } catch (Exception ex){
		   System.out.println("Exception at getCompanyName method "+ex.getMessage());
	   }
	   try{
		   QuickBaseClient qdb13 = new QuickBaseClient(this.loginID.trim() ,this.passWord.trim(), strURL);
		   quickBaseCompanys=qdb13.doQuery(accountsTableId, "{.EX.'"+companyName+"'}", "8", "3", s4);
		   for(int j = 0; j <= quickBaseCompanys.size() - 1; j++)
		   {
			    hashmap1 = (HashMap)quickBaseCompanys.elementAt(j);
			    Iterator iterator = hashmap1.values().iterator();
           		while (iterator.hasNext()) 
           		{   
					clientId = (String)iterator.next();
           		}
		   }
		   
	   } catch (QuickBaseException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
	   } catch (Exception e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
	   }
				
	   return clientId;
   }
    
    /*
     * 
     * 
     * 
     * getQuickBooksAccounts
     * 
     * 
     * */
	
    @SuppressWarnings("unchecked")
	public Vector getQuickBooksAccounts(Element accountQueryRs) {
    	
		String accountNumber =null;	
		String accountType =null;		
		String accountBalance =null;		
		String accountDesc =null;			
		String fullName =null;	
		String listId =null;	
		String isActive =null;	
		Date quickBooksDate ;	
    	Vector quickBooksAccounts = new Vector();
		try { 
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
				//System.out.println("Account: " + account.toString());
				quickBooksAccounts.add(account);
			}
		}catch(Exception e){
			System.out.println("Exception at getQuickBooks Accounts "+e.getMessage());
		}
		return quickBooksAccounts;
    }
    
    
    /*
     * 
     * 
     * 
     * getQuickBooksVendors
     * 
     * 
     * */
    
    @SuppressWarnings("unchecked")
    
	public Vector getQuickBooksVendors(Element vendorQueryRs) {
    	
		String companyName =null;
		String accountNumber = null;
		String isActive =null;		
		String type =null;	
		String term = null;
		String listID =null;		
		String timeCreated =null;		
		String name =null;
		String creditLimit = null;	
		Date quickBooksDate;	
    	Vector quickBooksVendors = new Vector();
		try { 
			System.out.println("Received response  ....");
    	
			Iterator vendorRetList = vendorQueryRs.getChildren("VendorRet").iterator();
			
			while (vendorRetList.hasNext()) {
				
				
				Element vendorRet1 = (Element)vendorRetList.next();
				VendorRet vendor = new VendorRet();
				
				
				String datetime = vendorRet1.getChildText("TimeModified").substring(0,19);	
				System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZ  Date from quickbooks: "+ datetime);
				
				//System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXX   quickBooksDate:" + quickBooksDate);
				vendor.setTimeModified(datetime);
				
				
				accountNumber = vendorRet1.getChildText("AccountNumber");
				if(accountNumber!=null) vendor.setAccountNumber(accountNumber);
				else  vendor.setAccountNumber("");		
				
				companyName = vendorRet1.getChildText("CompanyName");
				if(companyName!=null) vendor.setCompanyName(companyName);
				else  vendor.setCompanyName("");

				Iterator vendorTypeRefList = vendorRet1.getChildren("VendorTypeRef").iterator();
				Element vendorTypeRef = null;
				while (vendorTypeRefList.hasNext()) {
					vendorTypeRef = (Element)vendorTypeRefList.next();
					type = vendorTypeRef.getChildText("FullName");
					
					if(type!=null) {
						vendor.setType(type);
					}
					else {
						vendor.setType("");
					}
				}
				
				timeCreated = vendorRet1.getChildText("TimeCreated");
				if(timeCreated!=null) {
					vendor.setTimeCreated(timeCreated);
				}
				else  {
					vendor.setTimeCreated("");	
				}
					
				name = vendorRet1.getChildText("Name");
				if(name!=null) {
					vendor.setName(name);
				}
				else  {
					vendor.setName("");
				}
							 
				Iterator vendorTermsRefList = vendorRet1.getChildren("TermsRef").iterator();
				Element vendorTermsRef = null;
				while (vendorTermsRefList.hasNext()) {
					vendorTermsRef = (Element)vendorTermsRefList.next();
					term = vendorTermsRef.getChildText("FullName");
					if(term!=null) {
						vendor.setTermsRef(term);
					}
					else {
						vendor.setTermsRef("");
					}
				}
			
				creditLimit = vendorRet1.getChildText("CreditLimit");
				if(creditLimit!=null) {
					vendor.setCreditLimit(creditLimit);
				}
				else  {
					vendor.setCreditLimit("");	
				}
				
				listID = vendorRet1.getChildText("ListID");
				if(listID!=null) {
					vendor.setListID(listID);	
				}
				else  {
					vendor.setListID("");			
				}
						
				isActive = vendorRet1.getChildText("IsActive");
				if (isActive.equals("true")){
					vendor.setIsInActive("0");
				} else {
					vendor.setIsInActive("1");
				}
				
				//System.out.println("Vendor: " + vendor.toString());
				quickBooksVendors.add(vendor);
			
			}
			
		}catch(Exception e){
			System.out.println("Exception at getQuickBooks Vendors "+e.getMessage());
		}
		return quickBooksVendors;
    }  
    
    
    
    
		@SuppressWarnings("unchecked")
		public Vector getQuickBaseAccounts(String clientId) {
			
		HashMap hashmap1 = null;//new  HashMap();
    	Vector quickBaseAccounts = null;
    	Vector accountRetAccounts = new Vector();
    	AccountRet account = null;
    	String quickBooksDateModifiedInQuickBase ="";
    	try {

    		QuickBaseClient qdb13 = new QuickBaseClient(this.loginID.trim() ,this.passWord.trim(), strURL);
			quickBaseAccounts=qdb13.doQuery(accountsTableId, "{8.EX.'"+clientId+"'}", "3.7.10.20.24.6.26.28", "3", s4);
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
	           			
	           			//System.out.println(" quickBooksDateModifiedInQuickBase "+quickBooksDateModifiedInQuickBase);
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
		@SuppressWarnings("unchecked")
		public Vector getQuickBaseVendors(String clientId){

			HashMap hashmap1 = null;//new  HashMap();
	    	Vector quickBaseVendors = null;
	    	Vector vendorRetVendors = new Vector();
	    	VendorRet vendor = null;
	    	String quickBooksDateModifiedInQuickBase ="";
	    	try {

	    		QuickBaseClient qdb13 = new QuickBaseClient(loginID.trim() ,passWord.trim(), strURL);	
	    		quickBaseVendors = qdb13.doQuery(vendorTableId, "{12.EX.'"+clientId+"'}", "7.11.14.21.26.3.8.25.36.38", "7", s4);
				// 7 is vendorname
	    		// 11 is company name
	    		// 14 is account no
	    	    // 21 type
	    		// 26 vendorIsInactive
	    		// 3 is primary key
	    		// 8 is paymentTerms
	    		// 25 is creditLimit
	    		// 36 is quickbooksmodified date
	    		// 38 is listID
				for(int j = 0; j <= quickBaseVendors.size() - 1; j++)
				   {
					    hashmap1 = (HashMap)quickBaseVendors.elementAt(j);
					    Iterator iterator = hashmap1.values().iterator();
					    vendor = new VendorRet();
		           		while (iterator.hasNext())
		           			
		           		{   
		           			/*
		           			  System.out.println("1: Type\t "+ iterator.next());
		           			  System.out.println("2: ListID\t "+ iterator.next());
		           		      System.out.println("3: Vendor ID\t "+ iterator.next());
		           			  System.out.println("4: Account Number\t "+ iterator.next());
		           			  System.out.println("5: IsInActive\t "+ iterator.next());
		           			  System.out.println("6: QuickBooksModified Date\t "+ iterator.next());
		           			  System.out.println("7: Payment Terms:\t "+ iterator.next());
		           			  System.out.println("8: Company Name\t "+ iterator.next());
		           			  System.out.println("9: Credit Limit:\t "+ iterator.next());
		           			  System.out.println("10 Vendor Name:\t "+ iterator.next());
		           			*/
		           			vendor.setType(((String)iterator.next()).trim());
		           			vendor.setListID(((String)iterator.next()).trim());
		           			vendor.setQuickBasePrimaryKey(((String)iterator.next()).trim());
		           			vendor.setAccountNumber(((String)iterator.next()).trim());
		           			vendor.setIsInActive(((String)iterator.next()).trim());
		           			quickBooksDateModifiedInQuickBase = (String)iterator.next();
		           			vendor.setTermsRef(((String)iterator.next()).trim());
		           			vendor.setCompanyName(((String)iterator.next()).trim());
		           			vendor.setCreditLimit(((String)iterator.next()).trim());
		           			vendor.setName(((String)iterator.next()).trim());
		      
		           			System.out.println("################################# quickBooksDateModifiedInQuickBase "+quickBooksDateModifiedInQuickBase);
		           			if((quickBooksDateModifiedInQuickBase!=null) && (!quickBooksDateModifiedInQuickBase.equals(""))){
		           				vendor.setTimeModified(quickBooksDateModifiedInQuickBase);
		           				System.out.println("$$$$$$$$$$$$QuickBaseDate after date conversion: "+ vendor.getTimeModified());
		           			}else if(quickBooksDateModifiedInQuickBase==null){
		           				vendor.setTimeModified(null);	           				
		           			}
		           			
	           		}
		           		
		           		vendorRetVendors.add(vendor);
				   }
	    	} catch (QuickBaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   		return vendorRetVendors;
	    	
		}
		
		static public String getContents(File aFile) {
		    //...checks on aFile are elided
		    StringBuilder contents = new StringBuilder();
		    
		    try {
		      //use buffering, reading one line at a time
		      //FileReader always assumes default encoding is OK!
		      BufferedReader input =  new BufferedReader(new FileReader(aFile));
		      try {
		        String line = null; //not declared within while loop
		        /*
		        * readLine is a bit quirky :
		        * it returns the content of a line MINUS the newline.
		        * it returns null only for the END of the stream.
		        * it returns an empty String if two newlines appear in a row.
		        */
		        while (( line = input.readLine()) != null){
		          contents.append(line);
		          contents.append(System.getProperty("line.separator"));
		        }
		      }
		      finally {
		        input.close();
		      }
		    }
		    catch (IOException ex){
		      ex.printStackTrace();
		    }
		    
		    return contents.toString();
		  }

		  /**
		  * Change the contents of text file in its entirety, overwriting any
		  * existing text.
		  *
		  * This style of implementation throws all exceptions to the caller.
		  *
		  * @param aFile is an existing file which can be written to.
		  * @throws IllegalArgumentException if param does not comply.
		  * @throws FileNotFoundException if the file does not exist.
		  * @throws IOException if problem encountered during write.
		  */
		  static public void setContents(File aFile, String aContents)
		                                 throws FileNotFoundException, IOException {
		    if (aFile == null) {
		      throw new IllegalArgumentException("File should not be null.");
		    }
		    if (!aFile.exists()) {
		      throw new FileNotFoundException ("File does not exist: " + aFile);
		    }
		    if (!aFile.isFile()) {
		      throw new IllegalArgumentException("Should not be a directory: " + aFile);
		    }
		    if (!aFile.canWrite()) {
		      throw new IllegalArgumentException("File cannot be written: " + aFile);
		    }

		    //use buffering
		    Writer output = new BufferedWriter(new FileWriter(aFile));
		    try {
		      //FileWriter always assumes default encoding is OK!
		      output.write( aContents );
		    }
		    finally {
		      output.close();
		    }
		  }
		  
		public void init(String loginID, String passWord){
			 System.out.println("Initializing Quickbaseclient.....");
			 this.qdb13 = new QuickBaseClient(loginID ,passWord, strURL);
			 System.out.println("....done initializing Quickbaseclient.....");
		}
    }
    