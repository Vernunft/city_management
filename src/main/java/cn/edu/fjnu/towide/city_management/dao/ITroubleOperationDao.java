package cn.edu.fjnu.towide.city_management.dao;

import java.util.List;

import java.util.Map;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import cn.edu.fjnu.towide.city_management.common.SqlProvider;
import cn.edu.fjnu.towide.city_management.entity.TroubleOperation;
@CacheNamespace(size=512 ) 
//@Cacheable("staff")
@Repository
public interface ITroubleOperationDao {
	/**
	 * 查询故障操作记录信息列表
	 * 
	 * @param TroubleOperation
	 * @return
	 */
	
	@Select("select * from table_trouble_operation")
	public List<TroubleOperation> getAllTroubleOperation();

	/**
	 * 通过员工id查询故障操作记录信息
	 * 
	 * @param String
	 * @return
	 */
	@Select("select * from table_trouble_operation where staff_id=#{staffId}")
	public List<TroubleOperation> getTroubleOperationByStaffId(Long StaffId);

	/**
	 * 通过故障id查询故障操作记录信息,按操作时间降序排序
	 * 
	 * @param String
	 * @return
	 */
	@Select("select * from table_trouble_operation where trouble_id=#{troubleId} order by operation_datetime desc")
	public List<TroubleOperation> getTroubleOperationByTroubleId(Long troubleId);

	/**
	 * 通过操作人员所属部门id查询故障操作记录信息
	 * 
	 * @param String
	 * @return
	 */
	@Select("select * from table_trouble_operation where staff_department_id=#{staffDepartmentId}")
	public List<TroubleOperation> getTroubleOperationByStaffDepartmentId(Long id);

	/**
	 * 根据所做操作获取故障操作记录
	 * 
	 * @param operation
	 * @return
	 */
	@Select("select * from table_trouble_operation where operation=#{operation} and postscript=#{postscript} and department_id=#{departmentId}")
	public List<TroubleOperation> getTroubleByOpeAndDep(Map<String, Object> map);

	/**
	 * 更新故障操作记录信息
	 * 
	 * @param TroubleOperation
	 * @return
	 */
	@UpdateProvider(type = SqlProvider.class, method = "updateTroubleOperation")
	public int updateTroubleOperation(TroubleOperation troubleOperation);

	/**
	 * 增加故障操作记录
	 * 
	 * @param TroubleOperation
	 * @return
	 */
	@Insert("insert into table_trouble_operation(trouble_id,staff_department_id,staff_id,operation,operation_datetime,postscript,flag)"
			+ "values(#{troubleId},#{staffDepartmentId},#{staffId},#{operation},#{operationDatetime},#{postscript},#{flag})")
	public int insertTroubleOperation(TroubleOperation troubleOperation);

}
