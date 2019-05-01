package com.app.andel.andelsapp.ActivityFolder;

public class Activity {
    private String name;
    private String place;
    private String startTime;

    public Activity(String name, String place, String startTime) {
        this.name = name;
        this.place = place;
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return name + place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
