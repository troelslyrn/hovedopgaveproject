package com.app.andel.andelsapp.Controller;

public class SubPoint {
        private int subpoints_id;
        private int fk_points_id;
        private String title;
        private String makecomment;

    public void setSubpoints_id(int subpoints_id) {
        this.subpoints_id = subpoints_id;
    }

    public int getFk_points_id() {
        return fk_points_id;
    }

    public void setFk_points_id(int fk_points_id) {
        this.fk_points_id = fk_points_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SubPoint(int subpoints_id, String title, int fk_points_id) {
        this.subpoints_id = subpoints_id;
        this.title = title;
        this.fk_points_id = fk_points_id;

    }

    public String getMakecomment() {
        return makecomment;
    }

    public void setMakecomment(String makecomment) {
        this.makecomment = makecomment;
    }

    public SubPoint(int subpoints_id, String makecomment) {
        this.subpoints_id = subpoints_id;
        this.makecomment = makecomment;
    }

    public int getSubpoints_id() {
        return subpoints_id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;

    }
}
