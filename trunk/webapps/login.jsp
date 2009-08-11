  <%@ page language="java" import="com.intuit.quickbase.util.*,com.bke1.util.*,com.bke1.domain.*" %> 
  <%@ page buffer="128kb"%>  
  <%@ page import="java.util.*,java.io.*,java.text.*,java.sql.Timestamp"%>                     
  <%@ page import="java.text.SimpleDateFormat"%>      
  <%@ page import="java.lang.reflect.Array"%>         
  <%@ page import="java.io.File"%>      
                                                      
 <%
 String login =  request.getParameter("login");
 String u =  request.getParameter("u");
 String password = request.getParameter("password");
 
 String image =  request.getParameter("image");
 String imageH =  request.getParameter("imageH");
 String imageV = request.getParameter("imageV");
 
 String lastImageLocation = request.getParameter("lastImageLocation");
 String lastVoucherNumber = request.getParameter("lastVoucherNumber");
 if(image == null) image = "SXGA Dual - 768 by 1024 ~3:4 ratio";
 if(imageH == null) imageH = "768";
 if(imageV == null) imageV = "1024";
 
 String msg = request.getParameter("msg");
 if (msg == null) msg = "";
 
 String ac = request.getParameter("ac");
 String ac1 = ac;
 
 
  		System.out.println("@@@ac1@@@@@@@@@@@@@@@@@@@@@@@@@@ ac1 "+ac1); 	      
			 
			 
 String vid = request.getParameter("vid");
 
 
  String uid1="";
  String uid2="";  
  String voucherH="";
  String voucherV=""; 
  String cookieimageH="";
  String cookieimageV=""; 
  String cookieimage="";
  String cookielastVoucherNumber="";
  
  String cookielastImageLocation = "";
  
  int cookieTime = 60*60*24*365;
  String cookieuid1="";
  String cookieuid2=""; 
 
  String cookiepassword="";
 
 
Cookie[] cookieArray = request.getCookies(); 

//if ( (request.getParameter("sess")!=null)||(session.getAttribute("lookup")==null) ){

/*
    if (session != null) {
    	Lookup lookup = new Lookup();
        session.setAttribute("lookup", lookup);
        //value = session.getAttribute("com.mycompany.session-param");
    }

*/


if ( (request.getParameter("lac")==null) ){

	if( cookieArray != null) { 

		  //System.out.println("Cookie Set");

		  for( int i = cookieArray.length-1; i >= 0; i-- ) { 
		    Cookie cookie = cookieArray[i]; 
		    if(cookie.getName().equals("uid1"))
		    	cookieuid1 = cookie.getValue();
		    if(cookie.getName().equals("uid2"))
		    	cookieuid2 = cookie.getValue();
		    if(cookie.getName().equals("password")){
		    	cookiepassword = cookie.getValue();
		    	//System.out.println("Password Cookie exists "+cookiepassword);
		    	}
		 
		    
		    if(cookie.getName().equals("imageH")){
		    	imageH = cookie.getValue();
		    	//System.out.println("imageH Cookie exists "+imageH);
		    	}
		    	
		    if(cookie.getName().equals("imageV"))
		    	imageV = cookie.getValue();
		    	
		    if(cookie.getName().equals("image")){
		    	image = cookie.getValue();
		    	System.out.println("image Cookie exists "+image);
		    	}
		    	
		    if(cookie.getName().equals("lastVoucherNumber"))
		    	cookielastVoucherNumber = cookie.getValue();
	
		    if(cookie.getName().equals("lastImageLocation"))
		    	cookielastImageLocation = cookie.getValue();
		    

		    	
		    	
		    login = cookieuid1+"@"+cookieuid2;
 		    password = cookiepassword;
 		    imageH = cookieimageH;
 		    imageV = cookieimageV;
 		    image = cookieimage;
 		    
    		    lastVoucherNumber=cookielastVoucherNumber;
		    
    		    lastImageLocation=cookielastImageLocation;
		    
		    
		  } 
	}
}	
else {	
if ( request.getParameter("lac").equals("lac") ){

	
	if( (login!=null)&&(password!=null) ){
		String[] uids = login.split ("@");
 		uid1 = uids[0];
 //		System.out.println("uid1  "+uid1);
 		uid2 = uids[1];
 //		System.out.println("uid2  "+uid2);
 
 		Cookie cookie1 = new Cookie("uid1",uid1);
		cookie1.setMaxAge(cookieTime); 
		response.addCookie(cookie1); 
	
 		Cookie cookie2 = new Cookie("uid2",uid2);
		cookie2.setMaxAge(cookieTime); 
		response.addCookie(cookie2); 
	
 		Cookie cookie3 = new Cookie("password",password);
		cookie3.setMaxAge(cookieTime); 
		response.addCookie(cookie3); 
	
 		Cookie cookie4 = new Cookie("voucherH",voucherH);
		cookie4.setMaxAge(cookieTime); 
		response.addCookie(cookie4); 
	
 		Cookie cookie5 = new Cookie("voucherV",voucherV);
		cookie5.setMaxAge(cookieTime); 
		response.addCookie(cookie5); 
	
 		Cookie cookie6 = new Cookie("imageH",imageH);
		cookie6.setMaxAge(cookieTime); 
		response.addCookie(cookie6); 
	
//	System.out.println("imageH cookie set :"+imageH);
	
 		Cookie cookie7 = new Cookie("imageV",imageV);
		cookie7.setMaxAge(cookieTime); 
		response.addCookie(cookie7); 
	
 		Cookie cookie8 = new Cookie("image",image);
		cookie8.setMaxAge(cookieTime); 
		response.addCookie(cookie8); 
	
 		Cookie cookie9 = new Cookie("lastVoucherNumber",lastVoucherNumber);
		cookie9.setMaxAge(cookieTime); 
		response.addCookie(cookie9); 
	
		/*
		if(lastImageLocation.length()>0){
			if (! (new File(lastImageLocation).isDirectory()) ){
				lastImageLocation =  new File(lastImageLocation).getParent();
			}
		}
		*/
		
 		Cookie cookie10 = new Cookie("lastImageLocation",lastImageLocation);
		cookie10.setMaxAge(cookieTime); 
		response.addCookie(cookie10); 


  		Lookup lookup = (Lookup)getServletContext().getAttribute("lookup");
  		lookup.isAuthenticated(login,password);
  	//	lookup.refresh();
		
		
			if(ac1.equals("ad")||ac1.equals("ed")){
				response.sendRedirect("/bke1/aded.jsp?ac="+ac+"&u="+u+"&vid="+vid);
			}else if(ac1.equals("vu")){
				response.sendRedirect("/bke1/vu.jsp?ac="+ac+"&u="+u+"&vid="+vid);
			}else if(ac1.equals("rv")){
				response.sendRedirect("/bke1/rv.jsp?ac="+ac+"&u="+u+"&vid="+vid);
			}
		
		

	}else{
		System.out.println("No username/Password");
	
	    }
	}
}

%>
	
<%@ include file="login.html"%> 
