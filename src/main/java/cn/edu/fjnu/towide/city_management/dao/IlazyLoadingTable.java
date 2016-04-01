package cn.edu.fjnu.towide.city_management.dao;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.edu.fjnu.towide.city_management.common.Troubles;
import cn.edu.fjnu.towide.city_management.entity.Department;
import cn.edu.fjnu.towide.city_management.entity.TroubleAndDetail;
import cn.edu.fjnu.towide.city_management.entity.TroubleOperation;

@CacheNamespace(size=512 ) 
public interface IlazyLoadingTable {
	
	   @Select("select * FROM table_trouble_operation ")
	   @Results(  
			    {  
			        @Result(property = "trouble",column="trouble_id",javaType=cn.edu.fjnu.towide.city_management.entity.Trouble.class,
			        		one=@One(select = "cn.edu.fjnu.towide.city_management.dao.ITroubleDao.getTroubleById"))  
			    })  
	   public List<TroubleAndDetail> geTroubles();

}
