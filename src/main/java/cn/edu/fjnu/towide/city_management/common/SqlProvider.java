package cn.edu.fjnu.towide.city_management.common;

import org.apache.ibatis.jdbc.SQL;

import cn.edu.fjnu.towide.city_management.entity.Bulletin;
import cn.edu.fjnu.towide.city_management.entity.Citizen;
import cn.edu.fjnu.towide.city_management.entity.Department;
import cn.edu.fjnu.towide.city_management.entity.SceneSituation;
import cn.edu.fjnu.towide.city_management.entity.Staff;
import cn.edu.fjnu.towide.city_management.entity.Trouble;
import cn.edu.fjnu.towide.city_management.entity.TroubleOperation;

public class SqlProvider {
	public String updateBullentin(final Bulletin bulletin) {
		return new SQL() {
			{
				UPDATE("table_bullentin");
				if (bulletin.getStaffId() != null) {
					SET("staff_id = #{staffId}");
				}
				if (bulletin.getTitle() != null) {
					SET("title = #{title}");
				}
				if (bulletin.getFlag() != null) {
					SET("flag = #{flag}");
				}
				if (bulletin.getDate() != null) {
					SET("date = #{date}");
				}
				if (bulletin.getContent() != null) {
					SET("content = #{content}");
				}
				WHERE("id= #{id} and flag=1");
			}
		}.toString();
	}

	public String updateCitizen(final Citizen citizen) {
		return new SQL() {
			{
				UPDATE("table_citizen");
				if (citizen.getName() != null) {
					SET("name = #{name}");
				}
				if (citizen.getFlag() != null) {
					SET("flag=#{flag}");
				}
				if (citizen.getIntegral() != null) {
					SET("integral=#{integral}");
				}
				if (citizen.getPassword() != null) {
					SET("password=#{password}");
				}
				if (citizen.getState() != null) {
					SET("state=#{state}");
				}
				WHERE("telephone_number= #{telephoneNumber} and flag=1 ");
			}
		}.toString();
	}

	public String updateStaff(final Staff staff) {
		return new SQL() {
			{
				UPDATE("table_staff");
				if (staff.getDepartmentId() != null) {
					SET("department_id = #{departmentId}");
				}
				if (staff.getEmail() != null) {
					SET("email = #{email}");
				}
				if (staff.getFlag() != null) {
					SET("flag = #{flag}");
				}
				if (staff.getName() != null) {
					SET("name = #{name}");
				}
				if (staff.getPassword() != null) {
					SET("password = #{password}");
				}
				if (staff.getRole() != null) {
					SET("role = #{role}");
				}
				if (staff.getTelephoneNumber() != null) {
					SET("telephone_number = #{telephoneNumber}");
				}
				WHERE("id= #{id}  and flag=1");
			}
		}.toString();
	}

	public String updateTrouble(final Trouble trouble) {
		return new SQL() {
			{
				UPDATE("table_trouble");
				if (trouble.getDisposeStaffId() != null) {

					SET("dispose_staff_id=#{disposeStaffId}");
				}
				if (trouble.getFlag() != null) {

					SET("flag=#{flag}");
				}
				if (trouble.getProcessState() != null) {

					SET("process_state=#{processState}");
				}
				if (trouble.getReportCitizenTelephoneNumber() != null) {

					SET("report_citizen_telephone_number=#{reportCitizenTelephoneNumber}");
				}
				if (trouble.getReportDatetime() != null) {
					SET("report_datetime=#{reportDatetime}");

				}
				if (trouble.getStayDepartmentId() != null) {
					SET("stay_department_id=#{stayDepartmentId}");
				}
				if (trouble.getReportDepartmentId() != null) {
					SET("report_department_id=#{reportDepartmentId}");

				}
				if (trouble.getReportStaffId() != null) {
					SET("report_staff_id=#{reportStaffId}");

				}
				if (trouble.getSatisfactionEvaluation() != null) {
					SET("satisfaction_evaluation=#{satisfactionEvaluation}");
				}
				if (trouble.getSceneAddress() != null) {
					SET("scene_address=#{sceneAddress}");
				}
				if (trouble.getSceneDescription() != null) {
					SET("scene_description=#{sceneDescription}");
				}
				if (trouble.getUrgencyLevel() != null) {
					SET("urgency_level=#{urgencyLevel}");

				}

				WHERE("id=#{id}  and flag=1");
			}
		}.toString();
	}

	public String updateDepartment(final Department department) {
		return new SQL() {
			{
				UPDATE("table_department");
				if (department.getParentId() != null) {
					SET("parent_id = #{parentId}");
				}
				if (department.getName() != null) {
					SET("name=#{name}");
				}
				if (department.getFunction() != null) {
					SET("function=#{function}");
				}
				if (department.getPermissions() != null) {
					SET("permissions+#{permissions}");
				}
				if (department.getFlag() != null) {
					SET("flag=#{flag}");
				}
				WHERE("id= #{id}  and flag=1");
			}
		}.toString();
	}

	public String updateSceneSituation(final SceneSituation sceneSituation) {
		return new SQL() {
			{
				UPDATE("table_scene_situation");
				if (sceneSituation.getTroubleId() != null) {

					SET("trouble_id=#{troubleId}");
				}
				if (sceneSituation.getTroubleId() != null) {

					SET("staff_id=#{staffId}");
				}
				if (sceneSituation.getTroubleId() != null) {

					SET("staff_department_id=#{staffDepartmentId}");
				}
				if (sceneSituation.getTroubleId() != null) {

					SET("type=#{type}");
				}
				if (sceneSituation.getTroubleId() != null) {

					SET("description=#{description}");
				}
				if (sceneSituation.getTroubleId() != null) {

					SET("address=#{address}");
				}
				if (sceneSituation.getTroubleId() != null) {

					SET("date=#{date}");
				}
				if (sceneSituation.getTroubleId() != null) {

					SET("flag=#{flag}");
				}
				WHERE("id=#{id}  and flag=1");
			}
		}.toString();
	}

	public String updateTroubleOperation(final TroubleOperation troubleOperation) {
		return new SQL() {
			{
				UPDATE("table_trouble_operation");

				if (troubleOperation.getStaffDepartmentId() != null) {
					SET("staff_department_id = #{staffDepartmentId}");
				}
				if (troubleOperation.getStaffId() != null) {
					SET("staff_id = #{staffId}");
				}
				if (troubleOperation.getOperation() != null) {
					SET("operation = #{operation}");
				}
				if (troubleOperation.getOperationDatetime() != null) {
					SET("operation_datetime = #{operationDatetime}");
				}
				if (troubleOperation.getPostscript() != null) {
					SET("postscript = #{postscript}");
				}
				if (troubleOperation.getFlag() != null) {
					SET("flag = #{flag}");
				}
				WHERE("trouble_id= #{troubleId}  and flag=1");
			}
		}.toString();
	}

}
