package com.bke1.domain;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.bke1.domain.*;
public  class Client
	implements java.io.Serializable
	{

		private static final long serialVersionUID = 1234567890L;

		
		// id1
		private String id1;
		public String getId1(){return id1;}
		public void setId1(String id1){this.id1=id1;}
	
		// id
		private String id;
		public String getId(){return id;}
		public void setId(String id){this.id=id;}

		// name
		private String name;
		public String getName(){return name;}
		public void setName(String name){this.name=name;}

	  //Franchise
		private Franchise franchise = null;
		public Franchise getfranchise(){
			  return franchise;
		}
		public void setFranchise(Franchise franchise){
			  this.franchise=franchise;
		}

	  //ClientUser
		private Object clientUserCollection[] = null;
		public Object[] getClientUserCollection(){
			  return clientUserCollection;
		}
		public void setClientUserCollection(Object[] clientUserCollection){
			  this.clientUserCollection=clientUserCollection;
		}

	  //Group
		private Object groupCollection[] = null;
		public Object[] getGroupCollection(){
			  return groupCollection;
		}
		public void setGroupCollection(Object[] groupCollection){
			  this.groupCollection=groupCollection;
		}

	  //OtherDocument
		private Object otherDocumentCollection[] = null;
		public Object[] getOtherDocumentCollection(){
			  return otherDocumentCollection;
		}
		public void setOtherDocumentCollection(Object[] otherDocumentCollection){
			  this.otherDocumentCollection=otherDocumentCollection;
		}

	  //VendorControl
		private Object vendorControlCollection[] = null;
		public Object[] getVendorControlCollection(){
			  return vendorControlCollection;
		}
		public void setVendorControlCollection(Object[] vendorControlCollection){
			  this.vendorControlCollection=vendorControlCollection;
		}



		public String toString(){
			return 	" name :"+name;
		}
			
	}
