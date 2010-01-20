package com.bke2.util;


import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import java.text.SimpleDateFormat;
import com.intuit.quickbase.util.*;
import com.intuit.quickbase.util.*;

import java.io.PrintStream;
import java.util.*;

@SuppressWarnings("unchecked")
public class Lookup
{
	private String systemLogin = "sashiatwork@gmail.com";
	private String systemPassword = "SRquic12";
    private int timeOutLimit = 864000000;
    private String strURL = "https://docorganiz.quickbase.com/db/";
    private String clientId = "7";  //THIS IS FOR COMPANY AA
    private String bke1ApplicationId = "bes8a4tgg";
    private String clientTableId = "bes8a4tgn";
    private String vendorTableId = "bes8a4tgu";
    private String chartOfAccountTableId = "bes8a4tgv";
    private String statusChoiceTableId ="bes8a4tgs";
    private String lineClassificationTableId="bes8a4tgt";
    private String invoiceTableId="bes8a4tgq";
    private String lineItemTableId="bes8a4tgr";
    public String skipArray = "";
    private String lookupMessage;
    private String loginMessage;
    private String p;
    private String u;
    public String clientArray[];
    public String vendorArray[];
    private int clientSize=0;
    private int clientSequenceId = 0;
    private String vendorName="";

    private QuickBaseClient qdbLookup=null;
    private String bkeToken="eb8ujnbu7wy92bpafjvhc6zx2tp";


    //public String login;
    //public  String password;

    //private boolean loginFailure;
    //private boolean isLoggedIn;
    //private QuickBaseClient qdb;

    

    public Lookup()
    {
        //login = systemLogin;
        //password = systemPassword;
        //loginFailure = false;
        //isLoggedIn = true;
        clientArray = new String[2];
        //refresh();
    }

  public void reConnect(){
           try
            {
                qdbLookup = new QuickBaseClient(systemLogin, systemPassword, strURL);
                qdbLookup.setTimeout(timeOutLimit);
            }catch(Exception ee)
               {
                         lookupMessage=ee.getMessage();
                 }
    }

    public boolean isLoggedIn()  throws Exception
    {
            boolean isLoggedIn = false;
            String s="";
/*
            String s;
            s = qdb.getNumRecords(clientTableId);
            isLoggedIn = true;
*/
            try
            {
                //s = qdb21.getNumRecords(clientTableId);
                org.w3c.dom.Document ss =qdbLookup.getSchema(bke1ApplicationId);
                s = qdbLookup.getNumRecords(clientTableId);
                //System.out.println("AUTHENTICATE AT LOGINTEST()  >>> "+s);
                isLoggedIn = true;
                //System.out.println("AUTHENTICATE 1");
            }
            catch(QuickBaseException quickbaseexception)
            {
                isLoggedIn = false;
                lookupMessage=quickbaseexception.getMessage();
                //System.out.println("AUTHENTICATE 3");
                //System.out.println(quickbaseexception.getMessage());
                //if(quickbaseexception.getMessage().startsWith("Invalid email address or password.")){
                //System.out.println("INVALID EMAIL ");
                //isLoggedIn = false;
                 }catch(Exception ee)
                 {
                	 isLoggedIn = false;
                     lookupMessage=ee.getMessage();
                     //System.out.println("AUTHENTICATE 4");
                     //System.out.println(exception.getMessage());
                 }

               return isLoggedIn;
   }

    public String getSkipArray(){
        return skipArray;
    }

    public void setSkipArray(String skipArray){
        this.skipArray=skipArray;
    }
    
  public void refresh(){
        
        /*
        setAllVendor();
        setAllClient();
        setFromStatus();
        setApprover();
        setPC();
        setCD1();
        setCD2();
        setCD3();
        setDetailCode1();
        setDetailCode2();
        setNaturalAccount();
        setProcessStatus();
        setIGList();
        */
        System.out.println("Completed Refreshing ");
        setSkipArray("");

    }

    public String getLookupMessage(){
        return lookupMessage;
    }

    public String getLoginMessage(){
        return loginMessage;
    }

    public void setUser(String u){
        this.u=u;
    }
    public String getUser(){
            return u;
    }

    public void setPassword(String p){
        this.p=p;
    }
    public String getPassword(){
            return p;
    }

