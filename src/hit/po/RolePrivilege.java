package hit.po;

public class RolePrivilege {
	private Integer menu_id;
	private Integer role_id;
	public Integer getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	@Override
	public String toString() {
		return "RolePrivilege [menu_id=" + menu_id + ", role_id=" + role_id
				+ "]";
	}
	public RolePrivilege(Integer menu_id, Integer role_id) {
		super();
		this.menu_id = menu_id;
		this.role_id = role_id;
	}
	
	
	
}
