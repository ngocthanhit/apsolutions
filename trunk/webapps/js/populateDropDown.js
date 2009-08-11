var xmlHttp;
var invoiceCount;
var vendorArrayVar="";
		
function populateAllDropDown(clientId)
{ 
		populateVendor(clientId);
}

function populateVendor(clientId)
{ 
	//alert('IN get Voucher #  ');
		xmlHttp=GetVendorArrayXmlHttpObject();
		if (xmlHttp==null)
		  {
		  alert ("Your browser does not support AJAX!");
		  return;
		  } 
		var url="PopulateDropDown.jsp?sid="+Math.random();
		url=url+"&cId="+clientId+"&type=vId";
		//alert('URL '+url);
		xmlHttp.onreadystatechange=setVendorArray;
		xmlHttp.open("GET",url,false);
		xmlHttp.send(null);	
}


var scriptVar="";
function setVendorArray() 
{ 
	if (xmlHttp.readyState==4)
	{ 
		//alert('Ready'+xmlHttp.responseText);
		var resp=xmlHttp.responseText;
		resp=resp.trim();
		//vendorArrayVar=resp;
		eval(resp);
	}
}


function GetVendorArrayXmlHttpObject()
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