    public boolean isAuthenticated(String u,String p)
    {
        //System.out.println(" isAuthenticated ");
        QuickBaseClient qdbLocal = new QuickBaseClient(u, p, strURL);
        boolean isLoggedIn = false;
        String s="";
        try {
               //s = qdb21.getNumRecords(clientTableId);
               org.w3c.dom.Document ss =qdbLocal.getSchema(bke1ApplicationId);
               System.out.println("AUTHENTICATE  getSchema>>> ");
               isLoggedIn = true;
               setUser(u);
               setPassword(p);
               //System.out.println("AUTHENTICATE 1");
         } catch(QuickBaseException quickbaseexception) {
               isLoggedIn = false;
               //s=quickbaseexception.getMessage();
               //System.out.println("AUTHENTICATE 3");
               //System.out.println(quickbaseexception.getMessage());
               //if(quickbaseexception.getMessage().startsWith("Invalid email address or password.")){
               //System.out.println("INVALID EMAIL ");
                //isLoggedIn = false;
         }catch(Exception ee){
                isLoggedIn = false;
                s=ee.getMessage();
                //System.out.println("AUTHENTICATE 4");
                //System.out.println(exception.getMessage());
         }
        //System.out.println(" isAuthenticated ? "+isLoggedIn);
               loginMessage=s;
        return isLoggedIn;
    }

    public String[] getClientArray()
    {
        return clientArray;
    }

    public String[] getVendorArray()
    {
        return vendorArray;
    }

    public int getClientSize()
    {
        return clientSize;
    }

    public String editRecord(String tableId, HashMap infoHash, String tablePK)
    {
    	String primaryKey ="";
        //qdb = new QuickBaseClient(getUser(), getPassword(), strURL ,bkeToken);
    	QuickBaseClient qdb12 = new QuickBaseClient(getUser(), getPassword(), strURL);
        try{
            System.out.println("Inside addRecord");
            primaryKey = qdb12.editRecord(tableId, infoHash, tablePK);
        }catch(Exception ee2){
            primaryKey = (String)ee2.getMessage();
            System.out.println("Exception 1 Client "+primaryKey);
        }
        return primaryKey;
     }


    public String insertRecord(String tableId, HashMap infoHash)
    {
    	String primaryKey ="";
    	//qdb = new QuickBaseClient(getUser(), getPassword(), strURL ,bkeToken);
    	QuickBaseClient qdb12 = new QuickBaseClient(getUser(), getPassword(), strURL);
    	try{
    		System.out.println("Inside addRecord");
            System.out.println("*Table id******"+tableId);
            primaryKey = qdb12.addRecord(tableId, infoHash);

    	}catch(Exception ee2){
            primaryKey = (String)ee2.getMessage();
            System.out.println("Exception 1 insert record "+primaryKey);
        }
        return primaryKey;
    }



    public Vector getEditInfo(String tableId, String query, String queryAttributeList, String sortAttributes, String sortOrder)
    {
      Vector resultVector = null;
      String errorMessage="";
      System.out.println("getUser() "+getUser()+"getPassword() "+getPassword());
      QuickBaseClient qdb = new QuickBaseClient(getUser(), getPassword(), strURL);
      //doQuery(java.lang.String dbid, java.lang.String query, java.lang.String clist, java.lang.String slist, java.lang.String options)
      try{
    	  if(!isLoggedIn()) reConnect();
          resultVector = qdb.doQuery(tableId, query, queryAttributeList, sortAttributes, sortOrder);
          System.out.println("Completed getEditInfo");
      }catch(Exception ee2){
          errorMessage = (String)ee2.getMessage();
          System.out.println("Exception 1 Client "+errorMessage);
      }
      return resultVector;
     }

  /*
    public int isSimilarVendorInvoice(String vendorId, String invoiceNumber, String invoicePK)
    {
        //System.out.println("in 1");
        Object obj = null;
        HashSet hashset = new HashSet();
        HashMap hashmap = new HashMap();
        String s2 ="{'112'.EX.'"+vendorId+"'}AND{'9'.EX.'"+invoiceNumber+"'}";
        String s3 = "3";
        String s4 = "";
        String s5 = invoiceTableId;
        String s6 = "";
        int result = 0;
        //System.out.println("vector.size() "+vector.size());
        String temp;
        Vector vector = null;
        try
        {
        //System.out.println("in 2");
            vector = qdbLookup.doQuery(s5, s2, s3, s4, s6);
        //    System.out.println("in 3");
        }
        catch(QuickBaseException quickbaseexception)
        {
            System.out.println(quickbaseexception.getMessage());
        }
        catch(Exception exception)
        {
            System.out.println(exception.getMessage());
        }

         if(vector.size() > 0){
             hashmap = (HashMap)vector.elementAt(0);
         //System.out.println((new StringBuilder()).append("vendorHash =").append(hashmap1).toString());
              temp = ((String)hashmap.get("Invoice ID#"));
                  if(temp.equals(invoicePK))
                    result = 1;
                else
                    result = 2;
          }
         return result;
    }
*/


