package hit.po;

import java.util.Date;

public class Task {
    private Integer taskId;

    private String taskname;

    private String summary;

    private Integer totalscore;

    private Integer state;

    private Date timeIdBegin;

    private Date timeIdEnd;

    private Integer userIdLeader;

    private Integer clubId;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname == null ? null : taskname.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public Integer getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(Integer totalscore) {
        this.totalscore = totalscore;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getTimeIdBegin() {
        return timeIdBegin;
    }

    public void setTimeIdBegin(Date timeIdBegin) {
        this.timeIdBegin = timeIdBegin;
    }

    public Date getTimeIdEnd() {
        return timeIdEnd;
    }

    public void setTimeIdEnd(Date timeIdEnd) {
        this.timeIdEnd = timeIdEnd;
    }

    public Integer getUserIdLeader() {
        return userIdLeader;
    }

    public void setUserIdLeader(Integer userIdLeader) {
        this.userIdLeader = userIdLeader;
    }

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }
}