package cn.edu.fjnu.towide.city_management.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.fjnu.towide.city_management.dao.IlazyLoadingTable;
import cn.edu.fjnu.towide.city_management.dao.IManyTable;
import cn.edu.fjnu.towide.city_management.dao.IStaffDao;
import cn.edu.fjnu.towide.city_management.dao.ITestDao;
import cn.edu.fjnu.towide.city_management.dao.ITroubleDao;
import cn.edu.fjnu.towide.city_management.dao.ITroubleOperationDao;
import cn.edu.fjnu.towide.city_management.entity.Citizen;
import cn.edu.fjnu.towide.city_management.entity.Staff;
import cn.edu.fjnu.towide.city_management.entity.Trouble;
import cn.edu.fjnu.towide.city_management.entity.TroubleAndDetail;
import net.sf.json.JSONObject;

@Controller
public class TestController {
	int i=0;
	int j=0;
	@Resource
	private ITestDao TestDao;
	@Resource
	private IStaffDao staffdao;
	@Resource
	private IlazyLoadingTable dao;
	@Resource
	private ITroubleOperationDao troubleOperationDao;
	@Resource
	private ITroubleDao troubleDao;
	@Resource
	private IManyTable manytableDao;
	//@RequestMapping(value="teststaff")
	
	
	@RequestMapping(value = "test11")
	public void test11() throws Exception {
		System.out.println("进入");
		// TestDao.getCitizenByTel("13306934249");
		 System.out.println(++j+"次");
	//	 return "success";
	}

	@RequestMapping(value = "test1")
	@ResponseBody
	public String test1() throws Exception {
		System.out.println("实行懒加载");
		List<TroubleAndDetail> troubleAndDetails=dao.geTroubles();
		System.out.println("查询出trouble对象");
		for(TroubleAndDetail trouble:troubleAndDetails )
			System.out.println(trouble.getTrouble().toString());
		System.out.println("6l对象");
		Trouble trouble=troubleDao.getTroubleById(6l);
		trouble.setProcessState(8);
		troubleDao.updateTrouble(trouble);
		return "success";
		
		 
	}
	@RequestMapping(value = "test20")
	public void test20() throws Exception {
		troubleOperationDao.getAllTroubleOperation();
		
		 
	}
	
	@RequestMapping(value = "test21")
	@ResponseBody
	public String test21(HttpServletResponse response,HttpServletRequest request) throws Exception {
//		String callback=request.getParameter("jsoncallback");
//		response.setHeader("Cache-Control", "no-cache");
//		response.setContentType("text/json;charset=UTF-8");
     //	response.addHeader("Access-Control-Allow-Origin", "*");
//		//troubleOperationDao.getAllTroubleOperation();
 //    	response.setHeader("Access-Control-Allow-Origin", "*");
		troubleOperationDao.getTroubleOperationByStaffDepartmentId(1l);
		System.out.println(++i+"次");
		String aString="11";
		//=request.getParameter("callback");
		
		return aString+"xiangyingshuju";
	}
	
	@RequestMapping(value="testredis")
	public void testredis()throws Exception{
		
		Staff staff=staffdao.getStaffById(1l);
		System.out.println(staff.toString());
		staff.setEmail("00000000000000000000000");
		staffdao.updateStaff(staff);
		
		System.out.println(++i+"次");
	}
	@RequestMapping(value="testManyTableByRedisCache")
	public void testManyTableByRedisCache()throws Exception{
		System.out.println(manytableDao.geTroublesByManyTable().toString());
		System.out.println(++i+"次");
	}
	@RequestMapping(value="testManyTableByRedisCacheInsert")
	public void testManyTableByRedisCacheInsert()throws Exception{
		System.out.println(manytableDao.geTroublesByManyTable().toString());
		System.out.println(++i+"次");
	}
	//测试与前端对接的方式
	@RequestMapping(value = "createJSONURL1")
	@ResponseBody
	//@RequestBody Map map , consumes = "application/json", produces = "application/json"
	//Map<String, Object> map,HttpServletResponse response
	public void createJSON1(HttpServletResponse response,HttpServletRequest request) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		request.getContextPath();
		//System.out.println(map);
		System.out.println("111");
		//JSONObject jsonObject = JSONObject.fromObject(json);
		//Trouble.class
	//	Map< String, Object> map=
		//jsonObject.toBean(jsonObject, Map<String, Object>.class);
		//JSONObject jsonObject=JSONObject.fromObject(json);
	//	String phone=jsonObject.getString("telephoneNumber");
	//	System.out.println(phone);
		//JSONObject jsonObject = new JSONObject();
		//jsonObject.toBean(jsonObject, beanClass, classMap)
		//response.setHeader("Access-Control-Allow-Origin", "*");
		//JSONObject jsonObject = new JSONObject();
	   //jsonObject.toBean(jsonObject, beanClass, classMap)
		System.out.println(123);
		
		//return new Trouble();
	}
	
	@RequestMapping(value = "createJSONURL", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	//@RequestBody Map map
	public String createJSON(@RequestBody Map map,HttpServletResponse response) {
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		System.out.println(123);
		
		return null;
	}

}
