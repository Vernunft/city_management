package cn.edu.fjnu.towide.city_management.entity;

import java.io.Serializable;

public class Department implements Serializable{//部门表
	private Long  id;
	private Long parentId;
	private String name;
	private String function;
	private String  permissions;
	private Integer flag;
	
	public Department() {
	}

	public Department(Long id, Long parentId, String name, String function, String permissions,
			Integer flag) {
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.function = function;
		this.permissions = permissions;
		this.flag = flag;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

}
