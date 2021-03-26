package com.tencent.imsdk;

public class TIMBackgroundParam {
    private int c2cUnread;
    private int groupUnread;

    public void setC2cUnread(int i) {
        if (i < 0) {
            i = 0;
        }
        this.c2cUnread = i;
    }

    public void setGroupUnread(int i) {
        if (i < 0) {
            i = 0;
        }
        this.groupUnread = i;
    }

    public int getC2cUnread() {
        return this.c2cUnread;
    }

    public int getGroupUnread() {
        return this.groupUnread;
    }
}
