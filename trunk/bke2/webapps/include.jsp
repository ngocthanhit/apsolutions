<%@ page contentType="text/html;charset=WINDOWS-1252"%>
<%@ page session="false" %>

<%!
String selectOptions(String variable, String item) {
  return selectOptions(variable, item, item);
}
String selectOptions(String variable, String value, String item) {
  return "<option " + (variable.equalsIgnoreCase(value) ? "selected " : "") +
         "value=" + value + " >" + item + "</option>";
}

String urlEncode(StringBuffer data) {
  for (int i = 0; i < data.length(); i++) {
    if (data.charAt(i) == '<')
      data.replace(i, i + 1, "&lt;");
    else if (data.charAt(i) == '>')
      data.replace(i, i + 1, "&gt;");
  }
  return data.toString();
}

void title(JspWriter out, String str, String ctl, String file) throws java.io.IOException {

  String crlf = "\r\n";
  out.write("<HEAD>" + crlf);
  out.write("<TITLE>IBiz Integrator for QB JSP Demos - " + str + "</TITLE>" + crlf);
  out.write("<LINK REL=stylesheet TYPE=text/css HREF=stylesheet.css>" + crlf);
  out.write("<META NAME=\"description\" CONTENT=\"Demo of IBiz Integrator for QB JSP Edition - " + str + "\">" + crlf);
  out.write("<META NAME=\"keywords\" CONTENT=\"IBiz; jsp; nsoftware; " + str + "\">" + crlf);
  out.write("</HEAD>" + crlf);
  out.write("<h1>IBiz Integrator for QB V4 JSP Edition - Demo Pages</h1>" + crlf);

  if(!ctl.equals("")) {
    out.write("<h2>" + str + "</h2>" + crlf);
    out.write("<p>Illustrates the use of the " + ctl + " Object </p>");
    out.write("<A HREF=seecode.jsp?" + file + ">[See The Code]</A>");
  } else {
    out.write("<h2>Source Code For \"<A HREF=" + str + ">" + str + "</A>\"</h2>");
  }

  out.write(" <A HREF=index.htm>[Other Demos]</A>");
  out.write("<HR SIZE=1>" + crlf);
}

String trimQ(String s) {
  s.trim();
  int i;
  for (i = 0; i < s.length() && s.charAt(i) == '"'; i++);
  int j = s.indexOf("\"", i);
  return s.substring(i, j);
}

void trailer(JspWriter out) throws java.io.IOException {
  out.write("<br>" +
              "<br>" +
              "<br>" +
              "<hr SIZE=1>" +
              "NOTE: These pages are simple demos, and by no means complete applications.  They " +
              "are intended to illustrate the usage of the IBiz Integrafor for QB JSP objects in a simple, " +
              "straightforward way.  What we are hoping to demonstrate is how simple it is to " +
              "program with our tools.  If you want to know more about them, or if you have " +
              "questions, please visit <a href=\"http://www.nsoftware.com/?demopg-BBE4-V\">www.nsoftware.com</a> or " +
              "email to <a href=\"mailto:support@nsoftware.com\">support@nsoftware.com</a>. " +
              "<br><br>Copyright &copy; 2004 /n software inc.  All rights reserved.<br><br>");
}
%>
