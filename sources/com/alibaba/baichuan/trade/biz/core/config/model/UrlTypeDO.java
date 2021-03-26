package com.alibaba.baichuan.trade.biz.core.config.model;

import java.io.Serializable;

public class UrlTypeDO implements Serializable {
    private static final long serialVersionUID = -6959725773324370491L;
    private String[] pattern;
    private String type;

    public String[] getPattern() {
        return this.pattern;
    }

    public String getType() {
        return this.type;
    }

    public void setPattern(String[] strArr) {
        this.pattern = strArr;
    }

    public void setType(String str) {
        this.type = str;
    }
}
