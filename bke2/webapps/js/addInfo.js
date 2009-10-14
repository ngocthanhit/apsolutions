var xmlHttp;

var groupTableId = "bdy8ms9iq";



var tableId;
var invCtrId;
var allocCtrId;
var agentCtrId;
var voucherNumber;
var invoiceNumber;
var approver;


function addValue1(table, allocCtr)
{ 
	
	tableId=table;
	allocCtrId=allocCtr;
	var url1="insertData.jsp?";
	var clientId = document.getElementById('clientId').value;

	if(table=="group"){

		url1 = url1+"tb="+groupTableId+"&c1=14&v1="+clientId;
		
	}
	
	//alert('url1 >>  '+url1);
		xmlHttp=GetXmlHttpObject4BKE1AddValue();
		if (xmlHttp==null)
		  {
		  alert ("Your browser does not support AJAX!");
		  return;
		  }
		   
		url1=url1+"&sid="+Math.random();
		//url=url+"&cId="+clientId+"&type=vId";
		//alert('URL '+url);
		xmlHttp.onreadystatechange=setAddedPrimaryKey;
		xmlHttp.open("GET",url1,true);
		xmlHttp.send(null);	
}


//var scriptVar="";
function setAddedPrimaryKey() 
{ 
	if (xmlHttp.readyState==4)
	{ 
		alert('Ready'+xmlHttp.responseText);
		var resp=xmlHttp.responseText;
		resp=resp.trim();
		
		if(tableId=="group"){
			//alert('in vucher');	
			if(resp.length<15){	
				//alert('setting Voucher Id'+resp);
				document.getElementById('invoiceGroupId').value=resp;		
				document.getElementById('errorMessage').innerHTML=resp;
				
			}else if(resp.length>15){
				//alert('Error in setting Voucher Id');
				document.getElementById('errorMessage').innerHTML=resp;
				
			}
				
		}
		
		
	}
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





/*
var xmlHttp;
var groupTableId = "bdy8ms9iq";
var invoiceTableId = "bdy8mtn9n";
var allocationTableId = "bdy8mtz5c";


var tableId;
var invCtrId;
var allocCtrId;
var agentCtrId;
var voucherNumber;
var invoiceNumber;
var approver;


	
var invoiceNumberObject; 

function addValue(table, invCtr, allocCtr)
{ 
	
	tableId=table;
	invCtrId=invCtr;
	allocCtrId=allocCtr;
	//alert('in AddInfo invCtr '+invCtr+'allocCtr '+allocCtr);

	//invoiceNumberObject = eval("document.getElementById('invoice_no'+invCtr)");
	//alert("inside addValue in addInfo.js");
	var url1="addInfo.jsp?";
	//	var url1="addGroupInfo.jsp?";
	//voucherNumber = document.getElementById('voucher_no').value;	
	//var vendorId = document.getElementById('vendorId').value;
	//var voucher_date = document.getElementById('voucher_date').value;
	//var process_status = document.getElementById('process_status').value;
	//var groupIdPK = document.getElementById('groupIdPK').value;	
	//var vComm = document.getElementById('voucherComm').value;	
	//alert('Ready for add Voucher');
	//var voucherId = document.getElementById('voucherId').value;
	//var approver = document.getElementById('approver').value;
	//alert('voucherNumber   '+voucherNumber);
		var clientId = document.getElementById('clientId').value;

	if(table=="group"){

		url1 = url1+"tb="+groupTableId+"&c1=14&v1="+clientId;

		//url = url+"tb="+voucherTableId+"&c1=22&v1="+vendorId+"&c2=8&v2="+voucherNumber+"&c3=9&v3="+voucher_date+"&c4=88&v4="+process_status+"&c5=66&v5="+approver; //+"&c6=30&v6="+voucher_date;
		//alert('Ready for add Voucher');
		//url = url+"tb="+voucherTableId+"&c1=22&v1="+document.getElementById('vendorId').value+"&c2=8&v2="+voucherNumber+"&c3=9&v3="+document.getElementById('voucher_date').value+"&c4=27&v4="+document.getElementById('process_status').value;
		//url = url+"&v7="+document.getElementById('groupIdPK').value;
		//alert('URL1   '+url1);
	}
	
	
	else if(table=="invoice"){ 	
		url = url+"tb="+invoiceTableId+"&c1=9&v1="+document.getElementById('invoice_no'+invCtr).value+"&c2=8&v2="+document.getElementById('invoice_date'+invCtr).value+"&c3=106&v3="+voucherId+"&c4=112&v4="+vendorId;	
		//alert(url);
	}
	else if(table=="allocation"){ 
		//alert('inside allocation of addInfo.js');
		var invoiceId = document.getElementById('invoiceId'+invCtr).value;
		var lineNumber = document.getElementById('lineNumber'+invCtr+'l'+allocCtr).value;
		var desc = document.getElementById('description'+invCtr+'l'+allocCtr).value;
		var cd1 = document.getElementById('cd1'+invCtr+'l'+allocCtr).value;
		var cd2 = document.getElementById('cd2'+invCtr+'l'+allocCtr).value;
    var cd3 = document.getElementById('cd3'+invCtr+'l'+allocCtr).value;
		var purchaseAmount = document.getElementById('purchase_amt'+invCtr+'l'+allocCtr).value;
		//AAurl = url+"tb="+allocationTableId+"&c1=8&v1="+purchaseAmount+"&c2=97&v2="+cd1+"&c3=25&v3="+cd2+"&c4=9&v4="+invoiceId+"&c5=114&v5="+cd3+"&c6=43&v6="+lineNumber+"&c7=44&v7="+description;
		url = url+"tb="+allocationTableId+"&c1=8&v1="+purchaseAmount+"&c2=97&v2="+cd1+"&c3=25&v3="+cd2+"&c4=9&v4="+invoiceId+"&c5=43&v5="+lineNumber+"&c6=44&v6="+desc+"&c7=114&v7="+cd3;
		//alert(url);
	}
	
	
	xmlHttp=GetXmlHttpObject5AddInfo();
	if (xmlHttp==null)
	{
	  alert ("Your browser does not support AJAX!");
	  return;
	}
	
	//alert("Before URL");
	url1=url1+"&sid="+Math.random();
	xmlHttp.onreadystatechange=addInfo;
	xmlHttp.open("GET",url1,true);
	xmlHttp.send(null);
} 


function addInfo() 
{ 
	
	alert('Ready'+xmlHttp.responseText);
	
	if (xmlHTTP.readyState == 3)
    {
        alert(xmlHTTP.responseText);
    }



	if (xmlHttp.readyState==4)
	{ 
		alert('Ready'+xmlHttp.responseText);
		var resp=xmlHttp.responseText;
		resp=resp.trim();


		if(tableId=="group"){
			//alert('in vucher');	
			if(resp.length<15){	
				alert('setting Voucher Id'+resp);
				document.getElementById('invoiceGroupId').value=resp;		
				
			}else if(resp.length>15){
				//alert('Error in setting Voucher Id');
				document.getElementById('errorMessage').innerHTML=resp;
				document.getElementById('voucher_no').style.backgroundColor='red';
				
			}
				
		}
		
		else if(tableId=="invoice"){			
			var invoiceIdVar = document.getElementById('invoiceId'+invCtrId);
			if(resp.length>15){

				document.getElementById('errorMessage').innerHTML=resp;
				invoiceNumberObject.focus();
				//invoiceNumberObject.style.backgroundColor='red';
				document.getElementById('errorMessageHidden').value=resp;
			
			}else if(resp.length<15){
				document.getElementById('errorMessage').innerHTML="";
				//invoiceNumberObject.style.backgroundColor='white';
				//alert('invoiceIdVar'+invoiceIdVar.value);
				//alert('invoiceId'+invCtrId+' value '+resp);
				document.getElementById('invoiceId'+invCtrId).value=resp;
				document.getElementById('errorMessageHidden').value=resp;
				//alert('invoiceIdVar'+invoiceIdVar.value);	
				pausecomp(500);
			}
		
		} else if(tableId=="allocation"){
//alert('Response from Add Allocation .jsp ---> '+resp);
				document.getElementById('allocationId'+invCtrId+'l'+allocCtrId).value=resp;
//alert('Allocation ID value from FORM '+document.getElementById('allocationId'+invCtrId+'l'+allocCtrId).value);
				
		}else if(tableId=="agent"){
				//alert('Response from Add Agent .jsp '+resp);
				document.getElementById('agentId'+agentCtrId).value=resp;
				//alert('Agent ID value set  '+document.getElementById('agentId'+agentCtrId).value);
				
		}			
		
	}
}

function GetXmlHttpObject5AddInfo()
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
*/
