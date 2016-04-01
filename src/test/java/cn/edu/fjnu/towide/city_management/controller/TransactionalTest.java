package cn.edu.fjnu.towide.city_management.controller;

import static org.junit.Assert.*;

import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.fjnu.towide.city_management.dao.IDepartmentDao;
import cn.edu.fjnu.towide.city_management.dao.IStaffDao;
import cn.edu.fjnu.towide.city_management.entity.Department;
import cn.edu.fjnu.towide.city_management.entity.Staff;
import cn.edu.fjnu.towide.city_management.service.IAuditorService;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/springmvc.xml","classpath*:applicationContext.xml"})
@ActiveProfiles("production")
public class TransactionalTest {
	@Autowired
	private IAuditorService iauditorService;
	
	
	

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try {
			//iauditorService.Add();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
