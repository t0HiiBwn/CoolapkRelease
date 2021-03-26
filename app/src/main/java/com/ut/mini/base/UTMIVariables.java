package com.ut.mini.base;

import com.ut.mini.sdkevents.UTMI1010_2001Event;

public class UTMIVariables {
    private static UTMIVariables a = new UTMIVariables();
    private boolean S = false;

    /* renamed from: a  reason: collision with other field name */
    private UTMI1010_2001Event f98a = null;
    private String ak = null;
    private String an = null;
    private String ao = null;

    public synchronized void setToAliyunOSPlatform() {
        this.S = true;
    }

    public synchronized boolean isAliyunOSPlatform() {
        return this.S;
    }

    public synchronized void setUTMI1010_2001EventInstance(UTMI1010_2001Event uTMI1010_2001Event) {
        this.f98a = uTMI1010_2001Event;
    }

    public synchronized UTMI1010_2001Event getUTMI1010_2001EventInstance() {
        return this.f98a;
    }

    public static UTMIVariables getInstance() {
        return a;
    }

    public String getH5Url() {
        return this.ao;
    }

    public void setH5Url(String str) {
        this.ao = str;
    }

    public String getRefPage() {
        return this.ak;
    }

    public void setRefPage(String str) {
        this.ak = str;
    }

    public String getH5RefPage() {
        return this.an;
    }

    public void setH5RefPage(String str) {
        this.an = str;
    }
}
