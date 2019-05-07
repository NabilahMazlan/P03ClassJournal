package com.example.p03_classjournal;

import java.io.Serializable;

public class DailyGrade implements Serializable {
    String week;
    String grade;
    String module_code;

    public DailyGrade(String week, String grade, String module_code) {
        this.week = week;
        this.grade = grade;
        this.module_code = module_code;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getModule_code() {
        return module_code;
    }

    public void setModule_code(String module_code) {
        this.module_code = module_code;
    }
}
