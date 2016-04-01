package cn.edu.fjnu.towide.city_management.entity;

import java.beans.Transient;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
//implements Serializable 
public class TroubleOperation implements Serializable{
	 private Long troubleId;
	  private Long staffDepartmentId;
	  private Long staffId;
	  private String operation;
	  private Timestamp  operationDatetime;
	  private String postscript;
	  private Integer flag;
		public TroubleOperation() {
			super();
		}
		public TroubleOperation(Long troubleId, Long staffDepartmentId, Long staffId, String operation,
				Timestamp operationDatetime, String postscript, Integer flag) {
			this.troubleId = troubleId;
			this.staffDepartmentId = staffDepartmentId;
			this.staffId = staffId;
			this.operation = operation;
			this.operationDatetime = operationDatetime;
			this.postscript = postscript;
			this.flag = flag;
		}
		public Long getTroubleId() {
			return troubleId;
		}
		public void setTroubleId(Long troubleId) {
			this.troubleId = troubleId;
		}
		public Long getStaffDepartmentId() {
			return staffDepartmentId;
		}
		public void setStaffDepartmentId(Long staffDepartmentId) {
			this.staffDepartmentId = staffDepartmentId;
		}
		public Long getStaffId() {
			return staffId;
		}
		public void setStaffId(Long staffId) {
			this.staffId = staffId;
		}
		public String getOperation() {
			return operation;
		}
		public void setOperation(String operation) {
			this.operation = operation;
		}
		public Timestamp getOperationDatetime() {
			return operationDatetime;
		}
		public void setOperationDatetime(Timestamp operationDatetime) {
			this.operationDatetime = operationDatetime;
		}
		public String getPostscript() {
			return postscript;
		}
		public void setPostscript(String postscript) {
			this.postscript = postscript;
		}
		public Integer getFlag() {
			return flag;
		}
		public void setFlag(Integer flag) {
			this.flag = flag;
		}
		@Override
		public String toString() {
			return "TroubleOperation [troubleId=" + troubleId + ", staffDepartmentId=" + staffDepartmentId
					+ ", staffId=" + staffId + ", operation=" + operation + ", operationDatetime=" + operationDatetime
					+ ", postscript=" + postscript + ", flag=" + flag + "]";
		}
	
		

}
