package cn.edu.fjnu.towide.city_management.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.edu.fjnu.towide.city_management.common.DepartmentTree;
import cn.edu.fjnu.towide.city_management.common.PageParam;
import cn.edu.fjnu.towide.city_management.entity.Bulletin;
import cn.edu.fjnu.towide.city_management.entity.Citizen;
import cn.edu.fjnu.towide.city_management.entity.Department;
import cn.edu.fjnu.towide.city_management.entity.SceneSituation;
import cn.edu.fjnu.towide.city_management.entity.Staff;
import cn.edu.fjnu.towide.city_management.entity.Trouble;
import cn.edu.fjnu.towide.city_management.entity.TroubleOperation;
   

public interface IAuditorService {
	// 紧急时，给出下级部门
	public void getDepartmentTree(Set<DepartmentTree> department, Long departmentId, int grade) throws Exception;

	// 根据id给出操作记录
	public List<TroubleOperation> getTroublesDetail(Long troubleId) throws Exception;

	// 根据id给出勘测详情
	public List<SceneSituation> getTroubleSceneSituation(Long troubleId) throws Exception;
	//通过部门id查出相应部门信息
	public Department getDepartmentById(Long departmentId)throws Exception;


	// 通过停留部门id跟处理状态获取故障记录数
	public int getTroublesCountByStaAndDep(int state, Long stayDepartmentId) throws Exception;

	// 根据停留部门id以及处理状态获取故障信息
	public List<Trouble> getTroublesByStateAndDep(PageParam pageParam, int state, Long stayDepartmentId)
			throws Exception;

	// 添加操作故障记录
	public void insertTroubleOperation(TroubleOperation troubleOperation) throws Exception;

	// 更新故障表
	public void updateTrouble(Trouble trouble);

	// 通过市民电话找到市民信息
	public Citizen getCitizenByTel(String telephoneNumber) throws Exception;
	// 更新市民信息

	public void updateCitizen(Citizen citizen) throws Exception;

	// 更新员工信息

	public void updateStaff(Staff staff) throws Exception;
	// 更新公告信息

	public void updateBulletin(Bulletin bulletin) throws Exception;

	// 根据故障id查询故障

	public Trouble getTroubleById(Long troubleId) throws Exception;

	// 根据上级部门id获取下级部门信息

	public List<Department> getLowerDepartmentById(Long parentId) throws Exception;

	// 根据部门id得到部门信息

	public Department getParentDepartmentById(Long stayDepartmentId) throws Exception;

	// 根据所做操作获取故障操作记录
	public List<TroubleOperation> getTroubleByOpeAndDep(Map<String, Object> map) throws Exception;
}