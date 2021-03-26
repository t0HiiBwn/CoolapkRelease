package com.tencent.imsdk.friendship;

import java.util.ArrayList;
import java.util.List;

public class TIMFriendGroup {
    private List<String> friends = new ArrayList();
    private String name = "";
    private long userCnt;

    public String getName() {
        return this.name;
    }

    public long getUserCnt() {
        return this.userCnt;
    }

    public List<String> getFriends() {
        return this.friends;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("\t\tfriends='");
        for (String str : this.friends) {
            stringBuffer2.append(str);
            stringBuffer2.append(",");
        }
        stringBuffer.append("TIMFriendGroupItem{\n");
        stringBuffer.append("\t\tname='");
        stringBuffer.append(this.name);
        stringBuffer.append("',\n");
        stringBuffer.append("\t\tuserCnt='");
        stringBuffer.append(this.userCnt);
        stringBuffer.append("',\n");
        stringBuffer.append(stringBuffer2.toString());
        stringBuffer.append("'\n");
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
