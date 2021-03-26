package com.tencent.msdk.dns.core.rest.share;

import android.text.TextUtils;
import com.tencent.msdk.dns.core.f;

/* compiled from: LookupExtra */
public final class g implements f.a {
    public final String b;
    public final String c;

    public g(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bizId".concat(" can not be empty"));
        } else if (!TextUtils.isEmpty(str2)) {
            this.b = str;
            this.c = str2;
        } else {
            throw new IllegalArgumentException("bizKey".concat(" can not be empty"));
        }
    }

    public String toString() {
        return "LookupExtra{bizId='" + this.b + "', bizKey='" + this.c + "'}";
    }
}
