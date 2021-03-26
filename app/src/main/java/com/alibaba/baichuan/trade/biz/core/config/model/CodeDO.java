package com.alibaba.baichuan.trade.biz.core.config.model;

import java.io.Serializable;

public class CodeDO implements Serializable {
    private static final long serialVersionUID = 8200694469781596697L;
    private String name;
    private String url;

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
