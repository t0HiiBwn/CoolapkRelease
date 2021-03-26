package com.tencent.android.tpush;

/* compiled from: ProGuard */
public enum TypeStr {
    config(10, "config"),
    config_all(11, "config/#"),
    msg(20, "msg"),
    msg_all(21, "msg/#"),
    hearbeat(30, "heart"),
    hearbeat_all(31, "heart/#"),
    feedback(40, "feedback"),
    feedback_all(41, "feedback/#"),
    token(50, "token"),
    register(60, "register"),
    pullupxg(70, "pullupxg"),
    insert_mid_new(80, "insert_mid_new"),
    insert_mid_old(81, "insert_mid_old");
    
    private String str;
    private int type;

    private TypeStr(int i, String str2) {
        this.type = i;
        this.str = str2;
    }

    public static TypeStr getTypeStr(int i) {
        if (i == 10) {
            return config;
        }
        if (i == 11) {
            return config_all;
        }
        if (i == 20) {
            return msg;
        }
        if (i == 21) {
            return msg_all;
        }
        if (i == 30) {
            return hearbeat;
        }
        if (i == 31) {
            return hearbeat_all;
        }
        if (i == 40) {
            return feedback;
        }
        if (i == 41) {
            return feedback_all;
        }
        if (i == 50) {
            return token;
        }
        if (i == 60) {
            return register;
        }
        if (i == 70) {
            return pullupxg;
        }
        if (i == 80) {
            return insert_mid_new;
        }
        if (i != 81) {
            return null;
        }
        return insert_mid_old;
    }

    public int getType() {
        return this.type;
    }

    public String getStr() {
        return this.str;
    }
}
