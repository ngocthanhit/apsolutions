var xmlHttp;

var groupTableId = "bdy8ms9iq";		

//GROUP
var clientId_ColID = "14";
var url1;
var clientId;
function insertGroup(clientId)
{ 
		
		clientId = document.getElementById('clientId').value;

	//alert('IN get Voucher #  ');
		xmlHttp=GetGroupXmlHttpObject();
		if (xmlHttp==null)
		  {
		  alert ("Your browser does not support AJAX!");
		  return;
		  } 
			
		url1 = "insertGroup.jsp?tb="+groupTableId+"&c1="+clientId_ColID+"&v1="+clientId;
		url1=url1+"&sid="+Math.random();
		alert('URL '+url1);
		xmlHttp.onreadystatechange=setGroupId;
		xmlHttp.open("GET",url1,true);
		xmlHttp.send(null);	
}


var scriptVar="";

function setGroupId() 
{ 
	
		alert('Ready'+xmlHttp.responseText);
	if (xmlHttp.readyState==4)
	{ 
		alert('Ready'+xmlHttp.responseText);
		var resp=xmlHttp.responseText;
		resp=resp.trim();
			
			if(resp.length<15){	
				document.getElementById('invoiceGroup').value=resp;			
				document.getElementById('errorMessage').innerHTML='setting Group Id'+resp;		
			}else if(resp.length>15){
				//alert('Error in setting Voucher Id'+resp);
				document.getElementById('errorMessage').innerHTML=resp;				
			}
	}
}


function GetGroupXmlHttpObject()
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


