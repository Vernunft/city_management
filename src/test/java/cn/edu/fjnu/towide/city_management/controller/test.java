package cn.edu.fjnu.towide.city_management.controller;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.edu.fjnu.towide.city_management.dao.IStaffDao;
import cn.edu.fjnu.towide.city_management.entity.Staff;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/springmvc.xml","classpath*:applicationContext.xml"})
@ActiveProfiles("production")
public class test {
	@Autowired
	private IStaffDao dao;

	@Before
	public void setUp() throws Exception {
		System.out.println("开始测试");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("结束测试");
	}

	@Test
	public void test() {
		Staff staff=new Staff();
		//staff.setEmail("1111111111111110");
	//	staff.setId(new Long("1"));
	
		System.out.println(dao.getStaffById(1l));
		
	}

}
