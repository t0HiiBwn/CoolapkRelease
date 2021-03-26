package com.tencent.imsdk.friendship;

public class TIMFriendResponse {
    public static final int TIM_FRIEND_RESPONSE_AGREE = 0;
    public static final int TIM_FRIEND_RESPONSE_AGREE_AND_ADD = 1;
    public static final int TIM_FRIEND_RESPONSE_REJECT = 2;
    private String identifier = "";
    private String remark = "";
    private int responseType = 0;

    public int getResponseType() {
        return this.responseType;
    }

    public void setResponseType(int i) {
        this.responseType = i;
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

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TIMFriendResponse{\n");
        stringBuffer.append("\t\tidentifier='");
        stringBuffer.append(this.identifier);
        stringBuffer.append("',\n");
        stringBuffer.append("\t\tresponseType='");
        stringBuffer.append(this.responseType);
        stringBuffer.append("',\n");
        stringBuffer.append("\t\tremark='");
        stringBuffer.append(this.remark);
        stringBuffer.append("'\n");
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
