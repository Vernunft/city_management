package cn.edu.fjnu.towide.city_management.dao;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.edu.fjnu.towide.city_management.common.Troubles;
@CacheNamespaceRef(value =cn.edu.fjnu.towide.city_management.dao.ITroubleOperationDao.class )
@CacheNamespace(size=512)
public interface IManyTable {
	 @Select("select table_trouble.*,table_trouble_operation.* FROM table_trouble,table_trouble_operation WHERE table_trouble.id=table_trouble_operation.trouble_id")
	   @Results(  
			    {  
			        @Result(property = "troubleOperations",column="trouble_id",
			        		many=@Many (select = "cn.edu.fjnu.towide.city_management.dao.ITroubleOperationDao.getTroubleOperationByTroubleId")
			       )  
			    })  
	   public Troubles geTroublesByManyTable();

	

}
