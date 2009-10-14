 
  <%@ page language="java" import="com.intuit.quickbase.util.*,com.docorganiz5.util.*,com.docorganiz5.domain.*" %>
  <%@ page buffer="128kb"%>
  <%@ page import="java.util.*,java.io.*,java.text.*,java.sql.Timestamp"%>
 
  <%@ page import="java.text.SimpleDateFormat"%>
  <%@ page import="java.lang.reflect.Array"%>
  <%@ page import="org.w3c.dom.Document"%>
  <%@ page import="org.xml.sax.InputSource"%>
  <%@ page import="org.w3c.dom.Element"%>
  <%@ page import="org.w3c.dom.NodeList"%>
  <%@ page import="org.w3c.dom.Node"%>
 
 <%
 
	 String agentTableId = "bdyvk9utf";

	String agentNumberCID = "9";
        String allocRecordCID = "6";
        
        String agentAccountLineCID = "35";
        String agentChargeLineCID = "11";
        String agentDepLineCID = "12";
        String agentCmtLineCID = "49";
        
        String empIdCID = "11";
        String labCatCID = "35";
        String agentAmtLineCID = "10";
        String hours = "45"

System.out.println("IN AGENT JSP");
  %>
    	
<%@ include file="dpvu.html"%>
 
