package com.bke1.domain;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.bke1.domain.*;
public  class Franchise
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

	  //FranchiseUser
		private Object franchiseUserCollection[] = null;
		public Object[] getFranchiseUserCollection(){
			  return franchiseUserCollection;
		}
		public void setFranchiseUserCollection(Object[] franchiseUserCollection){
			  this.franchiseUserCollection=franchiseUserCollection;
		}

		
	}
