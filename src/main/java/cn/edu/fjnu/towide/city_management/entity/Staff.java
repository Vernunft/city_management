package cn.edu.fjnu.towide.city_management.entity;

import java.io.Serializable;

public class Staff implements Serializable{
	@Override
	public String toString() {
		return "Staff [id=" + id + ", departmentId=" + departmentId + ", password=" + password + ", name=" + name
				+ ", telephoneNumber=" + telephoneNumber + ", salt=" + salt + ", email=" + email + ", role=" + role
				+ ", flag=" + flag + "]";
	}
	private Long id;
	  private Long departmentId;
	  private String password;
	  private String name;
	  private String telephoneNumber;
	  private String salt;
	  private String email;
	  private Integer  role;
	  private Integer  flag;
		public Staff() {
			
		}
		
		public Staff(Long id, Long departmentId, String password, String name, String telephoneNumber, String salt,
				String email, Integer role, Integer flag) {
			super();
			this.id = id;
			this.departmentId = departmentId;
			this.password = password;
			this.name = name;
			this.telephoneNumber = telephoneNumber;
			this.salt = salt;
			this.email = email;
			this.role = role;
			this.flag = flag;
		}
		

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getDepartmentId() {
			return departmentId;
		}

		public void setDepartmentId(Long departmentId) {
			this.departmentId = departmentId;
		}

		public String getSalt() {
			return salt;
		}

		public void setSalt(String salt) {
			this.salt = salt;
		}

		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getTelephoneNumber() {
			return telephoneNumber;
		}
		public void setTelephoneNumber(String telephoneNumber) {
			this.telephoneNumber = telephoneNumber;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Integer getRole() {
			return role;
		}
		public void setRole(Integer role) {
			this.role = role;
		}
		public Integer getFlag() {
			return flag;
		}
		public void setFlag(Integer flag) {
			this.flag = flag;
		}

}
