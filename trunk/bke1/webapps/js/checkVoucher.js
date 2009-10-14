var xmlHttp
var voucher
var invoiceNumber


function checkVoucher(obj)
{ 
voucher = obj;
//alert('IN CHECKVOUCHER .js '+obj.value)
var str = obj.value;
	if(str.length>1){
		//alert('IN CHECKVOUCHER .js '+str)
		xmlHttp=GetXmlHttpObject();
		if (xmlHttp==null)
		  {
		  alert ("Your browser does not support AJAX!");
		  return;
		  } 
		var url="checkVoucher.jsp";
		url=url+"?voucherNumber="+str;
		url=url+"&sid="+Math.random();
		xmlHttp.onreadystatechange=stateChanged;
		xmlHttp.open("GET",url,true);
		xmlHttp.send(null);
	}	
}


function stateChanged() 
{ 
	if (xmlHttp.readyState==4)
	{ 
		//alert('Ready'+xmlHttp.responseText);
		var resp=xmlHttp.responseText;
		resp=resp.trim();
		//alert('Ready'+resp);

			if(eval(resp)){
				//alert('Ready'+resp);
				voucher.style.backgroundColor='red';
				document.getElementById('errorMessage').innerHTML="You have entered a Duplicate Voucher Number.  Please Replace the Voucher #, or Terminate Processing of this Voucher.";
			}else{
				voucher.style.backgroundColor='white';
				document.getElementById('errorMessage').innerHTML="";	
			}

		//document.getElementById("ajaxresponse").value=resp;
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

