package cn.edu.fjnu.towide.city_management.dao;

import org.apache.ibatis.annotations.CacheNamespace;
import org.springframework.stereotype.Repository;


import cn.edu.fjnu.towide.city_management.entity.Citizen;

@Repository
public interface ITestDao {
	public Citizen getCitizenByTel(String telephone);

}
