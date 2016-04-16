package hit.po;

import java.util.Date;

import hit.vo.EventVo;

public class EventPo extends EventVo{
	private Integer task_id;
	private Date time_id_begin;
	private Date time_id_end;
	
	public Integer getTask_id() {
		return task_id;
	}
	public void setTask_id(Integer task_id) {
		this.task_id = task_id;
	}
	public Date getTime_id_begin() {
		return time_id_begin;
	}
	public void setTime_id_begin(Date time_id_begin) {
		this.time_id_begin = time_id_begin;
	}
	public Date getTime_id_end() {
		return time_id_end;
	}
	public void setTime_id_end(Date time_id_end) {
		this.time_id_end = time_id_end;
	}
	@Override
	public String toString() {
		return "EventPo [time_id_begin=" + time_id_begin + ", time_id_end="
				+ time_id_end + "]";
	}
	
}
