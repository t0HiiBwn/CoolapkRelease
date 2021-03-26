package com.xiaomi.mipush.sdk;

import android.text.TextUtils;

class z {
    int a = 0;

    /* renamed from: a  reason: collision with other field name */
    String f167a = "";

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return !TextUtils.isEmpty(zVar.f167a) && zVar.f167a.equals(this.f167a);
    }
}
