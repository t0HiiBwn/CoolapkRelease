package com.alibaba.baichuan.trade.biz.applink.adapter;

public class AlibcNavResult {
    public boolean isSuccess = false;
    public int resultCode = 0;

    public boolean isFailByNoApp() {
        return !this.isSuccess && this.resultCode == 310;
    }

    public String toString() {
        return "AlibcNavResult{isSuccess=" + this.isSuccess + ", resultCode=" + this.resultCode + '}';
    }
}