    public boolean isVendorInvoiceExist(String vendorId, String invoiceNumber)
                {
        //System.out.println("in 1");
        Object obj = null;
        HashSet hashset = new HashSet();
        HashMap hashmap = new HashMap();
        String s2 ="{'18'.EX.'"+vendorId+"'}AND{'23'.EX.'"+invoiceNumber+"'}";
        String s3 = "";
        String s4 = "";
        String s5 = invoiceTableId;
        String s6 = "";
        Vector vector = null;
        try
        {
           if(!isLoggedIn()) reConnect();
           vector = qdbLookup.doQuery(s5, s2, s3, s4, s6);
        } catch(QuickBaseException quickbaseexception)
        {
            System.out.println("QB EX"+quickbaseexception.getMessage());
        }
        	catch(Exception exception)
        {
            System.out.println("EX"+exception.getMessage());
        }
        return vector.size() != 0;
    }
    
    public void setAllClientBackup()
    {

   // System.out.println("In Set Client 1");

        HashMap hashmap = new HashMap();
        String s = "{3.XCT.'$'}";
       // String s1 = "3,6,13,12";
        String s1 = "12";
        String s2 = "";
        String s3 = clientTableId;
        String s4 = "sortorder-AD";
        String s5 = "";
        String s6 = "";
        String s7 = "";
        String clientId = "";
        Object obj = null;
        Object obj1 = null;
        String as[] = new String[2];
        try	{
//    		System.out.println("In Set Client 2");
            if(!isLoggedIn()){
            	System.out.println(" OOPS! qdbLookup is LOGGED OUT \n trying to reconnect");
                reConnect();
                System.out.println(" adbLookup is connected ");
            }else{
                System.out.println(" GOOD qdbLookup is LOGGED IN  \n trying to reconnect");
            }

            Vector vector = qdbLookup.doQuery(clientTableId, "{3.XCT.'$'}", "6.3.13.12", "3", s4);
            clientSize = vector.size();
            s5 = "";
            s6 = "";
            //s6 = "var clientNameArray = new Array("+vector.size()+");";
            //System.out.println("vector.size()"+vector.size());
            HashMap hashmap1 = null;
            for(int i = 0; i <= vector.size() - 1; i++)
            {
               clientSequenceId = i;
               //System.out.println("In Set Client 31");
               hashmap1 = (HashMap)vector.elementAt(i);
               Iterator iterator = hashmap1.values().iterator();
               while (iterator.hasNext()) {
            	   s5=s5+"\n clientNameArray["+i+"] = \""+(String)iterator.next()+"\";";
            	   // Get value                                                            FranchiseName                                    FranchiseName                                FranchiseId
            	   clientId =     (String)iterator.next();
            	   s6=s6+"\n clientHiddenArray["+i+"] = \""+clientId+"&"+(String)iterator.next();
            	   s6=s6+"&"+(String)iterator.next()+"\";";
                   //setVendorsByClient(clientId);
            	   //s6=s6+"\n clientNameArray["+i+"] = \""+(String)iterator.next()+"\";";
                   //System.out.println("s5>>> "+s5+"\n s6>>> "+s6);
            	   //System.out.println(">>> "+iterator.next());
            	   //System.out.println(">>> "+iterator.next());
                }
               	//System.out.println("In Set Client 35");
            }
        }
        catch(QuickBaseException quickbaseexception)
        {
            System.out.println("Exception 1 Client "+quickbaseexception.getMessage());

        }
        catch(Exception exception2)
        {
            System.out.println("Exception 2 Client "+exception2.getMessage());
            exception2.printStackTrace();
        }
        System.out.println(" clientArray[1] >> "+s6 );
        as[0] = s5;
        //as[1] = s6;
        clientArray = as;
        //System.out.println(" clientArray[0] >> "+as[0] );
        //System.out.println(" clientArray[1] >> "+as[1] );
    }




