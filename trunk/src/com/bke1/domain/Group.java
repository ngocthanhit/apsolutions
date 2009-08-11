package com.bke1.domain;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.bke1.domain.*;
public  class Group
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

		// clientId
		private String clientId;
		public String getClientId(){return clientId;}
		public void setClientId(String clientId){this.clientId=clientId;}

		// clientName
		private String clientName;
		public String getClientName(){return clientName;}
		public void setClientName(String clientName){this.clientName=clientName;}


		// franchiseId
		private String franchiseId;
		public String getFranchiseId(){return franchiseId;}
		public void setFranchiseId(String franchiseId){this.franchiseId=franchiseId;}

		// franchiseName
		private String franchiseName;
		public String getFranchiseName(){return franchiseName;}
		public void setFranchiseName(String franchiseName){this.franchiseName=franchiseName;}

	  //Bill
		private Object billCollection[] = null;
		public Object[] getBillCollection(){
			  return billCollection;
		}
		public void setBillCollection(Object[] billCollection){
			  this.billCollection=billCollection;
		}

		public String toString(){
			return 	" id :"+id;
		}
	
		
	}
