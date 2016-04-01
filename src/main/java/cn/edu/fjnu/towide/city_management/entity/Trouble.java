package cn.edu.fjnu.towide.city_management.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
//implements Serializable
public class Trouble implements Serializable{
	
	private Long id;
	private String reportCitizenTelephoneNumber;
	private Long reportStaffId;
	private Long reportDepartmentId;
	private Long stayDepartmentId;
	private Long disposeStaffId;
	private String sceneDescription;
	private String sceneAddress;
	private Timestamp reportDatetime;
	private Integer processState;
	private Integer urgencyLevel;
	private Integer satisfactionEvaluation;
	private Integer flag;
	public Trouble() {
	}
	public Trouble(Long id, String reportCitizenTelephoneNumber, Long reportStaffId,
			Long reportDepartmentId, Long stayDepartmentId, Long disposeStaffId,
			String sceneDescription, String sceneAddress, Timestamp reportDatetime, Integer processState,
			Integer urgencyLevel, Integer satisfactionEvaluation, Integer flag) {
		this.id = id;
		this.reportCitizenTelephoneNumber = reportCitizenTelephoneNumber;
		this.reportStaffId = reportStaffId;
		this.reportDepartmentId = reportDepartmentId;
		this.stayDepartmentId = stayDepartmentId;
		this.disposeStaffId = disposeStaffId;
		this.sceneDescription = sceneDescription;
		this.sceneAddress = sceneAddress;
		this.reportDatetime = reportDatetime;
		this.processState = processState;
		this.urgencyLevel = urgencyLevel;
		this.satisfactionEvaluation = satisfactionEvaluation;
		this.flag = flag;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReportCitizenTelephoneNumber() {
		return reportCitizenTelephoneNumber;
	}
	public void setReportCitizenTelephoneNumber(String reportCitizenTelephoneNumber) {
		this.reportCitizenTelephoneNumber = reportCitizenTelephoneNumber;
	}
	public Long getReportStaffId() {
		return reportStaffId;
	}
	public void setReportStaffId(Long reportStaffId) {
		this.reportStaffId = reportStaffId;
	}
	public Long getReportDepartmentId() {
		return reportDepartmentId;
	}
	public void setReportDepartmentId(Long reportDepartmentId) {
		this.reportDepartmentId = reportDepartmentId;
	}
	public Long getStayDepartmentId() {
		return stayDepartmentId;
	}
	public void setStayDepartmentId(Long stayDepartmentId) {
		this.stayDepartmentId = stayDepartmentId;
	}
	public Long getDisposeStaffId() {
		return disposeStaffId;
	}
	public void setDisposeStaffId(Long disposeStaffId) {
		this.disposeStaffId = disposeStaffId;
	}
	public String getSceneDescription() {
		return sceneDescription;
	}
	public void setSceneDescription(String sceneDescription) {
		this.sceneDescription = sceneDescription;
	}
	public String getSceneAddress() {
		return sceneAddress;
	}
	public void setSceneAddress(String sceneAddress) {
		this.sceneAddress = sceneAddress;
	}
	public Timestamp getReportDatetime() {
		return reportDatetime;
	}
	public void setReportDatetime(Timestamp reportDatetime) {
		this.reportDatetime = reportDatetime;
	}
	public Integer getProcessState() {
		return processState;
	}
	public void setProcessState(Integer processState) {
		this.processState = processState;
	}
	public Integer getUrgencyLevel() {
		return urgencyLevel;
	}
	public void setUrgencyLevel(Integer urgencyLevel) {
		this.urgencyLevel = urgencyLevel;
	}
	public Integer getSatisfactionEvaluation() {
		return satisfactionEvaluation;
	}
	public void setSatisfactionEvaluation(Integer satisfactionEvaluation) {
		this.satisfactionEvaluation = satisfactionEvaluation;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "Trouble [id=" + id + ", reportCitizenTelephoneNumber=" + reportCitizenTelephoneNumber
				+ ", reportStaffId=" + reportStaffId + ", reportDepartmentId=" + reportDepartmentId
				+ ", stayDepartmentId=" + stayDepartmentId + ", disposeStaffId=" + disposeStaffId
				+ ", sceneDescription=" + sceneDescription + ", sceneAddress=" + sceneAddress + ", reportDatetime="
				+ reportDatetime + ", processState=" + processState + ", urgencyLevel=" + urgencyLevel
				+ ", satisfactionEvaluation=" + satisfactionEvaluation + ", flag=" + flag + "]";
	}
}
