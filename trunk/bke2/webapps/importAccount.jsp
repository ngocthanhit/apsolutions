<%@ page language="java" import="com.intuit.quickbase.util.*,com.bke1.util.*" %><%@ page import="ibizqb.*"%> <%@ page buffer="256kb"%>  <%@ page import="java.util.*"%><%@ page import="java.text.SimpleDateFormat"%>      <%@ page import="java.lang.reflect.Array"%>  <%@ page import="org.w3c.dom.Document"%>  <%@ page import="org.xml.sax.InputSource"%>  <%@ page import="org.w3c.dom.Element"%>  <%@ page import="org.w3c.dom.NodeList"%>  <%@ page import="org.w3c.dom.Node"%>  <%  	    	    		String strURL = "https://docorganiz.quickbase.com/db/";	  ServletContext context = this.getServletContext();  		String accountsTableId = context.getInitParameter( "accountsTableId" );		String vid = request.getParameter("vid");		String s4 = "sortorder-AD";				String u = "QuickBaseAdmin@docorganiz.com";		String p = "QBadd1234#*";		int quickBooksCount = 0;		int quickBaseCount = 0;		int insertCount = 0;		int quickBaseCountInsert = 0;		  		System.out.println("user name"+u);		System.out.println("password"+p);		System.out.println("vid"+vid);		  		QuickBaseClient qdb13 = new QuickBaseClient(u ,p , strURL);    Vector vector = qdb13.doQuery(accountsTableId, "{8.EX.'"+vid+"'}", "7.21.20.3.6.23", "3", s4);        		  				   	//getting the client id from  quickbooks	  final javax.servlet.jsp.JspWriter ps = out;		Objsearch search1 = new Objsearch();		Account account1 = new Account();	      		account1.setQBConnectionString("URL='http://10.100.42.85:2080'");		search1.setQBConnectionString("URL='http://10.100.42.85:2080'");		search1.reset();		search1.setActiveStatus(3);		search1.setQueryType(19);				System.out.println("*******************vector size**"+vector.size());				search1.setNameContains("");				//Only return a maximum of 200 results		search1.setMaxResults(300);    		int insert = 0;		search1.search();			String accountNameBooks ="";		String accountNameBooks1 ="";		String accountNameBase = "";		HashMap infoHash1 = new  HashMap();		HashMap infoHash2 = new  HashMap();		HashMap infoHash3 = new  HashMap();		String primaryKey ="";		String primaryKey1 ="";		String accountTypeBase = "";					HashMap hashmap1 = null;		HashMap hashmap2 = null;		String parentName = null;		int accountTypeBooks = 0;		String strAccountTypeBooks = "";		String accountDescBase = "";		String accountDescBooks = "";		String headerID = "";		String accountNumber = "";		boolean activeFlag = true;		String strActiveFlag = "";		String deactiveBooks = "";		String accountNumberBase = "";		String accountNumberBooks = "";							System.out.println("Result count "+search1.getResultCount());											if(vector.size()==0){					System.out.println("******Vector Size is 0********");					for (int i = 0; i< search1.getResultCount(); i++) 					{						account1.reset();		 				account1.setQBResponseAggregate(search1.getResultAggregate(i));		   			accountNameBooks = account1.getAccountName();		   					   					   					   			//System.out.println("acc type from books**************"+strAccountTypeBooks);		   					   			//System.out.println("**Id**"+account1.getParentId());		   					   					   					   			parentName = account1.getParentName();		   			//System.out.println("**parent name**"+parentName);		   					   					   			//checking and adding parentname 		   			if(parentName.equals(null) || parentName.equals("")){		   			System.out.println("no parent");		   			accountNameBooks1 = accountNameBooks;		   			}		   		  else{		   		  accountNameBooks1 = parentName + ":" + accountNameBooks ;		   		  System.out.println("after appending**********"+accountNameBooks1);		   		  }		   					   									//System.out.println("**account name**"+account1.getAccountName());						System.out.println("**parent name**"+account1.getParentName());						infoHash1.put("7",accountNameBooks1);						   									infoHash1.put("8", vid);						infoHash1.put("21",String.valueOf(account1.getAccountType()));						infoHash1.put("20",String.valueOf(account1.getDescription()));	   				primaryKey = 		qdb13.addRecord(accountsTableId, infoHash1);						System.out.println("primary key"+primaryKey);						System.out.println("After Insert");		   			}		   				System.out.println("Info Hash >> "+infoHash1);				}			else{	  			for (int i = 0; i< search1.getResultCount(); i++) 			{						account1.reset();		 				account1.setQBResponseAggregate(search1.getResultAggregate(i));		   			accountNameBooks = account1.getAccountName();		   			accountTypeBooks = account1.getAccountType();		   			strAccountTypeBooks = Integer.toString(accountTypeBooks);		   					   			accountDescBooks = account1.getDescription();		   			accountNumberBooks = account1.getAccountNumber();		   					   					   					   			//System.out.println("acc type from books**************"+strAccountTypeBooks);		   					   			//System.out.println("**Id**"+account1.getParentId());		   					   					   					   			parentName = account1.getParentName();		   			//System.out.println("**parent name**"+parentName);		   					   					   			//checking and adding parentname 		   			if(parentName.equals(null) || parentName.equals("")){		   			System.out.println("no parent");		   			accountNameBooks1 = accountNameBooks;		   			}		   		  else{		   		  	accountNameBooks1 = parentName + ":" + accountNameBooks ;		   		  	System.out.println("after appending**********"+accountNameBooks1);		   		  			   		  	}		   					   									int a=0;														   								for(int j = 0; j <= vector.size() - 1; j++)        {         		hashmap1 = (HashMap)vector.elementAt(j);            Iterator iterator = hashmap1.values().iterator();           	while (iterator.hasNext())            	{        /*   System.out.println("1"+(String)iterator.next());           	System.out.println("2"+(String)iterator.next());           	System.out.println("3"+(String)iterator.next());           	System.out.println("4"+(String)iterator.next());           	System.out.println("5"+(String)iterator.next());           	System.out.println("6"+(String)iterator.next());*/                     deactiveBooks = (String)iterator.next();                       // System.out.println("Accounts Primary Key"+headerID);                         headerID = (String)iterator.next();            	accountDescBase = (String)iterator.next();           	accountNameBase = (String)iterator.next();           	accountNumberBase = (String)iterator.next();           	accountTypeBase = (String)iterator.next();           	           	System.out.println("deactiveBooks"+deactiveBooks);           	System.out.println("accountDescBase"+accountDescBase);           	System.out.println("headerID"+headerID);           	//System.out.println("4"+(String)iterator.next());           	//System.out.println("5"+(String)iterator.next());           	//System.out.println("6"+(String)iterator.next());           			   			//System.out.println("*******************nam");			   				//System.out.println("account type in quick base********"+accountTypeBase);		   				// System.out.println("quickBase Acc Name"+accountNameBase);		   						   						   					 							   												//System.out.println("*****************account Name Books"+accountNameBooks1);																				  		  if(accountNameBase.equals(accountNameBooks1))				  		  {				  		 		System.out.println("equal******");				  		 		System.out.println("equal******"+accountNameBase);				  		 		System.out.println("equal******"+accountNameBooks1);				  		 						  		 				   			      activeFlag = account1.isIsActive();		   			      		   			      		   			      accountNumber = account1.getAccountNumber();		   			      		   			      System.out.println("***************account number from books"+accountNumber);		   					   		      	///System.out.println("is active****************"+activeFlag);		   		      	//System.out.println("*********deactivate books"+deactiveBooks);		   		      			   		      				  		 						  		 		if(activeFlag == true){				  		 						  		 			System.out.println("active flag is true***********");				  		 			System.out.println("deactiveBooks"+deactiveBooks);				  		 						  		 			if(deactiveBooks.equals("1") || deactiveBooks.equals("")){				  		 			System.out.println("***********deactivate");                        				System.out.println("Accounts Edit Hash table"+infoHash2);            				  		 			infoHash2.put("24","0");				  		 			primaryKey1 = qdb13.editRecord(accountsTableId, infoHash2,headerID );				  		 			System.out.println("Updated deactivate flag "+headerID);				  		 			}				  		 		}				  		 	else{				  		 			System.out.println("active flag is false***********");				  		 						  		 			if(deactiveBooks.equals("0") || deactiveBooks.equals("") ){				  		 			System.out.println("***********deactivate");				  		 			System.out.println("deactiveBooks"+deactiveBooks);				  		 			infoHash2.put("24","1");            System.out.println("Accounts Edit Hash table"+infoHash2);            				  		 			primaryKey1 = qdb13.editRecord(accountsTableId, infoHash2,headerID );				  		 			System.out.println("Updated deactivate flag "+headerID);				  		 			}				  		 						  		 		}				  		 						  		 		if(!(accountNumberBooks.equals(accountNumberBase))){				  		 		System.out.println("inside if"+accountNumberBase);				  		 		System.out.println("inside if"+accountNumberBooks);				  		 		System.out.println("account number not equal");				  		 		infoHash2.put("6",accountNumberBooks);                        System.out.println("Accounts Edit Hash table"+infoHash2);            				  		 		primaryKey1 = qdb13.editRecord(accountsTableId, infoHash2,headerID );				  		 		System.out.println("Updated account number "+headerID);	  		 						  		 				   		      	}				  		 		if(!(strAccountTypeBooks.equals(accountTypeBase))){				  		 						  		 		System.out.println("account type not equal");				  		 		infoHash2.put("21",strAccountTypeBooks);                        System.out.println("Accounts Edit Hash table"+infoHash2);            						  		 		primaryKey1 = qdb13.editRecord(accountsTableId, infoHash2,headerID );				  		 		System.out.println("Updated account type "+headerID);	  		 						  		 						  		 		}				  		 						  		 		if(!accountDescBase.equals(accountDescBooks)){				  		 	  	System.out.println("account desc not equal");				  		 		  infoHash2.put("20",accountDescBooks);            System.out.println("Accounts Edit Hash table"+infoHash2);            				  		 		  primaryKey1 = qdb13.editRecord(accountsTableId, infoHash2,headerID );				  		 		  System.out.println("Updated account desc "+headerID);				  		 		  }						  		 		  				  		 		  				  		 						  		 		//primaryKey = qdb12.editRecord(invoiceTableId, infoHash,headerID );				  		 		System.out.println("*****************inside If");				  		 						 			break;				  		  }				   		  else				   		  {		   				//	System.out.println("QuickBase Account Name "+accountNameBase);		   					//System.out.println("******Account Name from Books*****"+accountNameBooks);										   		  	a++;						  		//System.out.println("else" +a);							  		//System.out.println("vector.size()" +vector.size());							  		//System.out.println("d******************" +account1.getAccountType());						  		//System.out.println("**********a************"+a);						  		//System.out.println("***********//******"+vector.size());						  								  		if(a==vector.size())						  		{						  						  		  						  		  System.out.println("inside if");						   			infoHash1.put("6",String.valueOf(account1.getAccountNumber()));						   									   			//System.out.println("**account name**"+account1.getAccountName());						   			//System.out.println("**parent name**"+account1.getParentName());						   			infoHash1.put("7",accountNameBooks1);						   									   			infoHash1.put("8", vid);						   			infoHash1.put("21",String.valueOf(account1.getAccountType()));						   			infoHash1.put("20",String.valueOf(account1.getDescription()));						   			 if(activeFlag==true){									 infoHash1.put(String.valueOf(24),"0");									 }									 else{									 infoHash1.put(String.valueOf(24),"1");									 }	   								primaryKey = 		qdb13.addRecord(accountsTableId, infoHash1);										System.out.println("primary key"+primaryKey);										System.out.println("After Insert");						   			}				  		  }				   				  }//end if				}//end for		}// end for				/*Objsearch search2 = new Objsearch();		Account account2 = new Account();	      		account2.setQBConnectionString("URL='http://10.100.42.85:2080'");		search2.setQBConnectionString("URL='http://10.100.42.85:2080'");		search2.reset();		search2.setActiveStatus(3);		search2.setQueryType(19);		search2.search();*/				quickBooksCount = search1.getResultCount();		quickBaseCount = vector.size();		insertCount = (infoHash1.size())/6;		quickBaseCountInsert = quickBaseCount + insertCount;		System.out.println("quickBooksCount "+quickBooksCount);		System.out.println("quickBaseCount"+quickBaseCount);		System.out.println("quickBaseCountInsert "+quickBaseCountInsert);				if(quickBaseCount > quickBooksCount ){		Objsearch search2 = new Objsearch();		Account account2 = new Account();	      		account2.setQBConnectionString("URL='http://10.100.42.85:2080'");		search2.setQBConnectionString("URL='http://10.100.42.85:2080'");		search2.reset();		search2.setActiveStatus(3);		search2.setQueryType(19);		search2.search();				System.out.println("quick base  Count is greater");		for(int l = 0; l <= vector.size() - 1; l++)        {                 		hashmap2 = (HashMap)vector.elementAt(l);            Iterator iterator1 = hashmap2.values().iterator();            //System.out.println("**********"+l);           	while (iterator1.hasNext())            	{                      deactiveBooks = (String)iterator1.next();                                         headerID = (String)iterator1.next();            	accountDescBase = (String)iterator1.next();           	accountNameBase = (String)iterator1.next();           	accountNumberBase = (String)iterator1.next();           	accountTypeBase = (String)iterator1.next();           	//System.out.println("*********Name"+accountNameBase);           	int b = 0;           		for(int m = 0; m <= search2.getResultCount() - 1; m++){           		           		account2.reset();		 					account2.setQBResponseAggregate(search2.getResultAggregate(m));		   				accountNameBooks = account2.getAccountName();		   					parentName = account2.getParentName();		   					//System.out.println("**parent name**"+parentName);		   					   					   					//checking and adding parentname 		   					if(parentName.equals(null) || parentName.equals("")){		   					//System.out.println("no parent");		   					accountNameBooks1 = accountNameBooks;		   					}		   		  		else{		   		  		accountNameBooks1 = parentName + ":" + accountNameBooks ;		   		  		//System.out.println("after appending**********"+accountNameBooks1);		   		  		}		   					   				//	System.out.println("*********accountNameBooks"+accountNameBooks1);		   						   				if(accountNameBase.equals(accountNameBooks1))				  		  {				  		  break;				  		  }	           	else{	           		b++;	           	  //System.out.println("**********"+b);		           		if(b==search2.getResultCount()){	           		System.out.println("not equal");	           		System.out.println("accountNameBase"+accountNameBase);	           		System.out.println("accountNameBooks"+accountNameBooks1);	           		System.out.println("headerID"+headerID);	           		infoHash3.put("23","1");           	 		primaryKey1 = qdb13.editRecord(accountsTableId, infoHash3,headerID );				  		  System.out.println("Updated account desc "+headerID);	           			           		}	           		//System.out.println("*********not equal*");	           		}           		           		}           			   			}		   	}				}			System.out.println("Info Hash >> "+infoHash1);}	response.sendRedirect("https://docorganiz.quickbase.com/db/bes8a4tgn?a=q&qid=23&nv=1&v0=BK001");				%>