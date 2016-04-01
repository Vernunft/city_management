package cn.edu.fjnu.towide.city_management.common;


import cn.edu.fjnu.towide.city_management.entity.Department;

public class DepartmentTree {
	private  Long departmentId;//所处部门id
	private Department info;//部门内容
	private int grade;//等级
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public Department getInfo() {
		return info;
	}
	public void setInfo(Department info) {
		this.info = info;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "DepartmentTree [departmentId=" + departmentId + ", info=" + info + ", grade=" + grade + "]";
	}
	public DepartmentTree(Long departmentId, Department info, int grade) {
		super();
		this.departmentId = departmentId;
		this.info = info;
		this.grade = grade;
	}
	public DepartmentTree() {
		super();
		
	}
	
	

}
