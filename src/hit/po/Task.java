package hit.po;

public class Task {
    private Integer taskId;

    private String taskname;

    private String summary;

    private Integer totalscore;

    private Integer state;

    private Integer timeIdBegin;

    private Integer timeIdEnd;

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

    public Integer getTimeIdBegin() {
        return timeIdBegin;
    }

    public void setTimeIdBegin(Integer timeIdBegin) {
        this.timeIdBegin = timeIdBegin;
    }

    public Integer getTimeIdEnd() {
        return timeIdEnd;
    }

    public void setTimeIdEnd(Integer timeIdEnd) {
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