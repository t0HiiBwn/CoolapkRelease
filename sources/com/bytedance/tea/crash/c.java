package com.bytedance.tea.crash;

/* compiled from: CrashType */
public enum c {
    LAUNCH("launch"),
    JAVA("java"),
    NATIVE("native"),
    ANR("anr"),
    BLOCK("block"),
    ENSURE("ensure"),
    DART("dart"),
    CUSTOM_JAVA("custom_java"),
    ALL("all");
    
    private String j;

    private c(String str) {
        this.j = str;
    }

    public String a() {
        return this.j;
    }
}
