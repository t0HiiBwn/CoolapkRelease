package com.alibaba.baichuan.trade.biz.core.route.base;

import com.alibaba.baichuan.trade.biz.core.config.model.ActionDO;
import java.util.HashMap;
import java.util.List;

public class UrlRequest {
    private String a;
    private String b;
    private String c;
    private String d;
    private boolean e;
    private List<ActionDO> f;
    private final HashMap<String, Object> g;

    public UrlRequest(String str) {
        this(str, new HashMap());
    }

    public UrlRequest(String str, HashMap<String, Object> hashMap) {
        this.a = str;
        this.g = hashMap == null ? new HashMap<>() : hashMap;
    }

    public List<ActionDO> getActionPriorityList() {
        return this.f;
    }

    public String getBizCode() {
        return this.c;
    }

    public HashMap<String, Object> getFields() {
        return this.g;
    }

    public String getPageType() {
        return this.d;
    }

    public String getRegexUrl() {
        return this.b;
    }

    public String getUrl() {
        return this.a;
    }

    public boolean isAddParam() {
        return this.e;
    }

    public <T> UrlRequest putField(String str, T t) {
        if (t != null) {
            this.g.put(str, t);
        }
        return this;
    }

    public synchronized <T> UrlRequest putFieldIfAbsent(String str, T t) {
        if (t != null) {
            if (!this.g.containsKey(str)) {
                this.g.put(str, t);
            }
        }
        return this;
    }

    public void setActionPriorityList(List<ActionDO> list) {
        this.f = list;
    }

    public void setAddParam(boolean z) {
        this.e = z;
    }

    public void setBizCode(String str) {
        this.c = str;
    }

    public void setPageType(String str) {
        this.d = str;
    }

    public void setRegexUrl(String str) {
        this.b = str;
    }

    public void setUrl(String str) {
        this.a = str;
    }
}
