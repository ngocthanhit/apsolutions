<%@ include file="include.jsp" %>
<%@ page import="ibizqb.*"%>
<% //title(out, "Vendor Query", "Vendor", "vendorquery.jsp"); %>


<form method=post>
<center>
<table width="90%">

 <tr><td> <td><input type=hidden name=vendor value="" size=40>
 <tr><td><td><input type=hidden name=server value="http://10.100.42.85:2080" size=40>

 <tr><td><td><input type=submit value="  Import new vendors associated to Company AA  ">

</table>
</center>
</form>

  <%
    
    if (request.getMethod().equalsIgnoreCase("POST")) {
	    final javax.servlet.jsp.JspWriter ps = out;

		Objsearch search1 = new Objsearch();
		Vendor vendor1 = new Vendor();	      

		vendor1.setQBConnectionString("URL='" + request.getParameter("server") + "'");
		search1.setQBConnectionString("URL='" + request.getParameter("server") + "'");
		search1.reset();
		search1.setQueryType(1);
		
		search1.setNameContains(request.getParameter("vendor"));
		
		//Only return a maximum of 40 results
		search1.setMaxResults(40);
		
		search1.search();
		%>
		
		<TABLE width=50%>
		<TR>
		<TD>Vendor Name</TD><TD>Company Name</TD><TD>Account Number</TD><TD>Vendor Type</TD><TD>Payment Terms</TD><TD>Credit Limit</TD><TD>Is Inactive</TD>
		</TR>
		
		<%
		for (int i = 0; i< search1.getResultCount(); i++) {
		   vendor1.reset();
		   vendor1.setQBResponseAggregate(search1.getResultAggregate(i));
		   %>
		   
		<TR><TD><%=vendor1.getVendorName()%></TD><TD><%=vendor1.getCompanyName()%></TD><TD><%=vendor1.getAccountNumber()%></TD><TD><%=vendor1.getVendorTypeName()%></TD><TD><%=vendor1.getTermsName()%></TD><TD><%=vendor1.getCreditLimit()%></TD><TD><%=vendor1.isIsActive()%></TD> </TR>
		
		<%
		} //end for
		
		%>
		
		</TABLE>
			
			<%
			}
			%>

<% //trailer(out); %>