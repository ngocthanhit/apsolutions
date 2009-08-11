<%@ include file="include.jsp" %>
<%@ page import="ibizqb.*"%>
<% title(out, "Add Purchase Order", "PO_Add", "po_add.jsp"); %>

<form method=post>
<center>
<table width="90%">
 <tr><td>Customer Name: <td><input type=text name=customername value="Teichman, Tim:Kitchen" size=40>
 <tr><td>Vendor Name:      <td><input type=text name=vendorname value="Daigle Lighting" size=40>
 <tr><td>PO Number  :      <td><input type=text name=refnumber value="0001" size=8>
 <tr><td>ShipTo Name:      <td><input type=text name=shipto value="Daigle Lighting" size=40>
 <tr><td>Transaction Date: <td><input type=text name=transdate value="2002-12-15" size=10>
 <tr><td>Expected Date: <td><input type=text name=expecteddate value="2002-12-17" size=10>
 <tr><td>Item Name: <td><input type=text name=itemname value="Fluorescent Ceiling Lighting" size=40>
 <tr><td>Description: <td><input type=text name=desc value="Test Item added by IBiz Integrator for QB" size=40>
 <tr><td>Quantity: <td><input type=text name=quantity value="2" size=10>
 <tr><td>Price (in cents): <td><input type=text name=rate value="3000" size=10>
 <tr><td>Connector Server: <td><input type=text name=server value="http://10.100.42.85:2080" size=40>

 <tr><td><td><input type=submit value="  Add!  ">

</table>
</center>
</form>

  <%
    
    if (request.getMethod().equalsIgnoreCase("POST")) {
	      final javax.servlet.jsp.JspWriter ps = out;
	      
	Purchaseorder purchaseorder1 = new Purchaseorder();
	purchaseorder1.setQBConnectionString("URL='" + request.getParameter("server") + "'");
	
	purchaseorder1.reset();
	purchaseorder1.setVendorName(request.getParameter("vendorname"));
	purchaseorder1.setRefNumber(request.getParameter("refnumber"));
	purchaseorder1.setShipToName(request.getParameter("shipto"));
	
	purchaseorder1.setTransactionDate(request.getParameter("transdate"));
	purchaseorder1.setExpectedDate(request.getParameter("expecteddate"));
	
	purchaseorder1.setItemCount(1);
	purchaseorder1.setItemName(0, request.getParameter("itemname"));
	purchaseorder1.setItemDescription(0, request.getParameter("desc"));
	purchaseorder1.setItemQuantity(0, Integer.parseInt(request.getParameter("quantity")));
	purchaseorder1.setItemCustomerName(0, request.getParameter("customername"));
	purchaseorder1.setItemAmount(0, Integer.parseInt(request.getParameter("quantity")) * Integer.parseInt(request.getParameter("rate")));
	purchaseorder1.add();
	
	%>
	
	<p>PO Added.<P>
	
	<table>
	<tr><td>Vendor Address: </td><td><%= purchaseorder1.getVendorAddress() %></td></tr>
	<tr><td>ShipTo Address: </td><td><%= purchaseorder1.getShippingAddress() %></td></tr>
	</table>
	
	<%
	}
	%>

<% trailer(out); %>