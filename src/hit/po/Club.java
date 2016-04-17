package hit.po;

import java.util.Date;

public class Club {
    private Integer clubId;

    private String clubname;

    private String description;

    private String image;

    private Date setuptime;

    private Integer validationstate;

    private Integer userIdLeader;

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    public String getClubname() {
        return clubname;
    }

    public void setClubname(String clubname) {
        this.clubname = clubname == null ? null : clubname.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Date getSetuptime() {
        return setuptime;
    }

    public void setSetuptime(Date setuptime) {
        this.setuptime = setuptime;
    }

    public Integer getValidationstate() {
        return validationstate;
    }

    public void setValidationstate(Integer validationstate) {
        this.validationstate = validationstate;
    }

    public Integer getUserIdLeader() {
        return userIdLeader;
    }

    public void setUserIdLeader(Integer userIdLeader) {
        this.userIdLeader = userIdLeader;
    }

	@Override
	public String toString() {
		return "Club [clubId=" + clubId + ", clubname=" + clubname
				+ ", description=" + description + ", image=" + image
				+ ", setuptime=" + setuptime + ", validationstate="
				+ validationstate + ", userIdLeader=" + userIdLeader + "]";
	}
   
}