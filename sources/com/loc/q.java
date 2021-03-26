package com.loc;

import android.net.Uri;
import android.text.TextUtils;

/* compiled from: IPV6Request */
public abstract class q extends av {
    @Override // com.loc.av
    public String d() {
        if (TextUtils.isEmpty(c())) {
            return c();
        }
        String c = c();
        Uri parse = Uri.parse(c);
        if (parse.getAuthority().startsWith("dualstack-")) {
            return c;
        }
        Uri.Builder buildUpon = parse.buildUpon();
        return buildUpon.authority("dualstack-" + parse.getAuthority()).build().toString();
    }

    @Override // com.loc.av
    public final boolean i() {
        return true;
    }
}
