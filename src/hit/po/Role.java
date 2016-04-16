package hit.po;

public class Role {
    private Integer roleId;

    private String rolename;

    private String description;

    private Integer clubId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", rolename=" + rolename
				+ ", description=" + description + ", clubId=" + clubId + "]";
	}
    
}