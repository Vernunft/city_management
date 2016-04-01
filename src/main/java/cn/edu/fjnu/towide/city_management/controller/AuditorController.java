package cn.edu.fjnu.towide.city_management.controller;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ObjectUtils.Null;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ch.qos.logback.classic.Logger;
import cn.edu.fjnu.towide.city_management.common.DepartmentTree;
import cn.edu.fjnu.towide.city_management.common.PageParam;
import cn.edu.fjnu.towide.city_management.common.processStateEnum;
import cn.edu.fjnu.towide.city_management.dao.ICitizenDao;
import cn.edu.fjnu.towide.city_management.dao.IDepartmentDao;
import cn.edu.fjnu.towide.city_management.dao.IlazyLoadingTable;
import cn.edu.fjnu.towide.city_management.dao.IStaffDao;
import cn.edu.fjnu.towide.city_management.dao.ITestDao;
import cn.edu.fjnu.towide.city_management.dao.ITroubleDao;
import cn.edu.fjnu.towide.city_management.dao.ITroubleOperationDao;
import cn.edu.fjnu.towide.city_management.entity.Bulletin;
import cn.edu.fjnu.towide.city_management.entity.Citizen;
import cn.edu.fjnu.towide.city_management.entity.Department;
import cn.edu.fjnu.towide.city_management.entity.SceneSituation;
import cn.edu.fjnu.towide.city_management.entity.Staff;
import cn.edu.fjnu.towide.city_management.entity.Trouble;
import cn.edu.fjnu.towide.city_management.entity.TroubleAndDetail;
import cn.edu.fjnu.towide.city_management.entity.TroubleOperation;
import cn.edu.fjnu.towide.city_management.service.IAuditorService;
import cn.edu.fjnu.towide.city_management.serviceimpl.AuditorServiceImpl;
import junit.extensions.TestDecorator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class AuditorController {
	@Resource
	private IAuditorService auditorService;
	private static Logger log = (Logger) LoggerFactory.getLogger(AuditorController.class);
	private static Staff staff;// 当前的工作人员
	static int i = 0;// 设置id

	/**
	 * 紧急下派时，给出下级部门
	 */
	@RequestMapping("emergencyDispatching.do")
	public @ResponseBody Set<DepartmentTree> emergencyDispatching(@RequestBody Map<String, Object> map)
			throws Exception {
		Long departmentId = (Long) map.get("departmentId");
		Set<DepartmentTree> departmentTrees = new HashSet<>();
		departmentTrees.add(new DepartmentTree(departmentId, auditorService.getDepartmentById(departmentId), 0));
		auditorService.getDepartmentTree(departmentTrees, departmentId, 1);
		return departmentTrees;
	}

	/**
	 * 根据id给出操作记录
	 * 
	 */
	@RequestMapping("viewTroublesDetails")

	public @ResponseBody List<TroubleOperation> viewTroublesDetails(
			@RequestBody Map map) throws Exception {
		System.out.println("进入");
		Long troubleId =(Long) map.get("troubleId");
		List<TroubleOperation> troubleOperations = auditorService.getTroublesDetail(troubleId);
		return troubleOperations;

	}

	/**
	 * 根据id给出勘测记录
	 * 
	 */
	@RequestMapping("viewTroubleSceneSituation.do")

	public @ResponseBody List<SceneSituation> viewTroubleSceneSituation(
			@RequestParam(value = "troubleId", required = true) Long troubleId) throws Exception {
		List<SceneSituation> sceneSituations = auditorService.getTroubleSceneSituation(troubleId);
		return sceneSituations;
	}

	/**
	 * 获取当前操作的员工
	 * 
	 * @return
	 */
	public Staff getCurrentStaff() {

		return staff;
	}

	/**
	 * 退出系统
	 * 
	 * @return
	 */
	@RequestMapping(value = "exit" )
	public String exit() throws Exception {
		log.debug("debug");
		log.info("info");
		return "login";
	}
	 
	
	/**
	 * 修改个人信息
	 * 
	 * @param staff
	 * @throws Exception
	 */
	@RequestMapping(value = "modifyInformation")
	public void modifyInformation(@RequestBody Staff staff) throws Exception {
		log.debug("debug");
		auditorService.updateStaff(staff);
		log.info("info");
	}

	/**
	 * 提交公告信息
	 * 
	 * @param bulletin
	 * @throws Exception
	 */
	@RequestMapping(value = "submitAnnouncement")
	public void submitAnnouncement(@RequestBody Bulletin bulletin) throws Exception {
		log.debug("debug");
		log.info("info");
	}

	/**
	 * 发布公告
	 * 
	 * @param bulletin
	 * @return
	 */
	@RequestMapping("announcement")
	@ResponseBody
	public Bulletin announcement(@RequestBody Bulletin bulletin) throws Exception {
		log.debug("debug");
		auditorService.updateBulletin(bulletin);
		log.info("info");
		return bulletin;
	}

	/**
	 * 审核公告
	 * 
	 * @param bulletin
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "auditBulletin", consumes = "application/json", produces = "application/json")
	public void auditBulletin(@RequestBody Bulletin bulletin) throws Exception {
		log.debug("debug");
		auditorService.updateBulletin(bulletin);
		log.info("info");
	}

	/**
	 * 显示待审核故障信息
	 * 
	 * @param pageParam
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "auditTrouble", produces = "application/json", consumes = "application/json")
	@ResponseBody
	public List<Trouble> auditTrouble(@RequestBody PageParam pageParam,
			@RequestParam(value = "state", required = true) int state,
			@RequestParam(value = "stayDepartmentId", required = true) Long stayDepartmentId) throws Exception {
		log.debug("debug");
		log.info("info");
		pageParam = pageParam.paging(pageParam);
		return auditorService.getTroublesByStateAndDep(pageParam, state, stayDepartmentId);

	}

	/**
	 * 根据id获取图片
	 * 
	 * @param trouble
	 * @param pictureFile
	 * @throws Exception
	 */
	@RequestMapping(value = "operation", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public void Operation(@RequestBody Trouble trouble, MultipartFile pictureFile) throws Exception {
		File uploadPic = new java.io.File("city_management/" + trouble.getId());
		if (!uploadPic.exists()) {
			uploadPic.mkdirs();
		}
		// 向磁盘写文件
		pictureFile.transferTo(uploadPic);
	}

	/**
	 * 根据上级部门id显示下级部门信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "dispatching", produces = "application/json")
	@ResponseBody
	public List<Department> dispatching() throws Exception {
		log.debug("debug");
		log.info("info");
		return auditorService.getLowerDepartmentById(staff.getDepartmentId());
	}

	/**
	 * 提交故障操作信息
	 * 
	 * @param troubleOperation
	 * @param trouble
	 * @throws Exception
	 */
	@RequestMapping(value = "submit", consumes = "application/json")
	public void sumbit(@RequestBody Map<String, Object> map) throws Exception {
		Trouble trouble = (Trouble) map.get("trouble");
		TroubleOperation troubleOperation = (TroubleOperation) map.get("troubleOperation");
		auditorService.insertTroubleOperation(troubleOperation);
		if (troubleOperation.getOperation().equals("拒收")) {
			if (troubleOperation.getPostscript().equals("下派错误")) {
				Department department = auditorService.getParentDepartmentById(trouble.getStayDepartmentId());
				trouble.setStayDepartmentId(department.getParentId());
				trouble.setFlag(processStateEnum.NVALID.getIntVlue());
			}
			if (troubleOperation.getOperation().equals("恶意爆料")) {
				trouble.setFlag(1);
				Citizen citizen = auditorService.getCitizenByTel(trouble.getReportCitizenTelephoneNumber());
				citizen.setIntegral(citizen.getIntegral() - 5);// 减少的值再确定
				if (citizen.getIntegral() - 5 <= 0) {
					citizen.setFlag(0);

				}
				auditorService.updateCitizen(citizen);
			}
		}
		auditorService.updateTrouble(trouble);
	}

	/**
	 * 根据id查询故障单
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "query", consumes = "application/json")
	@ResponseBody
	public Trouble query(@RequestBody Map<String, Long> map) throws Exception {
		log.debug("debug");
		log.info("info");
		return auditorService.getTroubleById(map.get("troubleId"));
	}

	/**
	 * 垃圾桶
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "errorDispatching", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public List<Trouble> errorDispatching(@RequestBody Map<String, Object> map) throws Exception {
		List<Trouble> troubles = null;
		List<TroubleOperation> troubleOperations = auditorService.getTroubleByOpeAndDep(map);
		for (TroubleOperation troubleOperation : troubleOperations) {
			Trouble trouble = auditorService.getTroubleById(troubleOperation.getTroubleId());
			troubles.add(trouble);
		}
		return troubles;
	}

	/**
	 * 拒收任务
	 * 
	 * @param trouble
	 * @param troubleOperation
	 * @throws Exception
	 */
	@RequestMapping(value = "refuseTask", consumes = "application/json", produces = "application/json")
	public void refuseTask(@RequestBody Trouble trouble, @RequestBody TroubleOperation troubleOperation)
			throws Exception {
		log.debug("debug");
		troubleOperation.setTroubleId(trouble.getId());
		troubleOperation.setStaffId(staff.getId());
		troubleOperation.setOperation("拒收任务");
		log.info("info");
		// 如果拒收任务属于将爆料置为无效时，要改变市民 的是否禁用字段
		auditorService.updateTrouble(trouble);
	}

	/**
	 * 接受任务后委派人员等操作
	 * 
	 * @param trouble
	 * @param troubleOperation
	 * @throws Exception
	 */
	@RequestMapping(value = "acceptTask")
	public void acceptTask(@RequestBody Trouble trouble, @RequestBody TroubleOperation troubleOperation)
			throws Exception {
		log.debug("debug");
		auditorService.updateTrouble(trouble);
		// 更新故障操作表
		// service.updateTroubleOperation(troubleOperation);
		log.info("info");

	}

	/**
	 * 结案
	 * 
	 * @param trouble
	 * @param troubleOperation
	 * @throws Exception
	 */
	@RequestMapping(value = "closeout")
	public void Closeout(@RequestBody Trouble trouble, @RequestBody TroubleOperation troubleOperation)
			throws Exception {
		// 要不要判断有没有结案权？
		// 如果前端过来的数据已经是改变的就不用下面这句
		// 5?6
		log.debug("debug");
		trouble.setProcessState(processStateEnum.ENDCASE.getIntVlue());
		auditorService.updateTrouble(trouble);
		log.info("info");
	}

	/**
	 * 反馈给上级部门
	 * 
	 * @param troubleOperation
	 */
	@RequestMapping(value = "FeedbackToSuperior")
	public void FeedbackToSuperior(@RequestBody TroubleOperation troubleOperation) {
		log.debug("debug");
		// service.updateTroubleOperation(troubleOperation);
		log.info("info");
	}

	/**
	 * 新增反馈信息
	 * 
	 * @param troubleOperation
	 * @throws Exception
	 */
	@RequestMapping(value = "addFeedback")
	public void auditFeedback(@RequestBody TroubleOperation troubleOperation) throws Exception {
		log.debug("debug");
		log.info("info");
		auditorService.insertTroubleOperation(troubleOperation);
	}

	/**
	 * 撤销反馈
	 * 
	 * @param troubleOperation
	 * @throws Exception
	 */
	@RequestMapping(value = "cancelFeedback")
	public void cancelFeedback(@RequestBody TroubleOperation troubleOperation) throws Exception {
		log.debug("debug");
		log.info("info");
		System.out.println("2");
	}
}
