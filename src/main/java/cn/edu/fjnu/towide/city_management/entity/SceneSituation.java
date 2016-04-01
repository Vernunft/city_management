package cn.edu.fjnu.towide.city_management.entity;


import java.io.Serializable;
import java.sql.Timestamp;

public class SceneSituation implements Serializable {
	private Long id;
	   private Long troubleId;
	   private Long staffId;
	   private Long staffDepartmentId;
	   private Integer type;
	   private String description;
	   private String address;
	   private Timestamp date;
	   private Integer  flag;
		public SceneSituation() {	
		}
		public SceneSituation(Long id, Long troubleId, Long staffId, Long staffDepartmentId,
				Integer type, String description, String address, Timestamp date, Integer flag) {
			this.id = id;
			this.troubleId = troubleId;
			this.staffId = staffId;
			this.staffDepartmentId = staffDepartmentId;
			this.type = type;
			this.description = description;
			this.address = address;
			this.date = date;
			this.flag = flag;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Long getTroubleId() {
			return troubleId;
		}
		public void setTroubleId(Long troubleId) {
			this.troubleId = troubleId;
		}
		public Long getStaffId() {
			return staffId;
		}
		public void setStaffId(Long staffId) {
			this.staffId = staffId;
		}
		public Long getStaffDepartmentId() {
			return staffDepartmentId;
		}
		public void setStaffDepartmentId(Long staffDepartmentId) {
			this.staffDepartmentId = staffDepartmentId;
		}
		public Integer getType() {
			return type;
		}
		public void setType(Integer type) {
			this.type = type;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public Timestamp getDate() {
			return date;
		}
		public void setDate(Timestamp date) {
			this.date = date;
		}
		public Integer getFlag() {
			return flag;
		}
		public void setFlag(Integer flag) {
			this.flag = flag;
		}

}
