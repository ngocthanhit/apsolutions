
package com.bke2.servlet;

import com.bke2.util.*;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class CacheVendorServlet extends HttpServlet
{
  private PrintStream infops = null;
  public void init(ServletConfig config) throws ServletException
  {
    super.init(config);

    //System.out.println("Caching Vendor info");
		lookupInit();

  }

  public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
	  HttpSession session = request.getSession(true);
	  response.setContentType("text/plain");
	  PrintWriter out = response.getWriter();
	  String ac = request.getParameter("ac");
	  if((ac!=null)&&ac.equals("ref")){
		  System.out.println("Request for refresh()");
		  lookupInit();
	  }
	  //out.println("CacheVendorServlet....");
  }

/*
 * This Method Handles Post
 * <p>
 * @param HttpServletRequest request
 * @param HttpServletResponse response
 */

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {

	System.out.println("In do Get");

    doGet(request,response);


  }

  public void lookupInit(){
	try
    {
            Lookup lookup = new Lookup();
            getServletContext().setAttribute("lookup", lookup);

  	}
	  catch(Exception e)
    {
  		e.printStackTrace();
    }

 }

}


