package com.alibaba.alibclinkpartner.linkpartner.a;

import android.os.Bundle;
import android.text.TextUtils;

public class b {
    public d a;
    public String b;
    public String c;
    public long d;

    public void a(int i) {
        d dVar = this.a;
        if (dVar != null) {
            dVar.a(i);
        }
    }

    public void a(int i, Bundle bundle) {
        d dVar = this.a;
        if (dVar != null) {
            dVar.a(i, bundle);
        }
    }

    public boolean a(String str, String str2) {
        return !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(str2) && this.b.equals(str) && this.c.equals(str2);
    }
}
