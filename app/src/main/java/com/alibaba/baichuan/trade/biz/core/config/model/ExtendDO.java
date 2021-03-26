package com.alibaba.baichuan.trade.biz.core.config.model;

import java.io.Serializable;

public class ExtendDO implements Serializable {
    private static final long serialVersionUID = -460394603293451570L;
    private String failMode;
    private String isNeedAlipay;
    private String isSyncForTaoke;
    private String isTUnionMtopDegrade;
    private String isvCode;
    private String loginDegarade;
    private String sampling;
    private String urlApi;

    public String getFailMode() {
        return this.failMode;
    }

    public String getIsNeedAlipay() {
        return this.isNeedAlipay;
    }

    public String getIsSyncForTaoke() {
        return this.isSyncForTaoke;
    }

    public String getIsTUnionMtopDegrade() {
        return this.isTUnionMtopDegrade;
    }

    public String getIsvCode() {
        return this.isvCode;
    }

    public String getLoginDegarade() {
        return this.loginDegarade;
    }

    public String getSampling() {
        return this.sampling;
    }

    public String getUrlApi() {
        return this.urlApi;
    }

    public void setFailMode(String str) {
        this.failMode = str;
    }

    public void setIsNeedAlipay(String str) {
        this.isNeedAlipay = str;
    }

    public void setIsSyncForTaoke(String str) {
        this.isSyncForTaoke = str;
    }

    public void setIsTUnionMtopDegrade(String str) {
        this.isTUnionMtopDegrade = str;
    }

    public void setIsvCode(String str) {
        this.isvCode = str;
    }

    public void setLoginDegarade(String str) {
        this.loginDegarade = str;
    }

    public void setSampling(String str) {
        this.sampling = str;
    }

    public void setUrlApi(String str) {
        this.urlApi = str;
    }
}
