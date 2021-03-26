package com.alibaba.baichuan.android.trade.model;

import com.alibaba.baichuan.trade.biz.applink.adapter.AlibcFailModeType;

public class AlibcShowParams {
    private boolean a;
    private OpenType b;
    private OpenType c;
    private AlibcFailModeType d;
    private String e;
    private String f;
    private String g;
    private String h;
    private boolean i;
    private boolean j;

    public AlibcShowParams() {
        this.a = true;
        this.i = true;
        this.j = true;
        this.c = OpenType.Auto;
        this.g = "taobao";
    }

    public AlibcShowParams(OpenType openType) {
        this.a = true;
        this.i = true;
        this.j = true;
        this.c = openType;
        this.g = "taobao";
    }

    public String getBackUrl() {
        return this.e;
    }

    public String getClientType() {
        return this.g;
    }

    public String getDegradeUrl() {
        return this.f;
    }

    public AlibcFailModeType getNativeOpenFailedMode() {
        return this.d;
    }

    public OpenType getOpenType() {
        return this.c;
    }

    public OpenType getOriginalOpenType() {
        return this.b;
    }

    public String getTitle() {
        return this.h;
    }

    public boolean isClose() {
        return this.a;
    }

    public boolean isProxyWebview() {
        return this.j;
    }

    public boolean isShowTitleBar() {
        return this.i;
    }

    public void setBackUrl(String str) {
        this.e = str;
    }

    public void setClientType(String str) {
        this.g = str;
    }

    public void setDegradeUrl(String str) {
        this.f = str;
    }

    public void setNativeOpenFailedMode(AlibcFailModeType alibcFailModeType) {
        this.d = alibcFailModeType;
    }

    public void setOpenType(OpenType openType) {
        this.c = openType;
    }

    public void setOriginalOpenType(OpenType openType) {
        this.b = openType;
    }

    public void setPageClose(boolean z) {
        this.a = z;
    }

    public void setProxyWebview(boolean z) {
        this.j = z;
    }

    public void setShowTitleBar(boolean z) {
        this.i = z;
    }

    public void setTitle(String str) {
        this.h = str;
    }

    public String toString() {
        return "AlibcShowParams{isClose=" + this.a + ", openType=" + this.c + ", nativeOpenFailedMode=" + this.d + ", backUrl='" + this.e + "', clientType='" + this.g + "', title='" + this.h + "', isShowTitleBar=" + this.i + ", isProxyWebview=" + this.j + '}';
    }
}
