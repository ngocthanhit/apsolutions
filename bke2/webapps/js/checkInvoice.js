var xmlHttp
var voucher
var invoiceNumber

function checkInvoice(vendor, inv)
{ 

//alert('check Invoice ');
		
//	alert(vendor.value+'  '+inv.value);
	var vId = vendor;	
	invoiceNumber = inv;
	var invValue = inv;
	if(invValue.length>0){
		//alert('IN CHECKVOUCHER .js '+str)
		xmlHttp=GetXmlHttpObject();
		if (xmlHttp==null)
		  {
		  	alert ("Your browser does not support AJAX!");
		  	return;
		  } 
		var url="checkInvoice.jsp";
		url=url+"?vendorId="+vId+"&invoiceNumber="+invValue;
		url=url+"&sid="+Math.random();
		xmlHttp.onreadystatechange=stateChanged1;
		//pausecomp(300);
		xmlHttp.open("GET",url,false);
		xmlHttp.send(null);	
	}	
	
}


function getActivateChoiceFlag(billId)
{ 

//alert('check Invoice ');
		
//	alert(vendor.value+'  '+inv.value);
		if(billId.length>0){
		//alert('IN CHECKVOUCHER .js '+str)
		xmlHttp=GetXmlHttpObject();
		if (xmlHttp==null)
		  {
		  	alert ("Your browser does not support AJAX!");
		  	return;
		  } 
		var url="checkVoucher.jsp";
		url=url+"?billId="+billId;
		url=url+"&sid="+Math.random();
		xmlHttp.onreadystatechange=getChoiceFlag;
		//pausecomp(300);
		xmlHttp.open("GET",url,false);
		xmlHttp.send(null);	
	}	
	
}


function getChoiceFlag() 
{
		//alert('Here stateChanged1');

	if (xmlHttp.readyState==4)
	{ 
	
		var resp=xmlHttp.responseText;
		resp=resp.trim();
		//alert('Ready'+resp);
		document.getElementById('activateFlag').value =resp;
		
	}
}


function stateChanged1() 
{
		//alert('Here stateChanged1');

	if (xmlHttp.readyState==4)
	{ 
	
		var resp=xmlHttp.responseText;
		resp=resp.trim();
		//alert('Ready'+resp);
	
		if(eval(resp)){
//			alert('Ready'+resp);
			document.getElementById('errorStatus').value = "1";
			document.getElementById('errorMessage').innerHTML="You have entered a Duplicate Invoice Number for this Vendor.";
			//invoiceNumber.focus();
			//document.getElementById('invoiceNumber').focus();
			document.getElementById('invoiceNumber').style.backgroundColor='red';
			//return false;
		}else{
			document.getElementById('invoiceNumber').backgroundColor='white';
			document.getElementById('errorStatus').value = "0";
			document.getElementById('errorMessage').innerHTML="";
		}


	}
}
 

function GetXmlHttpObject()
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

