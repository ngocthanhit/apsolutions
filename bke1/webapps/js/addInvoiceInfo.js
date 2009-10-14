var invoiceTableId = "bc2ija97td";


var tableId;
var invCtrId;
var allocCtrId;
var agentCtrId;
var voucherNumber;

function addInvoiceValue(table, invCtr, allocCtr)
{ 
	tableId=table;
	invCtrId=invCtr;
	allocCtrId=allocCtr;

	//alert("inside addInfo.js");
	var url="addInvoiceInfo.jsp?";
	
	voucherNumber = document.getElementById('voucher_no').value;	
	url = url+"tb="+invoiceTableId+"&c1=9&v1="+document.getElementById('invoice_no'+invCtr).value+"&c2=8&v2="+document.getElementById('invoice_date'+invCtr).value+"&c3=106&v3="+document.getElementById('voucherId').value;
	
	
	//alert('IN EDITINFO.js === '+field)
	xmlHttp=GetXmlHttpObject2();
	if (xmlHttp==null)
	{
	  alert ("Your browser does not support AJAX!");
	  return;
	}
	
	//alert("Before URL");
	url=url+"&sid="+Math.random();
	xmlHttp.onreadystatechange=added;
	xmlHttp.open("GET",url,true);
	xmlHttp.send(null);
} 


function addAgentValue(table, agentCtr, allocPK)
{ 
	tableId=table;
	agentCtrId=agentCtr;
	var url="addInfo.jsp?";

	//alert('Ready for add Agent');
	url = url+"tb="+agentTableId+"&c1=9&v1="+document.getElementById('agent_number'+agentCtr).value+"&c2=10&v2="+document.getElementById('agent_amount'+agentCtr).value+"&c3=35&v3="+document.getElementById('account'+agentCtr).value+"&c4=11&v4="+document.getElementById('charge_code'+agentCtr).value+"&c5=12&v5="+document.getElementById('dep_code'+agentCtr).value+"&c6=6&v6="+allocPK;
	//alert('URL   '+url);	

	//alert('IN EDITINFO.js === '+field)
	xmlHttp=GetXmlHttpObject2();
	if (xmlHttp==null)
	{
	  alert ("Your browser does not support AJAX!");
	  return;
	}
	
	//alert("Before URL");
	url=url+"&sid="+Math.random();
	xmlHttp.onreadystatechange=added;
	xmlHttp.open("GET",url,true);
	xmlHttp.send(null);
}
function added() 
{ 
	if (xmlHttp.readyState==4)
	{ 
		//alert('Ready'+xmlHttp.responseText);
		var resp=xmlHttp.responseText;
		resp=resp.trim();
		//alert('Ready'+resp);		
		//alert('TableId'+tableId);

		if(tableId.lenght>15){		
			//alert('Error Message while Adding');			
			document.getElementById('errorMessage').innerHTML=resp;			
		}else{
			//alert('I am in ELSE');
			if(tableId=="voucher"){
				//alert('I am in VoucherId set');
				document.getElementById('voucherId').value=resp;
				//alert("Previous VoucherNumber"+getCookie("lastVoucherNumber")+" current Number is "+voucherNumber);
				setCookie("lastVoucherNumber", voucherNumber, 365);

				//alert("Current VoucherNumber"+getCookie("lastVoucherNumber"));

				//if(tableId.lenght>15){		
		
			}
			if(tableId=="invoice"){
				//alert('Response from Add Invoice .jsp '+resp);
				document.getElementById('invoiceId'+invCtrId).value=resp;
				//alert('Invoice ID value from FORM '+document.getElementById('invoiceId'+invCtrId).value);
				} 
			if(tableId=="allocation"){
				//alert('Response from Add Allocation .jsp ---> '+resp);
				document.getElementById('allocationId'+invCtrId+'l'+allocCtrId).value=resp;
				//alert('Allocation ID value from FORM '+document.getElementById('allocationId'+invCtrId+'l'+allocCtrId).value);
				
			} 
			if(tableId=="agent"){
				//alert('Response from Add Agent .jsp '+resp);
				document.getElementById('agentId'+agentCtrId).value=resp;
				//alert('Agent ID value set  '+document.getElementById('agentId'+agentCtrId).value);
			}			
		}
		

		
		//alert('Last in Added');
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


