package com.alibaba.baichuan.trade.biz.core.config.model;

import java.io.Serializable;

public class BizDO implements Serializable {
    private static final long serialVersionUID = -4086456119965173164L;
    private String bizCode;
    private String[] pattern;

    public String getBizCode() {
        return this.bizCode;
    }

    public String[] getPattern() {
        return this.pattern;
    }

    public void setBizCode(String str) {
        this.bizCode = str;
    }

    public void setPattern(String[] strArr) {
        this.pattern = strArr;
    }
}
