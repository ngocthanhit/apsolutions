import java.awt.*;
import java.applet.Applet;
import java.applet.*;
import java.security.*;
import java.io.FilePermission;
import java.security.PrivilegedAction;
import java.security.AccessController;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;


public class FileDeleteApplet extends Applet
{
    public String allFiles;
	public String allFiles1;
	public int imageArrayLength=0;

    public void init()
    {
    }


	public String file2Delete;
	public String delFile(String fileToDelete ){

	file2Delete = fileToDelete;

	Permission perm = new RuntimePermission("accessDeclaredMembers");

	     return (file2Delete.length()>0)
		 ?
		 (String) AccessController.doPrivileged(new PrivilegedAction() {
		    public Object run() {
				return deleteThisFile(file2Delete);
		    }
		  })
		 :"file to delete is not valid "+file2Delete;
	}



	public String deleteThisFile(String deleteThisFile){
		String message ="";
			    try {

							File filedel = new File(deleteThisFile);
							if (!filedel.exists())
								message = "Delete ---- no such file or directory: "+deleteThisFile;
							if (!filedel.canWrite())
								  message = "Delete ---- write protected: "+deleteThisFile;
							if (filedel.isDirectory()) {
								  String[] files = filedel.list();
								  if (files.length > 0)
									message = "Delete ---- directory not empty: "+deleteThisFile;
							}
							boolean success = filedel.delete();

							if (!success){
								message = "Delete: deletion failed"+deleteThisFile;
							}else{
									message = "The file "+deleteThisFile+" has been Succefully deleted ";
							}
		     			} catch (Exception e) {
		     				message = "Cannot load file "+deleteThisFile+" exception!  "+e.getMessage();
     				}
     		return message;
	}

/*
    public void delFile (String caller) {

		pp = caller;
		try {
	 	    Permission perm = new RuntimePermission("accessDeclaredMembers");

			System.out.println("Calling Delete in Applet");


	 	    AccessController.doPrivileged(new PrivilegedAction() {
		        public Object run() {
			    try {

					File filedel = new File(pp);
					if (!filedel.exists())
						System.out.println("Delete ---- no such file or directory: ");
					if (!filedel.canWrite())
						  System.out.println("Delete ---- write protected: ");
					if (filedel.isDirectory()) {
						  String[] files = filedel.list();
						  if (files.length > 0)
							System.out.println("Delete ---- directory not empty: ");
					}
					boolean success = filedel.delete();
					if (!success){
						System.out.println("Delete: deletion failed");
					}
     			} catch (Exception e) {
     				System.out.println("Cannot load, exception!");
     			}
	            return null;
     	   	}});

			//m_mess.setText("Selection : " + pp);

				System.out.println("Completed Delete in Applet");

 		} catch (AccessControlException ex) {
 			System.out.println("false");
 			ex.printStackTrace();
 		}
	}

*/

