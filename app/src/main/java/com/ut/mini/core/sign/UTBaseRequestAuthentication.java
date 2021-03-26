package com.ut.mini.core.sign;

import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.j;

public class UTBaseRequestAuthentication implements IUTRequestAuthentication {
    private boolean E = false;
    private String Y = null;
    private String g = null;

    @Override // com.ut.mini.core.sign.IUTRequestAuthentication
    public String getAppkey() {
        return this.g;
    }

    public String getAppSecret() {
        return this.Y;
    }

    public UTBaseRequestAuthentication(String str, String str2) {
        this.g = str;
        this.Y = str2;
    }

    public UTBaseRequestAuthentication(String str, String str2, boolean z) {
        this.g = str;
        this.Y = str2;
        this.E = z;
    }

    public boolean isEncode() {
        return this.E;
    }

    @Override // com.ut.mini.core.sign.IUTRequestAuthentication
    public String getSign(String str) {
        if (this.g == null || this.Y == null) {
            i.a("UTBaseRequestAuthentication", "There is no appkey,please check it!");
            return null;
        } else if (str == null) {
            return null;
        } else {
            return j.a(j.m27a((str + this.Y).getBytes()));
        }
    }
}
