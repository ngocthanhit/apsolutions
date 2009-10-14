  <%@ page language="java" import="com.intuit.quickbase.util.*,com.bke2.util.Lookup" %> 
   <%@ page import="java.util.HashMap"%>
 
  <%@ page buffer="128kb"%>  
     
   <%
 

   String groupTableId = "bdy8ms9iq";
   ServletContext context = this.getServletContext();  
	
	String invoiceTableId = context.getInitParameter( "invoiceTableId" ); 
	String lineTableId = context.getInitParameter( "itemTableId" );
   

 	
   HashMap infoHash = new  HashMap();
   String tableId = request.getParameter("tb");  
   System.out.println("tableId>>>>> "+tableId );
   	
   	
   if(request.getParameter("c1")!=null){
   	System.out.println("c1>>>>> "+request.getParameter("c1")+"v1>>>>> "+request.getParameter("v1") );
   	infoHash.put(request.getParameter("c1"), request.getParameter("v1"));
	}
  
  if(request.getParameter("c2")!=null){
   	System.out.println("c2>>>>> "+request.getParameter("c2")+"v1>>>>> "+request.getParameter("v2") );
   	infoHash.put(request.getParameter("c2"), request.getParameter("v2"));
	}
	
  if(request.getParameter("c3")!=null){
   	System.out.println("c3>>>>> "+request.getParameter("c3")+"v1>>>>> "+request.getParameter("v3") );
   	infoHash.put(request.getParameter("c3"), request.getParameter("v3"));
	}
  
  if(request.getParameter("c4")!=null){
   	System.out.println("c4>>>>> "+request.getParameter("c4")+"v4>>>>> "+request.getParameter("v4") );
   	infoHash.put(request.getParameter("c4"), request.getParameter("v4"));
	}
  
  if(request.getParameter("c5")!=null){
   	System.out.println("c5>>>>> "+request.getParameter("c5")+"v5>>>>> "+request.getParameter("v5") );
   	infoHash.put(request.getParameter("c5"), request.getParameter("v5"));
	}
  
  if(request.getParameter("c6")!=null){
   	System.out.println("c6>>>>> "+request.getParameter("c6")+"v6>>>>> "+request.getParameter("v6") );
   	infoHash.put(request.getParameter("c6"), request.getParameter("v6"));
	}
  
  if(request.getParameter("c7")!=null){
   	System.out.println("c7>>>>> "+request.getParameter("c7")+"v7>>>>> "+request.getParameter("v7") );
   	infoHash.put(request.getParameter("c7"), request.getParameter("v7"));
	}

  if(request.getParameter("c8")!=null){
   	System.out.println("c8>>>>> "+request.getParameter("c8")+"v8>>>>> "+request.getParameter("v8") );
   	infoHash.put(request.getParameter("c8"), request.getParameter("v8"));
	}

 

 	Lookup lookup = (Lookup)getServletContext().getAttribute("lookup");
	
	System.out.println("After Lookup");
	
	
	String primaryKey ="";
	
		try{
		 
	 			//Insert Group
	 			/*
	  		if( (tableId!=null)&&(tableId.equals(groupTableId)) ) {
	  			System.out.println("Inserting Group");
	  			primaryKey = lookup.insertRecord(tableId, infoHash);
	  		}else 
	  		*/
	  		
	  		if( (tableId!=null)&&(tableId.equals(invoiceTableId)) ) {
	  			System.out.println("Inserting Invoice");
	  			primaryKey = lookup.insertRecord(tableId, infoHash);
	  		}else if( (tableId!=null)&&(tableId.equals(lineTableId)) ) {
	  			System.out.println("Inserting Line Item");
	  			primaryKey = lookup.insertRecord(tableId, infoHash);
	  		}
	  	
	  	}catch(Exception ebk1){
				
				System.out.println("Exception at here"+ebk1.getMessage());
				primaryKey =ebk1.getMessage();
				
		  }
	
	System.out.println("primaryKey "+primaryKey);		
	out.print(primaryKey);
  	
%>	
