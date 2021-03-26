package com.alibaba.baichuan.trade.biz.core.config.model;

import java.io.Serializable;

public class ParamDO implements Serializable {
    private static final long serialVersionUID = -6914026567988802707L;
    private String clientPage;
    private String clientType;
    private String targetPath;

    public String getClientPage() {
        return this.clientPage;
    }

    public String getClientType() {
        return this.clientType;
    }

    public String getTargetPath() {
        return this.targetPath;
    }

    public void setClientPage(String str) {
        this.clientPage = str;
    }

    public void setClientType(String str) {
        this.clientType = str;
    }

    public void setTargetPath(String str) {
        this.targetPath = str;
    }
}
