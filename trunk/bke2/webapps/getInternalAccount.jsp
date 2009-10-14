  <%@ page language="java" import="com.docorganiz5.domain.Lookup" %> 
  <%@ page buffer="128kb"%>                           
 	
 	<%
 			System.out.println("Inside getInternalAccount.jsp2");
 		String allocationId = request.getParameter("aId");
   	if(allocationId==null){
   		System.out.println("allocationId to getInternalAccount.jsp is Null >>>>> "+allocationId);
		}
		Lookup lookup = (Lookup)getServletContext().getAttribute("lookup");
   	String result1="";   
	
			try{
						result1=lookup.getInternalAccount(allocationId);
				}catch(Exception e){
					System.out.println("Exception at getInternalAccount.jsp2 here"+e.getMessage());
				}
				out.println(result1);
%>	
