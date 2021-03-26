package com.alibaba.baichuan.trade.biz.context;

import com.alibaba.baichuan.trade.biz.applink.adapter.AlibcFailModeType;

public class AlibcTradeShowParam {
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

    public enum OpenType {
        Auto,
        Native
    }

    public AlibcTradeShowParam() {
        this.a = true;
        this.i = true;
        this.j = true;
        this.c = OpenType.Auto;
        this.g = "taobao";
    }

    public AlibcTradeShowParam(OpenType openType, boolean z) {
        this.a = true;
        this.i = true;
        this.j = true;
        this.c = openType;
        this.a = z;
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

    public boolean isFailModeH5() {
        AlibcFailModeType alibcFailModeType = this.d;
        return alibcFailModeType != null && alibcFailModeType.equals(AlibcFailModeType.AlibcNativeFailModeJumpH5);
    }

    public boolean isNativeFailedNone() {
        AlibcFailModeType alibcFailModeType = this.d;
        return alibcFailModeType != null && alibcFailModeType.equals(AlibcFailModeType.AlibcNativeFailModeNONE);
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

    public void setIsClose(boolean z) {
        this.a = z;
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
        return "AlibcShowParams{isClose=" + this.a + ", openType=" + this.c + ", backUrl='" + this.e + "'}";
    }
}
