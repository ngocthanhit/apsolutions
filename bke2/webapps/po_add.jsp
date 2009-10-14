<%@ include file="include.jsp" %>
<%@ page import="ibizqb.*"%>
<% //title(out, "Add Purchase Order", "PO_Add", "po_add.jsp"); %>

<form method=post>
<center>
	
<table width="90%">
	
 <tr><td><h2>Export to Quickbooks: <td>
	<!--
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
-->
 <tr><td>Vendor Name: <td><input type=text name=vendorname value="" size=40>
 <tr><td>Acct. No:      <td><input type=text name=accountnumber value="" size=40>
 <tr><td>Terms  :      <td><input type=text name=terms value="Net 60" size=8>
 <tr><td>Invoice Number  :      <td><input type=text name=invoicenumber value="0001" size=8>
 <tr><td>Invoice Date: <td><input type=text name=invoicedate value="8/16/2009" size=10>
 <tr><td>Total Number of Expenses  :      <td><input type=text name=expensecount value="2" size=4>
 <tr><td>Invoice Due Date: <td><input type=text name=invoiceduedate value="10/15/2009" size=10>
 	
 <tr><td>Line Item 1: <td>
 <tr><td>Account Name: <td><input type=text name=accountname1 value="Cost Of Revenue" size=40>
 <tr><td>Amount: <td><input type=text name=amount1 value="" size=40>
 <tr><td>Description: <td><input type=text name=memo1 value="Test Item 1 added by IBiz Integrator for QB" size=40>
 
 <tr><td>Line Item 2: <td>
 <tr><td>Account Name: <td><input type=text name=accountname2 value="Cost Of Revenue" size=40>
 <tr><td>Amount: <td><input type=text name=amount2 value="" size=40>
 <tr><td>Description: <td><input type=text name=memo2 value="Test Item 2 added by IBiz Integrator for QB" size=40>
 	
 	
 	
 	
 	
 <tr><td>Connector Server: <td><input type=text name=server value="http://10.100.42.85:2080" size=40>


 <tr><td><td><input type=submit value="  Add!  ">

</table>
</center>
</form>

  <%
    
    
	      final javax.servlet.jsp.JspWriter ps = out;
	      /*
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
	*/
	
	Bill bill1 = new Bill();
	bill1.setQBConnectionString("URL='" + request.getParameter("server") + "'");
	
	bill1.reset();
	bill1.setVendorName(request.getParameter("vendorname"));
	//bill1.setVendorName("Ameritel");
	
	bill1.setMemo(request.getParameter("accountnumber"));
	bill1.setTermsName(request.getParameter("terms"));
	bill1.setRefNumber(request.getParameter("invoicenumber"));
	bill1.setTransactionDate(request.getParameter("invoicedate"));
	bill1.setExpenseCount(2);
	bill1.setDueDate(request.getParameter("invoiceduedate"));
	
	//bill1.setItemCount(0);
	
	//line item 1
	bill1.setExpenseAccountName(0, request.getParameter("accountname1"));
	bill1.setExpenseAmount(0, 100000);
	bill1.setExpenseMemo(0, request.getParameter("memo1"));
	
	
	//line item 2
	
	bill1.setExpenseAccountName(1, request.getParameter("accountname2"));
	bill1.setExpenseAmount(1, 200000);
	bill1.setExpenseMemo(1, request.getParameter("memo2"));
	
	bill1.add();
	
	
	%>
	
	<p>Bill Added.<P>
	
	<table>
	</table>
	
	

<% //trailer(out); %>