package cn.edu.fjnu.towide.city_management.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import cn.edu.fjnu.towide.city_management.common.SqlProvider;
import cn.edu.fjnu.towide.city_management.entity.Citizen;

@CacheNamespace(size=512 ) 

@Repository
public interface ICitizenDao {

	//根据电话号码查询市民信息
	@Select("select * from table_citizen WHERE telephone_number=#{telephoneNumber}  and flag=1")
	public Citizen getCitizenByTelephone(String telephoneNumber)throws Exception;
	
	//添加市民信息
	@Insert("insert into table_citizen(telephone_number,name,state,password,salt,integral,flag) values(#{telephoneNumber},#{name},#{state},#{password},#{integral},#{flag})")
	public int insertCitizen(Citizen citizen)throws Exception;
	
	//更新市民信息
	@UpdateProvider(type = SqlProvider.class,method = "updateCitizen")
	public int updateCitizen(Citizen citizen)throws Exception;
	
	//积分排行榜
	@Select("select * from table_citizen order by integral desc limit ${offset},${size}")
	public List<Citizen> getAllCitizenSortByIntegrate(int  offset,int size)throws Exception;

}
