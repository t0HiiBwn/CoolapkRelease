package com.tencent.imsdk.v2;

import java.util.Map;

public class V2TIMCreateGroupMemberInfo {
    private Map<String, byte[]> customInfo;
    private int role = 0;
    private String userID;

    public void setUserID(String str) {
        this.userID = str;
    }

    String getUserID() {
        return this.userID;
    }

    public void setRole(int i) {
        if (i == 200) {
            i = 0;
        }
        this.role = i;
    }

    int getRole() {
        return this.role;
    }
}
