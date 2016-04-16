package hit.vo;

import java.util.List;

import hit.po.Task;
import hit.po.User;

public class TaskVo extends Task {
	private List<User>users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
