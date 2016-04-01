package cn.edu.fjnu.towide.city_management.controller;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.edu.fjnu.towide.city_management.common.DepartmentTree;
import cn.edu.fjnu.towide.city_management.service.IAuditorService;
import cn.edu.fjnu.towide.city_management.serviceimpl.AuditorServiceImpl;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/springmvc.xml","classpath*:applicationContext.xml"})
@ActiveProfiles("production")
public class auditorControllerTest {
	
	
	// 模拟request,response  
    private MockHttpServletRequest request;  
    private MockHttpServletResponse response;   
    private String json =null;  
    // 注入 auditorController
    @Autowired
    private  AuditorController  auditorController;  
	@Before
	public void setUp() throws Exception {
		 request = new MockHttpServletRequest();      
	     request.setCharacterEncoding("UTF-8");      
	     response = new MockHttpServletResponse();
		System.out.println("开始测试！");
	
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("结束测试");
	}

	@Test
	public void testEmergencyDispatching() {
		//json="{\"departmentId\":2}";
		//json=1;
		Map<String,Long> map =new HashMap<>();
		map.put("troubleId", 6L);
		//request.setAttribute("tree", json);
		//System.out.println(request.getAttribute("tree").toString());
		try {
			//auditorController.EmergencyDispatching(request, response);
		//	auditorController.EmergencyDispatching(2L, response);
			System.out.println(auditorController.query(map));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testViewTroublesDetails() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewTroubleSceneSituation() {
		fail("Not yet implemented");
	}

}
