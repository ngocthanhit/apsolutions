
//validation for login form
    
  function returnAC()
   {		    
		    
		   // alert(document.getElementById('browse_ind').value);
			
			//alert(ind_error_msg.length);
			var login_val = document.getElementById('login').value;
			var len_at=login_val.indexOf('@');
			var len_str=login_val.length;
			var len_dot=login_val.indexOf('.');
			
			if(len_str == 0)
		    {		     
		      //jQuery.facebox('Username name is Empty');
		      document.getElementById('ind_error_msg').innerHTML = "Username name is Empty";
		      return false;
		    }
		    else if(len_str < 5)
		    {		     
		      //jQuery.facebox('Enter the valid Username');
		      document.getElementById('ind_error_msg').innerHTML = "Enter the valid Username";
		      return false;
		    }
		    else if (login_val.indexOf('@')==-1)
		    {
		      //jQuery.facebox('Enter the valid Username');
		      document.getElementById('ind_error_msg').innerHTML = "Enter the valid Username";
		      return false;
		     }
		     else if (login_val.indexOf('@')==-1 || login_val.indexOf('@')==0 || login_val.indexOf('@')==len_str)
		     {
		      //jQuery.facebox('Enter the valid Username');
		       document.getElementById('ind_error_msg').innerHTML = "Enter the valid Username";
		      return false
		     }
		     else if (login_val.indexOf('.')==-1 || login_val.indexOf('.')==0 || login_val.indexOf('.')==len_str)
		     {
		      // jQuery.facebox('Enter the valid Username');
		        document.getElementById('ind_error_msg').innerHTML = "Enter the valid Username";
		       return false ;
		     }
		     
		      else if (login_val.indexOf('@',(len_at+1))!=-1)
		     {
		       //jQuery.facebox('Enter the valid Username');
		        document.getElementById('ind_error_msg').innerHTML = "Enter the valid Username";
		       return false ;
		     }
		      else if (login_val.substring(len_at-1,len_at)=='.' || login_val.substring(len_at+1,len_at+2)=='.')
		     {
		       //jQuery.facebox('Enter the valid Username');
		        document.getElementById('ind_error_msg').innerHTML = "Enter the valid Username";
		       return false;
		     }
		     else if (login_val.indexOf('.',(len_at+2))==-1)
		     {
		       //jQuery.facebox('Enter the valid Username');
		        document.getElementById('ind_error_msg').innerHTML = "Enter the valid Username";
		       return false;
		     }
		      else if (login_val.indexOf(" ")!=-1)
		     {
		      //jQuery.facebox('Enter the valid Username');
		      document.getElementById('ind_error_msg').innerHTML = "Enter the valid Username";
		      return false
		     }
		    else if(document.getElementById('password').value.length == 0)
		    {
		     
		      //jQuery.facebox('Password field is empty');
		      document.getElementById('ind_error_msg').innerHTML = "Password field is empty";
		      return false;
		    }
		    else if(document.getElementById('password').value.length < 4)
		    {
		     //jQuery.facebox("Enter the valid password");
		      document.getElementById('ind_error_msg').innerHTML = "Enter the valid password";
		      return false;
		    }
		    else if(document.getElementById('image').value.length == 0)
		    {
		      //jQuery.facebox("Enter the Resoultion Value");
		      document.getElementById('ind_error_msg').innerHTML = "Enter the Resoultion Value";
		      return false;
		    }
		    else if(document.getElementById('lastImageLocation').value.length == 0)
		    {
		      if(document.getElementById('browse_ind').value.length == 0)
		      {
		       //jQuery.facebox("Choose the File");
		       document.getElementById('ind_error_msg').innerHTML = "Select Image File Folder";
		      }
		      else
		      {
		      document.getElementById('lastImageLocation').value = document.getElementById('browse_ind').value;
		      }
		      return false;
		    }
		    
		  else 
		    {
		     document.getElementById('lac').value='lac';
		     returnACNew();		     
		     return true;
		    }
		    
		}
	//end of validation for login form	
	
	function validForAddPage()
	{
	  //alert("validForAddPage");
	   if(document.getElementById('clientName').value.length == 0)
	   {
	     jQuery.facebox("Enter the Client Name");
		      return false;
	   }
	   else if(document.getElementById('vendor').value.length == 0)
	   {
	     jQuery.facebox("Enter the Franchise Name");
		      return false;
	   }
	   else
	   {
	     document.getElementById('mv').value=ss11;

		insertUnSavedItems();

		//imageWindow.document.uploadForm.mv.value='clear';

		//imageWindow.document.uploadForm.Object1.src='';

		if(imageWindow.document.uploadForm.Object1.src!=null){
			/*** Checking previouse Image and submitting **/
			//alert('inside save and return 5')
			//pausecomp(300);
			
						imageWindow.document.uploadForm.submitButton.click();
			//pausecomp(300);
			
			//imageSubmitCaller(document.getElementById('inim').value);
		//alert('inside save and return 6')
		}else{

			//		alert('there is no image')
		}

	//	imageWindow.document.uploadForm.reset();
	//	imageWindow.document.uploadForm.Object1.src="";
		//alert('Image window '+imageWindow.document.uploadForm.vo.value);


		var invoiceId = document.getElementById('invoiceId').value;
		//alert('invoiceId.val'+invoiceId);
  	editValue(document.getElementById('status').value,'<%=invoiceStatus_ColID%>','<%=invoiceTableId%>',invoiceId);
  	document.voucherInvoiceAllocation.submit();
	//pausecomp(300);
	//agentWindow.close();
	//alert('3');
	imageWindow.close();
	//alert('4');
	//return false;
	   }
	   
	}
		