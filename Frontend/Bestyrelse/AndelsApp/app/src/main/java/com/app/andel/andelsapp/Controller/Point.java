package com.app.andel.andelsapp.Controller;

public class Point {
    private int point_id;
    private String title;
    private int fk_activity_id;

    public Point(int point_id, String title, int fk_activity_id){
        this.point_id = point_id;
        this.title = title;
        this.fk_activity_id = fk_activity_id;
    }

    public int getFk_activity_id() {
        return fk_activity_id;
    }


    public int getPoint_id() {
        return point_id;
    }

    public void setPoint_id(int point_id) {
        this.point_id = point_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
