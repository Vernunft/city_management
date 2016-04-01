package cn.edu.fjnu.towide.city_management.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import cn.edu.fjnu.towide.city_management.common.SqlProvider;
import cn.edu.fjnu.towide.city_management.entity.Department;

@CacheNamespace(size=512 ) 
@Repository
public interface IDepartmentDao {
	/**
	 * 获取所有部门
	 * @return
	 */
	
	@Select("select * from table_department where flag=1")
	public List<Department> getAllDepartment();
	/**
	 * 通过id得到部门信息
	 * @param id
	 * @return
	 */
	@Select("select * from table_department where id=#{id} and flag=1")
	public Department getDepartmentById(Long id);
	/**
	 * 根据部门名称查询
	 * @param departmentName
	 * @return
	 */
	@Select("select * from table_department where name like '%${name}%' and flag=1")
	public Department getDepartmentByName(String name);
	
	/**
	 * 根据部门职能查询
	 * @param function
	 * @return
	 */
	@Select("select * from table_department where function like '%${function}%' and flag=1")
	public List<Department> getDepartmentByFunction(String function);
	
	/**
	 * 根据部门权限查询
	 * @param permissions
	 * @return
	 */
	@Select("select * from table_department where permissions like '%${permissions}%' and flag=1")
	public List<Department> getDepartmentByPermissions(String permissions);
	
	
	@Select("select * from table_department where parent_id=#{parentId} and flag=1")
	public List<Department> getDepartmentByParentId(Long parentId);
	@Select("select id from table_department where parent_id=#{parentId} and flag=1")
	public List<Long> getDepartmentIdByParentId(Long parentId);
	/**
	 * 新增部门
	 * @param department
	 */
	@Insert("insert into table_department(id,parent_id,name,function,permissions,flag)"
			+ "values(#{id},#{parentId},#{name},#{function},#{permissions},#{flag})")
	public int insertDepartment(Department department);

	/**
	 * 修改部门信息
	 * @param department
	 */
	@UpdateProvider(type = SqlProvider.class,method = "updateDepartment")  
	public int  updateDepartment(Department department);
	

}
