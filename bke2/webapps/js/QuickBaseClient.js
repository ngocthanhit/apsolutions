//QuickBase Client for JavaScript

function QuickBaseClient(qdbServer)
{
if(qdbServer)
	{
	this.qdbServer = qdbServer;
	}
else
	{
	this.qdbServer = "";
	}

this.username = ""; //"sashiatwork@gmail.com";
this.password = ""; //"SRquic12";
this.ticket = "";
this.errorcode;
this.errortext;
this.errordetail;
this.errormessage="";

document.location.href.match(/\/db\/([^\?]+)\?/);
this.dbid = RegExp.$1;

 this.Authenticate = function(username, password)
      {
       this.username = username;
       this.password= password;
       this.ticket="";
       }
       
  this.GetTicket = function()
       {
       var xmlQDBRequest = this.initXMLRequest();
       xmlQDBResponse = this.APIXMLPost("main", "API_Authenticate", xmlQDBRequest);
       var newTicket = this.selectSingleNode(xmlQDBResponse, "/*/ticket");
       if(newTicket)
          {
           return this.text(newTicket);
           }
       
        }
        
  this.GetSchema = function(dbid)
       {
       var xmlQDBRequest = this.initXMLRequest();
       return this.APIXMLPost(dbid, "API_GetSchema", xmlQDBRequest);
        }

  this.GetDBInfo = function(dbid)
       {
       var xmlQDBRequest = this.initXMLRequest();
       return this.APIXMLPost(dbid, "API_DBInfo", xmlQDBRequest);
        }

  this.CloneDatabase = function(dbid, newdbname, newdbdesc )
       {
       var xmlQDBRequest = this.initXMLRequest();
       this.addParameter(xmlQDBRequest, "newdbname", newdbname);
       this.addParameter(xmlQDBRequest, "newdbdesc", newdbdesc );       
       xmlQDBResponse = this.APIXMLPost(dbid, "API_CloneDatabase", xmlQDBRequest);
       var newdbid = this.selectSingleNode(xmlQDBResponse, "/*/newdbid");
       if(newdbid)
          {
           return newdbid.childNodes[0].nodeValue;
           }
       return newdbid;
        }


  this.AddField = function(dbid, label, type, mode)
       {
       var xmlQDBRequest = this.initXMLRequest();
       this.addParameter(xmlQDBRequest, "label", label);
       this.addParameter(xmlQDBRequest, "type", type);
       if(mode != "")
          {
          this.addParameter(xmlQDBRequest, "mode", mode);
           }
       var xmlQDBResponse = this.APIXMLPost(dbid, "API_AddField", xmlQDBRequest);
       var fid = this.selectSingleNode(xmlQDBResponse, "/*/fid");
       if(fid)
          {
           return fid.childNodes[0].nodeValue;
           }
       return fid;
        }

  this.DeleteField = function(dbid, fid)
       {
       var xmlQDBRequest = this.initXMLRequest();
       this.addParameter(xmlQDBRequest, "fid", fid);
       var xmlQDBResponse = this.APIXMLPost(dbid, "API_DeleteField", xmlQDBRequest);
       return;
       }


  this.SetFieldProperties = function(dbid, fid, propertyName, value)
       {
       var xmlQDBRequest = this.initXMLRequest();
       this.addParameter(xmlQDBRequest, "fid", fid);
       this.addParameter(xmlQDBRequest, propertyName, value);
       return this.APIXMLPost(dbid, "API_SetFieldProperties", xmlQDBRequest);
        }

  this.GrantedDBs = function(withembeddedtables, Excludeparents, adminOnly)
	{
	var xmlQDBRequest = this.initXMLRequest();
	if(withembeddedtables != undefined)
	    {
	    this.addParameter(xmlQDBRequest, "withembeddedtables", withembeddedtables);
	    }
	if(Excludeparents != undefined)
	    {
	    this.addParameter(xmlQDBRequest, "Excludeparents", Excludeparents);
	    }
	if(adminOnly != undefined)
	    {
	    this.addParameter(xmlQDBRequest, "adminOnly", adminOnly);
	    }
	return this.APIXMLPost("main", "API_GrantedDBs", xmlQDBRequest);
	}

  this.AddRecord = function(dbid, recordArray, ignoreError)
       {
       var xmlQDBRequest = this.initXMLRequest();
       for ( var fieldCounter = 0; fieldCounter < recordArray.length; fieldCounter += 2)
           {
            this.addFieldParameter(xmlQDBRequest, recordArray[fieldCounter], recordArray[fieldCounter + 1]);
            }
	if(ignoreError)
	    {
	    this.addParameter(xmlQDBRequest, "ignoreError", "1");
	    }
       return this.APIXMLPost(dbid, "API_AddRecord", xmlQDBRequest);
        }


  this.EditRecord = function(dbid, rid, recordArray)
       {
       var xmlQDBRequest = this.initXMLRequest();
       this.addParameter(xmlQDBRequest, "rid", rid);
       for ( var fieldCounter = 0; fieldCounter < recordArray.length; fieldCounter += 2)
           {
            this.addFieldParameter(xmlQDBRequest, recordArray[fieldCounter], recordArray[fieldCounter + 1]);
            }
       return this.APIXMLPost(dbid, "API_EditRecord", xmlQDBRequest);
        }


  this.DeleteRecord = function(dbid, rid)
       {
       var xmlQDBRequest = this.initXMLRequest();
       this.addParameter(xmlQDBRequest, "rid", rid);
       return this.APIXMLPost(dbid, "API_DeleteRecord", xmlQDBRequest);
        }

  this.DoQuery = function(dbid, query, clist, slist, options)
       {
		return this.query(dbid, query, clist, slist, options, "structured");
	   }
  
  this.DoQueryADO = function(dbid, query, clist, slist, options)
       {
		return this.query(dbid, query, clist, slist, options, "xado");
	   }

  this.query = function query(dbid, query, clist, slist, options, fmt)
		{
       var xmlQDBRequest = this.initXMLRequest();
       this.addParameter(xmlQDBRequest, "fmt", fmt);
       if(query.match(/^\{.*\}$/))
           {
            this.addParameter(xmlQDBRequest, "query", query);
            }
       else if(query.match(/^[1-9][0-9]*$/))
           {
            this.addParameter(xmlQDBRequest, "qid", query);
            }
       else
           {
            this.addParameter(xmlQDBRequest, "qname", query);
            }
       this.addParameter(xmlQDBRequest, "clist", clist);
       this.addParameter(xmlQDBRequest, "slist", slist);
       this.addParameter(xmlQDBRequest, "options", options);
       return this.APIXMLPost(dbid, "API_DoQuery", xmlQDBRequest);
        }
        
  this.PurgeRecords = function(dbid, query)
       {
       var xmlQDBRequest = this.initXMLRequest();
       this.addParameter(xmlQDBRequest, "query", query);
       return this.APIXMLPost(dbid, "API_PurgeRecords", xmlQDBRequest);
        }
        
   this.ImportFromCSV = function(dbid, CSV, clist, rids, skipfirst)
       {
        var xmlQDBRequest = this.initXMLRequest();
        this.addParameter(xmlQDBRequest, "clist", clist);
        this.addParameter(xmlQDBRequest, "skipfirst", skipfirst);
        this.addCDATAParameter(xmlQDBRequest, "records_csv", CSV);
        var xmlQDBResponse = this.APIXMLPost(dbid, "API_ImportFromCSV", xmlQDBRequest);
        var RidNodeList = this.selectNodes(xmlQDBResponse, "/*/rids/rid");
        var ridListLength = RidNodeList.length;
        for(var i = 0; i < ridListLength; i++)
            {
             rids.push(RidNodeList[i].childNodes[0].nodeValue);
             }
        var result = this.selectSingleNode(xmlQDBResponse.documentElement, "/*/num_recs_added");
        var numrecords = 0;
        if(result)
           {
            numrecords += parseInt(result.childNodes[0].nodeValue);
            }
        result = this.selectSingleNode(xmlQDBResponse.documentElement, "/*/num_recs_updated");
        if(result)
           {
            numrecords += parseInt(result.childNodes[0].nodeValue);
            }
        return numrecords;
        }
	
    this.ListDBPages = function(dbid)
		{
		var xmlQDBRequest = this.initXMLRequest();
		return this.APIXMLPost(dbid, "API_ListDBpages", xmlQDBRequest);
		}
		
    this.GetDBPage = function(dbid, page)
        {
        var xmlQDBRequest = this.initXMLRequest();
        if(page.match(/^[1-9][0-9]*$/))
            {
            this.addParameter(xmlQDBRequest, "pageid", page);
            }
        else
            {
            this.addParameter(xmlQDBRequest, "pagename", page);
            }
        return this.APIXMLPost(dbid, "API_GetDBPage", xmlQDBRequest);
        }
    
    this.AddReplaceDBPage = function(dbid, page, pagetype, pagebody)
        {
        var xmlQDBRequest = this.initXMLRequest();
        if(page.match(/^[1-9][0-9]*$/))
            {
            this.addParameter(xmlQDBRequest, "pageid", page);
            }
        else
            {
            this.addParameter(xmlQDBRequest, "pagename", page);
            }
        this.addParameter(xmlQDBRequest, "pagetype", pagetype);
        this.addParameter(xmlQDBRequest, "pagebody", pagebody);
        return this.APIXMLPost(dbid, "API_AddReplaceDBPage", xmlQDBRequest);
        }

	  var xmlQDBRequest;
	  
	  function createXMLDOM () {
		try {
			if (document.implementation && document.implementation.createDocument) {
				var doc = document.implementation.createDocument("", "", null);					
				return doc;
			}
			if (window.ActiveXObject)
				return new ActiveXObject("Microsoft.XmlDom");
		}
		catch (ex) {}
		throw new Error("Sorry. Your browser does not support QuickBaseClient.js.");
		};
        
      this.initXMLRequest = function()
       {
        xmlQDBRequest = createXMLDOM();
        xmlQDBRequest.async = false;
        xmlQDBRequest.resolveExternals = false;

        var root = xmlQDBRequest.createElement("qdbapi");
        try{
	    xmlQDBRequest.removeChild(xmlQDBRequest.documentElement);
	    }
	catch(e)
	    {
	    }
        xmlQDBRequest.appendChild(root);

        if (!this.ticket)
            {
             if(this.username)
                 {
                 this.addParameter(xmlQDBRequest, "username", this.username);
                 this.addParameter(xmlQDBRequest, "password", this.password); 
                  }
            }
       else
            {
             this.addParameter(xmlQDBRequest, "ticket", this.ticket);
             }
        return xmlQDBRequest;
        }

   this.addParameter = function(xmlQDBRequest, Name, Value)
        {
         var Root = xmlQDBRequest.documentElement;
         var ElementNode = xmlQDBRequest.createElement(Name);
         var TextNode = xmlQDBRequest.createTextNode(Value);
         ElementNode.appendChild(TextNode);
         Root.appendChild(ElementNode);
        }

 this.addFieldParameter = function(xmlQDBRequest, fieldName, Value)
        {
         var Root = xmlQDBRequest.documentElement;
         var ElementNode = xmlQDBRequest.createElement("field");
         var attrField;
         if(fieldName.match(/^[1-9]\d*$/))
             {
              ElementNode.setAttribute("fid", fieldName)
              }
         else
              {
	      fieldName = fieldName.replace(/[^a-z0-9]/ig, "_").toLowerCase();
              ElementNode.setAttribute("name", fieldName)
            }
         var TextNode = xmlQDBRequest.createTextNode(Value);
         ElementNode.appendChild(TextNode);
         Root.appendChild(ElementNode);
        }

   this.addCDATAParameter = function(xmlQDBRequest, Name, Value)
        {
         var Root = xmlQDBRequest.documentElement;
         var ElementNode = xmlQDBRequest.createElement(Name);
         var CDATANode = xmlQDBRequest.createCDATASection(Value);
         ElementNode.appendChild(CDATANode);
         Root.appendChild(ElementNode);
        }
        
      var xmlHTTPPost;
   XMLhttpInit();
   
   function XMLhttpInit()
		{
		try {
			if (!xmlHTTPPost)
				xmlHTTPPost = new XMLHttpRequest();
			}
		catch(e)
			{
			}
		try {
			if (!xmlHTTPPost)
				xmlHTTPPost = new ActiveXObject("Msxml2.XMLHTTP");
			}
		catch(e)
			{
			}
		try {
			if (!xmlHTTPPost)
				xmlHTTPPost = new ActiveXObject("Microsoft.XMLHTTP");
			}
		catch(e)
			{
			alert("Sorry. This browser does not support QuickBaseClient.");
			}

		}
		
   this.APIXMLPost = function(dbid, action, xmlQDBRequest)
       {
       var script;
       script = this.qdbServer + "/db/" + dbid + "?act=" + action;
       xmlHTTPPost.open("POST", script, false);
       xmlHTTPPost.setRequestHeader("Content-Type","text/xml");
       xmlHTTPPost.send(xmlQDBRequest);
       var xmlAPI = xmlHTTPPost.responseXML;
       var topLevelChildren = xmlAPI.documentElement.childNodes;
       this.errorcode = "";
       this.errortext = "";
       this.errordetail = "";
       this.errormessage = "";
       for (var i = 0; i < topLevelChildren.length; i++) 
	    {
	    if(topLevelChildren[i].nodeName == "ticket")
		{
		this.ticket = topLevelChildren[i].childNodes[0].nodeValue;
		}
	    if(topLevelChildren[i].nodeName == "errcode")
		{
		this.errorcode = topLevelChildren[i].childNodes[0].nodeValue;
		}
	    if(topLevelChildren[i].nodeName == "errtext")
		{
		this.errortext = topLevelChildren[i].childNodes[0].nodeValue;
		this.errordetail += topLevelChildren[i].childNodes[0].nodeValue;
		}
	    if(topLevelChildren[i].nodeName == "errdetail")
		{
		this.errordetail += "\r\n" + topLevelChildren[i].childNodes[0].nodeValue;
		this.errormessage = "\r\n\r\n" + this.errordetail;
		}			
            }
       return xmlAPI;
       }

this.xpe = null;
this.nsResolver = null;

this.selectSingleNode = function (aNode, aExpr)
	{
	if((typeof aNode.selectSingleNode) != "undefined")
		{
		return aNode.selectSingleNode(aExpr);
		}
	if(this.xpe == null)
	    {    
	    this.xpe = new XPathEvaluator();
	    }
	this.nsResolver = this.xpe.createNSResolver(aNode.ownerDocument == null ? aNode.documentElement : aNode.ownerDocument.documentElement);
	var result = this.xpe.evaluate(aExpr, aNode, this.nsResolver, 0, null);
	return result.iterateNext();
	}

this.selectNodes = function (aNode, aExpr)
	{
	if((typeof aNode.selectNodes) != "undefined")
		{
		return aNode.selectNodes(aExpr);
		}
	if(this.xpe == null)
	    {    
	    this.xpe = new XPathEvaluator();
	    }
	this.nsResolver = this.xpe.createNSResolver(aNode.ownerDocument == null ? aNode.documentElement : aNode.ownerDocument.documentElement);
	var result = this.xpe.evaluate(aExpr, aNode, this.nsResolver, 0, null);
	var found = [];
	while (res = result.iterateNext())
            {
	    found.push(res);
            }
	return found;
	}

this.text = function(aNode)
	{
	if((typeof aNode.text) != "undefined")
	    {
	    return aNode.text;
	    }
	var nodetext = "";
	for(var i = 0; i < aNode.childNodes.length; i++)
	    { 
	    if(aNode.childNodes[i].nodeValue != null)
		{
		nodetext += aNode.childNodes[i].nodeValue;
		}
	    }
	return nodetext;
	}

this.GetURL = function(dbid, action)
       {
       var script;
       script = this.qdbServer + "/db/" + dbid + "?act=" + action;
       xmlHTTPPost.open("GET", script, false);
       xmlHTTPPost.send(null);
       return xmlHTTPPost.responseText; 
       }


   this.displayErrorAlert = function(message)
       {
        if(this.errorcode != '0')
            {
            alert(message + " " + this.errormessage);
            return true;
            }
        else
            {
            return false;
            }
        }
    
    this.HTTPPost = function(dbid, querystring, content, contentType)
        {
        var script;
        var xmlHTTPPost = new ActiveXObject("Microsoft.XMLHTTP");
        script = this.qdbServer + "/db/" + dbid + "?" + querystring;
        xmlHTTPPost.open("POST", script, false);
        xmlHTTPPost.setRequestHeader("Content-Type",contentType);
        xmlHTTPPost.send(content);
        return xmlHTTPPost.responseText;
        }
    
    
monthNames = new Array(12)
monthNames[1] = "January"
monthNames[2] = "February"
monthNames[3] = "March"
monthNames[4] = "April"
monthNames[5] = "May"
monthNames[6] = "June"
monthNames[7] = "July"
monthNames[8] = "August"
monthNames[9] = "September"
monthNames[10] = "October"
monthNames[11] = "November"
monthNames[12] = "December"

dayNames = new Array(7)
dayNames[1] = "Sunday"
dayNames[2] = "Monday"
dayNames[3] = "Tuesday"
dayNames[4] = "Wednesday"
dayNames[5] = "Thursday"
dayNames[6] = "Friday"
dayNames[7] = "Saturday"

    this.format = function(data, format)
        {
        if(format.match(/^date/i))
			{
			var intData = parseInt(data);
			var objGMTDate = new Date(intData);
			var milliGMToffset = objGMTDate.getTimezoneOffset()*60000;
			var oneDate = new Date(intData+ milliGMToffset);
			var date = oneDate.getDate();
			var day = oneDate.getDay() + 1;
			var month = oneDate.getMonth() + 1;
			var theYear = oneDate.getYear();
			if(theYear < 1900)
				{
				theYear += 1900;
				}
			if(format.match(/friend/i))
				{
				return monthNames[month] + " " + date + ", " + theYear;
				}
			if(format.match(/long/i))
				{
				return dayNames[day] + ", " + monthNames[month] + " " + date + ", " + theYear;
				}
			else if(format.match(/timestamp/i))
				{
					return oneDate.toLocaleString();
					}
			else
				{
				return month + "-" + date + "-" + theYear;
				}
			}
        if(format.match(/^timeofday/))
           {
            data = parseInt(data);
            var intHours=Math.floor(data/3600000);
            var intMinutes=Math.floor(data/60000)%60;
            if (intMinutes < 10){intMinutes="0"+intMinutes;}
            return ""+intHours+":"+intMinutes;
            }
        }

    var objGMTDate = new Date();
    var milliGMToffset=(objGMTDate.getTimezoneOffset()*60000)+(12*3600000);
        
        this.DisplayDate = function(XMLDOM)
            {
            var objDate=new Date();
            var nodeDate = XMLDOM.selectSingleNode(".");
            if (!nodeDate)
                {
                return "";
                }
            else
                {
                var strDate = nodeDate.childNodes[0].nodeValue;
                if(strDate==""){return "";}
                strDate = parseInt(strDate) + milliGMToffset;
                objDate.setTime(strDate);
                var intMonth=(objDate.getMonth())+1;
                var intYear=objDate.getYear();
                var intDay=objDate.getDate();
                if (intYear <100)
                    {
                    return ""+intMonth+"-"+intDay+"-19"+intYear;
                    }
                else
                    {	
                    return ""+intMonth+"-"+intDay+"-"+intYear;
                    }
                }
            }

this.parseQueryString = function()
{
var queryString = window.location.search;
    queryString = queryString.substring(1);
    var queryNameValuePairs = queryString.split("&");
    var NameValues = new Array();
    for (var i = 0; i < queryNameValuePairs.length; i++)
         {
          var queryNameValuePair = queryNameValuePairs[i].split("=");
          NameValues[unescape(queryNameValuePair[0])] = unescape(queryNameValuePair[1]);          
          }
return NameValues;
}
        
this.ParseDelimited = function(data, delim)
   {
      var output = new Array();
      var line = new Array();
      var offset = 0;
      
      var field="";
      var lineEmpty=true;
      var maxsize = 0;
      var numfields=0;
      var i = new Array();
      var field = "";
      
      // Parse lines until the eof is hit
      while (GetNextLine())
         {
            if(!lineEmpty)
               {
                  output.push(line);
                  numfields=line.length;
                  if (numfields > maxsize)
                     {
                        maxsize = numfields;
                     }
               }
         }
         
      
      // If there are any lines which are shorter than the longest
      // lines, fill them out with "" entries here. This simplifies
      // checking later.
      for (var i = 0; i < output.length; i++)
         {
            while (output[i].length < maxsize)
               {
                  output[i].push ("");
               }
         }
         
      return output;


function GetNextLine()
   {
      line = new Array();
      //skip any empty lines
      while ((offset < data.length) && ((data.substr(offset, 1) == "\r") || (data.substr(offset, 1) == "\n")))
         {
            offset++;
            }   
               
            if (offset >= data.length)
               {
                  return false;
               }
               
            lineEmpty = true;
            var moreToCome =true;
            while(moreToCome)
               {
                  moreToCome = GetNextField();
                  line.push(field);
                  if (field)
                     {
                        lineEmpty = false;
                     }
               }
            return true;
         }
      
function GetNextField()
         {
            var BEFORE_FIELD=0;
            var IN_QUOTED_FIELD=1;
            var IN_UNQUOTED_FIELD=2;
            var DOUBLE_QUOTE_TEST=3;
            var c="";
            var state = BEFORE_FIELD;
            var p = offset;
            var endofdata = data.length;
            
               
            field = "";
               
            while (true)
               {
                  if (p >= endofdata)
                     {
                        // File, line and field are done
                        offset = p;
                        return false;
                     }
                  
                  c = data.substr(p, 1);
                     
                  if(state == DOUBLE_QUOTE_TEST)
                     {
                        // These checks are ordered by likelihood */
                        if (c == delim)
                           {
                              // Field is done; delimiter means more to come
                              offset = p + 1;
                              return true;
                           }
                        else
                           {
                              if (c == "\n" || c == "\r")
                                 {
                                    // Line and field are done
                                    offset = p + 1;
                                    return false;
                                 }
                                 else
                                 {
                                    if (c == '"')
                                       {
                                          // It is doubled, so append one quote
                                          field += '"';
                                          p++;
                                          state = IN_QUOTED_FIELD;
                                       }
                                         else
                                       {
                                          // !!! Shouldn't have anything else after an end quote!
                                          // But do something reasonable to recover: go into unquoted mode
                                          field += c;
                                          p++;
                                          state = IN_UNQUOTED_FIELD;
                                       }
                                    }                
                                 } 
                           }
                        else
                           {
                              if(state == BEFORE_FIELD)
                                 {
                                    // These checks are ordered by likelihood */
                                    if (c == delim)
                                       {
                                          // Field is blank; delimiter means more to come
                                          offset = p + 1;
                                          return true;
                                       }
                                    else
                                       {
                                          if (c == '"')
                                             {
                                                // Found the beginning of a quoted field
                                                p++;
                                                state = IN_QUOTED_FIELD;
                                             }
                                          else
                                             {
                                                if (c == "\n" || c == "\r")
                                                   {
                                                      // Field is blank and line is done
                                                      offset = p + 1;
                                                      return false;
                                                   }
                                                else
                                                     {
                                                      if (c == ' ')
                                                         {
                                                            // Ignore leading spaces
                                                            p++;
                                                         }
                                                      else
                                                         {
                                                            // Found some other character, beginning an unquoted field
                                                            field += c;
                                                            p++;
                                                            state = IN_UNQUOTED_FIELD;
                                                         }
                                                    }
                                             }
                                       }
                                 }
                              else
                                 {
                                    if (state == IN_UNQUOTED_FIELD)
                                       {
                                          // These checks are ordered by likelihood */
                                          if (c == delim)
                                             {
                                                // Field is done; delimiter means more to come
                                                offset = p + 1;
                                                return true;
                                             }
                                          else
                                             {
                                                if (c == "\n" || c == "\r")
                                                   {
                                                      // Line and field are done
                                                      offset = p + 1;
                                                      return false;
                                                   }
                                                else
                                                   {
                                                      // Found some other character, add it to the field
                                                      field += c;
                                                      p++;
                                                   }
                                             }
                                       }
                                    else
                                       {
                                          if(state == IN_QUOTED_FIELD)
                                             {
                                                if (c == '"')
                                                   {
                                                      p++;
                                                      state = DOUBLE_QUOTE_TEST;
                                                   }
                                                else
                                                   {
                                                      // Found some other character, add it to the field
                                                      field += c;
                                                      p++;
                                                   }
                                             }
                                       }
                                  }
                              }             
                          }
                     }
                  
}                  

 }