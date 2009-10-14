function refreshLookup()
{ 
	alert("inside addInfo.js");
	var url="refresh.jsp";
	//alert('IN EDITINFO.js === '+field)
	xmlHttp=GetXmlHttpObject2();
	if (xmlHttp==null)
	{
	  alert ("Your browser does not support AJAX!");
	  return;
	}
	
	//alert("Before URL");
	//url=url+"&sid="+Math.random();
	xmlHttp.onreadystatechange=refreshed;
	xmlHttp.open("GET",url,true);
	xmlHttp.send(null);
} 


function refreshed() 
{ 
	if (xmlHttp.readyState==4)
	{ 
		//alert('Ready'+xmlHttp.responseText);
		var resp=xmlHttp.responseText;
		resp=resp.trim();
		alert('Ready'+resp);
		return true;
	}
}

function GetXmlHttpObject2()
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


