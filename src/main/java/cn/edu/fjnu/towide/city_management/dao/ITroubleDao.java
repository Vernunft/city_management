package cn.edu.fjnu.towide.city_management.dao;

import java.io.ObjectInputStream.GetField;

import org.apache.ibatis.annotations.ResultMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import cn.edu.fjnu.towide.city_management.common.SqlProvider;
import cn.edu.fjnu.towide.city_management.entity.Trouble;
//@CacheNamespace(size=512 ) 
//@Cacheable("staff")
@Repository
public interface ITroubleDao {
	
	/**
	 * 根据故障id查询出有效的故障单信息
	 * @param Id
	 * @return
	 */
	@Select("select * from table_trouble where id=#{Id} and flag =1")
	public Trouble getTroubleById(Long Id);

	/**
	 * 通过市民上报电话号码得到该市民上报的所有故障单，并按日期从大到小排序
	 * 
	 * @param phone
	 * @return
	 */
	@Select("SELECT * FROM table_trouble WHERE flag=1 AND report_citizen_telephone_number=#{phone} ORDER BY report_datetime DESC limit #{offset},#{size}")
	public List<Trouble> getTroublesByPhone(String phone);
	/**
	 * 通过故障单号查询出用户对此结果的满意度评价
	 * @param Id
	 * @return
	 */
	@Select("SELECT IFNULL(satisfaction_evaluation,0) FROM table_trouble WHERE id=#{Id} and flag =1")
	public int getsatisfactionEvaluationById(int Id);
	/**
	 * 通过停留部门id查询出该部门的待处理下派故障单/待处理反馈故障单/待处理正在施工故障单/在本部门结案的总数
	 * @param hashMap
	 * @return
	 */
	@Select("SELECT count(*) FROM table_trouble WHERE process_state=#{processState} and stay_department_id=#{stayDepartmentId}  and flag =1 ")
	public int getTroubleCountByPStateAndSDId(Map< String, Object> map);
	/**
	 * 通过故障停留部门id查找出该部门的某个状态的故障单
	 * @param hashMap
	 * @return
	 */
	@Select("select * from table_trouble where stay_department_id=#{stayDepartmentId} and process_state=#{processState} and flag =1 limit limit #{startRow},#{endRow}")
	public List<Trouble> getTroublesBySDIdAndPState(Map< String, Object> map);
	/**
	 * 添加故障单信息
	 * @param trouble
	 * @return
	 */
	

	@Insert("insert into table_trouble(report_citizen_telephone_number,report_staff_id,report_department_id,stay_department_id,dispose_staff_id,scene_description,scene_address,report_datetime,process_state,urgency_level,satisfaction_evaluation,flag)"
 +" values(#{reportCitizenTelephoneNumber},#{reportStaffId},#{reportDepartmentId},#{stayDepartmentId},#{disposeStaffId},#{sceneDescription},#{sceneAddress},#{reportDatetime},#{processState},#{urgencyLevel},#{satisfactionEvaluation},#{flag})")
	public int insertTrouble(Trouble trouble);
	/**
	 * 更新故障单信息
	 * @param trouble
	 * @return
	 */
   @UpdateProvider(type = SqlProvider.class,method = "updateTrouble")  
	public int updateTrouble(Trouble trouble);
   
	

}
