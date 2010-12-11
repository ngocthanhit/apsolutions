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
com.intuit.quickbase.util.*,com.bke2.util.*,com.bke2.domain.*" %> 
	      
     
<%@ page language="java" %>

<%					     

//org.apache.commons.fileupload.disk.DiskFileItemFactory,

//String toDir = "C:\\jakarta-tomcat-5.0.30\\webapps\\bke2\\" ;
String toDir = "/usr/local/apache-tomcat-5.5.23/webapps/bke2/" ;

DiskFileUpload upload = null;
String successfullFile = "";
String lastAccesedDir = "";
String lastImageLocation = "";

long sizeInBytes = 0l;	
String fromDir = "";
int maxByteSize = 8192;
String finalURL ="";
String skipArray ="";
        String mv = "";
        skipArray = request.getParameter("skipArray");
	String vo = request.getParameter("vo");
	//String ac = request.getParameter("uac");
	String in = request.getParameter("in");
	String uac = request.getParameter("uac");
	//System.out.println("UUUUUUAC "+uac);
	
	String fileName = "";
			
	boolean hasFile = false; 
	String   writeURL ="";

	StringBuffer ur = request.getRequestURL();	
	String url1 = ur.toString();
	String url = url1.substring(0, url1.length()-15);
  	int cookieTime = 60*60*24;

	String invoiceId = "";
	String tableId = "bes8a4tgq";
	String columnId ="40";
	
	boolean isMultipart = FileUpload.isMultipartContent(request);
	
	String fromDir1 = "";

		String imageH="";
		
		String imageV="";
	 
	 	 double imageHi=0;
	 	 	
	 	double imageVi=0;
	 	double imageHx=0;
	 	
	 	double imageVy=0;
	 
	Cookie[] cookieArray = request.getCookies(); 

	String cookieuid1="";
	String cookieuid2=""; 
	String cookiepassword="";
	String message="";	
	
	
	if ( (request.getParameter("lac")==null) ){
	
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
 		    	
 		    if(cookie.getName().equals("lastImageLocation"))
 		    	lastImageLocation = cookie.getValue();


								
	/*				
				if(cookie.getName().equals("imageH")){
					imageH = cookie.getValue();
					if(imageH.length()>0){
						imageHi =Double.parseDouble(imageH);
						
						//imageHi = imageHi ;//+ imageHi*0.02;
						imageHi = imageHi + imageHi*0.11;
						imageHx = imageHi ; 
				
					}
					
					//System.out.println("FROM IMAGE >>>>imageH Cookie exists "+imageH);
				}

			   if(cookie.getName().equals("imageV")){
					imageV = cookie.getValue();				
					if(imageV.length()>0){
						imageVi =Double.parseDouble(imageV);
						
						//imageVi = imageVi ;//+ imageVi*1;
						imageVi = imageVi + imageVi*0.100;
						imageVy = imageVi ; 
				
							}
					
				}
	*/			
				
				
					
			   }
		}	   
	}	    	




String imageParam =(String)session.getAttribute("imageParam");

if( imageParam == null ){
		System.out.println(">>>>>>>>>>>>>>>>>imageParam is NULL ");
	}else{	
	
		String[] fields = imageParam.split(",");
		imageH = fields[0];
		imageV = fields[1];
	
	}
	
	System.out.println("H value from Login"+imageH);
	System.out.println("V value from Login"+imageV);
	imageHi =Double.parseDouble(imageH);
	imageVi =Double.parseDouble(imageV);
	
	
	if(imageParam.equals("1920,1200")){
	  imageHi = imageHi*0.4190;
		imageHx = imageHi; 
	  imageVi = imageVi*0.8715;
		imageVy = imageVi; 
	}
	
//240x150

	if(imageParam.equals("1680,1050")){
	  imageHi = imageHi*0.4190;
		imageHx = imageHi; 
	  imageVi = imageVi*0.8715;
		imageVy = imageVi; 
	}
	
	// 1440,900
	if(imageParam.equals("1440,900")){
	  imageHi = imageHi*0.4090;
		imageHx = imageHi; 
	  imageVi = imageVi*0.8380;
		imageVy = imageVi; 
	}
	
	// 1280,800
	if(imageParam.equals("1280,800")){
	   System.out.println("1280,800");
	  imageHi = imageHi*0.4021; //4021
		imageHx = imageHi; 
	  imageVi = imageVi*0.7638; //7638
		imageVy = imageVi; 
	}
	
	
	
	/*
				if(imageH.length()>0){
						imageHi =Double.parseDouble(imageH);
						imageHi = imageHi + imageHi*0.0000;
						imageHx = imageHi ; 
				}
				if(imageV.length()>0){
						imageVi =Double.parseDouble(imageV);
						imageVi = imageVi + imageVi*0.0000;
						imageVy = imageVi ; 
				}
			
	*/		
	String login = cookieuid1+"@"+cookieuid2;
	String password = cookiepassword;	 
	String strURL = "https://docorganiz.quickbase.com/db/";
	

	HashMap  invoiceHash = new  HashMap();
	QuickBaseClient qdb = new QuickBaseClient(login, password, strURL);

	
	
	System.out.println("**************************** UAC ****"+uac);
	
		if(uac!=null){
			if(uac.equals("ed")){
			}else if(uac.equals("ad")){
				finalURL=url;
		
			}

		}else { 
			
			finalURL=url;
	
			if(isMultipart){

			System.out.println("skipArray from iaded is "+skipArray);
			//session.setAttribute( "sessionSkipArray", skipArray );

			try{
				upload = new DiskFileUpload();

				List items = upload.parseRequest(request);
				Iterator it = items.iterator();

				while (it.hasNext()) {
						FileItem item = (FileItem) it.next();
					if (item.isFormField()) {
					
						//Plain request parameters will come here.
						String name = item.getFieldName();
						String value = item.getString();	
						System.out.println(" name  "+name+"  value "+value);
						
						if(name.equals("fromDir1")) fromDir1 = value;
									
						if(name.equals("vo")) vo = value;
					
						if(name.equals("mv")) mv = value;
					
						if(name.equals("in")) in = value;
					
						if(name.equals("invoiceId")) invoiceId = value;
					
						if(name.equals("lastImageLocation")) lastImageLocation = value;
					
						if(name.equals("skipArray")) skipArray = value;
						
						//System.out.println(" lastImageLocation "+lastImageLocation);

						Cookie cookie3 = new Cookie("lastImageLocation",lastImageLocation);
						cookie3.setMaxAge(cookieTime); 
						response.addCookie(cookie3); 

						
						
						//if(name.equals("uac")) uac = value;
					
						
					} else {
				
						/*
						Random rand = new Random();
	
						fileName = rand.nextInt()+".pdf";
						*/
												
					}
				}
				
					

				
				
			}catch(Exception e11){
				System.out.println("Exception at Parsing    "+e11.getMessage());
			
			}
				 System.out.println("B4  fromDir1  "+fromDir1);

					    System.gc();

					    fromDir = writeURL;
					    finalURL=url+fileName;
			}//Multipart
		
		} //else
	
		
	if(skipArray==null){
		skipArray = ",";
   }else{
   	System.out.println("SkipArray Has values >>"+skipArray);
   	
		session.setAttribute( "sessionSkipArray", skipArray );
   	}		
	
	
%>


<%@ include file="iaded.html"%> 
