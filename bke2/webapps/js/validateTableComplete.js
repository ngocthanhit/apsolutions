
function isVoucherComplete()
{ 
	//alert('1');
	if(document.getElementById('clientId').value.length==0) return false;
	
	//else if(document.getElementById('vendorName').value.length==0) return false;
	//else if(document.getElementById('voucher_no').value.length==0)  return false;
	//else if(document.getElementById('voucher_date').value.length==0)  return false;
	//else if(document.getElementById('process_status').value.length==0)  return false;
	//else if(document.getElementById('approver').value.length==0)  return false;
//alert('2');
	return true;
}


function isInvoiceComplete()
{ 	
	if(document.getElementById('vendor').value.length==0) return false;
	else if(document.getElementById('invoiceNumber').value.length==0) return false;
	else if(document.getElementById('invoiceDate').value.length==0)  return false;
	else if(document.getElementById('invoiceAmt').value.length==0)  return false;
	else if(document.getElementById('invoiceDueDate').value.length==0)  return false;
	else if(document.getElementById('status').value.length==0)  return false;
	return true;	
}


function isLineItemComplete(count)
{ 	
	if(document.getElementById('lineItemAmt'+count).value.length==0) return false;
	//else if(document.getElementById('accountNumber'+count).value.length==0) return false;
	else if(document.getElementById('accountName'+count).value.length==0)  return false;
	//else if(document.getElementById('lineItemDesc'+count).value.length==0)  return false;
	//else if(document.getElementById('lineStatus'+count).value.length==0)  return false;
	//else if(document.getElementById('status').value.length==0)  return false;
	return true;	
}

