package com.bke2.util;

import java.text.SimpleDateFormat;
import com.intuit.quickbase.util.*;
import java.util.*;

@SuppressWarnings("unchecked")

public class Lookup
{
    private String strURL = "https://docorganiz.quickbase.com/db/";
    private String clientId = "7";  //THIS IS FOR COMPANY AA
    private String bke1ApplicationId = "bes8a4tgg";
    private String clientTableId = "bes8a4tgn";
    private String invoiceTableId="bes8a4tgq";
    private String lineItemTableId="bes8a4tgr";
    public String skipArray = "";
    private String lookupMessage;
    private String loginMessage;
    private String password;
    private String username;
    public String clientArray[];
    public String vendorArray[];
    private QuickBaseClient qdbLookup=null;

    public Lookup()
    {
    	System.out.println("In lookup constructor ...");
    }

    public boolean isLoggedIn()  throws Exception
    {
            boolean isLoggedIn = false;
            String s="";
            try
            {
                org.w3c.dom.Document ss =qdbLookup.getSchema(bke1ApplicationId);
                s = qdbLookup.getNumRecords(clientTableId);
                isLoggedIn = true;
            }
            catch(QuickBaseException quickbaseexception)
            {
                isLoggedIn = false;
                lookupMessage=quickbaseexception.getMessage();
            }
            catch(Exception ee)
            {
                isLoggedIn = false;
                lookupMessage=ee.getMessage();
            }
               return isLoggedIn;
    }

    public void setUser(String username){
        this.username=username;
    }
    
    public String getUser(){
            return username;
    }

    public void setPassword(String password){
        this.password=password;
    }
    
    public String getPassword(){
            return password;
    }

    public boolean isAuthenticated(String username,String password)
    {
        System.out.println("In Lookup.isAuthenticated() ...");
        QuickBaseClient qdbLocal = new QuickBaseClient(username, password, strURL);
        boolean isLoggedIn = false;
        String s="";
        try {
               org.w3c.dom.Document ss =qdbLocal.getSchema(bke1ApplicationId);
               isLoggedIn = true;
               setUser(username);
               setPassword(password);
        }
        catch(QuickBaseException quickbaseexception) {
               isLoggedIn = false;
        }
        catch(Exception ee){
               isLoggedIn = false;
               s=ee.getMessage();
         }
        System.out.println(" isAuthenticated ? "+isLoggedIn);
        loginMessage=s;
        return isLoggedIn;
    }

