package com.amap.api.col.s;

import android.net.Uri;
import android.text.TextUtils;

/* compiled from: IPV6Request */
public abstract class bp extends cy {
    @Override // com.amap.api.col.s.cy
    public final boolean k() {
        return true;
    }

    @Override // com.amap.api.col.s.cy
    public String a_() {
        if (TextUtils.isEmpty(h())) {
            return h();
        }
        String h = h();
        Uri parse = Uri.parse(h);
        if (parse.getAuthority().startsWith("dualstack-")) {
            return h;
        }
        Uri.Builder buildUpon = parse.buildUpon();
        return buildUpon.authority("dualstack-" + parse.getAuthority()).build().toString();
    }
}
