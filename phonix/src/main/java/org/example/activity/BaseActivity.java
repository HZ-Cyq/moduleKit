package org.example.activity;

import org.example.Player;

public abstract class BaseActivity {
    private int activityId;
    private long startTime;
    private long endTime;

    public BaseActivity(int activityId) {
        this.activityId = activityId;
    }

    public void onOpen() {

    }

    public void onEnd() {

    }

    public void onLogin(Player player) {

    }

    public void dailyReset(Player player) {

    }

    public void pulse(Player player) {

    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}
