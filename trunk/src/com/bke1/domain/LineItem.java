
package com.bke1.domain;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.bke1.domain.*;
public  class LineItem
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
	  
	  
		// amount
		private String amount;
		public String getAmount(){return amount;}
		public void setAmount(String amount){this.amount=amount;}

	  
	  // number
		private String number;
		public String getNumber(){return number;}
		public void setNumber(String number){this.number=number;}


		// accountName
		private String accountName;
		public String getAccountName(){return accountName;}
		public void setAccountName(String accountName){this.accountName=accountName;}


		// memo
		private String memo;
		public String getMemo(){return memo;}
		public void setMemo(String memo){this.memo=memo;}

	
		// status
		private String status;
		public String getStatus(){return status;}
		public void setStatus(String status){this.status=status;}

	
		public String toString(){
			return 	" id :"+id;
		}
	
		
	}
