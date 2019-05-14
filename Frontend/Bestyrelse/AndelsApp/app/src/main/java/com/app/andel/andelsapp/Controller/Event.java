package com.app.andel.andelsapp.Controller;

public class Event {
    int event_id;
    String title;
    String timeEnd;
    String timeStart;
    int fk_user_id;


    public Event(int event_id, String title, String timeEnd, String timeStart, int fk_user_id) {
        this.event_id = event_id;
        this.title = title;
        this.timeEnd = timeEnd;
        this.timeStart = timeStart;

        this.fk_user_id = fk_user_id;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public int getFk_user_id() {
        return fk_user_id;
    }

    public void setFk_user_id(int fk_user_id) {
        this.fk_user_id = fk_user_id;
    }

    @Override
    public String toString() {
        return title + " - " + timeStart;
    }
}
