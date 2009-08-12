<%@ page import="java.util.Iterator,
             java.io.*,
	     java.util.List,
	     java.util.HashMap,
	     java.util.Random,
	     java.io.ByteArrayOutputStream,
	     java.io.FileNotFoundException,
	     java.io.FileOutputStream,
	     java.io.IOException,
	     java.io.InputStream,
	     java.io.FileInputStream,
	     java.io.File,
	     java.net.InetAddress,
	     java.io.OutputStream, 
	     java.nio.channels.Channels,
org.apache.commons.fileupload.DiskFileUpload,
org.apache.commons.fileupload.disk.DiskFileItemFactory,
org.apache.commons.fileupload.FileUpload,
org.apache.commons.fileupload.FileItem, 
java.nio.channels.FileChannel,
java.io.RandomAccessFile,
com.intuit.quickbase.util.*,com.bke1.util.*" %> 
	      


<%@ page import="org.apache.commons.fileupload.DiskFileUpload"%>
<%@ page import="org.apache.commons.fileupload.FileItem"%>
<%@ page import="java.util.List,java.util.HashMap"%>
<%@ page import="java.util.Iterator"%>



<%@ page import="java.io.*,java.net.*"%>
<html>
<head><title>Process File Upload</title>
</head>
<%

	
	String toFile = request.getParameter("tf");

	String ii = request.getParameter("ii");


        try{
	// Write the message back to the applet
	response.setContentType("text/plain");
	PrintWriter toApplet = response.getWriter();


	System.out.println("tf >>"+toFile);	


	System.out.println("ii >>"+ii);	

		


//FileOutputStream fos = new FileOutputStream("C:\\jakarta-tomcat-5.0.30\\webapps\\bke1\\"+toFile);
FileOutputStream fos = new FileOutputStream("/usr/local/apache-tomcat-5.5.23/webapps/bke1/"+toFile);

	System.out.println("writing at  "+toFile);	
	
	
	//System.out.println("in stream Data");
        String ErrorStr = null;
          //find the right mime type and set it as contenttype
          //response.setContentType("application/octet-stream");
          BufferedInputStream bis = null;
          BufferedOutputStream bos = null;
          try{
              InputStream in = request.getInputStream();
              bis = new BufferedInputStream(in);
              bos = new BufferedOutputStream(fos);
              byte[] buff = new byte[10000];
              int bytesRead=0;
          
              while(-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
                System.out.println("writing");
              }
          
	      System.out.println("successfully written to the server");
	      toApplet.println("Messge from Servlet : successfully written to the server");

		//Ready to update into QuickBase
              
          } catch (Exception e) {
          
          
	  	toApplet.println("Problem at the server "+e.getMessage());
	    
                e.printStackTrace();
                ErrorStr = "Error Streaming the Data";
                System.out.println("Error in Servlet "+ErrorStr+"\t\t"+e.getMessage());
                //outstr.print(ErrorStr);
          } finally {
                if( bis != null ) {
                  bis.close();
                }
                if( bos != null ) {
                  bos.close();
                }
                if( fos != null ) {
                  fos.flush();
                  fos.close();
                }
                if(toApplet!=null){
		  toApplet.close();
                }
                
          }
        }
        catch(Exception e){
                e.printStackTrace();
        }


	 
	
	//Update the invoice record in QuickBase
	 
	if((toFile!=null)&&(ii!=null)){
		String invoiceId = ii;
		
		String invoiceTableId = "bd77scjia";
		    
		String columnId ="107";

		StringBuffer ur = request.getRequestURL();	
		String url1 = ur.toString();
		String url = url1.substring(0, url1.length()-15);


		Cookie[] cookieArray = request.getCookies(); 

		String cookieuid1="";
		String cookieuid2=""; 
		String cookiepassword="";
		String message="";

		if( cookieArray != null) { 

			  //System.out.println("Cookie Set");

			for( int i = cookieArray.length-1; i >= 0; i-- ) { 
				 Cookie cookie = cookieArray[i]; 

			    if(cookie.getName().equals("uid1"))
				cookieuid1 = cookie.getValue();
			    if(cookie.getName().equals("uid2"))
				cookieuid2 = cookie.getValue();
			    if(cookie.getName().equals("password"))
				cookiepassword = cookie.getValue();
			}
		}

		String login = cookieuid1+"@"+cookieuid2;
		String password = cookiepassword;	 
		String strURL = "https://docorganiz.quickbase.com/db/";
		String fileName = toFile;

		HashMap  invoiceHash = new  HashMap();
		QuickBaseClient qdb = new QuickBaseClient(login, password, strURL);
		invoiceHash.put(columnId, url+fileName);

		System.out.println("tableId >>> "+invoiceTableId);
		System.out.println("Hash >>> "+invoiceHash);
		System.out.println("invoiceId >>> "+invoiceId);

		try{								
			message = qdb.editRecord(invoiceTableId, invoiceHash,invoiceId);
			
		System.out.println("After editing >>> "+message);
		
		}catch(Exception ee){
			System.out.println("message Edit Failed >>>>> "+ee.getMessage());
		}
	}

	System.out.println("DONE PROCESS JSP Message is >> ");
                


%>
