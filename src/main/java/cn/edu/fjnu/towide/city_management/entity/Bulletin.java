package cn.edu.fjnu.towide.city_management.entity;



import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


public class Bulletin implements Serializable {//公告类
	private Long id;
	private Long staffId;
	private String title;
	private Timestamp date;
	private String content;
	private Integer flag;
	
	
	public Bulletin() {
	}
	
	public Bulletin(Long id, Long staffId, String title, Timestamp date, String content, Integer flag) {
		this.id = id;
		this.staffId = staffId;
		this.title = title;
		this.date = date;
		this.content = content;
		this.flag = flag;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getStaffId() {
		return staffId;
	}
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
}
