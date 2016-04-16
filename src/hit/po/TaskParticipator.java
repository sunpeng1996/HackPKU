package hit.po;

public class TaskParticipator {
	private User user;
	private Task task;
	private Integer contributeScore;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public Integer getContributeScore() {
		return contributeScore;
	}
	public void setContributeScore(Integer contributeScore) {
		this.contributeScore = contributeScore;
	}
	@Override
	public String toString() {
		return "TaskParticipator [user=" + user + ", task=" + task
				+ ", contributeScore=" + contributeScore + "]";
	}
	
}