 @SuppressWarnings({ "unchecked", "unchecked" })
public String exportBills(String username, String password, String clientId1) {
	    
	    String billCriteria ="{'90'.EX.'"+clientId1+"'}AND{'27'.EX.'Accept'}";
	    System.out.println("Username inside of Lookup.exportBills(): "+  username);
	    System.out.println("Password inside of Lookup.exportBills(): "+  password);
	    System.out.println("Client id inside of Lookup.exportBills(): " + clientId1);
	    String billColumns = "13.14.112.23.24.124.25.3.33";
	 
	    //13=vendorName,14=terms,112=accountNumber,23=invoiceNumber,24=invoiceDate,124=countApp,25=invoiceDueDate,3=primaryKey,33=notes (description)
	    
		String billSort = "3";
		String billSortOrder = "sortorder-AD";
		String lineItemColumns = "16.17.22.15.14";
		String lineItemSort = "14";
		String lineItemSortOrder = "sortorder-AD";
		
		//16=accountNumber,17=accountName,22=amount,15=description,14=lineNumber
		
		HashMap hashmap1 = null;
		HashMap hashmap2 = null;
		String headerID = null;
		String vendor = null;
		String accountNo = null;
		String terms = null;
		String invoiceNum = "";
		String invoiceDate = "";
		String invoiceDateProcessed = "";
		String countApp = "";
		String invoiceDueDate = "";
		String invoiceDueDateProcessed = "";
		String lineAmt = "";
		String lineDesc = "";
		String lineNum = "";
		String accName = "";
		String accNum = "";
		String description = "";
		String xml = "";
		String updatedStatusCode = "";
		HashMap infoHash = new  HashMap();
		
    	try {
    		String strURL = "https://docorganiz.quickbase.com/db/";
    		if(clientId1==null){
		  		return xml;
		}

		QuickBaseClient qdb12 = new QuickBaseClient(username.trim() ,password.trim() , strURL);
		Vector vector= null;
		try {
			vector = qdb12.doQuery(invoiceTableId, billCriteria, billColumns, billSort, billSortOrder);
			System.out.println("Size of vector returned from quickbooks:"+ vector.size());
		} catch (QuickBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ExportBills - Debug 2 - Vector Count: "+vector.size());
		String[] headerIdsArray = new String[vector.size()];
		for(int j = 0; j <= vector.size() - 1; j++)
         {
         	hashmap1 = (HashMap)vector.elementAt(j);
            Iterator iterator = hashmap1.values().iterator();
            xml = xml + "<BillAddRq requestID=\"";
    		xml = xml + (j+1) +"\" >";
            xml = xml +"<BillAdd>"+"<VendorRef>";
   		 
       	    while (iterator.hasNext()) 
			{
       	    	//13=vendorName,14=terms,112=accountNumber,23=invoiceNumber,24=invoiceDate,124=countApp,25=invoiceDueDate,3=primaryKey,33=notes (description)
     			// System.out.println("1: Memo\t "+ iterator.next());
     			// System.out.println("2: HeaderID\t "+ iterator.next());
     		    // System.out.println("3: Account Number\t "+ iterator.next());
     			// System.out.println("4: Invoice Due Date:\t "+ iterator.next());
     			// System.out.println("5: Invoice Date:\t "+ iterator.next());
     			// System.out.println("6: Invoice Number\t "+ iterator.next());
     			// System.out.println("7: Terms \t "+ iterator.next());
     			// System.out.println("8: Count App\t "+ iterator.next());
     			// System.out.println("9: VendorName\t "+ iterator.next());
     			  
     	     description = (String)iterator.next(); 
     	   
			 headerID=(String)iterator.next();
			 headerIdsArray[j]=headerID;
			 accountNo = (String)iterator.next();
			 invoiceDueDate = (String)iterator.next();
			 invoiceDueDateProcessed = new SimpleDateFormat("yyyy-MM-dd").format(new Date(Long.parseLong(invoiceDueDate) + 86400000l));
			 invoiceDate = (String)iterator.next();
			 invoiceDateProcessed = new SimpleDateFormat("yyyy-MM-dd").format(new Date(Long.parseLong(invoiceDate) + 86400000l));
			 invoiceNum = (String)iterator.next();	
			 terms = (String)iterator.next();
			 countApp = (String)iterator.next();
			 vendor = (String)iterator.next();
			 xml = xml + "<FullName>"+ vendor.trim()+ "</FullName>"+"</VendorRef>";
			 xml = xml + "<TxnDate>"+ invoiceDateProcessed + "</TxnDate>";
			 xml = xml + "<DueDate>"+ invoiceDueDateProcessed + "</DueDate>";
			 xml = xml + "<RefNumber>"+invoiceNum + "</RefNumber>";
      	     xml = xml + "<Memo>" + description + "</Memo>";
			 Vector lineItemVector = new Vector();
			 try {
				 lineItemVector = qdb12.doQuery(lineItemTableId,"{'6'.EX."+headerID+"}", lineItemColumns, lineItemSort, lineItemSortOrder);
			 } catch (QuickBaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			 } catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 //Set Expenses
			 for(int i = 0; i <= lineItemVector.size()-1; i++)
              {
         	     hashmap2 = (HashMap)lineItemVector.elementAt(i);
         	     Iterator iterator2 = hashmap2.values().iterator();
         	     while (iterator2.hasNext()) 
			     {
         	    	xml = xml + "<ExpenseLineAdd>";
         	    	xml = xml + "<AccountRef>";
         	    	
         	    	//16=accountNumber,17=accountName,22=amount,15=description,14=lineNumber

         	    	//System.out.println("1: Amount \t "+ iterator2.next());
       			    //System.out.println("2: LineNumber \t "+ iterator2.next());
       		        //System.out.println("3: Description \t "+ iterator2.next());
       			    //System.out.println("4: AccountName\t "+ iterator2.next());
       			    //System.out.println("5: AccountNumber\t "+ iterator2.next());
       			  
       			  
					lineAmt = (String)iterator2.next();
					lineNum = (String)iterator2.next();
		 			lineDesc = (String)iterator2.next();
		 			accName = (String)iterator2.next();
		 			accNum = (String)iterator2.next();
				
					xml = xml + "<FullName>"+ accName +"</FullName>";
         	        xml = xml + "</AccountRef>";
         	        xml = xml + "<Amount>" + lineAmt + "</Amount>";
         	        xml = xml + "<Memo>" + lineDesc + "</Memo>";
         			xml = xml + "</ExpenseLineAdd>"; 
					
			     }//end while
			 } //end for
			 
			 //add
			}

			 try{
			 		System.out.println("Before updating Q Base; \n Total size of headers to be udpated\t"+headerIdsArray.length );
					for(int m = 0; m <= headerIdsArray.length - 1; m++){
			 		  	infoHash.put("46","Exported");
			 		  	updatedStatusCode = qdb12.editRecord(invoiceTableId, infoHash,headerIdsArray[m] );
			 		  	System.out.println("Successfully updated"+updatedStatusCode);
			 	  }
			 } catch(Exception iBizQBException)
			 {
			   System.out.println("iBizQBException "+iBizQBException.getMessage());
			 }
			 
       	 xml = xml + "</BillAdd>"+ "</BillAddRq>";
         }
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
		return xml;
    }

    public static void main(String args[]) throws Exception
    {
    	
     }
}
