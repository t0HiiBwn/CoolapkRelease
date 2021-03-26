package com.alibaba.baichuan.trade.biz.core.taoke;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.Map;

public class AlibcTaokeParams implements Serializable {
    public static final String PID_PREFIX = "mm_";
    public String adzoneid;
    public Map<String, String> extraParams;
    public String pid;
    public String subPid;
    public String unionId;

    public AlibcTaokeParams(String str, String str2, String str3) {
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

    public AlibcTaokeParams setAdzoneid(String str) {
        this.adzoneid = str;
        return this;
    }

    public void setExtraParams(Map<String, String> map) {
        this.extraParams = map;
    }

    public AlibcTaokeParams setPid(String str) {
        this.pid = str;
        return this;
    }

    public AlibcTaokeParams setSubPid(String str) {
        this.subPid = str;
        return this;
    }

    public AlibcTaokeParams setUnionId(String str) {
        this.unionId = str;
        return this;
    }

    @Override // java.lang.Object
    public String toString() {
        return "AlibcTaokeParams{pid='" + this.pid + "', unionId='" + this.unionId + "', subPid='" + this.subPid + "', adzoneid='" + this.adzoneid + "'}";
    }
}