    public void setAllClient()
    {
    	// System.out.println("In Set Client 1");
        HashMap hashmap = new HashMap();
        String s = "{3.XCT.'$'}";
        //String s1 = "3,6,13,12";
        String s1 = "12";
        String s2 = "";
        String s3 = clientTableId;
        String s4 = "sortorder-AD";
        String s5 = "";
        String s6 = "";
        String s7 = "";
        String clientId = "";
        Object obj = null;
        Object obj1 = null;
        String franchiseName="";
        String franchiseNumber="";
        String as[] = new String[2];
        try {
        	//System.out.println("In Set Client 2");
            /*
                     if(!isLoggedIn()){
                        System.out.println(" OOPS! qdbLookup is LOGGED OUT \n trying to reconnect");
                             reConnect();
                        System.out.println(" adbLookup is connected ");
                     }else{
                        System.out.println(" GOOD qdbLookup is LOGGED IN  \n trying to reconnect");

                    }
                    */


                      QuickBaseClient qdb12 = new QuickBaseClient(getUser(), getPassword(), strURL);

            Vector vector = qdb12.doQuery(clientTableId, "{3.XCT.'$'}", "6.3.13.12", "3", s4);
            clientSize = vector.size();

            s5 = "";

            s6 = "";

 
            //s6 = "var clientNameArray = new Array("+vector.size()+");";

          //  System.out.println("vector.size()"+vector.size());
            HashMap hashmap1 = null;

            for(int i = 0; i <= vector.size() - 1; i++)
            {

                  clientSequenceId = i;
  //  System.out.println("In Set Client 31");

                hashmap1 = (HashMap)vector.elementAt(i);

                Iterator iterator = hashmap1.values().iterator();

                            while (iterator.hasNext()) {


                                            //Name
                             s5=s5+"\n clientNameArray["+i+"] = \""+(String)iterator.next()+"\";";

                                        // Get value                                                            FranchiseName                                    FranchiseName                                FranchiseId
                 clientId =     (String)iterator.next();
                 franchiseName = (String)iterator.next();
                 franchiseNumber = (String)iterator.next();
                 
  s6=s6+"\n clientHiddenArray["+i+"] = \""+clientId.trim()+"&"+franchiseName.trim()+"&"+franchiseNumber.trim()+"\";";
                      //     setVendorsByClient(clientId);

                    //         s6=s6+"\n clientNameArray["+i+"] = \""+(String)iterator.next()+"\";";
                    //         System.out.println("s5>>> "+s5+"\n s6>>> "+s6);
                //System.out.println(">>> "+iterator.next());
                //    System.out.println(">>> "+iterator.next());
                          }

    //System.out.println("In Set Client 35");


            }

        }
        catch(QuickBaseException quickbaseexception)
        {
            System.out.println("Exception 1 Client "+quickbaseexception.getMessage());

        }
        catch(Exception exception2)
        {

            System.out.println("Exception 2 Client "+exception2.getMessage());
                exception2.printStackTrace();

        }

        as[0] = s5;
        as[1] = s6;

    clientArray = as;

        //System.out.println(" clientArray[0] >> "+as[0] );
       // System.out.println(" clientArray[1] >> "+as[1] );

    }




        

    public String getVendorsByClient(String clientId)
    {
        HashMap hashmap = new HashMap();
        String query = "{12.EX.'"+clientId+"'}";
        String selectList = "7.3.9";
        String sortBy = "3";
        String sortOrder = "sortorder-AD";
        String s5 = "";
        String s6 = "";
        String s7 = "";
        Object obj = null;
        Object obj1 = null;
        String vendorTerm = "";
        String vendorId = "";
        try
        {
        //System.out.println("In Set Vendor 2");

                      QuickBaseClient qdb12 = new QuickBaseClient(getUser(), getPassword(), strURL);


            Vector vector = qdb12.doQuery(vendorTableId, query, selectList, sortBy, sortOrder);
    //System.out.println("In Set Vendor 3");

            //s5 = "vendorArray = new Array("+vector.size()+");";

                 HashMap hashmap1 = null;

                //         System.out.println("Client Id >>> "+clientId);

            for(int i = 0; i <= vector.size() - 1; i++)
            {
                hashmap1 = (HashMap)vector.elementAt(i);

                Iterator iterator = hashmap1.values().iterator();

                            while (iterator.hasNext()) {
                                              //Name

                              vendorTerm =     (String)iterator.next();
                              vendorId =     (String)iterator.next();
                              vendorName =     (String)iterator.next();
                             s5=s5+"\n vendorArray["+i+"] = \""+vendorName+"\";";
                                 s6=s6+"\n vendorTermArray["+i+"] = \""+vendorTerm+"\";";
                                 s7=s7+"\n vendorIdArray["+i+"] = \""+vendorId+"\";";

                               //System.out.println("vendorName >>> "+vendorName+"vendorTerm >>> "+vendorTerm);
                          }


            }

        }
        catch(QuickBaseException quickbaseexception)
        {
            System.out.println("Exception 1 Vendor Array "+quickbaseexception.getMessage());
        }
        catch(Exception exception2)
        {
            System.out.println("Exception 2 Vendor Array "+exception2.getMessage());

                exception2.printStackTrace();
        }


        //vendorArray[clientSequenceId]=s5;
        s5=s5+getChartOfAccountsByClient(clientId)+s6+s7;
      //System.out.println(" S5 >> \n "+s5 );
        return s5;
    }


