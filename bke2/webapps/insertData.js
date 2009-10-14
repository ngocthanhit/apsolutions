var xmlHttp;

var groupTableId = "bdy8ms9iq";
//var invoiceTableId = "bd77scjia";
var lineTableId = "bd77scjib";

//GROUP
////var clientId_ColID = "14";

//INVOICE
////var groupId_ColID = "6";
var clientId_ColID = "82";

var vendorId_ColID = "18";
var invoiceNumber_ColID = "23";
var invoiceDate_ColID = "24";
var invoiceAmt_ColID = "26";
var invoiceDueDate_ColID = "25";
var invoiceStatus_ColID = "46";
var payAmt_ColID = "100";


//LINE
var headerId_ColID = "6"; //InvoiceId
var ln_ColID = "14";
var amount_ColID = "22";
var accountId_ColID = "28";
var lineDesc_ColID = "15";
var lineStatusId_ColID = "47";
var lineStatusTrail_ColID = "24"; //Status String


var tableId;
//var invCtrId;
var itemCount;
var agentCtrId;
var voucherNumber;
var invoiceNumber;
var approver;


var vendorId;
var invoiceNumber;
var invoiceDate;
var invoiceAmt;
var invoiceDueDate;
var invoiceStatus;

function addBKEValue(table, count)
{ 
	
	tableId=table;
	//invCtrId=invCtr;
	itemCount=count;
	//alert('in AddInfo itemCount '+itemCount+'table '+table);

	var url1="insertData.jsp?";
	/*
	var clientId = document.getElementById('clientId').value;

	if(table=="group"){
		url1 = url1+"tb="+groupTableId+"&c1="+clientId_ColID+"&v1="+clientId;
	}else	
	*/		
	
		if(table=="invoice"){

	var clientId = document.getElementById('clientId').value;
	vendorId = document.getElementById('vendorId').value;
	invoiceNumber	 = document.getElementById('invoiceNumber').value;
	invoiceDate	 = document.getElementById('invoiceDate').value;
	invoiceAmt	 = document.getElementById('invoiceAmt').value;
	invoiceDueDate	 = document.getElementById('invoiceDueDate').value;
	invoiceStatus	 = document.getElementById('status').value;
	var payAmt	 = document.getElementById('payAmt').value;
	invoiceTableId = document.getElementById('invoiceTableId').value;
	
		url1 = url1+"tb="+invoiceTableId+"&c1="+clientId_ColID+"&v1="+clientId+"&c2="+vendorId_ColID+"&v2="+vendorId;
		url1 = url1+"&c3="+invoiceNumber_ColID+"&v3="+invoiceNumber+"&c4="+invoiceDate_ColID+"&v4="+invoiceDate;
		url1 = url1+"&c5="+invoiceAmt_ColID+"&v5="+invoiceAmt+"&c6="+invoiceDueDate_ColID+"&v6="+invoiceDueDate;
		//url1 = url1+"&c7="+invoiceStatus_ColID+"&v7="+invoiceStatus;
		url1 = url1+"&c8="+payAmt_ColID+"&v8="+payAmt;
	
		
	}else	if(table=="line"){
	
	var lineItemInvoiceId = document.getElementById('invoiceId').value;
	var lineNumber = document.getElementById('lineNumber'+itemCount).value;
	var lineItemAmt = document.getElementById('lineItemAmt'+itemCount).value;
	var accountId = document.getElementById('accountId'+itemCount).value;
	//var accountNumber = document.getElementById('accountNumber'+itemCount).value;
	//var accountName	 = document.getElementById('accountName'+itemCount).value;
	var lineItemDesc	= document.getElementById('lineItemDesc'+itemCount).value;
	var lineStatus	= document.getElementById('lineStatus'+itemCount).value;
	
		url1 = url1+"tb=bd77scjib&c1="+headerId_ColID+"&v1="+lineItemInvoiceId+"&c2="+ln_ColID+"&v2="+lineNumber;
		url1 = url1+"&c3="+amount_ColID+"&v3="+lineItemAmt+"&c4="+accountId_ColID+"&v4="+accountId;
		url1 = url1+"&c5="+lineDesc_ColID+"&v5="+lineItemDesc+"&c6="+lineStatusTrail_ColID+"&v6="+lineStatus;
		//url1 = url1+"&c7="+invoiceStatus_ColID+"&v7="+invoiceStatus;
	
	}
	
	
	
	  //alert(url1);	
		executeURL1(url1);
}


//var scriptVar="";
function setBKEPrimaryKey() 
{ 
	 //alert('In setBKEPrimaryKey() ');
	
	if (xmlHttp.readyState==4)
	{ 
		//alert('Ready'+xmlHttp.responseText);
		var resp=xmlHttp.responseText;
		resp=resp.trim();
		
		/*
		if(tableId=="group"){
			//alert('in vucher');	
			if(resp.length<15){	
				//alert('setting Voucher Id'+resp);
				//document.getElementById('errorMessage').innerHTML='setting Group Id'+resp;		
			}else if(resp.length>15){
				//alert('Error in setting Voucher Id'+resp);
				document.getElementById('errorMessage').innerHTML=resp;				
			}
		}else	
		*/	
		if(tableId=="invoice"){
			//alert('in vucher');	
			if(resp.length<15){	
				//alert('setting Voucher Id'+resp);
				document.getElementById('invoiceId').value=resp;			
				//document.getElementById('errorMessage').innerHTML='setting Group Id'+resp;		
			}else if(resp.length>15){
				//alert('Error in setting Voucher Id'+resp);
				document.getElementById('errorMessage').innerHTML=resp;				
			}		
		}else	if(tableId=="line"){
			//alert('in vucher');	
			if(resp.length<15){	
				//alert('setting Voucher Id'+resp);
				document.getElementById('lineItemId'+itemCount).value=resp;			
				//document.getElementById('errorMessage').innerHTML='setting Group Id'+resp;		
			}else if(resp.length>15){
				//alert('Error in setting Voucher Id'+resp);
				document.getElementById('errorMessage').innerHTML=resp;				
			}		
		}
		
	}
}


function executeURL1(url1)
{ 
	
	//alert('url1 >>  '+url1);
		xmlHttp=GetXmlHttpObject4BKE1AddValue();
		if (xmlHttp==null)
		  {
		  document.getElementById('errorMessage').innerHTML="Your browser does not support DocOrganiz funtions.";
		  return;
		  }
		   
		url1=url1+"&sid="+Math.random();
		//url=url+"&cId="+clientId+"&type=vId";
		//alert('URL '+url);
		xmlHttp.onreadystatechange=setBKEPrimaryKey;
		xmlHttp.open("GET",url1,false);
		xmlHttp.send(null);	
}


function GetXmlHttpObject4BKE1AddValue()
{
var xmlHttp=null;
try
  {
  // Firefox, Opera 8.0+, Safari
  xmlHttp=new XMLHttpRequest();
  }
catch (e)
  {
  // Internet Explorer
  try
    {
    xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }
  catch (e)
    {
    xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
  }
return xmlHttp;
} 





