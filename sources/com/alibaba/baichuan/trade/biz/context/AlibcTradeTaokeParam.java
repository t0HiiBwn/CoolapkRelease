package com.alibaba.baichuan.trade.biz.context;

import android.text.TextUtils;
import java.util.Map;

public class AlibcTradeTaokeParam {
    public static final String PID_PREFIX = "mm_";
    public String adzoneid;
    public Map<String, String> extraParams;
    public String pid;
    public String subPid;
    public String unionId;

    public AlibcTradeTaokeParam(String str, String str2, String str3) {
        this.pid = str;
        this.unionId = str2;
        this.subPid = str3;
    }

    public Map<String, String> getExtraParams() {
        return this.extraParams;
    }

    public boolean isAdZoneIdExist() {
        return !TextUtils.isEmpty(this.adzoneid) && !this.adzoneid.equals("null");
    }

    public boolean isPidExist() {
        return isValidPid();
    }

    public boolean isValidPid() {
        String str = this.pid;
        return str != null && str.startsWith("mm_");
    }

    public AlibcTradeTaokeParam setAdzoneid(String str) {
        this.adzoneid = str;
        return this;
    }

    public void setExtraParams(Map<String, String> map) {
        this.extraParams = map;
    }

    public AlibcTradeTaokeParam setPid(String str) {
        this.pid = str;
        return this;
    }

    public AlibcTradeTaokeParam setSubPid(String str) {
        this.subPid = str;
        return this;
    }

    public AlibcTradeTaokeParam setUnionId(String str) {
        this.unionId = str;
        return this;
    }
}
