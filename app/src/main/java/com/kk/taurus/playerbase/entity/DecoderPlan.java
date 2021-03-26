package com.kk.taurus.playerbase.entity;

public class DecoderPlan {
    private String classPath;
    private String desc;
    private int idNumber;
    private String tag;

    public DecoderPlan(int i, String str) {
        this(i, str, str);
    }

    public DecoderPlan(int i, String str, String str2) {
        this.idNumber = i;
        this.classPath = str;
        this.desc = str2;
    }

    public int getIdNumber() {
        return this.idNumber;
    }

    public void setIdNumber(int i) {
        this.idNumber = i;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public String getClassPath() {
        return this.classPath;
    }

    public void setClassPath(String str) {
        this.classPath = str;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public String toString() {
        return "id = " + this.idNumber + ", classPath = " + this.classPath + ", desc = " + this.desc;
    }
}
