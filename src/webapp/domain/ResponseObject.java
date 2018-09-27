package webapp.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ResponseObject { 
		private boolean success = false;
		private Set<? extends Object> data;
		private String message = null;
		
		public ResponseObject(Set<? extends Object> objList,boolean success,String message){
		  this.success = success;
		  this.data = objList;
		  this.message = message;
		}
	  
		public ResponseObject(String errorMsg){
		  Set<String> errorList = new HashSet<String>();
		  errorList.add(errorMsg);
		  this.success = success;
		  this.data = errorList; 
		}
  
		public ResponseObject() {
		// TODO Auto-generated constructor stub
		}
		
		

		/**
		 * @return the success
		 */
		public boolean isSuccess() {
			return success;
		}

		/**
		 * @param success the success to set
		 */
		public void setSuccess(boolean success) {
			this.success = success;
		}

		/**
		 * @return the data
		 */
		public Set<? extends Object> getData() {
			return data;
		}

		/**
		 * @param data the data to set
		 */
		public void setData(Set<? extends Object> data) {
			this.data = data;
		}
		
		
}