	public String submitFile(String fromFile,String toFile,String invoiceId ){
		System.out.println("Applet recieved fromFile  "+fromFile);
		System.out.print("toFile "+toFile);
		System.out.print("invoiceId "+invoiceId);

		String result = "false";
		String baseUrlStr = "http://localhost:8090/bke1/";
		//String baseUrlStr = "https://do-ap.com/bke1/";

		//request.getRequestURL().toString();

		try
		{

	//			System.out.println("In submitFile 2 baseUrlStr  >>>"+baseUrlStr);
				URL url = new URL("http://localhost:8090/bke1/FileProcess.jsp?ii="+invoiceId+"&tf="+toFile);
	//			URL url = new URL("https://do-ap/bke1/FileProcess.jsp?ii="+invoiceId+"&tf="+toFile);
				// create a boundary string
				String boundary = MultiPartFormOutputStream.createBoundary();
				URLConnection urlConn = MultiPartFormOutputStream.createConnection(url);

				System.out.println("In submitFile 3");

				urlConn.setRequestProperty("Accept", "*/*");
				urlConn.setRequestProperty("Content-Type","application/octet-stream");
				//	MultiPartFormOutputStream.getContentType(boundary));
				// set some other request headers...
				//urlConn.setRequestProperty("Connection", "Keep-Alive");
				urlConn.setRequestProperty("Cache-Control", "no-cache");


				System.out.println("In submitFile 4");

				// no need to connect cuz getOutputStream() does it
				MultiPartFormOutputStream out =
					new MultiPartFormOutputStream(urlConn.getOutputStream(), boundary);


				int maxByteSize = 8192;
				//out.writeFile(toFile, "application/pdf", new File(fromFile));

								InputStream stream = new FileInputStream(new File(fromFile));


								OutputStream bos = urlConn.getOutputStream();
									    int bytesRead = 0;
									    byte[] buffer = new byte[maxByteSize];

									    while ((bytesRead = stream.read(buffer, 0, maxByteSize)) != -1) {
										  //System.out.println("Reading from Stream ");
										  bos.write(buffer, 0, bytesRead);
										  //System.out.println("Writing from Stream ");
									    }

									bos.close();
									stream.close();
									out.close();

				// read response from server
				BufferedReader in = new BufferedReader(
					new InputStreamReader(urlConn.getInputStream()));
				String line = "";
				while((line = in.readLine()) != null) {
					 System.out.println("Response from Servlet "+line);
				}




				in.close();
				result=line;

				System.out.println("In submitFile 5");

		}
		catch (IOException ioe)
		{
				System.err.println("IO problem  >> "+ioe.toString());
		}
		catch (Exception me)
		{
				System.err.println("Error handling request: >>>" + me.getMessage());
		}

		return result;

	}





	public String ff,tf,ii;
	public String sendFile(String fromFile,String toFile,String invoiceId ){

	ff = fromFile;
	tf = toFile;
	ii = invoiceId;

	Permission perm = new RuntimePermission("accessDeclaredMembers");

	     return (ff.length()>0)
		 ?
		 (String) AccessController.doPrivileged(new PrivilegedAction() {
		    public Object run() {
				System.out.println("fromFile>> "+ff+"  toFile>> "+tf+" Current invoiceId >>> " +ii);
				return submitFile(ff,tf,ii);
		    }
		  })
		 :"";
	}





	public String fromDir;
	public String getAllFiles(String dirName){

	this.fromDir = dirName;

	Permission perm = new RuntimePermission("accessDeclaredMembers");


	     return (dirName.length()>0)
		 ?
		 (String) AccessController.doPrivileged(new PrivilegedAction() {
		    public Object run() {
				//System.out.println("fromDir" + fromDir);
				return listAllFiles(fromDir);
		    }
		  })
		 :"";
	}



public String listAllFiles(String dirName){
				try {

	   				//This example lists the files and subdirectories in a directory. To list all descendant files and subdirectories under a directory,
				   // File dir = new File("C:\\1DocuOrganiz\\artifacts\\DelInvoices");
					File dir = new File(fromDir);
					String[] children = dir.list();
					if (children == null) {
						// Either dir does not exist or is not a directory
					} else {
						for (int i=0; i<children.length; i++) {
							// Get fromFile of file or directory
							String filename = children[i];
						}
					}
					// It is also possible to filter the list of returned files.
					// This example does not return any files that start with `.'.
					FilenameFilter filter = new FilenameFilter() {
						public boolean accept(File dir, String name) {
							return name.endsWith(".pdf");
						}
					};
					children = dir.list(filter);
					System.out.println("children Length "+children.length);

					imageArrayLength=children.length;
					//allFiles1 = children;
					//String fileStr  = "<SCRIPT LANGUAGE='JavaScript'> fileArray = new Array("+children.length+");";
					for (int i=0; i<children.length; i++) {
						//System.out.println("allFiles "+i+"  name "+children[i]);
					allFiles1=allFiles1+"&"+children[i];
					//fileStr  = fileStr +"\n fileArray["+i+"] = \""+children[i]+"\";";
					//length1=i;
					}
					//length1++;
					//allFiles = fileStr+"</SCRIPT>";
			}catch (Exception e) {
					System.out.println("Oops! "+e.getMessage());
			}
		return 	 allFiles1;
}




}