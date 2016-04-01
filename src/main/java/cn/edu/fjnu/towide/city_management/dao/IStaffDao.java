package cn.edu.fjnu.towide.city_management.dao;


import java.util.List;



import org.apache.ibatis.annotations.ResultMap;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import cn.edu.fjnu.towide.city_management.common.SqlProvider;
import cn.edu.fjnu.towide.city_management.entity.Staff;

@Repository
@CacheNamespace(size=512 ) 
public interface IStaffDao  {	
	/**
	 * 更新员工信息
	 * @param staff
	 * @return
	 */
	@UpdateProvider(type = SqlProvider.class,  method = "updateStaff")  
	public int updateStaff(Staff staff);

	/**
	 * 通过员工id查询员工信息
	 * @param staff
	 * @return
	 */
	//@Cacheable(value="staff")
	@Select("select * from table_staff where id=#{id}")
	@Options(useCache=true,flushCache=false,timeout=10000)
	public Staff getStaffById(Long id);
	
	/**
	 * 通过id，password，role获取角色信息
	 * @param staff
	 * @return
	 */
	@Select("select * from table_staff where id=#{id} and password=#{password} and role=#{role} and flag=#{flag}")
	public Staff getStaffByIdAndPasAndRole(Staff staff);
	
	/**
	 * 增加员工
	 * @param staff
	 * @return
	 */
	@Insert("insert into table_staff(id,department_id,password,salt,name,telephone_number,email,role,flag) values(#{id},#{departmentId},#{password},#{name},#{telephoneNumber},#{email},#{role},#{flag})")
	public int insertStaff(Staff staff);
	
	/**
	 * 通过员工角色查询员工信息
	 * @param staff
	 * @return
	 */
	@Select("select * from table_staff where role=#{role} and flag=1 ")
	public List<Staff> getStaffByRoleAndFlag(Staff staff);
	

}
