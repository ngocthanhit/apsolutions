var voucherTableId = "bdy8ms9iq";
var invoiceTableId = "bd77scjia";
var allocationTableId = "bd77scjib";



var agentTableId = "bdyvk9utf";
var userInfoTableId = "bdyvk9utt";	
var invoiceNumberCID=9;

var currentTableId;
var currentColumnId;
var invoiceNumberObject;

function editValue(field, columnId, tableId, tablePK)
{ 

	//alert("inside");
	currentTableId=tableId;
	currentColumnId= columnId;

	if(field.length>0){
		//alert('IN EDITINFO.js === '+field)
		xmlHttp=GetXmlHttpObject4EditInfo();
				//GetXmlHttpObject();
		if (xmlHttp==null)
		  {
		 // alert ("Your browser does not support AJAX!");
		  return;
		  } 
		var url="editInfo.jsp";
		//alert("Before URL");
		url=url+"?field="+field+"&columnId="+columnId+"&tableId="+tableId+"&tablePK="+tablePK;
		//alert('url'+url);
		if( ( currentTableId==invoiceTableId )&&(columnId==invoiceNumberCID) ){
			var invCtr =document.getElementById('currentInvoiceCount').value;
			//alert('invCtr'+invCtr);
			invoiceNumberObject = document.getElementById('invoice_no'+invCtr);
			//alert('current ivoice Couter is '+invCtr+' invoiceNumberObject.value =  '+invoiceNumberObject.value  );
			url=url+"&vId="+document.getElementById('vendorId').value;	
			//alert('url'+url);
		}
		//alert('url'+url);
		
		url=url+"&sid="+Math.random();
		xmlHttp.onreadystatechange=edited;
		xmlHttp.open("GET",url,true);
		xmlHttp.send(null);
	}	
}

function edited() 
{ 
	if (xmlHttp.readyState==4)
	{ 
		//alert('Ready'+xmlHttp.responseText);
		var resp=xmlHttp.responseText;
		resp=resp.trim();
		//alert('Ready1');
		if(currentTableId==userInfoTableId){
		//alert('Ready1111');
			if(resp.length>15){
				document.getElementById('errorMessage').innerHTML=resp;
				document.getElementById('voucher_no').focus();
				document.getElementById('voucher_no').style.backgroundColor='red';
			}else if(resp.length<15){
				document.getElementById('errorMessage').innerHTML="";
				document.getElementById('voucher_no').style.backgroundColor='white';
			}
		}else if( (currentColumnId=='9')&&(currentTableId==invoiceTableId) ){
		//alert('Ready2222');
			if(resp.length>15){
				document.getElementById('errorMessage').innerHTML=resp;
				invoiceNumberObject.focus();
				invoiceNumberObject.style.backgroundColor='red';
				document.getElementById('errorMessageHidden').value=resp;
			}else if(resp.length<15){
				document.getElementById('errorMessage').innerHTML="";
				invoiceNumberObject.style.backgroundColor='white';
				document.getElementById('errorMessageHidden').value=resp;
			}
		}else{
		//alert('Ready3');
		
			
			if(resp.length>15){
				document.getElementById('errorMessage').innerHTML=resp;			
						
			}else{
				document.getElementById('errorMessage').innerHTML="";
				
			}
		}
		
	}
}

function GetXmlHttpObject4EditInfo()
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

