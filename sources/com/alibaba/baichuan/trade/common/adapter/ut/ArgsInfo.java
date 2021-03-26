package com.alibaba.baichuan.trade.common.adapter.ut;

import org.json.JSONObject;

public class ArgsInfo {
    public String appKey = "";
    public String sdkVersion = "";

    public String getJSONString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appKey", this.appKey);
            jSONObject.put("sdkVersion", this.sdkVersion);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
