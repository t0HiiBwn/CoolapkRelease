package com.alibaba.baichuan.trade.biz.core.config.model;

import java.io.Serializable;
import java.util.List;

public class ConfigDO implements Serializable {
    private static final long serialVersionUID = 2847021489456736604L;
    private List<String> addParamUrls;
    private List<BizDO> bizPattern;
    private List<CodeDO> codeConfig;
    private String em;
    private String[] forbidByCode;
    private ExtendDO misc;
    private List<RouteConfigDO> routeConfig;
    private String sign;
    private int st = 1;
    private List<UrlTypeDO> urlTypeConfig;
    private String version;

    public List<String> getAddParamUrls() {
        return this.addParamUrls;
    }

    public List<BizDO> getBizPattern() {
        return this.bizPattern;
    }

    public List<CodeDO> getCodeConfig() {
        return this.codeConfig;
    }

    public String getEm() {
        return this.em;
    }

    public String[] getForbidByCode() {
        return this.forbidByCode;
    }

    public ExtendDO getMisc() {
        return this.misc;
    }

    public List<RouteConfigDO> getRouteConfig() {
        return this.routeConfig;
    }

    public String getSign() {
        return this.sign;
    }

    public int getSt() {
        return this.st;
    }

    public List<UrlTypeDO> getUrlTypeConfig() {
        return this.urlTypeConfig;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAddParamUrls(List<String> list) {
        this.addParamUrls = list;
    }

    public void setBizPattern(List<BizDO> list) {
        this.bizPattern = list;
    }

    public void setCodeConfig(List<CodeDO> list) {
        this.codeConfig = list;
    }

    public void setEm(String str) {
        this.em = str;
    }

    public void setForbidByCode(String[] strArr) {
        this.forbidByCode = strArr;
    }

    public void setMisc(ExtendDO extendDO) {
        this.misc = extendDO;
    }

    public void setRouteConfig(List<RouteConfigDO> list) {
        this.routeConfig = list;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public void setSt(int i) {
        this.st = i;
    }

    public void setUrlTypeConfig(List<UrlTypeDO> list) {
        this.urlTypeConfig = list;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
