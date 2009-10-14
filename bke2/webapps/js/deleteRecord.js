function deleteRecord(tableId,tablePK)   
{ 
	//alert("Agent tableId"+ tableId);
        //alert("Agent tablePK"+ tablePK);     
        if(tablePK.length>1){
		//alert('IN deleteRecord.js === '+tablePK)
		xmlHttp=GetXmlHttpObject();
		if (xmlHttp==null)
		  {
		  alert ("Your browser does not support AJAX!");
		  return;
		  } 
		var url="deleteAgentRecord.jsp";
		//alert("Before URL");
		url=url+"?tableId="+tableId+"&tablePK="+tablePK;                                        
		url=url+"&sid="+Math.random();
		xmlHttp.onreadystatechange=edited;
		xmlHttp.open("GET",url,true);
		xmlHttp.send(null);
                //alert("Final");
	}	   
}


function deleteAllocRecord(tableId,tablePK)   
{ 
	alert("Agent tableId"+ tableId);
        alert("Agent tablePK"+ tablePK);     
        if(tablePK.length>1){
		alert('IN deleteAllocRecord.js === '+tablePK)
		xmlHttp=GetXmlHttpObject();
		if (xmlHttp==null)
		  {
		  alert ("Your browser does not support AJAX!");
		  return;
		  } 
		var url="deleteAllocRecord.jsp";
		alert("Before URL");
		url=url+"?tableId="+tableId+"&tablePK="+tablePK;                                        
		url=url+"&sid="+Math.random();
		xmlHttp.onreadystatechange=edited;
		xmlHttp.open("GET",url,true);
		xmlHttp.send(null);
                alert("Final");
	}	   
}

function edited() 
{ 
	if (xmlHttp.readyState==4)
	{ 
		//alert('Ready'+xmlHttp.responseText);
		var resp=xmlHttp.responseText;
		resp=resp.trim();
		document.getElementById('errorMessage').innerHTML=resp;
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