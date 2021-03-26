package com.tencent.beacon.core.event;

import java.io.Serializable;
import java.util.Map;

public class RDBean implements Serializable {
    public static final String TP_DN = "DN";
    public static final String TP_HO = "HO";
    public static final String TP_IP = "IP";
    public static final String TP_UA = "UA";
    private static final long serialVersionUID = 1;
    private String apn = "";
    private long cid = -1;
    private long elapse;
    private Map<String, String> emap;
    private String en;
    private boolean eventResult = true;
    private boolean immediatelyUpload;
    private long size;
    private String srcIp = "";
    private long tm;
    private String tp;

    public synchronized long getCid() {
        return this.cid;
    }

    public synchronized void setCid(long j) {
        this.cid = j;
    }

    public synchronized String getTP() {
        return this.tp;
    }

    public synchronized void setTP(String str) {
        this.tp = str;
    }

    public synchronized long getTM() {
        return this.tm;
    }

    public synchronized void setTM(long j) {
        this.tm = j;
    }

    public synchronized String getEN() {
        return this.en;
    }

    public synchronized void setEN(String str) {
        this.en = str;
    }

    public synchronized Map<String, String> getEMap() {
        return this.emap;
    }

    public synchronized void setEMap(Map<String, String> map) {
        this.emap = map;
    }

    public boolean isImmediatelyUpload() {
        return this.immediatelyUpload;
    }

    public void setImmediatelyUpload(boolean z) {
        this.immediatelyUpload = z;
    }

    public boolean isEventResult() {
        return this.eventResult;
    }

    public void setEventResult(boolean z) {
        this.eventResult = z;
    }

    public String getSrcIp() {
        return this.srcIp;
    }

    public void setSrcIp(String str) {
        this.srcIp = str;
    }

    public long getElapse() {
        return this.elapse;
    }

    public void setElapse(long j) {
        this.elapse = j;
    }

    public String getApn() {
        return this.apn;
    }

    public void setApn(String str) {
        this.apn = str;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long j) {
        this.size = j;
    }
}
