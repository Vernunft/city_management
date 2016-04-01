package cn.edu.fjnu.towide.city_management.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ch.qos.logback.classic.Logger;
import cn.edu.fjnu.towide.city_management.controller.AuditorController;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/springmvc.xml","classpath*:applicationContext.xml"})
@ActiveProfiles("production")
public class IManyTableTest {
	@Autowired
	private IlazyLoadingTable dao;
	private static Logger log = (Logger) LoggerFactory.getLogger(IlazyLoadingTable.class);


	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try {
			
			System.out.println(dao.geTroubles());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
