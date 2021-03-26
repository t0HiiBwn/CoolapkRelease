package com.ali.auth.third.core.model;

import java.util.Map;

public class InternalSession {
    public String autoLoginToken;
    public long expireIn;
    public String[] externalCookies;
    public String havanaSsoToken;
    public String loginId;
    public long loginTime;
    public String mobile;
    public Map<String, Object> otherInfo;
    public String sid;
    public String ssoToken;
    public String topAccessToken;
    public String topAuthCode;
    public String topExpireTime;
    public User user;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InternalSession [sid=");
        sb.append(this.sid);
        sb.append(", expireIn=");
        sb.append(this.expireIn);
        sb.append(", loginTime=");
        sb.append(this.loginTime);
        sb.append(", autoLoginToken=");
        sb.append(this.autoLoginToken);
        sb.append(",topAccessToken=");
        sb.append(this.topAccessToken);
        sb.append(",topAuthCode=");
        sb.append(this.topAuthCode);
        sb.append(",topExpireTime=");
        sb.append(this.topExpireTime);
        sb.append(",ssoToken=");
        sb.append(this.ssoToken);
        sb.append(",havanaSsoToken=");
        sb.append(this.havanaSsoToken);
        sb.append(", user=");
        sb.append(this.user.toString());
        sb.append(", otherInfo=");
        sb.append(this.otherInfo);
        sb.append(", cookies=");
        String[] strArr = this.externalCookies;
        if (strArr != null) {
            for (String str : strArr) {
                sb.append(str);
            }
        } else {
            sb.append("null");
        }
        sb.append("]");
        return sb.toString();
    }
}
