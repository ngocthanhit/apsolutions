var xmlHttp;
var invoiceCount;
var vendorArrayVar;

function getVoucherNumber()
{ 
	//alert('IN get Voucher #  ');
		xmlHttp=GetXmlHttpObject();
		if (xmlHttp==null)
		  {
		  alert ("Your browser does not support AJAX!");
		  return;
		  } 
		var url="VoucherNumber.jsp";
		url=url+"?sid="+Math.random();
		xmlHttp.onreadystatechange=setVoucherNumber;
		xmlHttp.open("GET",url,true);
		xmlHttp.send(null);	
}

function setVoucherNumber() 
{ 
	if (xmlHttp.readyState==4)
	{ 
		alert('Ready'+xmlHttp.responseText);
		var resp=xmlHttp.responseText;
		resp=resp.trim();
		//alert('Ready'+resp);
		document.getElementById('voucher_no').value = resp;		
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

