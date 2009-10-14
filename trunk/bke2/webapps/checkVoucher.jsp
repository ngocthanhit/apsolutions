  <%@ page language="java" import="com.intuit.quickbase.util.*,com.bke2.util.Lookup" %> 
   <%@ page import="java.util.HashMap"%>
 <%@ page import="java.util.Vector"%>
 
  <%@ page buffer="128kb"%>  
     
   <%
   String billId = request.getParameter("billId");


 		Lookup lookup = (Lookup)getServletContext().getAttribute("lookup");
	
		System.out.println("After Lookup  billId is >>"+billId);
		
   ServletContext context = this.getServletContext();  
	
	String invoiceTableId = context.getInitParameter( "invoiceTableId" ); 
	
	
	String message ="";
	
		try{
		 
		 
	 			//Insert Group
	  		if( (billId!=null)) {
						
						Vector resultBillVector =lookup.getEditInfo(invoiceTableId,  "{'3'.EX."+billId+"}", "106", "", "");

						// Get HashMap from Vector
						HashMap hashmap4Bill = (HashMap)resultBillVector.elementAt(0);
				//		Iterator itKey = null;
 						// Iterate over the keys in the map
  			//		if(hashmap4Bill!=null){  
  						//itKey = hashmap4Bill.keySet().iterator();
							message = (String)hashmap4Bill.get(hashmap4Bill.keySet().iterator().next());
							System.out.println("Flag is >>>> "+message);
				//		}
			
	  		}else {
	  			message ="Internal error caused by the fact billId being NULL";
	  		}
	  	}catch(Exception ebk1){
					//System.out.println("Exception at here"+ebk1.getMessage());
					message =ebk1.getMessage();
		  }
	
	out.print(message);
  	
%>	
   	
  