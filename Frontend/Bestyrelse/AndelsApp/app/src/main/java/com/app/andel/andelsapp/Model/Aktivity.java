package com.app.andel.andelsapp.Model;

public class Aktivity {
    int  activity_id;
    int  fk_event_id;
    String title;

    public Aktivity(int activity_id, int fk_event_id, String title) {
        this.activity_id = activity_id;
        this.fk_event_id = fk_event_id;
        this.title = title;
    }

    public int getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(int activity_id) {
        this.activity_id = activity_id;
    }

    public int getFk_event_id() {
        return fk_event_id;
    }

    public void setFk_event_id(int fk_event_id) {
        this.fk_event_id = fk_event_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Aktivity{" +
                "activity_id=" + activity_id +
                ", fk_event_id=" + fk_event_id +
                ", title='" + title + '\'' +
                '}';
    }
}