         public String getLineClassificationArray()
    {
        HashMap hashmap = new HashMap();
        String query = "{3.XCT.'$'}";
        String selectList = "6.7.8.13";
        String sortBy = "6.7";
        String sortOrder = "sortorder-AD";
        String s5 = "";
        String fromStatus = "";
        String toStatus = "";
        String billStatus = "";
        String isEditable = "";
        try
        {
        //System.out.println("In Set Vendor 2");

                        if(!isLoggedIn())             reConnect();

            Vector vector = qdbLookup.doQuery(lineClassificationTableId, query, selectList, sortBy, sortOrder);


                  HashMap hashmap1 = null;
                            Iterator iterator = null;

                //         System.out.println("Client Id >>> "+clientId);

            for(int i = 0; i <= vector.size() - 1; i++)
            {
                    hashmap1 = (HashMap)vector.elementAt(i);

                  iterator = hashmap1.values().iterator();

                              isEditable  =     (String)iterator.next();
                              fromStatus  =     (String)iterator.next();
                              billStatus   =     (String)iterator.next();
               							  toStatus =     (String)iterator.next();

                             s5=s5+"\n lineClassificationArray["+i+"] = \""+fromStatus+","+toStatus+","+billStatus+","+isEditable+"\";";

                               //System.out.println("fromStatus >>> "+fromStatus+" toStatus >>> "+toStatus+" billStatus >>> "+billStatus);

            }

        }
        catch(QuickBaseException quickbaseexception)
        {
            System.out.println("Exception 1 allStatusArray "+quickbaseexception.getMessage());
        }
        catch(Exception exception2)
        {
            System.out.println("Exception 2 allStatusArray "+exception2.getMessage());

                exception2.printStackTrace();
        }
        //vendorArray[clientSequenceId]=s5;
        //s5=s5+getChartOfAccountsByClient(clientId)+s6+s7;
      	//System.out.println(" S5 >> \n "+s5 );
        return s5;
    }

    public String getChartOfAccountsByClient(String clientId)
    {
        HashMap hashmap = new HashMap();
        String query = "{8.EX.'"+clientId+"'}";
        String selectList = "6.7.3";
        String sortBy = "";
        String sortOrder = "sortorder-AD";
        String s5 = "";
        String s6 = "";
        String s7 = "";
        String accountNumber="";
        String accountName="";
        String accountId="";
        try
        {
        	//System.out.println("In Set Vendor 2");
            if(!isLoggedIn()){
               //System.out.println(" OOPS! qdbLookup is LOGGED OUT \n trying to reconnect");
                 reConnect();
                 System.out.println(" adbLookup is connected ");
            }

            Vector vector = qdbLookup.doQuery(chartOfAccountTableId, query, selectList, sortBy, sortOrder);
            System.out.println("In Set Vendor 3");
            //s5 = "var accountNumberArray = new Array("+vector.size()+");";
            //s6 = "var accountNameArray = new Array("+vector.size()+");";
            HashMap hashmap1 = null;
            //System.out.println("Client Id >>> "+clientId);

            for(int i = 0; i <= vector.size() - 1; i++)
            {
                hashmap1 = (HashMap)vector.elementAt(i);
                Iterator iterator = hashmap1.values().iterator();
                while (iterator.hasNext()) {
                    
                	accountId =     (String)iterator.next();
                    accountName =     (String)iterator.next();
                    accountNumber =     (String)iterator.next();
                    s5=s5+"\n accountNumberArray["+i+"] = \""+accountNumber+"\";";
                    s6=s6+"\n accountNameArray["+i+"] = \""+accountName+"\";";
                    s7=s7+"\n accountIdArray["+i+"] = \""+accountId+"\";";
                    //System.out.println(">>> "+vendorName);
                }
            }
        }
        catch(QuickBaseException quickbaseexception)
        {
            System.out.println("Exception 1 Vendor Array "+quickbaseexception.getMessage());
        }
        catch(Exception exception2)
        {
            System.out.println("Exception 2 Vendor Array "+exception2.getMessage());
            exception2.printStackTrace();
        }

      //System.out.println(" S5 >> \n "+s5 );
      //System.out.println(" S5 >> \n "+s6 );

        //as[0]=s5;
        //as[1]=s6;

        //vendorArray[clientSequenceId]=s5;
        return s5+s6+s7;
    }




