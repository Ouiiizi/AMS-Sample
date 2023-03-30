package org.example.models;

public class modelClass {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public int getStudentcount() {
        return studentcount;
    }

    public void setStudentcount(int studentcount) {
        this.studentcount = studentcount;
    }

    private String classname;

    private int studentcount;

    public modelClass(int id, String classname, int studentcount) {
        this.id = id;
        this.classname = classname;
        this.studentcount = studentcount;
    }
}
