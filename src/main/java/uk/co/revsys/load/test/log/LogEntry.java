package uk.co.revsys.load.test.log;

import java.util.Date;

public class LogEntry<D extends Object, R extends Object> {

    private Date startTime = new Date();
    private D data;
    private R result;
    private Date submissionStartTime;
    private Date endTime;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

    public R getResult() {
        return result;
    }

    public void setResult(R result) {
        this.result = result;
    }

    public Date getSubmissionStartTime() {
        return submissionStartTime;
    }

    public void setSubmissionStartTime(Date submissionStartTime) {
        this.submissionStartTime = submissionStartTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    
    public long getSubmissionExecutionTime(){
        return endTime.getTime() - submissionStartTime.getTime();
    }
    
}