    // s = vendorId s1 InvoiceNumber
    /*
    public boolean isVendorInvoiceExist(String s, String s1)
    {
        //System.out.println("in 1");
        Object obj = null;
        HashSet hashset = new HashSet();
        HashMap hashmap = new HashMap();
        String s2 ="{'112'.EX.'"+s+"'}AND{'9'.EX.'"+s1+"'}";
        String s3 = "112";
        String s4 = "";
        String s5 = invoiceTableId;
        String s6 = "";
        Vector vector = null;
        try
        {
        //System.out.println("in 2");
            vector = qdbLookup.doQuery(s5, s2, s3, s4, s6);
        //    System.out.println("in 3");
        }
        catch(QuickBaseException quickbaseexception)
        {
            System.out.println(quickbaseexception.getMessage());
        }
        catch(Exception exception)
        {
            System.out.println(exception.getMessage());
        }

        //System.out.println("vector.size() "+vector.size());

        return vector.size() != 0;
    }

   */

/*
    public String getCommandLine(){

        //  open up standard input
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String userName = null;

      //  read the username from the command-line; need to use try/catch with the
      //  readLine() method
    while(true){
      try {
         userName = br.readLine();



      } catch (IOException ioe) {
         System.out.println("IO error trying to read your name!");
         System.exit(1);
      }
    }
}

*/

    public String getStatusArray()
    {
        HashMap hashmap = new HashMap();
        String query = "{3.XCT.'$'}";
        String selectList = "6.7.8.3";
        String sortBy = "6";
        String sortOrder = "sortorder-AD";
        String s5 = "";
        String fromStatus = "";
        String toStatus = "";
        String id = "";
        try
        {
        //System.out.println("In Set Vendor 2");

            if(!isLoggedIn())             reConnect();

            	Vector vector = qdbLookup.doQuery(statusChoiceTableId, query, selectList, sortBy, sortOrder);
            	HashMap hashmap1 = null;
            	Iterator iterator = null;

                //         System.out.println("Client Id >>> "+clientId);

            	for(int i = 0; i <= vector.size() - 1; i++)
            	{
                    hashmap1 = (HashMap)vector.elementAt(i);
                    iterator = hashmap1.values().iterator();
                    /*
                    toStatus  =     (String)iterator.next();
                    id =     (String)iterator.next();
                    fromStatus=     (String)iterator.next();
                    */
                    //s5=s5+"\n allStatusArray["+i+"] = \""+fromStatus+","+toStatus+","+id+"\";";
                    s5=s5+"\n allStatusArray["+i+"] = \""+(String)iterator.next()+","+(String)iterator.next()+","+(String)iterator.next()+","+(String)iterator.next()+"\";";
                    //System.out.println("fromStatus >>> "+fromStatus+" toStatus >>> "+toStatus+" id >>> "+id);
            }

        }
        catch(QuickBaseException quickbaseexception)
        {
            System.out.println("Exception 1 allStatusArray "+quickbaseexception.getMessage());
        }
        catch(Exception exception2)
        {
            System.out.println("Exception 2 allStatusArray "+exception2.getMessage());

                exception2.printStackTrace();
        }


        //vendorArray[clientSequenceId]=s5;
        //s5=s5+getChartOfAccountsByClient(clientId)+s6+s7;
        //System.out.println(" S5 >> \n "+s5 );
        return s5;
    }
    	
