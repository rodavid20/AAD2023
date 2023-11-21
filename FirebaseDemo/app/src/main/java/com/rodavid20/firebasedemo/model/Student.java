package com.rodavid20.firebasedemo.model;

public class Student {
    private String name;
    private String deptName;

    public Student() {
        setName("");
        setDeptName("");
    }
    public Student(String name, String deptName) {
        this.name = name;
        this.deptName = deptName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
