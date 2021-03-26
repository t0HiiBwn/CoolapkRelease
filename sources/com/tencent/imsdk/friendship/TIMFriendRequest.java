package com.tencent.imsdk.friendship;

public class TIMFriendRequest {
    private String addSource = "";
    private int addType;
    private String addWording = "";
    private String friendGroup = "";
    private String identifier = "";
    private String remark = "";

    public TIMFriendRequest(String str) {
        this.identifier = str;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public String getFriendGroup() {
        return this.friendGroup;
    }

    public void setFriendGroup(String str) {
        this.friendGroup = str;
    }

    public String getAddWording() {
        return this.addWording;
    }

    public void setAddWording(String str) {
        this.addWording = str;
    }

    public String getAddSource() {
        return this.addSource;
    }

    public void setAddSource(String str) {
        this.addSource = str;
    }

    public int getAddType() {
        return this.addType;
    }

    public void setAddType(int i) {
        if (i == 1 || i == 2) {
            this.addType = i;
        } else {
            this.addType = 2;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TIMFriendRequest{\n");
        stringBuffer.append("\t\tidentifier='");
        stringBuffer.append(this.identifier);
        stringBuffer.append("',\n");
        stringBuffer.append("\t\tremark='");
        stringBuffer.append(this.remark);
        stringBuffer.append("',\n");
        stringBuffer.append("\t\taddWording='");
        stringBuffer.append(this.addWording);
        stringBuffer.append("',\n");
        stringBuffer.append("\t\taddSource='");
        stringBuffer.append(this.addSource);
        stringBuffer.append("',\n");
        stringBuffer.append("\t\tfriendGroup='");
        stringBuffer.append(this.friendGroup);
        stringBuffer.append("'\n");
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
