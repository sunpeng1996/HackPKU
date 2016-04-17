package hit.po;

import java.util.Date;

public class News {
    private Integer newId;

    private String title;

    private Integer publisherId;

    private Integer clubId;

    private Date time;

    private byte[] summary;

    public Integer getNewId() {
        return newId;
    }

    public void setNewId(Integer newId) {
        this.newId = newId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public byte[] getSummary() {
        return summary;
    }

    public void setSummary(byte[] summary) {
        this.summary = summary;
    }
}