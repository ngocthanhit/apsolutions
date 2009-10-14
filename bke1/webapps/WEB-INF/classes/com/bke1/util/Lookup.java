package com.bke1.util;


import com.bke1.domain.*;
import com.bke1.util.*;
import com.intuit.quickbase.util.*;
//import com.intuit.quickbase.util.QuickBaseClient;
//import com.intuit.quickbase.util.QuickBaseException;
import java.io.PrintStream;
import java.util.*;

public class Lookup
{

    String clientTableId = "bdy7kpj9j";
    String vendorTableId = "bdy8n6dzd";
    String franchiseTableId = "bdy7kpj9j";
		String chartOfAccountTableId = "bdy8sm7i9";
    String invoiceTableId="bdy8mtn9n";
   
    public String login;
    public  String password;
    public  String strURL;
    private boolean loginFailure;
    private boolean isLoggedIn;
    private QuickBaseClient qdb;
    
    private String bkeToken="eb8ujnbu7wy92bpafjvhc6zx2tp";

    public Lookup()
    {
        login = "";
        password = "";
        strURL = "https://docorganiz.quickbase.com/db/";
        loginFailure = false;
        isLoggedIn = true;
        clientArray = new String[2];
        qdb = null;
        refresh();
    }

	public boolean loginTest()  throws Exception
	{
			boolean isLoggedIn = false;
	        String s;
	        s = qdb.getNumRecords(clientTableId);
		 	isLoggedIn = true;

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

        login = "sashiatwork@gmail.com";
        password = "SRquic12";
        //qdb = new QuickBaseClient(login, password, strURL ,bkeToken);
			  qdb = new QuickBaseClient(login, password, strURL);

	  try{

	  		if(loginTest()){
					System.out.println("The server is still logged in");
	  		}else
	  		{
					System.out.println("The server is NOT logged in");
	  		}

  	  }catch(Exception e){
		  	System.out.println("Error at Lookup refresh "+e.getMessage());
			System.out.println("\n\n Restarting the server instance");
	  }

		setAllClient();
		
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



	public boolean isAuthenticated(String u,String p)
	{
		//System.out.println(" isAuthenticated ");
		QuickBaseClient qdb11 = new QuickBaseClient(u, p, strURL);
	        boolean isLoggedIn = false;
	        String s;



	     	try
	        {

	            s = qdb11.getNumRecords(clientTableId);
		 	            //System.out.println("AUTHENTICATE 2  s>>> "+s);
		 	    isLoggedIn = true;
	            //System.out.println("AUTHENTICATE 1");
	        }
	        catch(QuickBaseException quickbaseexception)
	        {
	            //System.out.println("AUTHENTICATE 3");
	            //System.out.println(quickbaseexception.getMessage());
	            if(quickbaseexception.getMessage().startsWith("Invalid email address or password.")){
	            	//System.out.println("INVALID EMAIL ");
	            	isLoggedIn = false;
				}


	        }
	        catch(Exception exception)
	        {
				//System.out.println("AUTHENTICATE 4");
	            //System.out.println(exception.getMessage());
	        }
		//System.out.println(" isAuthenticated ? "+isLoggedIn);

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
		
    public void setAllClient()
    {
    System.out.println("In Set Client 1");
		
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
		
            Vector vector = qdb.doQuery(clientTableId, "{3.XCT.'$'}", "6.3.13.12", "3", s4);
            clientSize = vector.size();
            
            s5 = "var clientNameArray = new Array("+vector.size()+");";

            s6 = "var clientHiddenArray = new Array("+vector.size()+");";
           
            //s6 = "var clientNameArray = new Array("+vector.size()+");";
           
            System.out.println("vector.size()"+vector.size());
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
        						
        								// Get value															FranchiseName									FranchiseName								FranchiseId
        					 clientId = 	(String)iterator.next();
        					 s6=s6+"\n clientHiddenArray["+i+"] = \""+clientId+"&"+(String)iterator.next()+"&"+(String)iterator.next()+"\";";
        				//	 setVendorsByClient(clientId);
        					
        			//		 s6=s6+"\n clientNameArray["+i+"] = \""+(String)iterator.next()+"\";";
        			//		 System.out.println("s5>>> "+s5+"\n s6>>> "+s6);
        		//System.out.println(">>> "+iterator.next());
    			//	System.out.println(">>> "+iterator.next());
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
		//System.out.println(" clientArray[1] >> "+as[1] );

    }

		String vendorName="";

    public String getVendorsByClient(String clientId)
    {
        HashMap hashmap = new HashMap();
        String query = "{12.EX.'"+clientId+"'}";
        String selectList = "7.9";
        String sortBy = "3";
        String sortOrder = "sortorder-AD";
        String s5 = "";
        String s6 = "";
        Object obj = null;
        Object obj1 = null;
        String vendorTerm = "";
        try
        {
        System.out.println("In Set Vendor 2");
		
            Vector vector = qdb.doQuery(vendorTableId, query, selectList, sortBy, sortOrder);
    //System.out.println("In Set Vendor 3");
            
            //s5 = "vendorArray = new Array("+vector.size()+");";
	 		  
		         HashMap hashmap1 = null;

				//		 System.out.println("Client Id >>> "+clientId);

            for(int i = 0; i <= vector.size() - 1; i++)
            {
                hashmap1 = (HashMap)vector.elementAt(i);
		
                Iterator iterator = hashmap1.values().iterator();

    						while (iterator.hasNext()) {
	      									//Name
	      									
	      					vendorTerm = 	(String)iterator.next();
	      					vendorName = 	(String)iterator.next();			
        					 s5=s5+"\n vendorArray["+i+"] = \""+vendorName+"\";";
    							 s6=s6+"\n vendorTermArray["+i+"] = \""+vendorTerm+"\";";
    							
    						   System.out.println("vendorName >>> "+vendorName+"vendorTerm >>> "+vendorTerm);
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

		//vendorArray[clientSequenceId]=s5;
		s5=s5+getChartOfAccountsByClient(clientId)+s6;
		return s5;
    }


		
		String accountNumber="";
		String accountName="";
		
		
    public String getChartOfAccountsByClient(String clientId)
    {
        HashMap hashmap = new HashMap();
        String query = "{8.EX.'"+clientId+"'}";
        String selectList = "6.7";
        String sortBy = "";
        String sortOrder = "sortorder-AD";
        String s5 = "";
        String s6 = "";
        Object obj = null;
        Object obj1 = null;
        String as[] = new String[2];
        
        try
        {
    //			System.out.println("In Set Vendor 2");
		
            Vector vector = qdb.doQuery(chartOfAccountTableId, query, selectList, sortBy, sortOrder);
    				System.out.println("In Set Vendor 3");
            
            //s5 = "var accountNumberArray = new Array("+vector.size()+");";
	 		  
            //s6 = "var accountNameArray = new Array("+vector.size()+");";
	 		  
		         HashMap hashmap1 = null;

	//					 System.out.println("Client Id >>> "+clientId);

            for(int i = 0; i <= vector.size() - 1; i++)
            {
                hashmap1 = (HashMap)vector.elementAt(i);
		
                Iterator iterator = hashmap1.values().iterator();

    						while (iterator.hasNext()) {
	      									//Name
	      									
	      					accountName = 	(String)iterator.next();			
	      					accountNumber = 	(String)iterator.next();
        					 s5=s5+"\n accountNumberArray["+i+"] = \""+accountNumber+"\";";
    							 s6=s6+"\n accountNameArray["+i+"] = \""+accountName+"\";";
    							
//    						   System.out.println(">>> "+vendorName);
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
		return s5+s6;
    }

   


	// s = vendorId s1 InvoiceNumber
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
            vector = qdb.doQuery(s5, s2, s3, s4, s6);
		//	System.out.println("in 3");
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


    public static void main(String args[]) throws Exception
    {
        //AllVendor allvendor = new AllVendor("sashiatwork@gmail.com", "SRquic12");
		   Lookup lookup = new Lookup();
		
		
					//System.out.println("isAuthenticated ?  "+lookup.isAuthenticated("sashiatwork1@gmail.com", "SRquic12"));
		
		      System.out.println(lookup.getClientArray());
		    System.out.println(lookup.getVendorsByClient("1"));
		    /*
		    	String [] clnt= lookup.getClientArray();
			    System.out.println(clnt[0]);
			    System.out.println(clnt[1]);
			    
		    
		    	String  act=lookup.getChartOfAccountsByClient("1");
			    System.out.println(act);
			   */ 
	//			String [] ven = lookup.getVendorArray();
	//			String [] ven = lookup.getVendorArray();
//		    System.out.println(ven[0]);
				
     		System.out.println(lookup.getVendorsByClient("1"));
     }
    
    
}