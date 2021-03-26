package com.qq.e.comm.constants;

import java.util.Map;
import org.json.JSONObject;

public class LoadAdParams {
    private int a;
    private LoginType b;
    private String c;
    private String d;
    private String e;
    private int f;
    private String g;
    private Map h;
    private boolean i;
    private JSONObject j;

    public int getBlockEffectValue() {
        return this.f;
    }

    public JSONObject getExtraInfo() {
        return this.j;
    }

    public int getFlowSourceId() {
        return this.a;
    }

    public String getLoginAppId() {
        return this.c;
    }

    public String getLoginOpenid() {
        return this.d;
    }

    public LoginType getLoginType() {
        return this.b;
    }

    public Map getPassThroughInfo() {
        return this.h;
    }

    public String getPassThroughInfoJsonString() {
        try {
            Map map = this.h;
            if (map == null || map.size() <= 0) {
                return null;
            }
            return new JSONObject(this.h).toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String getUin() {
        return this.e;
    }

    public String getWXAppId() {
        return this.g;
    }

    public boolean isHotStart() {
        return this.i;
    }

    public void setBlockEffectValue(int i2) {
        this.f = i2;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        this.j = jSONObject;
    }

    public void setFlowSourceId(int i2) {
        this.a = i2;
    }

    public void setHotStart(boolean z) {
        this.i = z;
    }

    public void setLoginAppId(String str) {
        this.c = str;
    }

    public void setLoginOpenid(String str) {
        this.d = str;
    }

    public void setLoginType(LoginType loginType) {
        this.b = loginType;
    }

    public void setPassThroughInfo(Map map) {
        this.h = map;
    }

    public void setUin(String str) {
        this.e = str;
    }

    public void setWXAppId(String str) {
        this.g = str;
    }

    public String toString() {
        return "LoadAdParams{flowSourceId=" + this.a + ", loginType=" + this.b + ", loginAppId=" + this.c + ", loginOpenid=" + this.d + ", uin=" + this.e + ", blockEffect=" + this.f + ", passThroughInfo=" + this.h + ", extraInfo=" + this.j + '}';
    }
}