 @SuppressWarnings({ "unchecked", "unchecked" })
public String exportBills() {
	 
	    //String s1 ="{'90'.EX.'"+clientId+"'}AND{'27'.EX.'Accept'}AND{'131'.EX.'"+recode+"'}";
	    String s1 ="{'90'.EX.'"+clientId+"'}AND{'27'.EX.'Accept'}";
		
	    String s2 = "13.14.112.23.24.124.25.3";
		String s3 = "3";
		String s4 = "sortorder-AD";
		String s2a = "16.17.22.15";
		String s3a = "16";
		String u = "QuickBaseAdmin@docorganiz.com";
		String p = "QBadd1234#*";
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
		String accName = "";
		String accNum = "";
		String xml = "";
		String updatedStatusCode = "";
		HashMap infoHash = new  HashMap();
		
    	try {
    		String strURL = "https://docorganiz.quickbase.com/db/";
    		if(clientId==null){
		  		return xml;
		}

		QuickBaseClient qdb12 = new QuickBaseClient(u ,p , strURL);
		Vector vector= null;
		try {
			
			System.out.println("invoiceTableId: " + invoiceTableId);
			System.out.println("s1: " + s1);
			System.out.println("s2: " + s2);
			System.out.println("s3: " + s3);
			System.out.println("s4: " + s4);
			//vector = qdb12.doQuery(invoiceTableId,s1, s2, s3, s4);
			vector = qdb12.doQuery("bes8a4tgq",s1, s2, s3, s4);
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
			 headerID=(String)iterator.next();
			 headerIdsArray[j]=headerID;
			 System.out.println("ExportBills - Debug 3 - HeaderID: "+headerID);
			 accountNo = (String)iterator.next();
			 System.out.println("ExportBills - Debug 4 - AccountNo: "+accountNo);
			 invoiceDueDate = (String)iterator.next();
			 System.out.println("ExportBills - Debug 5 - Invoice Due Date: "+ invoiceDueDate);			
			 invoiceDueDateProcessed = new SimpleDateFormat("yyyy-MM-dd").format(new Date(Long.parseLong(invoiceDueDate) + 86400000l));
			 System.out.println("ExportBills - Debug 6 - Invoice Due Date Processed: "+invoiceDueDateProcessed);
			 invoiceDate = (String)iterator.next();
			 System.out.println("ExportBills - Debug 7 - Invoice Date: "+ invoiceDate);
			 invoiceDateProcessed = new SimpleDateFormat("yyyy-MM-dd").format(new Date(Long.parseLong(invoiceDate) + 86400000l));
			 System.out.println("ExportBills - Debug 8 - Invoice Date Processed: "+invoiceDateProcessed);
			 invoiceNum = (String)iterator.next();	
			 System.out.println("ExportBills - Debug 9 - InvoiceNum: "+invoiceNum);
			 terms = (String)iterator.next();
			 System.out.println("ExportBills - Debug 10 - Terms: "+terms);
			 countApp = (String)iterator.next();
			 System.out.println("ExportBills - Debug 11 - CountApp: "+countApp);
			 vendor = (String)iterator.next();
			 System.out.println("ExportBills - Debug 12 - Vendor: "+vendor);
			 xml = xml + "<FullName>"+ vendor.trim()+ "</FullName>"+"</VendorRef>";
			 xml = xml + "<TxnDate>"+ invoiceDateProcessed + "</TxnDate>";
			 xml = xml + "<DueDate>"+ invoiceDueDateProcessed + "</DueDate>";
      	     xml = xml + "<Memo>" + invoiceNum + "</Memo>";

			 //query corresponding Line Item
		
			 Vector lineItemVector = new Vector();
			 try {
				 lineItemVector = qdb12.doQuery(lineItemTableId,"{'6'.EX."+headerID+"}", s2a, s3a, s4);
				 System.out.println("ExportBills - Debug 13 - LineItem Vector Size: "+ lineItemVector.size());
			 } catch (QuickBaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			 } catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 //bills.setExpenseCount(lineItemVector.size());
			  
			  //Set Expenses
			 for(int i = 0; i <= lineItemVector.size()-1; i++)
              {
				 System.out.println("Value of i" + i);
				 System.out.println("ExportBills - Debug 14 - Interating through lineItemVecotr ....");
         	     hashmap2 = (HashMap)lineItemVector.elementAt(i);
         	     Iterator iterator2 = hashmap2.values().iterator();
         	     while (iterator2.hasNext()) 
			     {
         	    	xml = xml + "<ExpenseLineAdd>";
         	    	xml = xml + "<AccountRef>";
					lineAmt = (String)iterator2.next();
					System.out.println("ExportBills - Debug 15 - LineAmt: "+lineAmt);
		 			lineDesc = (String)iterator2.next();
					System.out.println("ExportBills - Debug 16 - LineDesc: "+lineDesc);
		 			accName = (String)iterator2.next();
					System.out.println("ExportBills - Debug 17 - AccName: "+accName);
		 			accNum = (String)iterator2.next();
					System.out.println("ExportBills - Debug 18 - AccNum: "+accNum);
					
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
						  //System.out.println(m+"  headerId "+headerIdsArray[m]);

			 		  	infoHash.put("46","Exported");
			 		  	updatedStatusCode = qdb12.editRecord(invoiceTableId, infoHash,headerIdsArray[m] );
			 		  	System.out.println("Successfully updated"+updatedStatusCode);
			 	  }
				  //System.out.println("Successfully added"+infoHash);
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
    	/*
        AllVendor allvendor = new AllVendor("sashiatwork@gmail.com", "SRquic12");
           Lookup lookup = new Lookup();


            System.out.println("isAuthenticated ?  "+lookup.isAuthenticated("sashiatwork@gmail.com", "SRquic12"));

            lookup.isAuthenticated("peterprep@docorganiz.com", "Preparer9$");

            lookup.setAllClient();

            		System.out.println("getStatus "+lookup.getLineClassificationArray());
                //System.out.println("getStatus "+lookup.getStatusArray());


               
                System.out.println("isAuthenticated ?  "+lookup.isAuthenticated("peterprep@docorganiz.com", "Preparer9$"));

                System.out.println("getStatus "+lookup.getStatusArray());

              
        String allocationTableId = "bd77scjib";
                String billId = "33";

    String queryAttributeList="84.3.83.86.91.18.20.23.24.26.29.25.105.30.31.58.33.107";
    String sortAttributes="3";
    String sortOrder="sortorder-AD";
    Vector resultVector =lookup.getEditInfo(invoiceTableId,  "{'3'.EX."+billId+"}", queryAttributeList, sortAttributes, sortOrder);

System.out.println("resultVector >>"+resultVector.getClass().getName());
System.out.println("resultVector.elementAt(0) >>"+resultVector.elementAt(0).getClass().getName());


         Get HashMap from Vector
        HashMap hashmap1 = null;

            for(int ii = 0; ii <= resultVector.size() - 1; ii++)
            {
                hashmap1 = (HashMap)resultVector.elementAt(ii);
                        }

          Iterate over the keys in the map
    Iterator itKey = hashmap1.keySet().iterator();
    Iterator itValue = hashmap1.values().iterator();
     Object keyString =null;
     Object valueString =null;
    while (itKey.hasNext()) {
        // Get key
        keyString = itKey.next();
        //Object valueString = itValue.next();
        valueString = hashmap1.get(keyString);
        System.out.println(keyString.toString() +"\t" +valueString.toString());
    }

    // Iterate over the values in the map
    Iterator itValue = map.values().iterator();
    while (itValue.hasNext()) {
        // Get value
        Object value = itValue.next();
        System.out.println(value.toString());
    }
   



                //System.out.println(" isVendorInvoiceExist ?  "+lookup.isVendorInvoiceExist("10", "12asf"));

                    //System.out.println("isAuthenticated ?  "+lookup.isAuthenticated("JoeC@docorganiz.com", "JoeTest9$"));

                //    System.out.println("isAuthenticated ?  "+lookup.getLoginMessage());

              //System.out.println(lookup.getClientArray());
              //System.out.println(lookup.getVendorsByClient("1"));

              //System.out.println(lookup.getChartOfAccountsByClient("1"));


           
                String [] clnt= lookup.getClientArray();
                System.out.println(clnt[0]);
                System.out.println(clnt[1]);


                String  act=lookup.getChartOfAccountsByClient("1");
                System.out.println(act);
              
                String [] ven = lookup.getVendorArray();
                String [] ven = lookup.getVendorArray();
               System.out.println(ven[0]);

            System.out.println(lookup.getVendorsByClient("1"));
            */
            Lookup myLookup = new Lookup();
            String myxml = myLookup.exportBills();
            System.out.println("Running the main ........................");
            System.out.println(myxml);
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
     }

    
   


}
