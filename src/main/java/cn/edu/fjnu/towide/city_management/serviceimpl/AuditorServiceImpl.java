package cn.edu.fjnu.towide.city_management.serviceimpl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.jsp.jstl.core.IteratedValueExpression;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.fjnu.towide.city_management.common.DepartmentTree;
import cn.edu.fjnu.towide.city_management.common.PageParam;
import cn.edu.fjnu.towide.city_management.dao.IBulletinDao;
import cn.edu.fjnu.towide.city_management.dao.ICitizenDao;
import cn.edu.fjnu.towide.city_management.dao.IDepartmentDao;
import cn.edu.fjnu.towide.city_management.dao.ISceneSituationDao;
import cn.edu.fjnu.towide.city_management.dao.IStaffDao;
import cn.edu.fjnu.towide.city_management.dao.ITroubleDao;
import cn.edu.fjnu.towide.city_management.dao.ITroubleOperationDao;
import cn.edu.fjnu.towide.city_management.entity.Bulletin;
import cn.edu.fjnu.towide.city_management.entity.Citizen;
import cn.edu.fjnu.towide.city_management.entity.Department;
import cn.edu.fjnu.towide.city_management.entity.SceneSituation;
import cn.edu.fjnu.towide.city_management.entity.Staff;
import cn.edu.fjnu.towide.city_management.entity.Trouble;
import cn.edu.fjnu.towide.city_management.entity.TroubleOperation;
import cn.edu.fjnu.towide.city_management.service.IAuditorService;
@Transactional
@Service
public class AuditorServiceImpl implements IAuditorService {
	 @Autowired
	ITroubleDao iTroubleDao;
	 @Autowired
	ITroubleOperationDao iTroubleOperationDao;
	 @Autowired
	ISceneSituationDao iSceneSituationDao;
	 @Autowired
	IDepartmentDao iDepartmentDao;
	 @Autowired
	 ICitizenDao iCitizizenDao;
	 @Autowired
	 IStaffDao  iStaffDao;
	 @Autowired
	 IBulletinDao iBulletinDao;

	/**
	 * 紧急下派时部门关系树
	 */
	@Override
	public void getDepartmentTree(Set<DepartmentTree> departmentTrees,Long departmentId, int grade)
			throws Exception {
		System.out.println("tree");
		List<Long> childrenIds=iDepartmentDao.getDepartmentIdByParentId(departmentId);
		try {
			for(Iterator<Long> iterator=childrenIds.iterator();iterator.hasNext();){
				 DepartmentTree departmentTree=new DepartmentTree();
				 departmentTree.setDepartmentId(iterator.next());
				 if (iDepartmentDao.getDepartmentById(departmentTree.getDepartmentId())!=null) {
				 
				 departmentTree.setInfo(iDepartmentDao.getDepartmentById(departmentTree.getDepartmentId()));
				 departmentTree.setGrade(grade);
				 departmentTrees.add(departmentTree);
				 }
					
				
				 if (!iDepartmentDao.getDepartmentIdByParentId(departmentTree.getDepartmentId()).isEmpty()) {
					
					 getDepartmentTree(departmentTrees, departmentTree.getDepartmentId(), grade+1);
				}
				 
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	
	}
	/**
	 * 根据部门id好查询出部门的信息
	 */
	@Override
	public Department getDepartmentById(Long departmentId)
	throws Exception{
		return iDepartmentDao.getDepartmentById(departmentId);
		
	}
	/**
	 * 根据id给出操作记录、勘测记录
	 */
	@Override
	public List<TroubleOperation> getTroublesDetail(Long troubleId) throws Exception {
		 List<TroubleOperation> troubleOperations=iTroubleOperationDao.getTroubleOperationByTroubleId(troubleId);
		 return troubleOperations;
	}
	@Override
	public List<SceneSituation> getTroubleSceneSituation(Long troubleId) throws Exception {

		return iSceneSituationDao.getSceneSituationByTroubleId(troubleId);
	}


		
	/**
	 * 通过停留部门id跟处理状态获取故障记录数
	 * @param i
	 * @param departmentId
	 * @return
	 */
	@Override
	public int getTroublesCountByStaAndDep(int state,Long stayDepartmentId)throws Exception {
		Map<String, Object> maps=new HashMap<String, Object>();
		maps.put("state",state);
		maps.put("departmentId", stayDepartmentId);
		int count=iTroubleDao.getTroubleCountByPStateAndSDId(maps);
		return count;
	}
	
	/**
	 * 根据停留部门id以及处理状态获取故障信息
	 * @param pageParam
	 * @return
	 */
	@Override
	public List<Trouble> getTroublesByStateAndDep(PageParam pageParam,int state,Long stayDepartmentId) throws Exception{
		Map<String, Object> maps =new HashMap<String, Object>();
		pageParam.setRowCount(getTroublesCountByStaAndDep(state, stayDepartmentId));
		pageParam.paging(pageParam);//进行分页
		maps.put("state", state);
		maps.put("stayDepartmentId",stayDepartmentId);
		maps.put("startRow", pageParam.getStartRow());
		maps.put("endRow", pageParam.getEndRow());
		return iTroubleDao.getTroublesBySDIdAndPState(maps);
	}
	/**
	 * 添加操作故障记录
	 * @param troubleOperation
	 */
	@Override
	public void insertTroubleOperation(TroubleOperation troubleOperation)throws Exception {
		iTroubleOperationDao.insertTroubleOperation(troubleOperation);
	}
	
	/**
	 * 更新故障表
	 * @param trouble
	 */
	@Override
	public void updateTrouble(Trouble trouble) {
		iTroubleDao.updateTrouble(trouble);
	}
	
	/**
	 * 通过市民电话找到市民信息
	 * @param telephoneNumber
	 * @return
	 */
	@Override
	public Citizen getCitizenByTel(String telephoneNumber) throws Exception{
		return iCitizizenDao.getCitizenByTelephone(telephoneNumber);
		
	}
	
	/**
	 * 更新市民信息
	 * @param citizen
	 */
	@Override
	public void updateCitizen(Citizen citizen)throws Exception {
		iCitizizenDao.updateCitizen(citizen);
	}
	

	/**
	 * 更新员工信息
	 * @param staff
	 */
	@Override
	public void updateStaff(Staff staff)throws Exception {
		iStaffDao.updateStaff(staff);
	}

	/**
	 * 更新公告信息
	 * @param bulletin
	 */
	@Override
	public void updateBulletin(Bulletin bulletin)throws Exception {
		iBulletinDao.updateBulletin(bulletin);
	}

	/**
	 * 根据故障id查询故障
	 * @param object
	 * @return
	 */
	@Override
	public Trouble getTroubleById(Long troubleId)throws Exception {
		return iTroubleDao.getTroubleById(troubleId);
	}

	/**
	 * 根据上级部门id获取下级部门信息
	 * @param departmentId
	 * @return
	 */
	@Override
	public List<Department> getLowerDepartmentById(Long parentId)throws Exception {
		return iDepartmentDao.getDepartmentByParentId(parentId);
	}

	/**
	 * 根据部门id得到部门信息
	 * @param stayDepartmentId
	 * @return
	 */
	@Override
	public Department getParentDepartmentById(Long stayDepartmentId)throws Exception {
		return iDepartmentDao.getDepartmentById(stayDepartmentId);
	}

	/**
	 * 根据所做操作获取故障操作记录
	 * @param Operation
	 * @return
	 */
	@Override
	public List<TroubleOperation> getTroubleByOpeAndDep(Map<String, Object> map)throws Exception {
		return iTroubleOperationDao.getTroubleByOpeAndDep(map);
	}

	

}
