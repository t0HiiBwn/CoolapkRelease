package com.xiaomi.mipush.sdk;

import android.text.TextUtils;

class v {
    int a = 0;

    /* renamed from: a  reason: collision with other field name */
    String f178a = "";

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return !TextUtils.isEmpty(vVar.f178a) && vVar.f178a.equals(this.f178a);
    }
}
