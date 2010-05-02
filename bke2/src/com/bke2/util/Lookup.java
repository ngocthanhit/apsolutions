package com.bke2.util;


import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;


import com.intuit.quickbase.util.*;
//import com.intuit.quickbase.util.QuickBaseClient;
//import com.intuit.quickbase.util.QuickBaseException;
import java.io.PrintStream;
import java.util.*;

public class Lookup
{

 
		//System.out.println("invoiceTableId11 >>"+invoiceTableId11);
//10@bookkeepingexpress.com

        //String systemLogin = "sashiatwork@gmail.com";
        String systemLogin = "sashiatwork@gmail.com";
        String systemPassword = "SRquic12";
        private int timeOutLimit = 864000000;
    String strURL = "https://docorganiz.quickbase.com/db/";

    String bke1ApplicationId = "bes8a4tgg";

    String clientTableId = "bes8a4tgn";
    String vendorTableId = "bes8a4tgu";
       String chartOfAccountTableId = "bes8a4tgv";
    String statusChoiceTableId ="bes8a4tgs";
       String lineClassificationTableId="bes8a4tgt";
    String invoiceTableId="bes8a4tgq";

       private QuickBaseClient qdbLookup=null;



    //public String login;
    //public  String password;

    //private boolean loginFailure;
    //private boolean isLoggedIn;
    //private QuickBaseClient qdb;

    private String bkeToken="eb8ujnbu7wy92bpafjvhc6zx2tp";

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
                //    isLoggedIn = false;
                 }catch(Exception ee)
           {
                isLoggedIn = false;
                         lookupMessage=ee.getMessage();
                        //System.out.println("AUTHENTICATE 4");
              //System.out.println(exception.getMessage());
            }

               return isLoggedIn;
   }

    public String skipArray = "";

    public String getSkipArray(){
        return skipArray;
    }

    public void setSkipArray(String skipArray){
        this.skipArray=skipArray;
    }


  public void refresh(){

        //setAllClient();

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
        */
        //setIGList();

        System.out.println("Completed Refreshing ");
        setSkipArray("");

    }



    private String lookupMessage;
    public String getLookupMessage(){

        return lookupMessage;
    }

    private String loginMessage;

    public String getLoginMessage(){

        return loginMessage;
    }

    private String u;
    public void setUser(String u){
        this.u=u;
    }
    public String getUser(){
            return u;
    }

    private String p;
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



             try
            {
                //s = qdb21.getNumRecords(clientTableId);
                           org.w3c.dom.Document ss =qdbLocal.getSchema(bke1ApplicationId);

                           System.out.println("AUTHENTICATE  getSchema>>> ");
                         isLoggedIn = true;
                         setUser(u);
                         setPassword(p);

                //System.out.println("AUTHENTICATE 1");
            }
            catch(QuickBaseException quickbaseexception)
            {
                    isLoggedIn = false;
                             //s=quickbaseexception.getMessage();
                              //System.out.println("AUTHENTICATE 3");
                //System.out.println(quickbaseexception.getMessage());
                //if(quickbaseexception.getMessage().startsWith("Invalid email address or password.")){
                    //System.out.println("INVALID EMAIL ");
                //    isLoggedIn = false;
                 }catch(Exception ee)
           {
                isLoggedIn = false;
                             s=ee.getMessage();
                        //System.out.println("AUTHENTICATE 4");
              //System.out.println(exception.getMessage());
            }
        //System.out.println(" isAuthenticated ? "+isLoggedIn);
                    loginMessage=s;
            return isLoggedIn;
    }



    public String clientArray[];
        public String vendorArray[];

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

        private int clientSize=0;
        private int clientSequenceId = 0;


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




    // s = vendorId s1 InvoiceNumber
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
    // s = vendorId s1 InvoiceNumber


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
                }
        catch(QuickBaseException quickbaseexception)
        {
            System.out.println("QB EX"+quickbaseexception.getMessage());
        }
        catch(Exception exception)
        {
            System.out.println("EX"+exception.getMessage());
        }

        //System.out.println("vector.size() "+vector.size());

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
        try
        {
//    System.out.println("In Set Client 2");
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
                             s6=s6+"\n clientHiddenArray["+i+"] = \""+clientId+"&"+(String)iterator.next();
                             s6=s6+"&"+(String)iterator.next()+"\";";
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
        
        System.out.println(" clientArray[1] >> "+s6 );

        as[0] = s5;
       // as[1] = s6;

    clientArray = as;

        //System.out.println(" clientArray[0] >> "+as[0] );
        //System.out.println(" clientArray[1] >> "+as[1] );

    }




    public void setAllClient()
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

