package org.example.models;

public class modelAttendance {
    private int id;
    private int classid;

    public modelAttendance(int id, int classid, int userid, int presentall) {
        this.id = id;
        this.classid = classid;
        this.userid = userid;
        this.presentall = presentall;
    }

    private int userid;

    private int presentall;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getPresentall() {
        return presentall;
    }

    public void setPresentall(int presentall) {
        this.presentall = presentall;
    }
}
