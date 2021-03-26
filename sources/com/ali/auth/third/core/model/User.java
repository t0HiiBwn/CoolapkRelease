package com.ali.auth.third.core.model;

public class User {
    public String avatarUrl;
    public String cbuLoginId;
    public String deviceTokenKey;
    public String deviceTokenSalt;
    public String email;
    public String memberId;
    public String nick;
    public String openId;
    public String openSid;
    public String userId;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User [userId=");
        sb.append(this.userId);
        sb.append(", openId=");
        sb.append(this.openId);
        sb.append(", openSid= ");
        sb.append(this.openSid);
        sb.append(", nick=");
        sb.append(this.nick);
        sb.append(", email=");
        sb.append(this.email);
        sb.append(",cbuloginId=");
        sb.append(this.cbuLoginId);
        sb.append(",memberId=");
        sb.append(this.memberId);
        sb.append(",deviceTokenKey=");
        sb.append(this.deviceTokenKey + "");
        sb.append(",deviceTokenSalt=");
        sb.append(this.deviceTokenSalt + "");
        sb.append("]");
        return sb.toString();
    }
}
