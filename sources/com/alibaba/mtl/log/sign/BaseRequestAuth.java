package com.alibaba.mtl.log.sign;

import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.j;

public class BaseRequestAuth implements IRequestAuth {
    private boolean E = false;
    private String Y = null;
    private String g = null;

    @Override // com.alibaba.mtl.log.sign.IRequestAuth
    public String getAppkey() {
        return this.g;
    }

    public String getAppSecret() {
        return this.Y;
    }

    public BaseRequestAuth(String str, String str2) {
        this.g = str;
        this.Y = str2;
    }

    public BaseRequestAuth(String str, String str2, boolean z) {
        this.g = str;
        this.Y = str2;
        this.E = z;
    }

    public boolean isEncode() {
        return this.E;
    }

    @Override // com.alibaba.mtl.log.sign.IRequestAuth
    public String getSign(String str) {
        if (this.g == null || this.Y == null) {
            i.a("BaseRequestAuth", "There is no appkey,please check it!");
            return null;
        } else if (str == null) {
            return null;
        } else {
            return j.a(j.m17a((str + this.Y).getBytes()));
        }
    }
}
