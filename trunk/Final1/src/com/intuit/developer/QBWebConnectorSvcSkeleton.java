


/**
 * QBWebConnectorSvcSkeleton.java
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import org.jdom.Element;
import org.jdom.input.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.bke2.util.Lookup;
import com.intuit.quickbase.util.QuickBaseClient;
import com.intuit.quickbase.util.QuickBaseException;

    import javax.xml.parsers.*;
import javax.xml.xpath.*;
    /**
     *  QBWebConnectorSvcSkeleton java skeleton for the axisService
     */
    public class QBWebConnectorSvcSkeleton{
        String login = null;
        String password = null;
        String companyname = "7";
        String isSecondCall = null;
        String strURL = "https://docorganiz.quickbase.com/db/";
        String s4 = "sortorder-AD";
		String accountsTableId = "bes8a4tgv";
		String vendorTableId ="bes8a4tgu";
        
         
        /**
         * Auto generated method signature
         * 
         * @param sendRequestXML
         */
        
    	public com.intuit.developer.SendRequestXMLResponse sendRequestXML
    	(
    			com.intuit.developer.SendRequestXML sendRequestXML
    	)
    	{
    		
    		SendRequestXMLResponse response = new SendRequestXMLResponse();
    		String inXML;
    		String clientId = null;
    		Lookup lookup = new Lookup();
    		String token = sendRequestXML.getTicket();
    		String secondQuery = null;
    	
    		System.out.println("Token inside of sendRequest" + token);
     		
            String fileName = String.valueOf("QUERY"+token+".txt");
            String fileQueryStateName = String.valueOf("STATE"+token+".txt");
            try{
            	
            	String finalFileName = "/usr/local/"+fileName;
            	String finalQueryStateFileName = "/usr/local/"+fileQueryStateName;
            	File fileWithTokenName = new File(finalFileName);
            	File fileWithStateTokenName = new File(finalQueryStateFileName);
            	String userNamePassword = getContents(fileWithTokenName);
            	secondQuery = getContents(fileWithStateTokenName);
            	System.out.println("SecondQuery Value when parsing for clientID: "+ secondQuery);
            	if (secondQuery.startsWith("yes")){
            		int clientIDMark = secondQuery.indexOf("#");
            		clientId = secondQuery.substring(clientIDMark+1);
            		System.out.println("CLLIENT ID: "+ clientId);
            	}
            	System.out.println("usernamePassword"+ userNamePassword);
            	System.out.println("Query State: "+ secondQuery);
            	int endOfLoginID = userNamePassword.indexOf("p=");         	
            	this.login = userNamePassword.substring(2, endOfLoginID);                  	
            	this.password = userNamePassword.substring(endOfLoginID+2);
            	//init(login, password);
     		
            } catch (Exception ex){
            	System.out.println("X Error creating username/password file: "+ ex.getMessage());
            }
    		
    		if (secondQuery.trim().equals("no")) {
    			System.out.println("Running the first query ......");
    			inXML ="<?xml version=\"1.0\" ?>" +
        		"<!DOCTYPE QBXML PUBLIC '-//INTUIT//DTD QBXML QBD 1.0//EN' >" +
        		"<QBXML>" +
        		"<QBXMLMsgsRq onError = \"continueOnError\">" +
        		"<CompanyQueryRq requestID = \"2\">" +
        		"</CompanyQueryRq>" +
        		"</QBXMLMsgsRq></QBXML>";
    			
    			
    			
    		} else {
    			System.out.println("Running the second query ......");
    			inXML ="<?xml version=\"1.0\"?>"+ 
    			"<?qbxml version=\"3.0\"?>"+
    		    "<QBXML>"+
    		    "<QBXMLMsgsRq onError=\"stopOnError\" >"+ lookup.exportBills(login,password,clientId)+  
    		    "</QBXMLMsgsRq>"+
    		    "</QBXML>";
    		
    		}
    		 
    		System.out.println("Final XML STRING: "+ inXML);
    		response.setSendRequestXMLResult(inXML);
    		
    		return response;
    	}
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param connectionError
         */
        
         public com.intuit.developer.ConnectionErrorResponse connectionError(
                  com.intuit.developer.ConnectionError connectionError
                  )
            {
                ConnectionErrorResponse response = new ConnectionErrorResponse();
                try {
                	response.setConnectionErrorResult("Error in Web Service");
                //TODO : fill this with the necessary business logic
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
        
                 public com.intuit.developer.CloseConnectionResponse closeConnection
             	(
             			com.intuit.developer.CloseConnection closeConnection
             	)

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
        
                 public com.intuit.developer.GetLastErrorResponse getLastError
             	(
             			com.intuit.developer.GetLastError getLastError
             	)
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
        
                 public com.intuit.developer.AuthenticateResponse authenticate
             	(
             			com.intuit.developer.Authenticate authenticate
             	)
             	{
             		AuthenticateResponse response = new AuthenticateResponse();
             	    Lookup lookup = new Lookup();
             	    
             		try{
             			System.out.println("In authenticate method ....");
             			String[] asRtn = new String[2];
             			//asRtn[0] = "{F5FCCBC3-AA13-4d28-9DBF-3E571823F2BB}"; //myGUID.toString();
             			String token = String.valueOf(System.currentTimeMillis());
             			asRtn[0] = token;
                        String fileName = String.valueOf("QUERY"+token+".txt");
                        String queryCountFileName = String.valueOf("STATE"+token+".txt");
             			System.out.println("UserName: " + authenticate.getStrUserName());
             			System.out.println("Password: " + authenticate.getStrPassword());
             			this.login = authenticate.getStrUserName();
             			this.password = authenticate.getStrPassword();
             			
             			boolean isAuthenticated=true;
             		    isAuthenticated = lookup.isAuthenticated(login,password);
             			
             			//isAuthenticated = true;
             			System.out.println("Is Authenticated: "+ isAuthenticated);
             			//Checks for authentication and sends a result back to QBWC
             			if(isAuthenticated)
             				{asRtn[1] = "";} 
             			else
             				{asRtn[1] = "NVU";}
             			ArrayOfString asRtn2 = new ArrayOfString();
             			asRtn2.setString(asRtn);
             			String finalFileName = "/usr/local/"+fileName;
             			String finalFileQueryStateName = "/usr/local/"+queryCountFileName; 
              			System.out.println("FILENAME WE ARE USING IN for Pasword file: "+ finalFileName);
              			System.out.println("FILENAME WE ARE USING IN for query state file: "+ finalFileQueryStateName);
                        File fileWithTokenName = new File(finalFileName);
                        File fileWithQueryStateName = new File(finalFileQueryStateName); 
                        boolean isFileCreated = fileWithTokenName.createNewFile();
                        boolean isQueryStateFileCreated = fileWithQueryStateName.createNewFile();

                        if (isFileCreated) {
                        	System.out.println("Password File Created... ");
                        	System.out.println("Writing contents for username/password: ");
                            setContents(fileWithTokenName, "u="+login+"p="+password);
                        }
                        else {
                        	System.out.println("Could not create password file... ");
                        }
                        if (isQueryStateFileCreated){
                        	System.out.println("QueryState File Created... ");
                        	System.out.println("Writing contents for querystatefile: ");
                        	setContents(fileWithQueryStateName,"no");
                        } 
                        else {
                        	System.out.println("Could not create query state file...");
                        }
             			response.setAuthenticateResult(asRtn2);
             			System.out.println("Leaving authenticate method ....");
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
        
             	public com.intuit.developer.ReceiveResponseXMLResponse receiveResponseXML
            	(
            			com.intuit.developer.ReceiveResponseXML receiveResponseXML
            	)
            	{
             		Element companyQueryRs = null;
            		String clientId = null;
            		
            		ReceiveResponseXMLResponse response = new ReceiveResponseXMLResponse();
            		String token = receiveResponseXML.getTicket();
            		String secondQuery = null;
            		String fileName = String.valueOf("QUERY"+token+".txt");
            		String finalFileName = "/usr/local/"+fileName;
                	File fileWithTokenName = new File(finalFileName);
                	String userNamePassword = getContents(fileWithTokenName);
                	System.out.println("usernamePassword"+ userNamePassword);
                	int endOfLoginID = userNamePassword.indexOf("p=");         	
                	this.login = userNamePassword.substring(2, endOfLoginID);                  	
                	this.password = userNamePassword.substring(endOfLoginID+2);
            		File fileWithQueryStateName = null;
                    String queryCountFileName = String.valueOf("STATE"+token+".txt");
         			String finalFileQueryStateName = "/usr/local/"+queryCountFileName; 
                    try{
                    	fileWithQueryStateName = new File(finalFileQueryStateName);
                    	secondQuery = getContents(fileWithQueryStateName);
                    	System.out.println("Value of second query inside of receiveResponseXML: " + secondQuery);
                    } catch (Exception ex){
                    	System.out.println("Y Error creating username/password file: "+ ex.getMessage());
                    }
            		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            		DocumentBuilder builder = null;
            		try {
            			builder = factory.newDocumentBuilder();
            		} catch (ParserConfigurationException e) {
            			e.printStackTrace();
            		}
            		try {
            			System.out.println("Received response  ....");
            			String response1 = receiveResponseXML.getResponse();
            			System.out.println(response1);
            			if (secondQuery.trim().startsWith("no")){
            				org.jdom.Document document = null;
            				SAXBuilder builder1 = new SAXBuilder();

            				document = builder1.build(new InputSource(new StringReader(response1)));
            				Element qbxml = document.getRootElement();
            				Element qbxmlrs = (Element)qbxml.getChild("QBXMLMsgsRs");
            				companyQueryRs = (Element)qbxmlrs.getChild("CompanyQueryRs");
            				clientId = getCompanyName(companyQueryRs, this.login, this.password);
            				System.out.println("Setting contents of state file with clientId: " + clientId);
            				setContents(fileWithQueryStateName,"yes#"+clientId);
            				System.out.println("Setting response result to 50%");
            				response.setReceiveResponseXMLResult(50);
            			} 
            			else {
            		    	response.setReceiveResponseXMLResult(100);
            		    	System.out.println("Setting response result to 100%");
            		    	System.out.println("Deleting token files ....");
            		    	boolean success = fileWithTokenName.delete();
            		    	if (!success)
            		    	      throw new IllegalArgumentException("Delete: deletion failed");
            		    	boolean success1 = fileWithQueryStateName.delete();
            		    	if (!success1)
            		    	      throw new IllegalArgumentException("Delete: deletion failed");
            		    }
            		} catch (Exception ex){
            			throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#receiveResponseXML");
            		}
            		return response;
            	}
             	
             	
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
             	
             	public String getCompanyName(Element companyQueryRs, String login, String password){
             	   String companyName = null;
             	   String clientId = null;
             	   String clientTableId = "bes8a4tgn";
             	   Vector quickBaseCompanys = null;
             	   HashMap hashmap1 = null;//new  HashMap();
             	   try {
             			Iterator companyRetList = companyQueryRs.getChildren("CompanyRet").iterator();
             			while (companyRetList.hasNext()) {
             				Element companyRet = (Element)companyRetList.next();

             				companyName = companyRet.getChildText("CompanyName");
             				System.out.println("ZZZZZZZZZZZZZZZZZZZXXXXXXXXXXXXXXXXXX COMPANYNAME:" + companyName);
             			}
             	   } catch (Exception ex){
             		   System.out.println("Exception at getCompanyName method "+ex.getMessage());
             	   }
             	   try{
             		   QuickBaseClient qdb13 = new QuickBaseClient(login.trim() ,password.trim(), strURL);
             		   System.out.println("Login ID:" + this.login.trim());
             		   System.out.println("Password: "+ this.password.trim());
             		   System.out.println("STRURL: "+ strURL);
             		   //quickBaseCompanys=qdb13.doQuery(accountsTableId, "{.EX.'"+companyName+"'}", "8", "3", s4);
             		   quickBaseCompanys=qdb13.doQuery(clientTableId, "{6.EX.'"+companyName+"'}", "3", "3", s4);
             		   for(int j = 0; j <= quickBaseCompanys.size() - 1; j++)
             		   {
             			    hashmap1 = (HashMap)quickBaseCompanys.elementAt(j);
             			    Iterator iterator = hashmap1.values().iterator();
                        		while (iterator.hasNext())
                        		{
             					clientId = (String)iterator.next();
             					System.out.println("XXXXXXXXX"+ clientId);
                        		}
             		   }

             	   } catch (QuickBaseException e) {
             		   // TODO Auto-generated catch block
             		   System.out.println("Error retrieving clientID from QuickBase");
             		   e.printStackTrace();
             	   } catch (Exception e) {
             		   // TODO Auto-generated catch block
             		   e.printStackTrace();
             	   }

             	   return clientId;
                }

    }
    