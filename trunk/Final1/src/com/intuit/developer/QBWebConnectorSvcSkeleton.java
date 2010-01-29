


/**
 * QBWebConnectorSvcSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
    package com.intuit.developer;
    import java.io.IOException;
import java.io.StringReader;

import org.w3c.dom.*;
    import org.xml.sax.InputSource;
    import org.xml.sax.SAXException;

import com.bke2.util.Lookup;

    import javax.xml.parsers.*;
import javax.xml.xpath.*;
    /**
     *  QBWebConnectorSvcSkeleton java skeleton for the axisService
     */
    public class QBWebConnectorSvcSkeleton{
        
         
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
    		/*
    		inXML ="<?xml version=\"1.0\" ?>" +
    		"<!DOCTYPE QBXML PUBLIC '-//INTUIT//DTD QBXML QBD 1.0//EN' >" +
    		"<QBXML>" +
    		"<QBXMLMsgsRq onError = \"continueOnError\">" +
    		
    		"<BillQueryRq requestID = \"1\">" +
    		"</BillQueryRq>" +
    		"</QBXMLMsgsRq></QBXML>";
    */
    		
    		inXML ="<?xml version=\"1.0\"?>"+ 
    		"<?qbxml version=\"3.0\"?>"+
    		    "<QBXML>"+
    		        "<QBXMLMsgsRq onError=\"stopOnError\" >"+ lookup.exportBills()+   
    		        "</QBXMLMsgsRq>"+
    		    "</QBXML>";
    		 
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
             	    String login;
             	    String password;

             		try{
             			System.out.println("In authenticate method ....");
             			String[] asRtn = new String[2];
             			asRtn[0] = "{F5FCCBC3-AA13-4d28-9DBF-3E571823F2BB}"; //myGUID.toString();
             			//System.out.println("UserName: " + authenticate.getStrUserName());
             			//System.out.println("Password: " + authenticate.getStrPassword());
             			login = authenticate.getStrUserName();
             			password = authenticate.getStrPassword();
             			
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
             			response.setAuthenticateResult(asRtn2);
             		
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
            		ReceiveResponseXMLResponse response = new ReceiveResponseXMLResponse();
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
            			Document document = null;
            			try {
            				document = builder.parse(new InputSource(new StringReader(response1)));
            			} catch (SAXException e) {
            				e.printStackTrace();
            			} catch (IOException e) {
            				e.printStackTrace();
            			}
            			System.out.println("ABOUT TO PRINT OUT DOCUMENT XXXXXXXXXXXXXXXXXXXX");
            			XPathFactory factory1 = XPathFactory.newInstance();
            		    XPath xpath = factory1.newXPath();
            		    XPathExpression expr = xpath.compile("//AccountRet/FullName/text()");
            		    Object result = expr.evaluate(document, XPathConstants.NODESET);
            		    NodeList nodes = (NodeList) result;
            		    for (int i = 0; i < nodes.getLength(); i++) {
            		    	System.out.println("Company Names: "+ nodes.item(i).getNodeValue()+"\n");
            		    }
            		    XPath xpath1 = factory1.newXPath();
            		    XPathExpression expr1 = xpath1.compile("//AccountRet/AccountNumber/text()");
            		    Object result1 = expr1.evaluate(document, XPathConstants.NODESET);
            		    NodeList nodes1 = (NodeList) result1;
            		    for (int i = 0; i < nodes1.getLength(); i++) {
            		    	System.out.println("Account Number:  "+ nodes1.item(i).getNodeValue()+"\n");
            		    }
            			response.setReceiveResponseXMLResult(-3);
            		} catch (Exception ex){
            			throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#receiveResponseXML");
            		}
            		return response;
            	}
     
    }
    