package com.alibaba.baichuan.trade.biz.core.config.model;

import java.io.Serializable;
import java.util.List;

public class BizPatternDO implements Serializable {
    private static final long serialVersionUID = 7386623680199455396L;
    private List<String> addParamUrls;
    private List<BizDO> bizPattern;
    private String sign;

    public List<String> getAddParamUrls() {
        return this.addParamUrls;
    }

    public List<BizDO> getBizPattern() {
        return this.bizPattern;
    }

    public String getSign() {
        return this.sign;
    }

    public void setAddParamUrls(List<String> list) {
        this.addParamUrls = list;
    }

    public void setBizPattern(List<BizDO> list) {
        this.bizPattern = list;
    }

    public void setSign(String str) {
        this.sign = str;
    }
}
