package com.qq.e.comm.util;

public enum VideoAdValidity {
    VALID("有效且可展示的广告"),
    OVERDUE("过期的广告"),
    SHOWED("已经展示的广告"),
    NONE_CACHE("视频未缓存的广告");
    
    private String a;

    private VideoAdValidity(String str) {
        this.a = str;
    }

    public final String getMessage() {
        return this.a;
    }
}
