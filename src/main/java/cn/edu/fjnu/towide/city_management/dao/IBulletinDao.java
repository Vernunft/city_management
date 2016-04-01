package cn.edu.fjnu.towide.city_management.dao;

import java.sql.Timestamp;


import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import cn.edu.fjnu.towide.city_management.common.SqlProvider;
import cn.edu.fjnu.towide.city_management.entity.Bulletin;



@CacheNamespace(size=512)
@Repository
public interface IBulletinDao {
	/**
	 * 查询所有公告
	 * @return
	 */
	@Select("select * from table_bulletin order by date")
	public List<Bulletin> getAllBulletin();
	/**
	 * 通过公告id查找公告
	 * @param id
	 * @return
	 */
	@Select("select * from table_bulletin where id =#{id} order by date")
	public Bulletin getBulletinById(Long id);
	/**
	 * 通过发布员工id查找所有公告
	 * @param staffId
	 * @return
	 */
	@Select("select * from table_bulletin where staff_id =#{staffId} order by date")
	public List<Bulletin> getBulletinByStaffId(Long staffId);
	/**
	 * 通过标题查找所有公告
	 * @param title
	 * @return
	 */
	@Select("select * from table_bulletin where title like '%${value}%' order by date")
	public List<Bulletin> getBulletinByTitle(String title);
	/**
	 * 通过内容查找所有公告
	 * @param content
	 * @return
	 */
	@Select("select * from table_bulletin where content like '%${value}%' order by date")
	public List<Bulletin> getBulletinByContent(String content);
	/**
	 * 通过公告发布时间查找公告
	 * @param date
	 * @return
	 */
	@Select("select * from table_bulletin where date = #{date} order by date")
	public List<Bulletin> getBulletinByDate(Timestamp date);
	/**
	 * 新增公告
	 * @param bulletin
	 * @return
	 */
	@Insert("insert into table_bulletin (id,staff_id,title,date,content,flag) "
			+ "values(#{id},#{staffId},#{title},#{date},#{content},#{flag})")
	public int insertBulletin(Bulletin bulletin);
	/**
	 * 更新公告
	 * @param bulletion
	 * @return
	 */
	 @UpdateProvider(type = SqlProvider.class,method = "updateBullentin")  
	public int updateBulletin(Bulletin bulletin);
	

}
