package hit.vo;

import hit.po.User;

import java.util.List;

public class EventVo {
	private Integer task_id;
	private String taskname;
	private String summary;
	private String totalscore;
	private String members;
	private String start_hour;
	private String start_min;
	private String end_hour;
	private String end_min;
	private String thisDay;
	private List<User> ptcs;
	
	public List<User> getPtcs() {
		return ptcs;
	}
	public void setPtcs(List<User> ptcs) {
		this.ptcs = ptcs;
	}
	public Integer getTask_id() {
		return task_id;
	}
	public void setTask_id(Integer task_id) {
		this.task_id = task_id;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getTotalscore() {
		return totalscore;
	}
	public void setTotalscore(String totalscore) {
		this.totalscore = totalscore;
	}
	public String getMembers() {
		return members;
	}
	public void setMembers(String members) {
		this.members = members;
	}
	public String getStart_hour() {
		return start_hour;
	}
	public void setStart_hour(String start_hour) {
		this.start_hour = start_hour;
	}
	public String getStart_min() {
		return start_min;
	}
	public void setStart_min(String start_min) {
		this.start_min = start_min;
	}
	public String getEnd_hour() {
		return end_hour;
	}
	public void setEnd_hour(String end_hour) {
		this.end_hour = end_hour;
	}
	public String getEnd_min() {
		return end_min;
	}
	public void setEnd_min(String end_min) {
		this.end_min = end_min;
	}
	public String getThisDay() {
		return thisDay;
	}
	public void setThisDay(String thisDay) {
		this.thisDay = thisDay;
	}
	
	
	public EventVo(String taskname, String summary, String totalscore,
			String members, String start_hour, String start_min,
			String end_hour, String end_min, String thisDay) {
		super();
		this.taskname = taskname;
		this.summary = summary;
		this.totalscore = totalscore;
		this.members = members;
		this.start_hour = start_hour;
		this.start_min = start_min;
		this.end_hour = end_hour;
		this.end_min = end_min;
		this.thisDay = thisDay;
	}
	public EventVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
