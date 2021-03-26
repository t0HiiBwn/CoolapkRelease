package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

final class w extends u {
    private final z e;

    w(Context context, z zVar) {
        super(true, false);
        this.e = zVar;
    }

    @Override // com.bytedance.embedapplog.u
    protected boolean a(JSONObject jSONObject) {
        String a = bw.a(this.e.e());
        if (TextUtils.isEmpty(a)) {
            return false;
        }
        jSONObject.put("cdid", a);
        return true;
    }
}
