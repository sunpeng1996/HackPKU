package hit.po;

public class ClubMember{
	private  User user;
	private Role role;
	private Club club;
	private Integer score;
	
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Club getClub() {
		return club;
	}
	public void setClub(Club club) {
		this.club = club;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "ClubMember [user=" + user + ", role=" + role + ", club=" + club
				+ "]";
	}
	public ClubMember() {
		super();
	}
	public ClubMember(Integer user_id, Integer club_id,	Integer role_id) {
		super();
		  Club club = new Club();
		  club.setClubId(club_id);
		  this.setClub(club);
		  User user = new User();
		  user.setUserId(user_id);
		  this.setUser(user);
		  Role role = new Role();
		  role.setRoleId(role_id);
		  this.setRole(role);
	}
	public ClubMember(User user, Role role, Club club) {
		super();
		this.user = user;
		this.role = role;
		this.club = club;
	}
	
}
