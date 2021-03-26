package com.xiaomi.push;

public enum dl {
    ACTIVITY("activity"),
    SERVICE_ACTION("service_action"),
    SERVICE_COMPONENT("service_component"),
    PROVIDER("provider");
    
    public String e;

    private dl(String str) {
        this.e = str;
    }
}
