package cn.edu.fjnu.towide.city_management.entity;

import java.io.Serializable;
//
public class Citizen implements Serializable {//市民
	private String telephoneNumber;
	private String name;
	private Integer state;
	private String password;
	private String salt;
	private Integer integral;
	private Integer flag;
	
	public Citizen() {
		
	}
    
	
	public Citizen(String telephoneNumber, String name, Integer state, String password, String salt, Integer integral,
			Integer flag) {
		super();
		this.telephoneNumber = telephoneNumber;
		this.name = name;
		this.state = state;
		this.password = password;
		this.salt = salt;
		this.integral = integral;
		this.flag = flag;
	}
	


	public String getSalt() {
		return salt;
	}


	public void setSalt(String salt) {
		this.salt = salt;
	}


	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Citizen [telephoneNumber=" + telephoneNumber + ", name=" + name + ", state=" + state + ", password="
				+ password + ", integrate=" + integral + ",flag=" + flag +"]";
	}	
	
	
    
    
}