String franchiseName="";
String franchiseNumber="";

        String as[] = new String[2];
        try
        {
//    System.out.println("In Set Client 2");
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




        String vendorName="";

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
    //            System.out.println("In Set Vendor 2");

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

    //                     System.out.println("Client Id >>> "+clientId);

            for(int i = 0; i <= vector.size() - 1; i++)
            {
                hashmap1 = (HashMap)vector.elementAt(i);

                Iterator iterator = hashmap1.values().iterator();

                            while (iterator.hasNext()) {
                                              //Name

                              accountId =     (String)iterator.next();
                              accountName =     (String)iterator.next();
                              accountNumber =     (String)iterator.next();
                             s5=s5+"\n accountNumberArray["+i+"] = \""+accountNumber+"\";";
                                 s6=s6+"\n accountNameArray["+i+"] = \""+accountName+"\";";
                                 s7=s7+"\n accountIdArray["+i+"] = \""+accountId+"\";";

//                               System.out.println(">>> "+vendorName);
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


    public static void main(String args[]) throws Exception
    {
        //AllVendor allvendor = new AllVendor("sashiatwork@gmail.com", "SRquic12");
           Lookup lookup = new Lookup();


            System.out.println("isAuthenticated ?  "+lookup.isAuthenticated(lookup.systemLogin, "SRquic12"));

            //lookup.isAuthenticated("peterprep@docorganiz.com", "Preparer9$");

            //lookup.setAllClient();

            		System.out.println("getStatus "+lookup.getLineClassificationArray());
                //System.out.println("getStatus "+lookup.getStatusArray());


                /*
                System.out.println("isAuthenticated ?  "+lookup.isAuthenticated("peterprep@docorganiz.com", "Preparer9$"));

                System.out.println("getStatus "+lookup.getStatusArray());

              
        String allocationTableId = "bd77scjib";
                String billId = "33";

    String queryAttributeList="84.3.83.86.91.18.20.23.24.26.29.25.105.30.31.58.33.107";
    String sortAttributes="3";
    String sortOrder="sortorder-AD";
    Vector resultVector =lookup.getEditInfo(invoiceTableId,  "{'3'.EX."+billId+"}", queryAttributeList, sortAttributes, sortOrder);

//System.out.println("resultVector >>"+resultVector.getClass().getName());
//System.out.println("resultVector.elementAt(0) >>"+resultVector.elementAt(0).getClass().getName());


        // Get HashMap from Vector
        HashMap hashmap1 = null;

            for(int ii = 0; ii <= resultVector.size() - 1; ii++)
            {
                hashmap1 = (HashMap)resultVector.elementAt(ii);
                        }

         // Iterate over the keys in the map
    Iterator itKey = hashmap1.keySet().iterator();
//    Iterator itValue = hashmap1.values().iterator();
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
    */



                //System.out.println(" isVendorInvoiceExist ?  "+lookup.isVendorInvoiceExist("10", "12asf"));

                    //System.out.println("isAuthenticated ?  "+lookup.isAuthenticated("JoeC@docorganiz.com", "JoeTest9$"));

                //    System.out.println("isAuthenticated ?  "+lookup.getLoginMessage());

              //System.out.println(lookup.getClientArray());
              //System.out.println(lookup.getVendorsByClient("1"));

              //System.out.println(lookup.getChartOfAccountsByClient("1"));


            /*
                String [] clnt= lookup.getClientArray();
                System.out.println(clnt[0]);
                System.out.println(clnt[1]);


                String  act=lookup.getChartOfAccountsByClient("1");
                System.out.println(act);
               */
    //            String [] ven = lookup.getVendorArray();
    //            String [] ven = lookup.getVendorArray();
//            System.out.println(ven[0]);

             //System.out.println(lookup.getVendorsByClient("1"));
     }


}
