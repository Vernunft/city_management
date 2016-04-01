package cn.edu.fjnu.towide.city_management.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import cn.edu.fjnu.towide.city_management.common.SqlProvider;
import cn.edu.fjnu.towide.city_management.entity.SceneSituation;
@CacheNamespace(size=512 ) 
@Repository
public interface ISceneSituationDao {
	/**
	 * 获取所有的现场勘查表
	 * @return
	 */
	@Select("select * from table_scene_situation")
	public List<SceneSituation> getAllSceneSituation();
	
	/**
	 * 通过勘测表id查询对应的记录
	 * @param id
	 * @return
	 */
	@Select("select * from table_scene_situation where id=#{id}")
	public SceneSituation getSceneSituationById(Long id);
	
	/**
	 * 通过故障id字段查询对应的记录
	 * @param id
	 * @return
	 */
	@Select("select * from table_scene_situation where trouble_id=#{troubleId}")
	public List<SceneSituation> getSceneSituationByTroubleId(Long id);
	
	/**
	 * 通过工作人员id字段查询对应的记录（查看处理报料单历史记录）
	 * @param id
	 * @return
	 */
	@Select("select * from table_scene_situation where staff_id=#{staffId}")
	public SceneSituation getSceneSituationByStaffId(Long id);
	
	/**
	 * 根据现场勘测表的状态返回勘测表集合（查看未处理报料单具体信息）
	 * @param type
	 * @return
	 */
	@Select("select * from table_scene_situation where type=#{type}")
	public List<SceneSituation> getSceneSituationByType(Integer type);
	
	/**
	 * 根据现场勘测表的id和状态返回该记录(反馈经过处理的勘测表信息)
	 * @param sceneSituation
	 * @return
	 */
	@Select("select * from table_scene_situation where id=#{id} and type=#{type}")
	public SceneSituation getSceneSituationByIdAndType(SceneSituation sceneSituation);
	
	/**
	 * 增加现场勘测表
	 * @param sceneSituation
	 */
	@Insert("insert into table_scene_situation(trouble_id,staff_id,staff_department_id,type,description,address,date,flag) VALUES(#{troubleId},"
			+ "#{staffId},#{staffDepartmentId},#{type},#{description},#{address},#{date},#{flag}")
	public void insertSceneSituation(SceneSituation sceneSituation);
	
	/**
	 * 修改现场勘测表信息
	 * @param sceneSituation
	 */
    @UpdateProvider(type = SqlProvider.class,method = "updateSceneSituation")  
	public void updateSceneSituation(SceneSituation sceneSituation);
	

}
