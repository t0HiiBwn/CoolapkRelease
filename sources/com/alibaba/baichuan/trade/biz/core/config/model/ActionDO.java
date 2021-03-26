package com.alibaba.baichuan.trade.biz.core.config.model;

import java.io.Serializable;

public class ActionDO implements Serializable {
    private static final long serialVersionUID = -3681529206766209320L;
    private String openType;
    private ParamDO param;

    public String getOpenType() {
        return this.openType;
    }

    public ParamDO getParam() {
        return this.param;
    }

    public void setOpenType(String str) {
        this.openType = str;
    }

    public void setParam(ParamDO paramDO) {
        this.param = paramDO;
    }
}
